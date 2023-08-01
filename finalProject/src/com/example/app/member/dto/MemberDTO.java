package com.example.app.member.dto;

public class MemberDTO {
	private int MemberNumber;
	private String MemberId;
	private String MemberPassword;
	private String MemberName;
	private int MemberAge;
	private String MemberGender;
	private String MemberEmail;
	private String MemberAddress;
	
	public MemberDTO() {	}

	public int getMemberNumber() {
		return MemberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		MemberNumber = memberNumber;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getMemberPassword() {
		return MemberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		MemberPassword = memberPassword;
	}

	public String getMemberName() {
		return MemberName;
	}

	public void setMemberName(String memberName) {
		MemberName = memberName;
	}

	public int getMemberAge() {
		return MemberAge;
	}

	public void setMemberAge(int memberAge) {
		MemberAge = memberAge;
	}

	public String getMemberGender() {
		return MemberGender;
	}

	public void setMemberGender(String memberGender) {
		MemberGender = memberGender;
	}

	public String getMemberEmail() {
		return MemberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		MemberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return MemberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		MemberAddress = memberAddress;
	}

	@Override
	public String toString() {
		return "MemberDTO [MemberNumber=" + MemberNumber + ", MemberId=" + MemberId + ", MemberPassword="
				+ MemberPassword + ", MemberName=" + MemberName + ", MemberAge=" + MemberAge + ", MemberGender="
				+ MemberGender + ", MemberEmail=" + MemberEmail + ", MemberAddress=" + MemberAddress + "]";
	}

	
	
	
	
}
