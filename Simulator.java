import java.math.*;
public class Simulator {

private Employee[] employees;
private int numEmployees = 6;

	public static void main(String[] args) {
		Simulator s = new Simulator(500.00, 200.00, 100.00);
		s.passYear();
	}

	public Simulator(double tss, double ms, double ss) {
		employees = new Employee[numEmployees];
		for(int i = 0; i < numEmployees; i++) {
			if(i < 2) {
			employees[i] = new TastebudStylist(tss);
			}
			else if(i < 4) {
			employees[i] = new Moover(ms);
			}
			else {
			employees[i] = new Shaker(ss);
			}
		}
	}
	
	public void passDay(int daynum) {
		int shakesserved = (int)(Math.random() * 150);
		for(int j = 0; j < shakesserved; j++) {
			for(int i = 0; i < numEmployees; i++) {
				employees[i].work();
			}
		}
		switch (daynum) {
			case 1: System.out.println(shakesserved + " shakes were served on Monday!");
					break;
			case 2: System.out.println(shakesserved + " shakes were served on Tuesday!");
					break;
			case 3: System.out.println(shakesserved + " shakes were served on Wednesday!");
					break;
			case 4: System.out.println(shakesserved + " shakes were served on Thursday!");
					break;
			case 5: System.out.println(shakesserved + " shakes were served on Friday!");
					break;
		}
		System.out.println("");
	}
	
	public void passWeek(int weeknum) {
		for(int i = 0; i < 5; i++) {
			passDay(i + 1);
		}
		for(int i = 0; i < numEmployees; i++) {
			employees[i].earnPaycheck();
			System.out.println("Week " + weeknum + " report for employee " + (i+1) + ": "); 
			System.out.println(employees[i]);
			employees[i].setEffectivenessMultiplier(1);
		}
		System.out.println("");
	}
	
	public void passMonth(int monthnum) {
		for(int i = 0; i < 4; i++) {
			passWeek(i + 1);
		}
		giveBonus();
		for(int i = 0; i < numEmployees; i++) {
			System.out.println("Month " + monthnum + " report for employee " + (i+1) + ": ");
			System.out.println(employees[i]);
		}
		System.out.println("");
	}
	
	public void passYear() {
		for(int i = 0; i < 12; i++) {
			passMonth(i + 1);
		}
		for(int i = 0; i < numEmployees; i++) {
			System.out.println("Year report for employee " + (i+1) + ": ");
			System.out.println(employees[i]);
		}
		double total = 0;
		for(int i = 0; i < numEmployees; i++) {
			total+= employees[i].getTotalPaymentToDate();
		}
		BigDecimal roundtotal = new BigDecimal(total + "");
		roundtotal = roundtotal.setScale(2, RoundingMode.HALF_UP);
		System.out.println("");
		System.out.println("Total amount paid to workers in the last year: $" + roundtotal);
		double moo = (int)(Math.random() * 300000) + 500000;
		BigDecimal profit = new BigDecimal(moo + "");
		profit = profit.setScale(2, RoundingMode.HALF_UP);
		System.out.println("It's a good thing you made $" + profit + " off of your overpriced milkshakes!");
	}
	
	public void giveBonus() {
		int i = (int)(Math.random() * numEmployees);
		double amount = Math.random() * 100 + 100.0;
		BigDecimal mount = new BigDecimal(amount + "");
		mount = mount.setScale(2, RoundingMode.HALF_UP);
		employees[i].earnBonus(amount);
		System.out.println("");
		System.out.println("Employee " + (i+1) + " won the line dancing competition this month and"
		+ " recieved a prize of $" + mount + "!");
		System.out.println("");
	}
}