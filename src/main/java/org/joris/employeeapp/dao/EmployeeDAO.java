package org.joris.employeeapp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joris.employeeapp.model.Employee;
 
public class EmployeeDAO {
 
    private static final Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
 
    public static Employee getEmployee(int id) throws ValidationException {
    	validateId(id);
        return empMap.get(id);
    }

 
    public static Employee addEmployee(Employee emp) throws ValidationException {
    	// If id = 0 is was not numeric
    	if(emp.getId() == 0) {
    		throw new ValidationException("Employee id must be numeric");
    	}
    	
    	// Check if Employee Id is unique
    	if (!empMap.isEmpty() && empMap.containsKey(emp.getId())) {
    		throw new ValidationException("Employee id already exists.");
    	}
    	
    	validatePartnerId(emp);
    	setPartnerIdForPartnerAsWell(emp);
    	
        empMap.put(emp.getId(), emp);
        return emp;
    }


	private static void setPartnerIdForPartnerAsWell(Employee emp) {
		if (emp.getPartnerId() != 0) {
    		Employee employee = empMap.get(emp.getPartnerId());
    		employee.setPartnerId(emp.getId());
    	}
	}

    public static Employee updateEmployee(Employee emp) throws ValidationException {
    	validateId(emp.getId());
    	validatePartnerId(emp);
    	setPartnerIdForPartnerAsWell(emp);
        empMap.put(emp.getId(), emp);
        return emp;
    }
 
    public static void deleteEmployee(int id) throws ValidationException {
    	validateId(id);    	
    	// Check if id is partner somewhere if so remove
		for (Employee employee : empMap.values()) {
			if (employee.getPartnerId() == id) {
				employee.setPartnerId(0);
			}
		}
        empMap.remove(id);
    }
 
    public static List<Employee> getAllEmployees() throws ValidationException {
      	if (empMap.isEmpty()) {
    		throw new ValidationException("No employees found.");
    	}
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }

    private static void validateId(int id) throws ValidationException {
    	// Check if id exists
    	if (empMap.isEmpty() || !empMap.containsKey(id)) {
    		throw new ValidationException("Employee id does not exist");
    	}
    }

	private static void validatePartnerId(Employee emp) throws ValidationException {
		if (emp.getPartnerId() != 0) {
    		// Check if partnerId is equal to employeeId
    		if(emp.getPartnerId() == emp.getId()) {
    			System.out.println("Partner id and employee id can not be the same.");
        		throw new ValidationException("Partner id and employee id can not be the same.");
    		}
    		
        	// Check is partnerId is a valid Employee id
    		if (!empMap.containsKey(emp.getPartnerId())) {
    			System.out.println("Partner id is not a valid employee.");
        		throw new ValidationException("Partner id is not a valid employee.");
    		}
        	// Check if partnerId is already registered somewhere
    		for (Employee employee : empMap.values()) {
    			if (employee.getPartnerId() == emp.getPartnerId()) {
    				System.out.println("Partner id is already listed as partner for another employee.");
            		throw new ValidationException("Partner id is already listed as partner for another employee.");
    			}
			}
    	}
	}

}
