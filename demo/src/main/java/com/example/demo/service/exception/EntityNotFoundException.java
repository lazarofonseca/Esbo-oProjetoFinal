package com.example.demo.service.exception;

public class EntityNotFoundException extends RuntimeException{

	public EntityNotFoundException(String msg) {
		super(msg);
	}
}
