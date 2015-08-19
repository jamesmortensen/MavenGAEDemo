package com.setmore.myapp;

import java.util.Date;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.Objectify;

public class DateFetcher {

	public long getDateAsLong() {
		getACar();
		return ( (long) new Date().getTime() );
	}

	public int addOne(int operand) {

		return ++operand;
	}

	public void getACar() {

		Car porsche = new Car("2FAST", 0);
		//ofy().save().entity(porsche).now();    // async without the now()
		Objectify objectify = OfyService.ofy();
    	//	objectify.put(porsche);
    	objectify.save().entity(porsche);  

	}
}