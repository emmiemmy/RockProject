package project;

import java.io.Serializable;

public class Information implements Serializable {
	// Band
	private int bandID;
	private String bandName;
	private String genre;
	private String country;
	// Medlem
	private int memberID;
	private String memberName;
	private int fkBandID;
	private String partytrick;

	/**
	 * Bandinformation
	 * @param inBandID
	 * @param inName
	 * @param inGenre
	 * @param inCountry
	 */
	public Information(int inBandID, String inName, String inGenre,
			String inCountry) {
		this.bandID = inBandID;
		this.bandName = inName;
		this.genre = inGenre;
		this.country = inCountry;
	}

	/**
	 * Medlemsinformation
	 * @param inMemberID
	 * @param inMemberName
	 * @param inFkBandID
	 * @param inPartytrick
	 */
	public Information(int inMemberID, String inMemberName, int inFkBandID,
			String inPartytrick) {
		this.memberID = inMemberID;
		this.memberName = inMemberName;
		this.fkBandID = inFkBandID;
		this.partytrick = inPartytrick;
	}

	// Band
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	public int getBandID() {
		return bandID;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getBandName() {
		return bandName;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
	
	// Medlem
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setFkBandID(int fkBandID) {
		this.fkBandID = fkBandID;
	}
	
	public int getFkBandID() {
		return fkBandID;
	}
	
	public void setPartytrick(String partytrick) {
		this.partytrick = partytrick;
	}
	
	public String getPartytrick() {
		return partytrick;
	}
}