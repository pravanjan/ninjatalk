package v0.com.ninja.thirdparty;

public interface PaymentType {
  Boolean makePayment(int amount);
  public void deletePayment(String id);
  
}
