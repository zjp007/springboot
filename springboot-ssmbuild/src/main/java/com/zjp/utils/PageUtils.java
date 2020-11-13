package com.zjp.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtils {

    /**
     * 获取request中的参数 格式 {limit: 0, offset: 10, conding: "id=1&name=aaa"}
     * @param request
     * @return
     */
    public static Map<String, Object> getHttpMap(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        if(request != null){
            Integer begin = 0, end = 10;
            String limit = request.getParameter("limit");
            String offset = request.getParameter("offset");
            if(!StringUtils.isEmpty(limit) && !StringUtils.isEmpty(offset)){
                Integer limitI = Integer.parseInt(limit);
                Integer offsetI = Integer.parseInt(offset);
                begin = limitI;
                end = limitI + offsetI;
            }
            map.put("begin", begin);
            map.put("end", end);
            String conding = request.getParameter("conding");
            if(!StringUtils.isEmpty(conding)){
                String[] condArray = conding.split("&");
                if(condArray != null && condArray.length > 0){
                    for (String cond : condArray) {
                        if(!StringUtils.isEmpty(cond)){
                            String[] sArray = conding.split("=");
                            if(sArray != null && sArray.length > 1){
                                map.put(sArray[0], sArray[1]);
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     *
     * @param str           待分割字符
     * @param splitStr      分割符
     * @return
     */
    public static List<Integer> toIntegerList(String str, String splitStr){
        List<Integer> result = toList(str, splitStr, Integer.class);
        return  result;
    }

    /**
     *
     * @param str           待分割字符
     * @param splitStr      分割符
     * @return
     */
    public static List<String> toStringList(String str, String splitStr){
        List<String> result = toList(str, splitStr, String.class);
        return  result;
    }

    /**
     *
     * @param str           待分割字符
     * @param splitStr      分割符
     * @param Class         返回集合类型
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String str, String splitStr,  Class<T> Class){
        List<T> result = new ArrayList<>();
        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(str)){
            String[] array = str.split(splitStr);
            if(array != null && array.length > 0){
                for (String s : array) {
                    result.add((T)s);
                }
            }
        }
        return  result;
    }
}
