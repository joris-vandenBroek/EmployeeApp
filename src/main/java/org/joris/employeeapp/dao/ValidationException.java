package org.joris.employeeapp.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public class ValidationException extends Exception {

	public String message;

	public ValidationException() {
	}

	public ValidationException(String message) {
		this.message = message;
		// TODO Auto-generated constructor stub
	}

    // Overrides Exception's getMessage()
    @Override
    public String getMessage(){
        return message;
    }

}
