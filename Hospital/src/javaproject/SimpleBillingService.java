package javaproject;

public class SimpleBillingService extends BillingService {
	 public SimpleBillingService(double rate) {
	        this.ratePerDay = rate;
	    }

	    public double calculateBill(Patient patient) {
	        return patient.getDays() * ratePerDay;
	    }
	

}