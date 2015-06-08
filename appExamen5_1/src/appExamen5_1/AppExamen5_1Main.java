package appExamen5_1;

import java.util.*;
import java.io.*;
import java.math.*;

public class AppExamen5_1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
		//CurrentSystemProperties();
		//Cadenas();
		//circleArea(1);
		UtilitiesSystem.foo();
	}

	public static void CurrentSystemProperties() {
		
		Properties p = System.getProperties();
		
		TimeZone t = TimeZone.getDefault();
		
		File f = new File("c:\\Haxlogs.txt");
		
		if (f.isDirectory())
			System.out.println("Es un directorio");
		else
			System.out.println("No es un directorio");
	}
	
	public static void Cadenas() {

		String a=new String ("abcdefg");
		String b=new String ("ABCDEFG");
		String c=new String ("AbcdefG");
		String d=new String ("cde");
		
		System.out.println (a.equals(b));
		System.out.println (a.equalsIgnoreCase(b)); 
		System.out.println (c.substring(2,4)); 
	}
	
	public static double circleArea (double radius){
		double first=Math.PI;
		double second=Math.abs(radius);
		double third=Math.pow(second,2);
		return first*third;
	}
}
