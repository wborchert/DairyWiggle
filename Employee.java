// @BC: Simple, clear, well-implemented super and subclasses. Nicely done!
import java.math.*;
public abstract class Employee {

private double effectivenessMultiplier;
private double baseWeeklySalary;
private double totalPaymentToDate;

	public Employee(double bws) {
		baseWeeklySalary = bws;
		effectivenessMultiplier = 1;
		totalPaymentToDate = 0;
	}
	
	public abstract void work();
	
	public void earnPaycheck() {
		setTotalPaymentToDate(getTotalPaymentToDate() + (baseWeeklySalary * effectivenessMultiplier));
	}
	
	public void earnBonus(double amount) {
		setTotalPaymentToDate(getTotalPaymentToDate() + amount);
	}
	
	public double getEffectivenessMultiplier() {
		return effectivenessMultiplier;
	}
	// @BC: Looking at the way your subclasses use this method, would it be worth consiering changing/ adding mutator methods?
	public void setEffectivenessMultiplier(double mult) {
		effectivenessMultiplier = mult;
	}
	
	public double getBaseWeeklySalary() {
		return baseWeeklySalary;
	}
	
	public double getTotalPaymentToDate() {
		return totalPaymentToDate;
	}
	
	public void setTotalPaymentToDate(double amount) {
		totalPaymentToDate = amount;
	}
	
	public String toString() {
		BigDecimal a = new BigDecimal(getBaseWeeklySalary() + "");
		BigDecimal b = new BigDecimal(getEffectivenessMultiplier() + "");
		BigDecimal c = new BigDecimal(getTotalPaymentToDate() + "");
		a = a.setScale(2, RoundingMode.HALF_UP);
		b = b.setScale(2, RoundingMode.HALF_UP);
		c = c.setScale(2, RoundingMode.HALF_UP); 
		return "Base Weekly Salary: $" + getBaseWeeklySalary() + ", Total Payment to Date: $" 
		+ c + ", Effectiveness: " + b;
	}
}