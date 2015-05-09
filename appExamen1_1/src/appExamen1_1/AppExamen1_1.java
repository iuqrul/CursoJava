package appExamen1_1;

public class AppExamen1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int b = 2;
		int c = a/b;
		String result = a+"/"+b+"="+c;
		System.out.println (result);
		
		int n = 10;
		if (n % 5 == 0) {
		    System.out.println(n);
		} else {
		    System.out.println(n - 1);
		}
		
		
		int p = 1;
		int q = 2;
		int r = 3;
		if (r > p + q) {
		    r = 2 * p;
		}
		else if (r < p + q) {
		    r = 2 * q;
		}
		else {
		    q = 2 * r;
		}
	    System.out.println(r);
	    System.out.println(q);
	    
	    
	    String aa = "This is a String.";

	    String bb = "This is another String.";

	    String cc = "Another String this is."; 
	    if (bb.length() > cc.length()) {
	        System.out.println(bb);
	    } else if (cc.length() > bb.length()) {
	        System.out.println(cc);
	    } else {
	        System.out.println(bb.charAt(0) + "" + cc.charAt(0));
	    }
		
	    
	    if (aa.length() > bb.length()) {
	        System.out.println(aa);
	    } else if (bb.length() > aa.length()) {
	        System.out.println(bb);
	    } else {
	        System.out.println(aa + bb);
	    }
	}

}
