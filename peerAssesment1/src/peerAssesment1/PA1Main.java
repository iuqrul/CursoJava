package peerAssesment1;

public class PA1Main {

	public PA1Main () {
		
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
	}

	/**
	 * 
	 * @param preyPred is the array of results, with the initial hares in preyPred[0] and initial lynxes in preyPred[1] 
	 * @param a the array with the two constant for hares
	 * @param b the array with the two constant for lynxes
	 * @param n number of periods
	 * @return preyPred array with calculations from 2 to 2 * (n - 1) + 1
	 * 
	 * This could be a test main function: 
	 
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
		
	}

	 */
	static double[] preyPredLV(double[] preyPred, double[] a, double[] b, int n) {
	
		/*
		 * i is the previous calculation position of hares, and i + 1 the previous calculation of lynxes
		 * i + 2 is the position of hares in this calculation, and i + 3 is the position of lynxes of this calculation
		 */
		
		for (int i = 0; i < n * 2 ; i+=2) {
			
			/*
			 * the function base is H[n+1] = H[n] * (1 + a1 - a2*L[n])
			 * the Hares are in pair positions: 0, 2, 4 .. 2 * (n - 1)   
			 */
			
			preyPred[i + 2] = preyPred[i] * (1 + a[0] - a[1] * preyPred[i + 1]); 
					
			
			/*
			 * the function base is L[n+1] = L[n] * (1 - b1 +b2*H[n])
			 * the Lynxes are in the odd positions: 1, 3, 5 .. 2 * (n - 1) + 1
			 */
			preyPred[i + 3] = preyPred[i + 1] * (1 - b[0] + b[1] * preyPred[i]); 
			
		}
		
		return preyPred;
		
	}
}
