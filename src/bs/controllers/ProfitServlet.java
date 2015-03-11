package bs.controllers;

import java.io.IOException;
import java.util.Calendar;

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
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profit;
		String sales;
		String profit1;
		String sales1;
		
		String startYear = request.getParameter("startyear");
		String startMonth = request.getParameter("startmonth");
		String startDay = request.getParameter("startday");
		String endYear = request.getParameter("endyear");
		String endMonth = request.getParameter("endmonth");
		String endDay = request.getParameter("endday");
		
		String startYear1 = request.getParameter("startyear1");
		String startMonth1 = request.getParameter("startmonth1");
		String startDay1 = request.getParameter("startday1");
		String endYear1 = request.getParameter("endyear1");
		String endMonth1 = request.getParameter("endmonth1");
		String endDay1 = request.getParameter("endday1");
		
		
		Calendar startCal = Calendar.getInstance();
		startCal.set(Calendar.YEAR, Integer.parseInt(startYear));
		startCal.set(Calendar.MONTH, Integer.parseInt(startMonth));
		startCal.set(Calendar.DATE, Integer.parseInt(startDay));
		
		Calendar endCal = Calendar.getInstance();
		endCal.set(Calendar.YEAR, Integer.parseInt(endYear));
		endCal.set(Calendar.MONTH, Integer.parseInt(endMonth));
		endCal.set(Calendar.DATE, Integer.parseInt(endDay));
		
		Calendar startCal1 = Calendar.getInstance();
		startCal1.set(Calendar.YEAR, Integer.parseInt(startYear1));
		startCal1.set(Calendar.MONTH, Integer.parseInt(startMonth1));
		startCal1.set(Calendar.DATE, Integer.parseInt(startDay1));
		
		System.out.println();
		Calendar endCal1 = Calendar.getInstance();
		endCal1.set(Calendar.YEAR, Integer.parseInt(endYear1));
		endCal1.set(Calendar.MONTH, Integer.parseInt(endMonth1));
		endCal1.set(Calendar.DATE, Integer.parseInt(endDay1));
		
	    java.sql.Date startDate = java.sql.Date.valueOf( 
	    		startCal.get(Calendar.YEAR) + "-" + 
	    				startCal.get(Calendar.MONTH) + "-" + 
	    				startCal.get(Calendar.DATE) );
	    
	    java.sql.Date endDate = java.sql.Date.valueOf( 
	    		endCal.get(Calendar.YEAR) + "-" + 
	    				endCal.get(Calendar.MONTH) + "-" + 
	    				endCal.get(Calendar.DATE) );
	    
	    java.sql.Date startDate1 = java.sql.Date.valueOf( 
	    		startCal1.get(Calendar.YEAR) + "-" + 
	    				startCal1.get(Calendar.MONTH) + "-" + 
	    				startCal1.get(Calendar.DATE) );
	    
	    java.sql.Date endDate1 = java.sql.Date.valueOf( 
	    		endCal1.get(Calendar.YEAR) + "-" + 
	    				endCal1.get(Calendar.MONTH) + "-" + 
	    				endCal1.get(Calendar.DATE) );
	    
	   profit =  ProfitDb.getProfit(startDate, endDate);
	   sales = ProfitDb.getSales(startDate, endDate);
	   
	   profit1 = ProfitDb.getProfit(startDate1, endDate1);
	   sales1 = ProfitDb.getProfit(startDate1, endDate1);
	   
	   request.getSession().setAttribute("profit", profit);
	   request.getSession().setAttribute("sales", sales);
	   request.getSession().setAttribute("startdate", startDate);
	   request.getSession().setAttribute("enddate", endDate);
	   
	   request.getSession().setAttribute("profit1", profit1);
	   request.getSession().setAttribute("sales1", sales1);
	   request.getSession().setAttribute("startdate1", startDate1);
	   request.getSession().setAttribute("enddate1", endDate1);
	   
	   response.sendRedirect("ProfitReport.jsp");
	    
			
	}

}
