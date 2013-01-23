public class Moover extends Employee {

	public Moover(double bws) {
		super(bws);
	}
	
	public void work() {
		takeOrder();
		deliverShake();
	}
	
	public void takeOrder() {
		double i = Math.random(); 
		if(i <= 0.2) {
			setEffectivenessMultiplier(getEffectivenessMultiplier() - 0.1);
		}
		else {
			setEffectivenessMultiplier(getEffectivenessMultiplier() + 0.05);
		}
	}
	
	public void deliverShake() {
		double i = Math.random(); 
		if(i <= 0.05) {
			setEffectivenessMultiplier(getEffectivenessMultiplier() - 0.1);
		}
		else {
			setEffectivenessMultiplier(getEffectivenessMultiplier() + 0.03);
		}
	}
}