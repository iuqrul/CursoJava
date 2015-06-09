package appExamen2_1;

public class AppExamen2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(Bucle1(10, 20));
		//System.out.println(Bucle2(10, 20));
		CalculaFactor(33);
		//System.out.println(Array1());
	}

	public static int Bucle1 (int vA, int vB) {
		
		int resultado = 0;
		
		for (int i = vA; i < vB; i++) {
			resultado++;
		}
		
		return resultado;
		
	}
	
	public static int Bucle2 (int vA, int vB) {
		
		int resultado = 0;
		
		for (int i = vA; i <= vB; i++) {
			resultado++;
		}
		
		return resultado;
		
	}
	
	public static float CalculaFactor(int vNumero) {
		
		int count = 0;
		
		for (int factor = 2; factor <= vNumero; factor++) {
		
			while (vNumero % factor == 0){
				vNumero = vNumero / factor;
				System.out.println(String.valueOf(factor));
			}
			
		}
		
		return vNumero;
		
	}
	
	public static int Array1() {

		int array[] = {81,13,10,34,23,234,8,33};
		int value = array[0]; 
		int value2 = value;
		int resultado = 0;
		
		for (int element : array){
		    if (element > value){
		        value = element;
		    }
		    if (element < value2){
		        value2 = element;
		    }
		    resultado++;
		}
		
		System.out.println(value+" "+value2);
		
		return resultado;
		
	}

}
