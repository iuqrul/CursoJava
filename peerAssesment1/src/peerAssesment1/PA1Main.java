package peerAssesment1;

public class PA1Main {

	public PA1Main() {

	}

	public static void main(String[] args) {

		final double a1 = 0.1;
		final double a2 = 0.01;
		final double b1 = 0.01;
		final double b2 = 0.00002;
		final double h0 = 300;
		final double l0 = 20;

		int n = 200;
		double[] preyPred = new double[2 * (n + 1)];
		double[] a = new double[2];
		double[] b = new double[2];
		double[] result;

		a[0] = a1;
		a[1] = a2;
		b[0] = b1;
		b[1] = b2;

		preyPred[0] = h0;
		preyPred[1] = l0;

		result = preyPredLV(preyPred, a, b, n);
		System.out.println("Snowshoe hares: " + Double.toString(result[2 * n]));
		System.out.println("Lynxes: " + Double.toString(result[2 * n + 1]));

		result = preyPredLV_5(preyPred, a, b, n);

		System.out.println("Snowshoe hares: " + Double.toString(result[2 * n]));
		System.out.println("Lynxes: " + Double.toString(result[2 * n + 1]));
	}

	/**
	 * 
	 * @param preyPred
	 *            is the array of results, with the initial hares in preyPred[0]
	 *            and initial lynxes in preyPred[1]
	 * @param a
	 *            the array with the two constant for hares
	 * @param b
	 *            the array with the two constant for lynxes
	 * @param n
	 *            number of periods
	 * @return preyPred array with calculations from 2 to 2 * (n - 1) + 1
	 * 
	 *         This could be a test main function:
	 * 
	 *         public static void main(String[] args) {
	 * 
	 *         final double a1 = 0.1; final double a2 = 0.01; final double b1 =
	 *         0.01; final double b2 = 0.00002; final double h0 = 300; final
	 *         double l0 = 20;
	 * 
	 *         int n = 200; double[] preyPred = new double[2 * (n + 1)];
	 *         double[] a = new double[2]; double[] b = new double[2]; double[]
	 *         result;
	 * 
	 *         a[0] = a1; a[1] = a2; b[0] = b1; b[1] = b2;
	 * 
	 *         preyPred[0] = h0; preyPred[1] = l0;
	 * 
	 *         result = preyPredLV(preyPred, a, b, n);
	 * 
	 *         System.out.println("Snowshoe hares: " + Double.toString(result[2
	 *         * n])); System.out.println("Lynxes: " + Double.toString(result[2
	 *         * n + 1]));
	 * 
	 *         }
	 */
	static double[] preyPredLV(double[] preyPred, double[] a, double[] b, int n) {

		/*
		 * i is the previous calculation position of hares, and i + 1 the
		 * previous calculation of lynxes i + 2 is the position of hares in this
		 * calculation, and i + 3 is the position of lynxes of this calculation
		 */

		for (int i = 0; i < n * 2; i += 2) {

			/*
			 * the function base is H[n+1] = H[n] * (1 + a1 - a2*L[n]) the Hares
			 * are in pair positions: 0, 2, 4 .. 2 * (n - 1)
			 */

			preyPred[i + 2] = preyPred[i] * (1 + a[0] - a[1] * preyPred[i + 1]);

			/*
			 * the function base is L[n+1] = L[n] * (1 - b1 +b2*H[n]) the Lynxes
			 * are in the odd positions: 1, 3, 5 .. 2 * (n - 1) + 1
			 */
			preyPred[i + 3] = preyPred[i + 1] * (1 - b[0] + b[1] * preyPred[i]);

		}

		return preyPred;

	}

	/**
	 * This takes the data in the preyPred array, initializes it into population
	 * variables, and then *uses those variables to calculate the future
	 * population, until the number of cycles desired *is reached.
	 *
	 * @param harepop
	 *            the population of hares double
	 * @param lynxpop
	 *            the population of lynxes double
	 * @param a0
	 *            the first a constant double
	 * @param a1
	 *            the second a constant double
	 * @param b0
	 *            the first a constant double
	 * @param b1
	 *            the second b constant double
	 * @param n
	 *            the number of periods that should be used for the final
	 *            population
	 * @return the population of hares and lynxes in an array
	 */
	// static double[] preyPredLV_1(double[] preyPred, double[] a, double[] b,
	// int n) {
	//
	// double harePop= preyPred[0];
	// double lynxPop=preyPred[1];
	//
	// for (int i=1; i<=n; i++) {
	// harePop= harePop * (1 + a[0] - a[1]*lynxPop);
	// lynxPop= lynxPop * (1 - b[0] +b[1]*harePop);
	// }
	//
	// return double preyPred[]= {harePop,lynxPop};
	// }

	/**
	 * Method to calculate dynamic between a population of snow hares and lynx
	 * based on the Lotka-Volterra model.
	 *
	 * @param preyPred
	 *            an array containing the initial number of snow hares in
	 *            preyPred[0] and the initial number of lynx in preyPred[1].
	 * @param a
	 *            an array containing the constants for the hare population used
	 *            in the Lotka-Volterra model. a[0] = a1 and a[1] = a2.
	 * @param b
	 *            an array containing the constants for the lynx population used
	 *            in the Lotka-Volterra model. b[0] = b1 and b[1] = b2.
	 * @param n
	 *            an integer specifying the number of iterations or time
	 *            periods.
	 * @return preyPred an array returning the final calculated values of snow
	 *         hares in preyPred[0] and lynx in preyPred[1] at the end of time
	 *         period n.
	 */

