package com.mjw.JSON.test;
import java.io.IOException;
import java.text.ParseException;

import org.codehaus.jackson.map.ObjectMapper;
  
public class JacksonDemo { 
  public static void main(String[] args) throws ParseException, IOException { 
    String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":19890820,\"email\":\"xiaomin@sina.com\"}"; 
      
    /** 
     * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。 
     */
    ObjectMapper mapper = new ObjectMapper(); 
    User user = mapper.readValue(json, User.class); 
    System.out.println(user.getName() + " " + user.getAge() + " " + user.getBirthday() + " " + user.getEmail()); 
  } 
}