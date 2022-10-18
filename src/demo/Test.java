package demo;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
	        String[] array1 = {"A", "B", "C"};
	        String[] array2 = {"D", "E", "F"};

	        int aLen = array1.length;
	        int bLen = array2.length;
	        String[] result = new String[aLen + bLen];

	        System.arraycopy(array1, 0, result, 0, aLen);
	        System.arraycopy(array2, 0, result, aLen, bLen);

	        System.out.println(Arrays.toString(result));
	    

	}

}
