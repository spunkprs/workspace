package com.prateek.IdeasQuestionOne;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class ProcessorTest {
	
	private Processor processor;
	private static final String SERVER_ONE = "Server1";
	private static final String SERVER_TWO = "Server2";
	private static final String SERVER_THREE = "Server3";
	
	@Before
	public void setUp() {
		processor = new Processor();
		processor.getSoftwareKindToVersionMap().clear();
		processor.getServerNameToInfoMap().clear();
	}
	
	@Test
	public void shouldFetchNamesOfServersHavingAtLeastOneSoftwareWithOldVersion() {
		final List<SoftwareInfo> softwareInfos = prepareSoftwareInfoList();
		final Map<SoftwareInfo, String> softwareToVersionMap = new HashMap<SoftwareInfo, String>();
		final Map<String, List<SoftwareInfo>> serverNameToInfoMap = new HashMap<String, List<SoftwareInfo>>();
		
		softwareToVersionMap.put(softwareInfos.get(0), softwareInfos.get(0).getSoftwareVersion());
		softwareToVersionMap.put(softwareInfos.get(2), softwareInfos.get(3).getSoftwareVersion());
		
		final List<SoftwareInfo> listOne = new ArrayList<SoftwareInfo>();
		listOne.add(softwareInfos.get(0));
		listOne.add(softwareInfos.get(3));
		serverNameToInfoMap.put(SERVER_ONE, listOne);
		
		final List<SoftwareInfo> listTwo = new ArrayList<SoftwareInfo>();
		listTwo.add(softwareInfos.get(1));
		serverNameToInfoMap.put(SERVER_TWO, listTwo);
		
		final List<SoftwareInfo> listThree = new ArrayList<SoftwareInfo>();
		listThree.add(softwareInfos.get(2));
		serverNameToInfoMap.put(SERVER_THREE, listThree);
		
		processor.setSoftwareKindToVersionMap(softwareToVersionMap);
		processor.setserverNameToInfoMap(serverNameToInfoMap);
		
		final List<String> expectedServerNames = new ArrayList<String>();
		expectedServerNames.add(SERVER_TWO);
		expectedServerNames.add(SERVER_THREE);
		
		final List<String> actualServerNames = processor.fetchServersWithOldVersionOfSoftwares();
		
		Assert.assertEquals(expectedServerNames.size(), actualServerNames.size());
		verifyServerNames(expectedServerNames, actualServerNames);
	}
	
	private void verifyServerNames(final List<String> expectedServerNames, final List<String> actualServerNames) {
		for (String serverName : expectedServerNames) {
			Assert.assertTrue(actualServerNames.contains(serverName));
		}
	}

	@Test
	public void shouldPrepareBothMaps() {
		final List<SoftwareInfo> softwareInfos = prepareSoftwareInfoList();
		
		final List<SoftwareInfo> listOne = new ArrayList<SoftwareInfo>();
		listOne.add(softwareInfos.get(0));
		listOne.add(softwareInfos.get(3));
		
		final List<SoftwareInfo> listTwo = new ArrayList<SoftwareInfo>();
		listTwo.add(softwareInfos.get(1));
		
		final List<SoftwareInfo> listThree = new ArrayList<SoftwareInfo>();
		listThree.add(softwareInfos.get(2));
		
		processor.process(prepareInput());
		
		final Map<SoftwareInfo, String> mapOne = processor.getSoftwareKindToVersionMap();
		final Map<String, List<SoftwareInfo>> mapTwo = processor.getServerNameToInfoMap();
		
		Assert.assertEquals(3, mapOne.size());
		Assert.assertEquals(3, mapTwo.size());
		Assert.assertEquals("5.5", mapOne.get(softwareInfos.get(0)));
		Assert.assertEquals("12.04", mapOne.get(softwareInfos.get(2)));
		Assert.assertEquals("2.6.3", mapOne.get(softwareInfos.get(5)));
		
		verify(listOne, mapTwo.get(SERVER_ONE));
		verify(listTwo, mapTwo.get(SERVER_TWO));
		verify(listThree, mapTwo.get(SERVER_THREE));
	}
	
	private List<String> prepareInput() {
		final List<String> input = new ArrayList<String>();
		input.add("Server1, Database, MySQL, 5.5");
		input.add("Server2, Database, MySQL, 5.1");
		input.add("Server3, OS, Ubuntu, 10.04");
		input.add("Server1, OS, Ubuntu, 12.04");
		input.add("Server2, OS, Ubuntu, 12.04");
		input.add("Server3, Language, Python, 2.6.3");
		return input;
	}

	private List<SoftwareInfo> prepareSoftwareInfoList() {
		final List<SoftwareInfo> softwareInfos = new ArrayList<SoftwareInfo>();
		
		final SoftwareInfo siOne = new SoftwareInfo("Database", "MySQL", "5.5");
		final SoftwareInfo siTwo = new SoftwareInfo("Database", "MySQL", "5.1");
		final SoftwareInfo siThree = new SoftwareInfo("OS", "Ubuntu", "10.04");
		final SoftwareInfo siFour = new SoftwareInfo("OS", "Ubuntu", "12.04");
		final SoftwareInfo siFive = new SoftwareInfo("OS", "Ubuntu", "12.04");
		final SoftwareInfo siSix = new SoftwareInfo("Language", "Python", "2.6.3");
		
		softwareInfos.add(siOne);
		softwareInfos.add(siTwo);
		softwareInfos.add(siThree);
		softwareInfos.add(siFour);
		softwareInfos.add(siFive);
		softwareInfos.add(siSix);
		
		return softwareInfos;
	}

	private void verify(final List<SoftwareInfo> expectedList, final List<SoftwareInfo> actualList) {
		for (SoftwareInfo si : expectedList) {
			Assert.assertTrue(actualList.contains(si));
		}
	}
}
