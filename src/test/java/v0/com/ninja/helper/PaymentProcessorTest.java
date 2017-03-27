package v0.com.ninja.helper;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import v0.com.ninja.thirdparty.fake.PayPalFake;

public class PaymentProcessorTest {
	
	public static PaymentProcessor paymentProcessor = null;
	@BeforeClass 
	public static  void beforeTest(){
		paymentProcessor = new PaymentProcessor(new PayPalFake());
	}
	
	@Test
	public void makePaymentTest() {
		assertEquals(true, paymentProcessor.processPayment(50));
		
	}

}
