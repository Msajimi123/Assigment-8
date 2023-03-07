//Assignment #: Arizona State University Spring 2023 CSE205 #8
//Name: 
//StudentID: 
//Lecture: 
//Description:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment8 {

	public static void main(String[] args) {
		// menu
		try {


		} catch (IOException ex) {
			
		}
	}

	// A: recursive method that calculates the sum of all elements in an array of
	// doubles and returns the sum

	// B: recursive method that calculates the sum of all integers between two
	// numbers (including the two numbers) and returns the sum

	// C: recursive method that calculates the prime factorization of an integer and returns a string as a result

	// D: recursive method that removes all occurrences of a specified substring in a string and returns the result string


	// ----------------------------------------------------------------------------------------

	// utility method for parsing doubles from standard input that returns an array of doubles
	public static double[] parseDoubles(BufferedReader reader) {
		String line = "";
		ArrayList<Double> container = new ArrayList<>();
		try {
			line = reader.readLine();
			double num = Double.parseDouble(line);

			while (num != 0) {
				container.add(num);
				line = reader.readLine();
				num = Double.parseDouble(line);
			}

		} catch (IOException ex) {
			System.out.println("IO Exception.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, return to main menu.");
		}

		double[] result = new double[container.size()];
		for (int i = 0; i < container.size(); i++) {
			result[i] = container.get(i);
		}
		return result;
	}

	// utility method for parsing integers from standard input (only positive integers allowed)
    public static int readInteger(BufferedReader reader) throws IOException {
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error reading input. Please try again.");
            number = readInteger(reader);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            number = readInteger(reader);
        }
        if (number <0) {
        	System.out.println("Invalid input. Only positive integers allowed. Please try again.");
        	number = readInteger(reader);
        }
        return number;
    }

	// utility method for printing the menu
	public static void printMenu() {
		System.out.print("\nWhat would you like to do?\n\n");
		System.out.print("A: Calculate the sum of all elements in an array of doubles\n");
		System.out.print("B: Calculate the sum of all integers between two numbers (including the two numbers)\n");
		System.out.print("C: Calculate the prime factorization of an integer\n");
		System.out.print("D: Remove all occurrences of a specified substring in a string\n");
		System.out.print("E: Quit\n\n");
	}
}
