package com.zjp.dao;

import com.zjp.pojo.Deparment;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Deparment> deparments = null;

    static {
        deparments = new HashMap<>();
        for (int i =0;i<5;i++){
            Deparment deparment = new Deparment((10 + i + 1),"部门——0" + (i+1));
            deparments.put((10 + i), deparment);
        }
    }

    public Collection<Deparment> getDeparments(){
        if(deparments != null){
            return deparments.values();
        }
        return null;
    }

    public Deparment getDeparmentById (Integer id){
        if(deparments != null && deparments.containsKey(id)){
            return deparments.get(id);
        }
        return null;
    }
}
