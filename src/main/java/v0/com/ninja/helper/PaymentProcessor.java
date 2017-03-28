package v0.com.ninja.helper;

import v0.com.ninja.thirdparty.PaymentType;

public class PaymentProcessor {
	PaymentType  paymentProcessor;
	PaymentProcessor (PaymentType paymentProcessor){
	this.paymentProcessor = paymentProcessor;
		
		
	}
	public Boolean makePayment(int amount ){
		return paymentProcessor.makePayment(amount);
	}


}
