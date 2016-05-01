package com.prateek.IdeasQuestionOne;

import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {
	
	private Application application;
	
	@Before
	public void setUp() {
		application = new Application();
	}

	@Test
	public void shouldReadFromFileAndWriteToFile() {
		application.execute();
	}
}
