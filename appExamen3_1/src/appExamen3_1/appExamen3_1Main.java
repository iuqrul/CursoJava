package appExamen3_1;

public class appExamen3_1Main {

	public static void main(String[] args) {

		int [] arr = {25, 7, 7, 14, 14, 14, 21, 3, 3, 3, 5, 12, 12, 13, 13};
		//System.out.println(countSorted(arr));
		//System.out.println(foo(arr, 30));
		//bar();
		
		System.out.println(foo(0));
		System.out.println(foo(1));
		System.out.println(foo(10));
		System.out.println(foo(234));
		System.out.println(foo(1234));

	}

	static int countSorted(int[] array){	
		int count = 1; 
		int max = 1;
		for (int k = 1; k < array.length; k++) {
			if (array[k-1] <= array[k]) {
				count++;
			} else {
				if (count > max) {
					max = count;
				}
				count = 1;
			}
		}
		
		if (max < count)
			max = count;
		
		return max;
	}
	
	static int foo(int[] array, int num){
	    
		int i = array.length - 1;
	    
		while (i >= 0){
	        if (array[i] > num){
	            return i;
	        }
	        i--;
	    }
	    return i;
	}
	
	static int foo(String x, int number, int[] array){
	    number = array.length;
	    x = x + "xAtfoo";
	    for (int i=0; i < number; i++){
	        array[i] = array[i] + x.length();
	    }
	    x = x + "Success";
	    return x.length();
	}
	
	static void bar(){
	    String s = new String("Hello");
	    int num = 6;
	    int [] array = {1, 2, 3, 4};
	    int result = 0;
	    result = foo(s, num, array);
	}
	
	static void bar(int[] array, int num, int lim){
	    int i = 0;
	    int v = 0;
	    while ((i < array.length) && (array[i] + num < lim)){
	        if (array[i] <= array[v]){
	            v = i; /* Statement A */
	        }  
	        i++; /* Statement B */
	    }
	    System.out.println(v);
	}
	
	static int foo(int n){
	    if (n < 1){
	        return 0;
	    } else { 
	        return 1 + foo(n / 10);
	    }
	}
}
