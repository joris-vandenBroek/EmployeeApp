package org.joris.employeeapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
 
    private String id;
    private String name;
    private String partnerId;
 
    // This default constructor is required if there are other constructors.
    public Employee() {
 
    }
 
    public Employee(String id, String name, String partnerId) {
        this.id = id;
        this.name = name;
        this.partnerId = partnerId;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPartnerId() {
        return partnerId;
    }
 
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
 
}