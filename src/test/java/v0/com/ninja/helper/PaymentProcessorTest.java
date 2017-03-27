package v0.com.ninja.helper;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import v0.com.ninja.thirdparty.fake.PayPalFake;

public class PaymentProcessorTest {
	
	public static PaymentProcessor paymentProcessor = null;
	private static final Logger logger = Logger.getLogger(PaymentProcessorTest.class.getPackage().getName());
	@BeforeClass 
	public static  void beforeTest(){
		paymentProcessor = new PaymentProcessor(new PayPalFake());
	}
	
	@Test
	public void makePaymentTest() {
		logger.info("The payment processor resposne "+paymentProcessor.processPayment(30));
		
		assertEquals(true, paymentProcessor.processPayment(50));
		
	}

}
