package org.joris.employeeapp.model;

import java.util.Comparator;

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
    
    /*Comparator for sorting the list by name*/
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

	public int compare(Employee e1, Employee e2) {
	   String name1 = e1.getName().toUpperCase();
	   String name2 = e2.getName().toUpperCase();

	   //ascending order
	   return name1.compareTo(name2);

	   //descending order
	   //return name2.compareTo(name1);
    }};

    /*Comparator for sorting the list by id*/
    public static Comparator<Employee> IdComparator = new Comparator<Employee>() {

	public int compare(Employee e1, Employee e2) {

	   int id1 = e1.getId();
	   int id2 = e2.getId();

	   /*For ascending order*/
	   return id1-id2;

	   /*For descending order*/
	   //id2-id11;
   }};
 
}