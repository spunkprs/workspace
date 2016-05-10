import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PharmeasyHiringChallenge {

	public static void main(String[] args) throws IOException {
		 final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	            line = br.readLine();
	            System.out.println(prepareDifficultyOfCharacters(line));
	        }
		//final String st = "oomar";
		//System.out.println(prepareDifficultyOfCharacters(line));
	}
	
	private static StringBuilder prepareDifficultyOfCharacters(final String str) {
		final char arr[] = str.toCharArray();
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		prepareMap(map, arr);
		final List<Node> nodes = sortCharactersAsPerFrequency(map);
		return processOutput(nodes, map);
	}

	private static StringBuilder processOutput(final List<Node> nodes, final Map<Character, Integer> map) {
		final StringBuilder sb = new java.lang.StringBuilder();
		for (int i = 122; i >= 97; i--) {
			char character = (char)i;
			if (!map.containsKey(character)) {
				sb.append(character);
				sb.append(" ");
			}
		}
		
		for (Node node : nodes) {
			sb.append(node.getCharacter());
			sb.append(" ");
		}
		return sb;
	}

	private static List<Node> sortCharactersAsPerFrequency(Map<Character, Integer> map) {
		final List<Node> nodes = new ArrayList<Node>();
		for (Character ch : map.keySet()) {
			final Node node = new Node(ch, map.get(ch).intValue());
			nodes.add(node);
		}
		Collections.sort(nodes);
		return nodes;
	}

	private static void prepareMap(Map<Character, Integer> map, char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				int count = map.get(arr[i]);
				map.put(arr[i], count + 1);
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		private Character character;
		private int count;
		
		public Character getCharacter() {
			return character;
		}

		public int getCount() {
			return count;
		}

		protected Node(final Character character, final int count) {
			this.character = character;
			this.count = count;
		}
		
		public int compareTo(final Node node) {
			if (this.count < node.count) {
				return -1;
			} else if (this.count == node.getCount()) {
				if (this.character < node.getCharacter()) {
					return 1;
				} else if (this.character > node.getCharacter()) {
					return -1;
				}
			}
			return 1;
		}
	}
	
}
