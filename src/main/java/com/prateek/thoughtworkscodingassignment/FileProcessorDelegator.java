package com.prateek.thoughtworkscodingassignment;

import java.util.ArrayList;
import java.util.List;
/*Responsible for providing the suitable FileProcessor. 
 * */
public class FileProcessorDelegator {

	private static final String space = " ";
	private static final String HOW = "how";
	private static final String CREDITS = "Credits";
	
	private List<FileProcessor> processors;
	private static FileProcessorDelegator fileProcessorDelegator;
	
	private FileProcessorDelegator() {
		processors = new ArrayList<FileProcessor>();
		processors.add(new FileProcessorSectionOne());
		processors.add(new FileProcessorSectionTwo());
		processors.add(new FileProcessorSectionThree());
	}
	
	protected static FileProcessorDelegator getInstance() {
		if (fileProcessorDelegator == null) {
			fileProcessorDelegator = new FileProcessorDelegator();
			return fileProcessorDelegator;
		} else {
			return fileProcessorDelegator;
		}
	}
	
	protected void delegate(final String line) {
		try {
			if (checkForPresenceOfRomanCharacter(line)) {
				processors.get(0).parseAndProcess(line);
			} else if (line.contains(CREDITS) && !line.contains(HOW)) {
				processors.get(1).parseAndProcess(line);
			} else if (line.contains(HOW)) {
				processors.get(2).parseAndProcess(line);
			} else {
				
			}
		} catch(final Exception e) {
			//Can log error messages here
		}
	}
	
	public List<FileProcessor> getProcessors() {
		return this.processors;
	}

	private boolean checkForPresenceOfRomanCharacter(final String line) {
		String prefix = "is" + space;
		for (RomanCharacters romanCharacter : RomanCharacters.values()) {
			prefix = prefix + romanCharacter.getNameOfCharacter();
			if (line.contains(prefix)) {
				return true;
			} else {
				prefix = "is" + space;
			}
		}
		return false;
	}
}
