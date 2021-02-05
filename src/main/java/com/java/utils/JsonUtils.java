package com.java.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Employee;

import java.io.IOException;
import java.io.InputStream;
//object mapping by jackson
public class JsonUtils {
    public static void main(String[] args) throws IOException {

        Employee e= new Employee();
        e.setId(01);
        e.setName("Abhisek");
        toJson(e);
        InputStream is=JsonUtils.class.getClassLoader().getResourceAsStream("data.json");
        toObject(is);

    }
    private static final ObjectMapper MAPPER = new ObjectMapper();

//jason to java object conversion
private static void toObject(InputStream  is) throws IOException {
Employee e= MAPPER.readValue(is, Employee.class);
    System.out.println(e.getId());
    System.out.println(e.getName());

}
//java object to json conversion
private static void toJson(Object object ) throws JsonProcessingException {
String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    System.out.println(json);
}

}
