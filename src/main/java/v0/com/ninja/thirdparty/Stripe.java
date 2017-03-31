package v0.com.ninja.thirdparty;

public class Stripe implements PaymentType {

	@Override
	public Boolean makePayment(int amount) {
		return true;
	}

	@Override
	public void deletePayment(String id) {
	
	}

}
