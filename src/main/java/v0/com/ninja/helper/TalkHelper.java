package v0.com.ninja.helper;

import org.apache.log4j.Logger;

public class TalkHelper {
	private static final Logger logger = Logger .getLogger(TalkHelper.class.getPackage().getName());
	public  String  getTalk (String args ){
		logger.info("this is non static call ");
		return "ninjatalk";
		
	}
	public static String getTalkStatic(String name) {
		logger.info("this is static ******** ");

		name ="Hello "+name;
		return name;
	
	}

}