	public static double[] preyPredLV_2(double[] preyPred, double[] a,
			double[] b, int n) {

		double[] preyPredTemp = { 0, 0 };

		/**
		 * Calculation loop
		 */
		for (int i = 1; i <= n; i++) {
			preyPredTemp[0] = preyPred[0] * (1 + a[0] - a[1] * preyPred[1]); // calculate
																				// new
																				// hare
																				// population
																				// and
																				// assign
																				// to
																				// temporary
																				// array
			preyPredTemp[1] = preyPred[1] * (1 - b[0] + b[1] * preyPred[0]); // calculate
																				// new
																				// lynx
																				// population
																				// and
																				// assign
																				// to
																				// temporary
																				// array
			preyPred[0] = preyPredTemp[0];
			preyPred[1] = preyPredTemp[1];
			// System.out.println("Iteration " + i); //Uncomment to display loop
			// iteration cycles.
		}
		return preyPred;
	}

	/**
	 * Calculates the population of Lynxes and Snowshoe Hares at the given
	 * number of periods based in the Lotka-Volterra model
	 *
	 * @param preyPred
	 *            contains the initial population of the Snowshoe Hares and
	 *            Lynxes
	 * @param a
	 *            contains the constants a1 and a2 from the Lotka-Volterra model
	 * @param b
	 *            contains the constants b1 and b2 from the Lotka-Volterra model
	 * @param n
	 *            number of periods at which you want to predict the future
	 *            population of snowshoe hares and lynxes
	 * @return The population of snowshoe hares and lynxes at the given number
	 *         of periods
	 */
	public static double[] preyPredLV_3(double[] preyPred, double[] a,
			double[] b, int n) {
		int i = 1; // Initialization of the Loop

		while (i <= n) {
			double s = preyPred[0];
			double l = preyPred[1];
			preyPred[0] = preyPred[0] * (1 + a[0] - a[1] * l);
			preyPred[1] = preyPred[1] * (1 - b[0] + b[1] * s);
			i++;
		}

		return preyPred;

	}

	/**
	 * Calculates the Predator-Prey models defined by Lotka and Volterra
	 *
	 * @param preyPred
	 *            an array with two doubles: the initial population of snowshoe
	 *            hares and the initial population of lynx
	 * @param a
	 *            an array of two doubles containing the constants a1 and a2
	 *            used to calculate the population of prey - snowshoe hares
	 * @param b
	 *            an array of two doubles containing the constants b1 and b2
	 *            used to calculate the population of predator - lynx
	 * @param n
	 *            the number of periods which to predict the population
	 * @return preyPred the array with two doubles: the population of snowshoe
	 *         hares and the poplulation of lynx after n periods
	 */

	static double[] preyPredLV_4(double[] preyPred, double[] a, double[] b,
			int n) {
		/*
		 * Declare array called "H" with two doubles used to calculate prey and
		 * array called "L" with two doubles used to calculate predator Two
		 * variables are required because initial values cannot be lost until
		 * both prey and predator calculations are complete
		 */
		double H[] = new double[2];
		double L[] = new double[2];

		H[0] = preyPred[0]; // initialize H[0] to initialize population of
							// snowshoe hares
		L[0] = preyPred[1]; // initialize L[0] to initialize population of lynx

		// iterative for loop to calculate population to n periods
		for (int i = 1; i <= n; i++) {
			H[1] = H[0] * (1 + a[0] - a[1] * L[0]); // Lotka-Volterra formula to
													// calculate prey
			L[1] = L[0] * (1 - b[0] + b[1] * H[0]); // Lotka-Volterra formula to
													// calculate predator
			H[0] = H[1]; // assign prey result to H[0] to prepare for next
							// iteration
			L[0] = L[1]; // assign predator result to L[0] to prepare for next
							// iteration
		}
		preyPred[0] = H[0]; // assign final prey result to preyPred[0]
		preyPred[1] = L[0]; // assign final predator result to preyPred[1]

		return preyPred; // return result
	}

	/****************** From Here ****************************/
	/**
	 * Returns the number of prey and predators remaining after n cycles of the
	 * predator-prey model. This uses the Predator-Prey model developed by Lotka
	 * and Volterra.
	 * <p>
	 * The prey and predator arguments for this method are entered as 2 element
	 * arrays. The remaining number of prey and predators is returned in as a
	 * two element array.
	 *
	 * @param preyPred
	 *            a 2 element array of doubles where element 0 = starting number
	 *            of prey element 1 = starting number of predators
	 * @param a
	 *            a 2 element array of doubles where element 0 = growth rate of
	 *            prey element 1 = loss rate of prey due to predators
	 * @param b
	 *            a 2 element array of doubles where element 0 = decline rate of
	 *            predators element 1 = growth rate of predators due to
	 *            consuming prey
	 * @param n
	 *            integer number of cycles to run the calculation
	 * @return a 2 element array of doubles where element 0 = ending number of
	 *         prey element 1 = ending number of predators
	 */
	static double[] preyPredLV_5(double[] preyPred, double[] a, double[] b,
			int n) {
		double beginPrey = 0; // beginning of each cycle counts
		double beginPred = 0;
		// perform calculation cycles based on number n from call to this method
		for (int cycle = 1; cycle <= n; cycle++) {
			// use new variables for beginning of cycle count
			// to not change beginning count during this calculation cycle
			beginPrey = preyPred[0];
			beginPred = preyPred[1];
			// caculate prey at end of this cycle
			preyPred[0] = beginPrey * (1 + a[0] - a[1] * beginPred);
			// calculate predators at end of this cycle
			preyPred[1] = beginPred * (1 - b[0] + b[1] * beginPrey);
		}

		return preyPred;
	}
	/***************** Until Here ****************************/

}
