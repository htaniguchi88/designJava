

public class MiniDuckSimulator {
	public static void main(String[] args) {
		
		// Strategyパターンの学習だよ!
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		
		Duck fighter = new FighterDuck();
		fighter.performFly();
		fighter.display();
		
	}
}
