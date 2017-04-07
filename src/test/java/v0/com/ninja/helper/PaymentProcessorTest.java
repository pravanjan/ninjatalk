package v0.com.ninja.helper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import v0.com.ninja.thirdparty.PayPal;


public class PaymentProcessorTest {
	public static PaymentProcessor paymentProcessor = null;
	
	@BeforeClass
	public void setup(){
		paymentProcessor =  PaymentProcessor(new PayPal());
	}
	
	@Test
	public void paypaltest (){
		assertEquals(true,paymentProcessor.makePayment(30));
	}

	

}
