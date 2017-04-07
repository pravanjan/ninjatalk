package v0.com.ninja.helper;

public class PaymentHelper {
	public static String  processGet(String id){
		return "Hey";
		
	}

	public static String callPrivate(String id){
		return privateMethod(id);
	}
	
	private static String privateMethod(String id) {
		return "I am private";
	}
	

}
