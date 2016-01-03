package com.prateek.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistAndReadSerializedObject {

	private static String fileName = "Man.txt";
	private static Man serialObjectOne;
	private static Man serialObjectTwo;
	
	public static void main(String[] args) {

		writeSerialObjectToFile();
		readSerialObjectFromFile();
	}
	
private static void writeSerialObjectToFile() {
		
		serialObjectOne = new Man("SPUNK", "ABCD", "BROWN");
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

private static void readSerialObjectFromFile() {
	FileInputStream fis = null;
    ObjectInputStream in = null;
    
    try {
		fis = new FileInputStream(fileName);
		in = new ObjectInputStream(fis);
		serialObjectTwo = (Man)in.readObject();
		System.out.println("Serial Object Read From File");
		compareObjects(serialObjectOne, serialObjectTwo);
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	} 
}

private static void compareObjects(final Man serialObjectOne, final Man serialObjectTwo) {
	if (serialObjectOne.equals(serialObjectTwo)) {
		System.out.println("Both objects are same");
	} else {
		System.out.println("Both objects are different");
	}
}

}
