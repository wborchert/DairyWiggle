public class Shaker extends Employee {

	public Shaker(double bws) {
		super(bws);
	}
	
	public void work() {
		shake();
	}
	
	public void shake() {
		setEffectivenessMultiplier(getEffectivenessMultiplier() + 0.02);
	}
}