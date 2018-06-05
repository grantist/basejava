package com.javops.webapp;

import com.javops.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by TRACTEL_RND on 22.04.2018.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        //Class<? extends Resume> resumeClass = resume.getClass();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);

        //TODO:invoke resume.toString via reflection

        Method method = Resume.class.getMethod("toString");
        System.out.println(method.invoke(resume));




    }
}
