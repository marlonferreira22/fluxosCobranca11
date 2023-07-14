package br.com.bma.fluxosCobranca11.model;

import java.util.List;

public class Task {

	private String username;
	private String password;
	private String companyId;
	private String processInstanceId;
	private String choosedState;
	private List<Colleague>colleagueIds;
	private String comments;
	private String userId;
	private String completeTask;
	private List<Attachment>attachments;
	private List<CardData>cardData;
	private List<Appointment>appointment;
	private String managerMode;
	private String threadSequence;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getChoosedState() {
		return choosedState;
	}
	public void setChoosedState(String choosedState) {
		this.choosedState = choosedState;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCompleteTask() {
		return completeTask;
	}
	public void setCompleteTask(String completeTask) {
		this.completeTask = completeTask;
	}
	public String getManagerMode() {
		return managerMode;
	}
	public void setManagerMode(String managerMode) {
		this.managerMode = managerMode;
	}
	public String getThreadSequence() {
		return threadSequence;
	}
	public void setThreadSequence(String threadSequence) {
		this.threadSequence = threadSequence;
	}
	public List<Colleague> getColleagueIds() {
		return colleagueIds;
	}
	public void setColleagueIds(List<Colleague> colleagueIds) {
		this.colleagueIds = colleagueIds;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	public List<CardData> getCardData() {
		return cardData;
	}
	public void setCardData(List<CardData> cardData) {
		this.cardData = cardData;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	
	
	
}
