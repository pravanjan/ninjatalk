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
	public static PaymentProcessor paymentProcessor   = null ;
	@BeforeClass
	public static void setup(){
		//paymentProcessor = new PaymentProcessor(new PayPalFake());
	}
	@Test
	public void testPayment(){
		PayPal fakepaypal = Mockito.mock(PayPal.class);
		paymentProcessor = new PaymentProcessor(fakepaypal);
		 when(fakepaypal.makePayment(30)).thenReturn(true);
		
		assertEquals(true, paymentProcessor.makePayment(30));
	}
	

}
