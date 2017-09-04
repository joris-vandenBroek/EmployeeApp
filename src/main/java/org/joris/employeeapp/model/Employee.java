package org.joris.employeeapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
 
    private int id;
    private String name;
    private int partnerId;
 
    // This default constructor is required if there are other constructors.
    public Employee() {
 
    }
 
    public Employee(int id, String name, int partnerId) {
        this.id = id;
        this.name = name;
        this.partnerId = partnerId;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getPartnerId() {
        return partnerId;
    }
 
    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }
 
}