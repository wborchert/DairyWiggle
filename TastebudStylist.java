public class TastebudStylist extends Employee {

	public TastebudStylist(double bws) {
		super(bws);
	}
	
	public void work() {
		makeShake();
	}
	
	public void makeShake() {
		double i = Math.random(); 
		if(i <= 0.1) {
			setEffectivenessMultiplier(1);
		}
		else {
			setEffectivenessMultiplier(getEffectivenessMultiplier() + 0.1);
		}
	}

}