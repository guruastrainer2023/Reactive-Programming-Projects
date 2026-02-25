
public class Circle {
	
	private int radius;
	static double pi=3.14;
	
	
	
	Circle(){
	 // constructor method
		System.out.println("Circle created");
	}
	
	Circle(int r){
		radius=r;
	}
	
	void setRadius(int r) {
		radius=r;
	}
	
	int getRadius() {
		return radius;
	}
	
	double getArea() {
		double area=radius*radius*3.14;
		return area;
	}
	
	double getDiameter() {
		double diameter=2*radius;
		return diameter;
	}
	
	static void greet() {
		//System.out.println(radius);
		System.out.println("Hello");
	}

}
