package com.example.sezertanriverdi.reflection.accessible;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAccessibleApp {
    public static void main(String[] args) {
        try {
            final Class<?> clazz = Class.forName("com.example.sezertanriverdi.restricted.RestrictedClass");
            final Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
            final Object clazzInstance = defaultConstructor.newInstance();

            final Method publicMethod = clazz.getDeclaredMethod("publicMethod");
            publicMethod.invoke(clazzInstance);

            final Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(clazzInstance);
        } catch (ClassNotFoundException
            | NoSuchMethodException
            | InvocationTargetException
            | InstantiationException
            | IllegalAccessException e)
        {
            System.err.println("ReflectionAccessibleApp: An exception occurred: " + e.getMessage());
        }
    }
}
