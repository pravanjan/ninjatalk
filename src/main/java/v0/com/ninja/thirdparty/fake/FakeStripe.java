package v0.com.ninja.thirdparty.fake;

import v0.com.ninja.thirdparty.PaymentType;

public class FakeStripe implements PaymentType {

	@Override
	public Boolean makePayment(int amount) {
		return true;
	}

	@Override
	public void deletePayment(String id) {
		// TODO Auto-generated method stub
		
	}
	

}
