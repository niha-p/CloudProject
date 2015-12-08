package servlets;

import helperClasses.DatabaseQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.*;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String user="root";
	static String password="";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String t=(String) request.getParameter("sb");
		System.out.println(t);
		String c=(String) request.getParameter("category");
		System.out.println(c);
		
		String addr=(String) request.getParameter("address");
		System.out.println(addr);
		//String q2="SELECT * FROM product WHERE `description` LIKE %"+t+"%";
		String query="";
		String query1="";
		if(t!=null)
		{
			if(c.equals("all"))
			{
				query="SELECT COUNT(*) FROM product WHERE (`product_name` LIKE '%"+t+"%' OR `description` LIKE '%"+t+"%') AND status=0";
				query1="SELECT * FROM product WHERE (`product_name` LIKE '%"+t+"%' OR `description` LIKE '%"+t+"%') AND status=0";
			}
			else
			{
				query="SELECT COUNT(*) FROM product WHERE (`product_name` LIKE '%"+t+"%' OR `description` LIKE '%"+t+"%') AND status=0 AND `category` LIKE '%"+c+"%'" ;
				query1="SELECT * FROM product WHERE (`product_name` LIKE '%"+t+"%' OR `description` LIKE '%"+t+"%') AND status=0 AND `category` LIKE '%"+c+"%'" ;
			}
		}
		System.out.println("QUERY="+query);
		//String query="SELECT COUNT(*) FROM product WHERE (`product_name` LIKE '%"+t+"%' OR `description` LIKE '%"+t+"%') AND status=0";
        ResultSet rs2=DatabaseQuery.getResultSet(query);
        int number=0;
        try {
			if(rs2.next()){
				number=rs2.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //query="SELECT * FROM product WHERE (`product_name` LIKE '%"+t+"%' OR `description` LIKE '%"+t+"%') AND status=0";
		ResultSet rs=DatabaseQuery.getResultSet(query1);
		String[] names=new String[number];
		double[] prices=new double[number];
		String[] descriptions=new String[number];
		String[] image1=new String[number];
		int[] product_id=new int[number];
		
		int i=0;
		try {
			while(rs.next()){
				product_id[i]=rs.getInt("product_id");
				names[i]=rs.getString("product_name");
				prices[i]=rs.getDouble("price");
				descriptions[i]=rs.getString("description");
				image1[i]=rs.getString("image1");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("search", t);
		request.setAttribute("pid", product_id);
		request.setAttribute("names",names);
		request.setAttribute("prices",prices);
		request.setAttribute("descriptions",descriptions);
		request.setAttribute("image1",image1);
		request.setAttribute("number",number);
		
		request.getRequestDispatcher("SearchPage.jsp").forward(request, response);

	}
	
	/*
	public double getDistance(String source, String destination)
	{
		double distance=0;
		String URLs="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&mode=bicycling&language=fr-FR&key=YOUR_API_KEY";
		try {
	        //URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address="+ URIUtil.encodeQuery("Sayaji Hotel, Near balewadi stadium, pune") + "&sensor=true");
	        //URL url=new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+ URIUtil.encodeQuery(source) +"&destinations="+ URIUtil.encodeQuery(destination) +"&mode=bicycling&language=fr-FR&key=YOUR_API_KEY");
			URL url=new URL(URLs);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());}
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	        String output = "", full = "";
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	            full += output;
	        }

	        PincodeVerify gson = new Gson().fromJson(full, PincodeVerify.class); 
	        response = new IsPincodeSupportedResponse(new PincodeVerifyConcrete(
	                gson.getResults().get(0).getFormatted_address(), 
	                gson.getResults().get(0).getGeometry().getLocation().getLat(),
	                gson.getResults().get(0).getGeometry().getLocation().getLng())) ;
	        try {
	            String address = response.getAddress();
	            Double latitude = response.getLatitude(), longitude = response.getLongitude();
	            if (address == null || address.length() <= 0) {
	               // log.error("Address is null");
	            }
	        } catch (NullPointerException e) {
	            //log.error("Address, latitude on longitude is null");
	        	
	        }
	        conn.disconnect();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		
		return distance;
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
