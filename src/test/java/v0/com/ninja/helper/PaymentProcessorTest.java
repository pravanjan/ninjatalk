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

@RunWith(PowerMockRunner.class)
@PrepareForTest({PaymentHelper.class})
public class PaymentProcessorTest {
	
	public static PaymentProcessor paymentProcessor   = null ;
	public static PayPal fakePaypal  = null;
	
	
	
	@BeforeClass
	public static void setup (){
		fakePaypal = Mockito.mock(PayPal.class);
		when(fakePaypal.makePayment(30)).thenReturn(true);
		paymentProcessor = new PaymentProcessor(fakePaypal);
		
		
	}
	
	@Test 
	public void testPayPal (){
		
		
		assertEquals(true, paymentProcessor.makePayment(30));
	}
	
	
	@Test
	public void testPowerMock(){
		PowerMockito.mockStatic(PaymentHelper.class);
		PowerMockito.when(PaymentHelper.processGet("id")).thenReturn("Bye")
;		assertEquals("Hi", PaymentProcessor.getPayment("id"));
		
	}
	
	@Test
	public void testPrivate () throws Exception{
		
		PaymentHelper privatemethod = PowerMockito.spy(new PaymentHelper());
		PowerMockito.doReturn("I am private").when(privatemethod,"privateMethod","soem");
		assertEquals("I am private",PaymentProcessor.callPrivate("soem"));
		
	}
	
	
	
    
	
	
	

}
