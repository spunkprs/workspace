package com.prateek.pubmatic;

import java.awt.Component;
import java.awt.TextField;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class OptimizeCode {

	public void method(Component comp) {
		
		if (comp instanceof TextField) {
			TextField textField = (TextField)comp;
			textField.setText(""); 
			textField.setEditable(false);
		}
		}
	
	public void concatValues() {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < 20; i++) {
			result.append(getNextString());
		}
	}

	private String getNextString() {
		//Implementation is not provided in question for this method.
		return null;
	}
	
	public static void fileProcessor() {
		final int ZERO = 0;
		final int ONE = 1;
		final int TEN = 10;
		String strFileName = "C:\\demo.java"; 
		FileOutputStream fos = null;
		DataOutputStream ds = null; 
		
		try
		{
		fos = new FileOutputStream(strFileName); 
		ds = new DataOutputStream(fos);
		int i = ZERO; 
		
		/*
		 * Removed redundant loops by below single loop as all three of them were writing constant number to file.
		 * */
		
		for (int j = ZERO; j < 3*TEN; j++) {
			ds.writeByte(ONE);
		}
		
		} catch(java.io.IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (ds != null) {
					ds.close();
				}
				
				if (fos != null) {
					fos.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
