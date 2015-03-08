package bs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.CustomerDb;
import bs.models.Customer;
import bs.models.UserAuth;

/**
 * Servlet implementation class CustomerAnalysisServlet
 */
@WebServlet("/CustomerAnalysisServlet")
public class CustomerAnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAnalysisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer target = new Customer(); 
		String action = request.getParameter("actionTag");
		List<Customer> custList = new ArrayList<Customer>();
		
		switch (action){
		case "transactiondate":
			break;
		case "customerid":
			target.setId(Integer.parseInt(request.getParameter("customerid")));

			break;
		case "customername":
			target.setFirstName(request.getParameter("customerFirstName"));
			target.setLastName(request.getParameter("customerLastName"));

			break;
		case "customeraddress":
			target.setAddress(request.getParameter("customerAddress"));
			target.setAddress2(request.getParameter("customerAddress2"));
			target.setCity(request.getParameter("customerCity"));
			target.setState(request.getParameter("customerState"));
			if (request.getParameter("customerZipcode") == null){
				target.setZipcode(Integer.parseInt(request.getParameter("customerZipcode")));
			}
			break;
		case "customeremail":
			target.setEmail(request.getParameter("customerEmail"));
			break;
		case "customerusername":
			target.setUserName(new UserAuth(request.getParameter("customerUsername"),""));
			break;
		case "customerbookidquantity":
			System.out.println(request.getParameter("customerbookid"));
			System.out.println(request.getParameter("customerbookquantity"));
			custList = CustomerDb.getCustomerByBooktoQuantityPurchase
			(Integer.parseInt(request.getParameter("customerbookid")), Integer.parseInt(request.getParameter("customerbookquantity")));
		}
		if (!action.equals("customerbookidquantity")){
			setAllNullFieldsToBlank(target);
			custList = CustomerDb.getPartialCustomer(target);
		}
		
		request.getSession().setAttribute("custResultList", custList);
		
		response.sendRedirect("SearchCustomer.jsp");	
	}
	
	private void setAllNullFieldsToBlank(Customer toMod){
		if (toMod.getId() == '\0'){
			toMod.setId(0);
		}
		if (toMod.getFirstName() == null){
			toMod.setFirstName("");
		}
		if (toMod.getLastName() == null){
			toMod.setLastName("");
		}
		if (toMod.getAddress() == null){
			toMod.setAddress("");
		}
/*		if (toMod.getAddress2() == null){
			toMod.setAddress2("");
		}*/
		if(toMod.getCity() == null){
			toMod.setCity("");
		}
		if (toMod.getState() == null){
			toMod.setState("");
		}
		if(toMod.getZipcode() == '\0'){
			toMod.setZipcode(0);
		}
		if(toMod.getEmail() == null){
			toMod.setEmail("");
		}
		if(toMod.getUserName() == null){
			toMod.setUserName(new UserAuth("",""));
		}
	}

}
