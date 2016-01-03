package com.prateek.Permutation;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GeneratePermutations {
	private Map<String,Integer> visitedVertex = Maps.newHashMap();
	private List<String> permutations = Lists.newArrayList();
	private List<Integer> visitedIndexes = Lists.newArrayList();
	
	public List<String> generatePermutations(final String input) {
		final char arr[] = input.toCharArray();
		int i = 0;
		final int height = 0;
		while (i < arr.length) {
		    prepareListOfVisitedIndexes(i);
			generate(arr, i, height + 1, null);
			i++;
		}
		return permutations;
	}

	private List<Integer> prepareListOfVisitedIndexes(final Integer visited)  {
	   visitedIndexes.clear();
	   visitedIndexes.add(visited);
	   return visitedIndexes;
	}

	private void generate(final char[] arr, final int i, int height, String str) {
		List<Integer> visitedVertexIndexes = ImmutableList.copyOf(visitedIndexes);
		if (height == 1) {
			str = new String(((Character)arr[i]).toString());
			
			if (height == arr.length) {
				permutations.add(str);
			}
			
			if (isVertexExplored(str)) {
				return;
			}
		}
			
		if (height != arr.length) {
			final List<Integer> decisions = getDecisions(arr);
			for (int j = 0; j < decisions.size(); j++) {
				visitedIndexes.add(decisions.get(j));
				str += ((Character)arr[decisions.get(j)]).toString();
				if ((!isVertexExplored(str)) && visitedIndexes.size() != arr.length) {
					generate(arr, i, height + 1, new String(str));
					str = str.substring(0, str.length() - 1);
					visitedIndexes = Lists.newArrayList(visitedVertexIndexes);
				} else {
					if (str.length() == arr.length) {
						permutations.add(str);
					} else {
						str = str.substring(0, str.length() - 1);
						visitedIndexes = Lists.newArrayList(visitedVertexIndexes);
					}
				}
			}
		} 
	}
	
	private boolean isVertexExplored(final String str) {
		if (null != visitedVertex.get(str)) 
			return true;
		else {
			visitedVertex.put(str, new Integer(1));
			return false;
		}
	}

	private List<Integer> getDecisions(final char arr[]) {
		final List<Integer> decisionList = Lists.newArrayList();
		for (int i = 0; i < arr.length; i++) {
			if (!visitedIndexes.contains(i))
				decisionList.add(i);
		}
		return decisionList;
	}
}
