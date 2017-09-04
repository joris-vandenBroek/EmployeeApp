package org.joris.employeeapp.service;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joris.employeeapp.dao.EmployeeDAO;
import org.joris.employeeapp.dao.ValidationException;
import org.joris.employeeapp.model.Employee;
 
@Path("/employees")
public class EmployeeService {
 
    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getEmployees_JSON(@QueryParam("sortBy") String sortBy) {
    	try {
    		List<Employee> listOfEmployees = EmployeeDAO.getAllEmployees();
    		if("id".equals(sortBy)) {
    			Collections.sort(listOfEmployees, Employee.IdComparator);
    		}
    		if("name".equals(sortBy)) {
    			Collections.sort(listOfEmployees, Employee.NameComparator);
    		}
    		GenericEntity<List<Employee>> entity
    	        = new GenericEntity<List<Employee>>(listOfEmployees) {};
            return Response.ok().entity(entity).build();
        } catch (ValidationException e) 	{
        	return Response.ok().entity(createValidationMessage(e)).build();
		}
    }

 
    // URI:
    // /contextPath/servletPath/employees/{id}
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getEmployee(@PathParam("id") int id) {
    	try {
	        Employee employee =  EmployeeDAO.getEmployee(id);
	        return Response.ok().entity(employee).build();
	    } catch (ValidationException e) 	{
	    	return Response.ok().entity(createValidationMessage(e)).build();
		}
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addEmployee(Employee emp) {
    	try {
            Employee employee =  EmployeeDAO.addEmployee(emp);
            return Response.ok().entity(employee).build();
        } catch (ValidationException e) 	{
        	return Response.ok().entity(createValidationMessage(e)).build();
		}
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateEmployee(Employee emp) {
    	try {
            Employee employee =  EmployeeDAO.updateEmployee(emp);
            return Response.ok().entity(employee).build();
        } catch (ValidationException e) 	{
        	return Response.ok().entity(createValidationMessage(e)).build();
		}
    }
 
    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteEmployee(@PathParam("id") int id) {
    	try {
            EmployeeDAO.deleteEmployee(id);
            return Response.ok().entity("{\"message:\": \"Employee with id " + id + " has been deleted\"}").build();
        } catch (ValidationException e) 	{
        	return Response.ok().entity(createValidationMessage(e)).build();
		}
    }
 
	private String createValidationMessage(ValidationException e) {
		return "{\"message:\": \"" + e.getMessage() + "\"}";
	}

}