package javaproject;
import java.util.Scanner;
public class MainApp{
	 public static void main(String[] args) {

	        Hospital hospital = new Hospital();
	        BillingService billing = new SimpleBillingService(1000);
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1 Admit Patient");
	            System.out.println("2 Discharge Patient");
	            System.out.println("3 List Patients");
	            System.out.println("4 Calculate Bill");
	            System.out.println("5 Occupancy");
	            System.out.println("6 Exit");

	            int choice = sc.nextInt();

	            try {
	                switch (choice) {
	                case 1:
	                    System.out.print("ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Age: ");
	                    int age = sc.nextInt();
	                    System.out.print("Days: ");
	                    int days = sc.nextInt();

	                    hospital.admitPatient(Ward.GENERAL,
	                            new Patient(id, name, age, days));
	                    break;

	                case 2:
	                    System.out.print("ID: ");
	                    int pid = sc.nextInt();
	                    hospital.dischargePatient(Ward.GENERAL, pid);
	                    break;

	                case 3:
	                    hospital.listPatients();
	                    break;

	                case 4:
	                    System.out.print("Days: ");
	                    int d = sc.nextInt();
	                    Patient temp = new Patient(0, "Temp", 0, d);
	                    System.out.println("Bill = " + billing.calculateBill(temp));
	                    break;

	                case 5:
	                    hospital.occupancy();
	                    break;

	                case 6:
	                    sc.close();
	                    System.out.println("Thank you !");
	                    return;
	                }
	            } catch (Exception e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }

}