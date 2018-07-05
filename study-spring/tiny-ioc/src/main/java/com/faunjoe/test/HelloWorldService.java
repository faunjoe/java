package com.faunjoe.test;

public class HelloWorldService {
	private String text;
	private ReferenceService referenceService;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ReferenceService getReferenceService() {
		return referenceService;
	}
	public void setReferenceService(ReferenceService referenceService) {
		this.referenceService = referenceService;
	}
	public void helloworld(){
		System.out.println(text);
	}
	public void invokeReference(){
		referenceService.doSomething();
	}
}
