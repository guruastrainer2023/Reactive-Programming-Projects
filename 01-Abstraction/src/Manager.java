
public class Manager extends Employee {
	
	public double getIncentive() {
		return getBasicSalary()*0.50;
	}
	
	
	//Method Overriding
	public double getAllowance() {
		return getBasicSalary()*0.45;
	}

}
