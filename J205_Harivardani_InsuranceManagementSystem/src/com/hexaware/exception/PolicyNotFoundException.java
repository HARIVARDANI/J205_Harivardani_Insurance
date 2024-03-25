package com.hexaware.exception;


@SuppressWarnings("serial")
public class PolicyNotFoundException extends Exception {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}
