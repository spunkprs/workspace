package com.prateek.ReflectionPractice;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionPracticeClass {

	public static void main(final String... arg) throws ClassNotFoundException, NoSuchFieldException, SecurityException, 
	InstantiationException, IllegalAccessException {
		//The entry point for all reflection operations is java.lang.Class
		/*
		final String s = "prateek"; 
		Class c1 = String.class;
		Class c2 = s.getClass();
		System.out.println(c1.getName());
		System.out.println(c2.getSimpleName());
		
		System.out.println(Class.forName("java.lang.Double"));
		System.out.println(Double.TYPE);
		*/
		System.out.println(Modifier.toString(Serializable.class.getModifiers()));
		
		Class<?> practiceClass = Class.forName("com.prateek.ReflectionPractice.PracticeClass");
		System.out.println(practiceClass.getSuperclass().getSimpleName());
		
		/*
		for (Class<?> c : practiceClass.getClasses()) {
			System.out.println(c.getName());
			System.out.println(c.getDeclaringClass());
			System.out.println(Modifier.toString(c.getDeclaringClass().getModifiers()));
			for (Annotation annotation : c.getDeclaringClass().getAnnotations()) {
				System.out.println(annotation);
			}
		}
		
		System.out.println("break");
		
		for (Method method : practiceClass.getMethods()) {
			System.out.println(method.getClass());
		}
		*/
		for (Field field : practiceClass.getDeclaredFields()) {
			System.out.println(field);
		}
		
		for (Method method : practiceClass.getDeclaredMethods()) {
			 for (Annotation annotation : method.getAnnotations()) {
				 System.out.println(annotation);
			 }
		}
		
		PracticeClass object = (PracticeClass)practiceClass.newInstance();
		object.practiceMethod();
	}
}
