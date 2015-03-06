package bs.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.ProfitDb;

/**
 * Servlet implementation class ProfitServlet
 */
@WebServlet("/ProfitServlet")
public class ProfitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String profit;
		String sales;
		
		String startYear = request.getParameter("startyear");
		String startMonth = request.getParameter("startmonth");
		String startDay = request.getParameter("startday");
		String endYear = request.getParameter("endyear");
		String endMonth = request.getParameter("endmonth");
		String endDay = request.getParameter("endday");
		
		Calendar startCal = Calendar.getInstance();
		startCal.set(Calendar.YEAR, Integer.parseInt(startYear));
		startCal.set(Calendar.MONTH, Integer.parseInt(startMonth));
		startCal.set(Calendar.DATE, Integer.parseInt(startDay));
		
		Calendar endCal = Calendar.getInstance();
		endCal.set(Calendar.YEAR, Integer.parseInt(endYear));
		endCal.set(Calendar.MONTH, Integer.parseInt(endMonth));
		endCal.set(Calendar.DATE, Integer.parseInt(endDay));
		
	    java.sql.Date startDate = java.sql.Date.valueOf( 
	    		startCal.get(Calendar.YEAR) + "-" + 
	    				startCal.get(Calendar.MONTH) + "-" + 
	    				startCal.get(Calendar.DATE) );
	    
	    java.sql.Date endDate = java.sql.Date.valueOf( 
	    		endCal.get(Calendar.YEAR) + "-" + 
	    				endCal.get(Calendar.MONTH) + "-" + 
	    				endCal.get(Calendar.DATE) );
	    
	   profit =  ProfitDb.getProfit(startDate, endDate);
	   sales = ProfitDb.getSales(startDate, endDate);
	   
	   request.getSession().setAttribute("profit", profit);
	   request.getSession().setAttribute("sales", sales);
	   request.getSession().setAttribute("startdate", startDate);
	   request.getSession().setAttribute("enddate", endDate);
	   
	   response.sendRedirect("ProfitReport.jsp");
	    
			
	}

}
