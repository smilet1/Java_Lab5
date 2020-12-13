/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxso
 */

package com.mycompany.lab5;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;


/**
 * 
 * @author Максим Усков
 */
public class Injector{
/**
 * 
 * @param obj Класс
 * @return Класс после проверки на наличие аннотаций и применения рефлексии
 */
    public static<T> T inject(T obj){

        Class<? extends Object> cls=obj.getClass();
        Field[] publicFields = cls.getDeclaredFields();
        FileInputStream fileInputStream ;
        Properties prop = new Properties();
        
        for(Field field : publicFields){
            if(field.isAnnotationPresent(AutoInjectable.class)){
                
                Class fieldType = field.getType();
                String TypeFirst = fieldType.getName();
                field.setAccessible(true);
                try { 
                    fileInputStream = new FileInputStream("lab5.properties");
                    prop.load(fileInputStream);
                    String type = prop.getProperty(TypeFirst);
                    Class cls1 =Class.forName(type);
                    field.set(obj, cls1.newInstance());
                    
                }catch (Exception e) {
                    System.out.println("Ошибка в программе: файл не обнаружен");
                }
                
            }
        }
        return obj;
    }
}
