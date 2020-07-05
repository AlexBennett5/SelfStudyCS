
package ab.practice.tick4star;

class Statistics {

	private Pattern p;
	private int loopStart;
	private int loopEnd;
	private double maxGrowth;
	private double maxDeath;
	private int maxPop;
	private int height;
	private int width;

	Statistics(Pattern pat) throws PatternFormatException {

		p = pat;

		height = p.getHeight();
		width = p.getWidth();

		boolean[][] world = new boolean[height][width];
		p.initialise(world);
		
		getStats(world);	


	}


	private void getStats(boolean[][] world) {
		
		boolean[][][] states = new boolean[100][height][width];
		boolean[][] next = world;
		states[0] = next;

		int mpop = currentPop(next);
		int prevpop = currentPop(next);
		int currpop = 0;
		double mgrowth = 0.0;
		double mdeath = 0.0;
		double currgrowth = 0.0;
		double currdeath = 0.0;
		boolean loopDetected = false;
		loopStart = 0;
		loopEnd = 99;


		for (int i = 1; i < 100; i++) {
			

			if (loopDetected) {
				break;
			}

			if (prevpop == 0) { 
				loopStart = i-1;
				loopEnd = i;
				break; 
			}

			next = StatisticsLife.nextGeneration(next);
			states[i] = next;
			
			currpop = currentPop(next);

			currgrowth = ((currpop - prevpop)*1.0)/(prevpop*1.0);
			currdeath = ((prevpop - currpop)*1.0)/(prevpop*1.0);

			if (currpop > mpop) { mpop = currpop; }
			if (currgrowth > mgrowth) { mgrowth = currgrowth; }
			if (currdeath > mdeath) { mdeath = currdeath; }

			prevpop = currpop;

			for (int j = 0; j < i; j++) {

				if (sameWorld(states[j], states[i])) {
					loopStart = j;
					loopEnd = i-1;
					loopDetected = true;
					break;
				}
			}


		}

		this.maxPop = mpop;
		this.maxDeath = mdeath;
		this.maxGrowth = mgrowth;

		
	}


	private boolean sameWorld(boolean[][] w1, boolean[][] w2) {

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				if (w1[i][j] != w2[i][j]) {

					return false;
				}
			}
		}

		return true;


	}

	private int currentPop(boolean[][] world) {

		int pop = 0;

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				if (world[i][j])
					pop++;
			}
		}

		return pop;

	}



	public double getMaximumGrowthRate() {

		return maxGrowth;

	}

	public double getMaximumDeathRate() {

		return maxDeath;

	}

	public int getLoopStart() {

		return loopStart;

	}

	public int getLoopEnd() {

		return loopEnd;
	}

	public int getMaximumPopulation() {

		return maxPop;

	}


}


