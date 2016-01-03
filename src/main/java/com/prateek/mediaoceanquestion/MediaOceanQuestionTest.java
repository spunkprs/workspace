package com.prateek.mediaoceanquestion;

public class MediaOceanQuestionTest {

	public static void main(final String at[]) {
		
		final String st = "5#9#6#4#6#8#9#7#0#1#";
		System.out.println(MediaOceanQuestion.validTriangleSum(st));
		
		final String st1 = "5#9#6#4#6#8#0#7#1";
		System.out.println(MediaOceanQuestion.validTriangleSum(st1));
	}
}
