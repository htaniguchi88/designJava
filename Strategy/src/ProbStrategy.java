import java.util.Random;

public class ProbStrategy implements Strategy {
	
	private Random random;
	private int prevHandValue = 0;
	private int currentHandValue = 0;
	
	// [前回出した手] [今回だす手]
	private int[][] history = {
			{1, 1, 1, },
			{1, 1, 1, },
			{1, 1, 1, },
	};
	
	public ProbStrategy(int seed) {
		random = new Random(seed);
	}
	
	@Override
	public Hand nextHand () {
		// グーチョキパー勝数の合計から乱数生成
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue = 0;
		// グーの範囲
		if (bet < history[currentHandValue][0]) {
			handvalue = 0;
		// チョキの範囲
		} else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
			handvalue = 1;
		// パーの範囲
		} else {
			handvalue = 2;
		}
		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	}

	private int getSum(int hv) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += history[hv][i];
		}
		return sum;
	}
	
	public void study(boolean win) {
		if (win) {
			history[prevHandValue][currentHandValue]++;
		} else {
			history[prevHandValue][(currentHandValue +1)%3]++;
			history[prevHandValue][(currentHandValue +2)%3]++;
		}
	}	

}
