package com.prateek.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * When you serialize an object, only the object's state will be saved, not the object's class file or methods.
 * Note that serialization does not care about access modifiers. It serializes all private, public and protected and void fields. 
 * By marking any variable as transient or static it would no longer be serialized.
 * */

public class PersistAndReadSerialClass {

	private static String fileName = "Serial.txt";
	private static SerialClass serialObjectOne;
	private static SerialClass serialObjectTwo;
	
	public static void main(String[] args) {

		//writeSerialObjectToFile();
		readSerialObjectFromFile();
		
	}

	private static void readSerialObjectFromFile() {
		FileInputStream fis = null;
        ObjectInputStream in = null;
        
        try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			serialObjectTwo = (SerialClass)in.readObject();
			System.out.println("Serial Object Read From File");
			//System.out.println(serialObjectTwo);
			printDate(serialObjectOne, serialObjectTwo);
			compareObjects(serialObjectOne, serialObjectTwo);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private static void printDate(SerialClass serialObjectOne, SerialClass serialObjectTwo) {
		System.out.println("Date from first object" + " " + serialObjectOne.getCurrentTime());
		System.out.println("Date from second object" + " " + serialObjectTwo.getCurrentTime());
	}

	private static void compareObjects(final SerialClass serialObjectOne, final SerialClass serialObjectTwo) {
		if (serialObjectOne.equals(serialObjectTwo)) {
			System.out.println("Both objects are same");
		} else {
			System.out.println("Both objects are different");
		}
	}

	private static void writeSerialObjectToFile() {
		serialObjectOne = new SerialClass("CHILD");
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        
        try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(serialObjectOne);
			out.close();
			System.out.println("Serialized Object Saved In File");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
