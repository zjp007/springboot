package com.zjp.dao;

import com.zjp.pojo.Deparment;
import com.zjp.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        for (int i = 0;i<5;i++){
            Deparment deparment = new Deparment((10 + i + 1),"部门——0" + (i+1));
            Employee employee = new Employee((1000 + i + 1),"员工00" + (i + 1),
                    "地点——0" + (i + 1), "办公-0" + (i + 1), 20 + i +1, new Date(), 2000f + i + 1, deparment);
            employees.put((1000 + i + 1), employee);
        }
    }

    private static Integer initId = 1006;

    public Collection<Employee> getEmployees(){
        if(employees != null){
            return employees.values();
        }
        return null;
    }

    public int addEmployee (Employee employee){
        int result = 0;
        if(employees != null && employee != null){
            if(employee.getId() == null){
                employee.setId(initId++);
            }
            if(employee.getDeparment() != null && employee.getDeparment().getId() != null){
                employee.setDeparment(departmentDao.getDeparmentById(employee.getDeparment().getId()));
            }
            if(!employees.containsKey(employee.getId())){
                employees.put(employee.getId(), employee);
                result = 1;
            }
        }
        return result;
    }

    public int updateEmployee (Employee employee){
        int result = 0;
        if(employees != null && employee != null){
            if(employee.getDeparment() != null && employee.getDeparment().getId() != null){
                employee.setDeparment(departmentDao.getDeparmentById(employee.getDeparment().getId()));
            }
            if(employees.containsKey(employee.getId())){
                employees.put(employee.getId(), employee);
                result = 1;
            }
        }
        return result;
    }

    public Employee getEmployeeById (Integer id){
        if(employees != null ){
            if(employees.containsKey(id)){
                return employees.get(id);
            }
        }
        return null;
    }

    public int delete (Integer id){
        int result = 0;
        if(employees != null ){
            if(employees.containsKey(id)){
                employees.remove(id);
                result = 1;
            }
        }
        return result;
    }
}
