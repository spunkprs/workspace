package com.prateek.IdeasQuestionOne;

class SoftwareInfo {
	private String softwareDivision;
	private String softwareType;
	private String softwareVersion;
	
	String getSoftwareDivision() {
		return softwareDivision;
	}

	String getSoftwareType() {
		return softwareType;
	}

	String getSoftwareVersion() {
		return softwareVersion;
	}

	SoftwareInfo(final String softwareDivision, final String softwareType, final String softwareVersion) {
		this.softwareDivision = softwareDivision;
		this.softwareType = softwareType;
		this.softwareVersion = softwareVersion;
	}
	
	public int hashCode() {
		return softwareDivision.hashCode() ^ softwareType.hashCode();
	}
	
	public boolean equals(final Object obj) {
		final SoftwareInfo si = (SoftwareInfo)obj;
		if (this.softwareDivision.equals(si.getSoftwareDivision()) && this.softwareType.equals(si.getSoftwareType())) {
			return true;
		}
		return false;
	}
}
