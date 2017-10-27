/**
 * json字符串转对象
 */
package com.mjw.JSON.test;

import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonToJavaBean {
    public static void main(String[] args) {
    	//json里面的数组转化为对象的时候为list
    	//json里面的key和对象里面的字段名字需要一致
        String str="{\"student\":[{\"name\":\"leilei\",\"age\":23},{\"name\":\"leilei02\",\"age\":23}]}";
        List<Student> list = null;
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            StudentList studentList=objectMapper.readValue(str, StudentList.class);
             
            list=studentList.getStudent();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        for(Student s:list){
            System.out.println(s.getName()+"   "+s.getAge());
        }
    }
}