

public class FighterDuck extends Duck {
	public FighterDuck () {
		flyBehavior = new FlySpeedy();
		quackBehavior = new Quack();
	}
	
	public void display() {
		System.out.println("戦う鴨です");
	}

}
