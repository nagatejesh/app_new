package com.nbc.app.exception;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(long id) {
        this(String.format("The Employee with id: %s you are looking for is not available in our database. please the id entered and try again!!", id));
    }
}
