package v0.com.ninja.helper;

import v0.com.ninja.thirdparty.PaymentType;

public class PaymentProcessor {
	PaymentType paymentType = null;
	
	public PaymentProcessor(PaymentType  paymentType ) {
		this.paymentType = paymentType;
		
		
	}
	
   public Boolean  processPayment (int amount){
	  return  paymentType.makePayment(amount);
   }

}
