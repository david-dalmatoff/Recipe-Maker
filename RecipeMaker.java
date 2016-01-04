/* Purpose Statement	: 
 * Author		: David Dalmatoff
 * File	Name	: RecipeMaker.java
 * Date Started	: 
 * Date Ended	: 
 */


import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class RecipeMaker {

	//@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {

		System.out.println("Created by David Dalmatoff");
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the URL: ");			//prompts user for URL
		String URL;												//string variable created to store the input URL
		URL = myScanner.next();									//assigns string variable to the entered URL
		System.out.println("");									//prints 2 blank lines for aesthetics
		System.out.println("");									//
		
		if (URL.startsWith("http://") == false){				//if the entered URL doesn't start with http, attach http to the front of the string
			URL = "http://" + URL;
		}

		if (URL.contains("allrecipes.com")){					//if URL is a valid allrecipes.com URL, do the following

			URL oracle = new URL(URL);							//creates new URL to be read by BufferedReader library
			
			//URL oracle = new URL("http://allrecipes.com/Recipe/Denises-Peanut-Chicken/Detail.aspx?evt19=1");
			//URL oracle = new URL("http://allrecipes.com/recipe/apple-pie-by-grandma-ople/");
			//BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
																//instantiates new BufferedReader to cycle through lines of website

			int print = 0;										//declares and initializes a print count (accounts for amount of sections printed in the loop)
			String title = "itemTitle";							//keywords to search the html code
			String iAmt = "ingredient-amount";
			String iName = "ingredient-name";
			String dir = "plaincharacterwrap";

			String misc = "";

			String directions = "";
			String inputLine;

			// TITLE
			while ((inputLine = in.readLine()) != null)			//while the html code has another line, we cycle through each line
				if (inputLine.contains(title)){					//if the line contains a title, we do the following:
					System.out.println("Title:");				//print the title of recipe
					System.out.println(inputLine.substring(inputLine.indexOf(">")+1,inputLine.indexOf("</")) + " - Allrecipes.com");
					System.out.println("");						//blank lines for aesthetics
					System.out.println("");
					System.out.println("Ingredients:");			//print the title of ingredients
				}

			// INGREDIENTS subsection:
			//Prints out numerical amount of ingredient (cups, tablespoons, teaspoons, etc)
				else if (inputLine.contains(iAmt)){
					System.out.print(inputLine.substring(inputLine.indexOf(">")+1,inputLine.indexOf("</"))+ " ");
				}

			//Prints out the name of ingredient (cloves, garlic, sugar, etc)
				else if (inputLine.contains(iName)) {
					System.out.println(inputLine.substring(inputLine.indexOf(">")+1,inputLine.indexOf("</")));
				}


			//DIRECTIONS
				else if (inputLine.contains(dir)){
					System.out.println("");
					System.out.println("");
					if (print == 0){
						System.out.println("Directions:");
						print++;
					}
					System.out.println(inputLine.substring(inputLine.indexOf("\">")+2,inputLine.indexOf("</")));
				}

			// INGREDIENTS


			/*
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine.trim());
		in.close();
			 */
		}
		else {
			System.err.println("Sorry, that is an invalid \"allrecipes.com\" URL. ");
			System.exit(0);
		}
	}
}
