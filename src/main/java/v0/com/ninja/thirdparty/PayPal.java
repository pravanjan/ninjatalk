package v0.com.ninja.thirdparty;

public class PayPal implements  PaymentType {

	@Override
	public Boolean makePayment(int amount) {
		return false;
	}

}
