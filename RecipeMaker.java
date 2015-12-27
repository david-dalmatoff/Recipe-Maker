
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class RecipeMaker {

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {

		System.out.println("David Dalmatoff");
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the URL: ");
		String URL;
		URL = myScanner.next();
		System.out.println("");
		System.out.println("");
		
		if (URL.startsWith("http://") == false){
			URL = "http://" + URL;
		}

		if (URL.contains("allrecipes.com")){

			URL oracle = new URL(URL);
			//URL oracle = new URL("http://allrecipes.com/Recipe/Denises-Peanut-Chicken/Detail.aspx?evt19=1");
			//URL oracle = new URL("http://allrecipes.com/recipe/apple-pie-by-grandma-ople/");
			//BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));



			int print = 0;
			String title = "itemTitle";
			String iAmt = "ingredient-amount";
			String iName = "ingredient-name";
			String dir = "plaincharacterwrap";

			String misc = "";

			String directions = "";
			String inputLine;

			// TITLE
			while ((inputLine = in.readLine()) != null)
				if (inputLine.contains(title)){
					System.out.println("Title:");
					System.out.println(inputLine.substring(inputLine.indexOf(">")+1,inputLine.indexOf("</")) + " - Allrecipes.com");
					System.out.println("");
					System.out.println("");
					System.out.println("Ingredients:");

				}

			// INGREDIENTS:

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
