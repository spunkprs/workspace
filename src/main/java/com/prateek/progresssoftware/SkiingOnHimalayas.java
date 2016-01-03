package com.prateek.progresssoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Maps;

public class SkiingOnHimalayas {

	private static Map<Pair, Boolean> mapOne = Maps.newHashMap();
	private static Map<Pair, Integer> mapTwo = Maps.newHashMap();
	private static int grid[][];
	private static String location;
	private static int maximumNumberOfPointsCovered = 0;
	
	public static void main(String[] args) throws Exception {
	 File f = new File("Output.txt");
	 f.createNewFile();
	 FileOutputStream fos = new FileOutputStream(f);
	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
     FileReader fileReader = new FileReader("Input1.txt");
     BufferedReader br = new BufferedReader(fileReader);
     String line = br.readLine();
     int counterOne = 1;
     int numberOfTestCases = 0;
     int rows = 0;
     
     while((null != line)) {
    	 if (counterOne == 1) {
    		 numberOfTestCases = Integer.parseInt(line);
    	 }
    	 if (location == null && counterOne != 1) {
    		 parse(line);
    	 } else if (location != null) {
    		 if (rows == grid.length) {
    			 rows = -1;
    			 cleanCache();
    			 parse(line);
    		 } else {
    			 String columns[] = line.split(" ");
    			 populateGrid(rows, columns);
    		 }
    		 rows++;
    		 if (rows == grid.length) {
    			 writeToFile(bw);
    		 }
    	 }
    	 line = br.readLine();
    	 counterOne = 2;
     }
     bw.close();
	}

	private static void writeToFile(final BufferedWriter bw) {
		try {
			int numberOfPointsCovered = getMaximumNumberOfSkiingPointsCovered();
			bw.write(location+":"+" "+numberOfPointsCovered);
			bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void cleanCache() {
		 maximumNumberOfPointsCovered = 0;
		 mapOne = Maps.newHashMap();
		 mapTwo = Maps.newHashMap();
	}

	private static void populateGrid(int rows, String[] columns) {
		int j = 0;
		for (String column : columns) {
			grid[rows][j] = Integer.parseInt(column);
			j++;
		}
	}

	private static void parse(String line) {
		String arr[] = line.split(" ");
		location = arr[0];
		int row = Integer.parseInt(arr[1]);
		int coloumn = Integer.parseInt(arr[2]);
		grid = new int[row][coloumn];
	}
	
	private static int getMaximumNumberOfSkiingPointsCovered() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				final Pair p = new Pair(i, j);
				if (mapOne.get(p) == null || !mapOne.get(p)) {
					mapOne.put(p, true);
					calculateMaximumNumberOfSkiingPointsCovered(p);
				} 
			}
		}
		return maximumNumberOfPointsCovered;
	}

	private static void calculateMaximumNumberOfSkiingPointsCovered(final Pair pair) {
		List<Pair> adjoiningPoints = pair.getAdjoiningPoints();
		if (adjoiningPoints.isEmpty()) {
			mapTwo.put(pair, 1);
			updateMaximumNumberOfPointsCovered(1);
		} else {
			for (Pair p : adjoiningPoints) {
				mapOne.put(p, true);
				if (0 == getValue(p)) {
					calculateMaximumNumberOfSkiingPointsCovered(p);
				}  
				if (getValue(pair) - 1 < getValue(p)) {
					mapTwo.put(pair, getValue(p) + 1);
					int value = getValue(pair);
					updateMaximumNumberOfPointsCovered(value);
				}
			}
		}
	}
	
	private static void updateMaximumNumberOfPointsCovered(int value) {
		if (maximumNumberOfPointsCovered < value) {
			maximumNumberOfPointsCovered = value;
		}
	}

	private static int getValue(Pair pair) {
		final Integer value = mapTwo.get(pair);
		return value == null ? 0 : value;
	}

	public static int[][] getGrid() {
		return grid;
	}
}
