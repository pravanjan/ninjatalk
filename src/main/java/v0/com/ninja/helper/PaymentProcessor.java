package v0.com.ninja.helper;

import v0.com.ninja.thirdparty.PaymentType;

public class PaymentProcessor {
	PaymentType  paymentType;
	
	
	PaymentProcessor (PaymentType paymentType){
	this.paymentType = paymentType;
	}
	
	
	public Boolean makePayment(int amount ){
		return paymentType.makePayment(amount);
	}
	
	public static String   getPayment(String paymentId){
		
		return PaymentHelper.processGet(paymentId);
		
	}
	
	public static String   callPrivate(String paymentId){
		
		return PaymentHelper.callPrivate(paymentId);
		
	}
	

}
