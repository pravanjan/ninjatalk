package v0.com.ninja.helper;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import v0.com.ninja.thirdparty.PayPal;
import v0.com.ninja.thirdparty.fake.PayPalFake;

public class PaymentProcessorTest {
	
	public static PaymentProcessor paymentProcessor = null;
	private static final Logger logger = Logger.getLogger(PaymentProcessorTest.class.getPackage().getName());
	@BeforeClass 
	public static  void beforeTest(){
		paymentProcessor = new PaymentProcessor(new PayPalFake());
	}
	
//	@Test
//	public void makePaymentTest() {
//		logger.info("The payment processor resposne "+paymentProcessor.processPayment(30));
//
//		assertEquals(true, paymentProcessor.processPayment(50));
//
//		
//	}
//	
//	@Test
//	public void testWithMokito() {
//		logger.info("The payment processor resposne "+paymentProcessor.processPayment(30));
//		PayPal paypal = Mockito.mock(PayPal.class);
//		paymentProcessor = new PaymentProcessor(paypal);
//
//		 when(paypal.makePayment(30)).thenReturn(true);
//
//		assertEquals(true, paymentProcessor.processPayment(30));
//
//		
//	}
//	
	@Test
	public void spyIt() {
		logger.info("The payment processor resposne "+paymentProcessor.processPayment(30));
		PayPal paypalspy = Mockito.spy(PayPal.class);
		paymentProcessor = new PaymentProcessor(paypalspy);

		doReturn(true).when(paypalspy).makePayment(30);

		assertEquals(true, paymentProcessor.processPayment(30));

		
	}

}
