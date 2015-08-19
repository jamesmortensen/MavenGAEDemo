package com.setmore.myapp;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		DateFetcher dateFetcher = new DateFetcher();
		long dateAsLong = 0;
		dateAsLong = dateFetcher.getDateAsLong();

		resp.setContentType("text/plain");
		resp.getWriter().write("Today's Date is " + dateAsLong );
		
	}

}
