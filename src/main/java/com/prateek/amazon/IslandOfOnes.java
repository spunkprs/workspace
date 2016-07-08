package com.prateek.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IslandOfOnes {
	
	private static int array[][];
	public static void main(final String ar[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numberOfTestCases = Integer.parseInt(br.readLine());
			for (int i = 1; i <= numberOfTestCases; i++) {
				String numberOfRowsAndColumns[] = br.readLine().split(" ");
				int rows = Integer.parseInt(numberOfRowsAndColumns[0]);
				int columns = Integer.parseInt(numberOfRowsAndColumns[1]);
				populateArray(rows, columns, br);
				System.out.println(countIslands(array, rows, columns));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//int arr[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
	}

	private static void populateArray(final int rows, final int columns, final BufferedReader br) {
		array = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			try {
				int j = 0;
				String st[] = br.readLine().split(" ");
				for (String s : st) {
					array[i][j] = Integer.parseInt(s);
					j++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int countIslands(int arr[][], int m, int n) {
		int count = 0;
		 
	    for(int i=0; i<m; i++)
	        for(int j=0; j<n; j++)
	            if(arr[i][j] == 1)
	            {
	                count++;
	                markIsland(arr, i, j, m, n);
	            }
	 
	    return count;
	}
	
	private static void markIsland(int arr[][], int i, int j, int m, int n)
	{
	    arr[i][j] = -1;
	 
	    if(i-1 >= 0)
	    {
	        // (i-1, j-1)
	        if(j-1 >= 0 && arr[i-1][j-1] == 1)
	            markIsland(arr, i-1, j-1, m, n);
	 
	        // (i-1, j)
	        if(arr[i-1][j] == 1)
	            markIsland(arr, i-1, j, m, n);
	 
	        // (i-1, j+1)
	        if(j+1 < n && arr[i-1][j+1] == 1)
	            markIsland(arr, i-1, j+1, m, n);
	    }
	 
	    if(i+1 < m)
	    {
	        // (i+1, j-1)
	        if(j-1 >= 0 && arr[i+1][j-1] == 1)
	            markIsland(arr, i+1, j-1, m, n);
	 
	        // (i+1, j)
	        if(arr[i+1][j] == 1)
	            markIsland(arr, i+1, j, m, n);
	 
	        // (i+1, j+1)
	        if(j+1 < n && arr[i+1][j+1] == 1)
	            markIsland(arr, i+1, j+1, m, n);
	    }
	 
	    // (i, j-1)
	    if(j-1 >= 0 && arr[i][j-1] == 1)
	        markIsland(arr, i, j-1, m, n);
	 
	    // (i, j+1)
	    if(j+1 < n && arr[i][j+1] == 1)
	        markIsland(arr, i, j+1, m, n);
	}
}
