package com.prateek.javaconceptsbrushup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MakingUseOfVariousMapImplementations {

	public static void main(String[] args) {
     final Map<String, String> mapOne = new HashMap<String, String>();
     final Map<String, String> mapTwo = new LinkedHashMap<String, String>();
     final Map<String, String> mapThree = new TreeMap<String, String>();
     final Map nonGenericMap = new TreeMap();
     final Map<Model, String> mapFour = new TreeMap<MakingUseOfVariousMapImplementations.Model, String>();
     
     MakingUseOfVariousMapImplementations obj = new MakingUseOfVariousMapImplementations();
     MakingUseOfVariousMapImplementations.Model modelOne = obj.new Model(10);
     MakingUseOfVariousMapImplementations.Model modelTwo = obj.new Model(20);
     
     makeUseOfTreeMap(mapThree);
     //makeUseOfNonGenericMap(nonGenericMap);
     mapFour.put(modelTwo, "abcd");
     mapFour.put(modelOne, "xyzw");
     printValues(mapFour);
	}

	private static void makeUseOfNonGenericMap(Map nonGenericMap) {
		nonGenericMap.put("Prateek", "Bareilly");
		nonGenericMap.put("Alok", "Kanpur");
		nonGenericMap.put(1, 2);
	}

	private static void makeUseOfTreeMap(Map<String, String> mapThree) {
		mapThree.put("Prateek", "Bareilly");
		mapThree.put("Alok", "Kanpur");
		mapThree.put("Bhaskar", "Patna");
		mapThree.put("Gaurav", "Kota");
		
		printValues(mapThree);
	}

	
	
	private static <K,V> void printValues(Map<K, V> mapThree) {
		Set<K> keySet = mapThree.keySet();
		
		for (K key : keySet) {
			System.out.println("Value for" +" "+ key +"------>"+" "+mapThree.get(key));
		}
	}
	
	 class Model implements Comparable<Model>{
		final int number;
		
		Model(final int number) {
			this.number = number;
		}
		
		public int getNumber() {
			return this.number;
		}
		
		public int compareTo(Model model) {
			if(this.number > model.getNumber()) {
				return 1;
			} else if (this.number < model.getNumber()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
