package com.covid.exception;

public class NotFoundCovidDaily extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundCovidDaily(String message) {
		super(message);
	}

}
