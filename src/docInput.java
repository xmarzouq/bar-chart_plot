/**
 * @author Mohamed Ali
 * @since 29-01-2021
 * @QUID 201912476
 * 
 */

/**
 * 
 */

import java.util.*;
import java.io.*;

public class docInput {
	private static Scanner input;
	private static File fileObj;
	
	public static void main(String[] args) throws FileNotFoundException {
		input = new Scanner(System.in);
		if(open()) {read();}
		else {System.exit(0);}
		close();
	} //end of main block.
	
	public static boolean open() throws FileNotFoundException {
		System.out.print("Enter file name: ");
		String fileName = input.next();
		//Path path = Paths.get(fileName);
		fileObj = new File(fileName);
		if(fileObj.exists()) {
			//System.out.println("The document is opened successfully.");
			return true;
		}
		else {
			System.out.println("Cannot find the document !");
			return false;
		}
	} //end of method block.
	
	public static void read() throws FileNotFoundException {
		String data = "";
		input = new Scanner(fileObj);
		char alphabets[] = new char[26]; 
        int frequencies[] = new int[26]; 
        char c = 'a';
        for(int i=0; i<26; i++) {
        	alphabets[i]=c;
        	frequencies[i]=0;      
            c++;
        }
		while(input.hasNext()) {
			char check;
			data = input.nextLine();
			data = data.toLowerCase();
			int length = data.length();
			char[] charArray = data.toCharArray();
	        for(int i=0; i<26; i++) {
	            for(int j=0; j<length; j++) {
	                check = charArray[j]; 
	                if(check == alphabets[i]) 
	                	frequencies[i]++; 
	            }
	        }
		}
		output(alphabets, frequencies);
	} //End of method block.
	
	public static void output (char[] alphabets, int[] frequencies) {

        System.out.println("Alphabet\tFrequency");
        System.out.println("__________________________");
		
		for(int i=0; i<26; i++)
        {
            if(frequencies[i]!=0) {
            	System.out.print("   "+alphabets[i]+"\t\t");
            	for (int j=0; j<=frequencies[i]; j++)
            	{System.out.print("|");}
            	System.out.println();
            }
        }
	} //end of method block.
	
	public static void close() {
		input.close();
	}
}
