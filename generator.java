/**
*Code Generator for PRN Workflow.
*This program reads a .txt file and generates the code
*needed to assign the raw data to variables in the Imposition Script
*
*	Version 1.0
*	Author @JSmyth
*	11.06.2017
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class generator {
    
    public static void main(String[] args){

	try {
	    File file = new File(args[0]);
	    FileReader fileReader = new FileReader(file);
	    BufferedReader bR = new BufferedReader(fileReader);
	    String s="";
	    char [] r2;
	    int i=0,j=0;
	    char[][] c = new char[7][45];
 			while((s = bR.readLine())!=null){
 				r2=s.toCharArray();

 				for (j=0;j<r2.length;j++ ) {
					c[i][j]=r2[j];
					System.out.print(""+c[i][j]); 					
 				}
 				i++;
 				System.out.println("\n");
 			}



 			for (int y=0;y<c.length;y++ ) {
 				System.out.print("Output_0.Records.");
 				//For loop checks the variable names of the second part
 				//checks for spaces and replace with '_'
 				//Chekcs for apostrophe and removes. 
 				for (int m=20;m<c[y].length;m++) {
 					if (c[y][m]==' ') {
 						c[y][m]='_';
 					}
 					if (c[y][m]=='\'') {
 						c[y][m]='\b';
 					}
 					System.out.print(c[y][m]);
 				}
 				System.out.print(" = Input_0.Array[i].R");
 				for (int x = 0;x<19;x++ ) {
 	 				if (c[y][x]==' ') {
 						c[y][x]='_';
 					}
 					System.out.print(c[y][x]);
 				}
 				System.out.print(" = line.mid(16);");
 				System.out.print("\n");
 			}


 			// for (int r=0;r<20;r++ ) {
 			// 	System.out.print(c[0][r]);
 				
 			// }
 			// System.out.print("\n");

 		}catch(IOException io){
	
	    io.printStackTrace();
	}
}
}
