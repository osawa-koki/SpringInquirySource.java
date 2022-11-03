package com.example.demo.service;

// BL(ビジネスロジック)上からスローする。
public class InquiryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InquiryNotFoundException(String message) {
		super(message);
	}

}