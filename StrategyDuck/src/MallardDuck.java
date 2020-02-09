

public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Squeak();
	    flyBehavior = new FlyWithWings();
	}
	
	public void display() {
		System.out.println("本物のマガモです");
	}
}
