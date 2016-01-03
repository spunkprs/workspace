package com.prateek.practicereflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Client {
	
	private static String text;
	private static int num;
	public static String name;
	
	private Client(int num) {
		
	}
	
	public Client(final String text, final int num) {
		this.text = text;
		this.num = num;
	}
	
	public void firstMethod() {
		System.out.println("Executing First Method");
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
     
		//Class cl1 = int.class;
	    //System.out.println(cl1.getSimpleName());
		
	  Class cl = Client.class;
      System.out.println(cl.getSimpleName());
      
      Class cl1 = Class.forName("com.prateek.practicereflection.Client");
      System.out.println(cl1.getName());
      
      //Modifier
      System.out.println(Modifier.isPublic(cl1.getModifiers()));
      
      //Package Information
      Package p = cl1.getPackage();
      System.out.println(p.getName());
      
      //Superclass Information
      Class superClass = cl1.getSuperclass();
      System.out.println(superClass.getName()); 
      
      //Interfaces the class has implemented(not its super classes's interfaces only the ones which this class  has implemented explicitly)
      Class interfaces[] = cl1.getInterfaces();
      System.out.println(interfaces.length);
      System.out.println(superClass.getInterfaces().length);
      
      /*
       * Getting constructors
       * */
      
      //This will fetch all the public constructors
      Constructor constructors[] = cl1.getConstructors();
      System.out.println("Number of public constructors" +" "+ constructors.length);
      
      //This will get the specified constructor depending on the type of parameter it takes
      Constructor constructor = cl1.getConstructor(String.class, int.class);
      System.out.println(constructor.getName()); 
      
      //It get all the types of the parameter which this particular constructor takes
      Class parameterTypes [] = constructor.getParameterTypes();
      
      for (Class parameterType : parameterTypes) {
    	  System.out.println(parameterType.getName());
      }
      
      //Instantiating the object using its constructor via reflection
      Client client = null;
      try {
		client = (Client)constructor.newInstance("XXX", 10);
		System.out.println(text);
		System.out.println(num); 
	} catch (Exception e) {
		e.printStackTrace();
	} 
      
      //Getting Fields and setting its values
      Field fields[] = cl1.getFields();
      System.out.println("Number of public fields" + " " + fields.length);
      try {
		Field field = cl1.getField("name");
		System.out.println("Type of public field name "+" "+ field.getType().getName());
		field.set(client, "CLIENT");
		System.out.println("Value of public field name" +" "+field.get(client));
		field.set(null, "UPDATED CLIENT");
		System.out.println("Value of public field name" +" "+field.get(null));
	} catch (Exception e) {
		e.printStackTrace();
	} 
      
      
      //Getting and invoking methods
      Method methods[] = cl1.getMethods();
      
      //It will list all the public methods that are present in it and that are present in its super classes
      System.out.println("Number of methods in super class"+" "+superClass.getMethods().length);
      System.out.println("Number of public methods" +" "+ methods.length);
      
      Method method = cl1.getMethod("firstMethod", null);
      try {
		method.invoke(client, null);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      
      //Accessing private fields
      try {
		Field privateFieldOne = cl1.getDeclaredField("text");
		Field privateFieldTwo = cl1.getDeclaredField("num");
		makePrivateFieldsAccessible(privateFieldOne, privateFieldTwo);
		
		printValuesOfPrivateFields(privateFieldOne, privateFieldTwo);
		
		//Setting Values of private fields without any setter methods
		privateFieldOne.set(null, "YYY");
		privateFieldTwo.set(null, 30);
		
		printValuesOfPrivateFields(privateFieldOne, privateFieldTwo);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	}

	private static void printValuesOfPrivateFields(Field ...fields ) {
		for (Field field : fields) {
			try {
				System.out.println("Value of private field" +" "+ field.get(null));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}

	private static void makePrivateFieldsAccessible(Field ...fields) {
		for (Field field : fields) {
			field.setAccessible(true);
		}
	}
}
