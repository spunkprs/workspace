package com.prateek.Arrays;

public class AllUniqueCharacters {
	
	public boolean allUniqueCharacters(final String string) {
		final boolean arr[] = new boolean[128];
		
		for (int i = 0; i < string.length(); i++) {
			 if (isNotUnique(arr, string.charAt(i))) {
				 return false;
			 }
		}
		return true;
	}

	private boolean isNotUnique(final boolean arr[], final char x) {
		if (!arr[x]) {
			arr[x] = true;
			return false;
		}
		return true; 
	}
}
