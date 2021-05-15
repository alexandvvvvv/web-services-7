package com.juddi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "CoffeeService")
public class CoffeeWebService {

	@WebMethod(operationName = "getCoffees")
	public List<Coffee> getCoffees() {
		PostgreSQLDAO dao = new PostgreSQLDAO();
		return dao.getCoffees();
	}
	@WebMethod(operationName = "getFilteredCoffees")
	public List<Coffee> getFilteredCoffees(@WebParam(name="filter")CoffeeFilter filter) {
		PostgreSQLDAO dao = new PostgreSQLDAO();
		return dao.getFilteredCoffees(filter);
	}
}