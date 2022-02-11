package com.example.sezertanriverdi.reflection.inaccessible;

import java.lang.reflect.Constructor;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionInAccessibleApp {
    public static void main(String[] args) {
        try {
            final Class<?> clazz = Class.forName("com.example.sezertanriverdi.restricted.RestrictedClass");
            final Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
            final Object clazzInstance = defaultConstructor.newInstance();

            final Method publicMethod = clazz.getDeclaredMethod("publicMethod");
            publicMethod.invoke(clazzInstance);

            final Method privateMethod = clazz.getDeclaredMethod("privateMethod");

            // This line will throw an InaccessibleObjectException
            // because we didn't open restricted.module to this module
            privateMethod.setAccessible(true);
            privateMethod.invoke(clazzInstance);
        } catch (ClassNotFoundException
            | NoSuchMethodException
            | InvocationTargetException
            | InstantiationException
            | IllegalAccessException e)
        {
            System.err.println("ReflectionInAccessibleApp: An exception occurred: " + e.getMessage());
        } catch (InaccessibleObjectException e) {
            System.err.println("ReflectionInAccessibleApp - InaccessibleObjectException: " + e);
        }
    }
}
