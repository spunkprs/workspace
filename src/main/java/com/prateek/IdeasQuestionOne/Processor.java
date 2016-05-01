package com.prateek.IdeasQuestionOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {

	private Map<SoftwareInfo, String> softwareKindToVersionMap = new HashMap<SoftwareInfo, String>();
	private Map<String, List<SoftwareInfo>> serverNameToInfoMap = new HashMap<String, List<SoftwareInfo>>();
	
	List<String> fetchServersWithOldVersionOfSoftwares() {
		final List<String> serverNames = new ArrayList<String>();
		for (String serverName : serverNameToInfoMap.keySet()) {
			for (SoftwareInfo softwareInfo : serverNameToInfoMap.get(serverName)) {
				if (compareVersions(softwareKindToVersionMap.get(softwareInfo), softwareInfo.getSoftwareVersion())) {
					serverNames.add(serverName);
					break;
				}
			}
		}
		return serverNames;
	}
	
	void process(final List<String> input) {
		for (String dataInfo : input) {
			final String[] info = dataInfo.split(",");
			final SoftwareInfo si = new SoftwareInfo(info[1].trim(), info[2].trim(), info[3].trim());
			prepareSoftwareKindToVersionMap(si);
			prepareServerNameToInfoMap(info[0], si);
		}
	}
	
	private void prepareServerNameToInfoMap(final String serverName, final SoftwareInfo si) {
		if (!serverNameToInfoMap.containsKey(serverName)) {
			List<SoftwareInfo> softwareInfos = new ArrayList<SoftwareInfo>();
			softwareInfos.add(si);
			serverNameToInfoMap.put(serverName, softwareInfos);
		} else {
			List<SoftwareInfo> softwareInfos = serverNameToInfoMap.get(serverName);
			softwareInfos.add(si);
		}
	}

	private void prepareSoftwareKindToVersionMap(final SoftwareInfo si) {
		if (!softwareKindToVersionMap.containsKey(si)) {
			softwareKindToVersionMap.put(si, si.getSoftwareVersion());
		} else {
			String version = softwareKindToVersionMap.get(si);
			if (compareVersions(si.getSoftwareVersion(), version)) {
				softwareKindToVersionMap.put(si, si.getSoftwareVersion());
			}
		}
	}

	private boolean compareVersions(String newVersion, String previousVersion) {
		final String newVersionSplit[] = newVersion.split("\\.");
		final String previousVersionSplit[] = previousVersion.split("\\.");
		for(int i = 0; i < previousVersionSplit.length; i++) {
			Integer previousVersionPart = Integer.parseInt(previousVersionSplit[i]);
			Integer newVersionPart = Integer.parseInt(newVersionSplit[i]);
			if (newVersionPart > previousVersionPart) {
				return true;
			}
		}
		return false;
	}
	
	Map<SoftwareInfo, String> getSoftwareKindToVersionMap() {
		return softwareKindToVersionMap;
	}

	Map<String, List<SoftwareInfo>> getServerNameToInfoMap() {
		return serverNameToInfoMap;
	}

	void setSoftwareKindToVersionMap(Map<SoftwareInfo, String> softwareKindToVersionMap) {
		this.softwareKindToVersionMap = softwareKindToVersionMap;
	}

	void setserverNameToInfoMap(Map<String, List<SoftwareInfo>> serverNameToInfoMap) {
		this.serverNameToInfoMap = serverNameToInfoMap;
	}
}
