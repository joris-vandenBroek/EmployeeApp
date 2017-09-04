package org.joris.employeeapp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joris.employeeapp.model.Employee;
 
public class EmployeeDAO {
 
    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();
 
    static {
        initEmps();
    }
 
    private static void initEmps() {
        Employee emp1 = new Employee("100", "Jan", "102");
        Employee emp2 = new Employee("101", "Piet", "");
        Employee emp3 = new Employee("102", "Anna", "100");
 
        empMap.put(emp1.getId(), emp1);
        empMap.put(emp2.getId(), emp2);
        empMap.put(emp3.getId(), emp3);
    }
 
    public static Employee getEmployee(String id) {
        return empMap.get(id);
    }
 
    public static Employee addEmployee(Employee emp) {
        empMap.put(emp.getId(), emp);
        return emp;
    }
 
    public static Employee updateEmployee(Employee emp) {
        empMap.put(emp.getId(), emp);
        return emp;
    }
 
    public static void deleteEmployee(String id) {
    	// Check if id is partner somewhere
        empMap.remove(id);
    }
 
    public static List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
     
    List<Employee> list;
 
}
