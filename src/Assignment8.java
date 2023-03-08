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
		// Menu Options
		char inputOpt = ' ';
		String inputLine;
		double sumA; 
		int sumB, numB1, numB2, numC;
		String resultC, inputD1, inputD2, resultD;
		try {
			printMenu();
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader stdin = new BufferedReader(isr);
			do {
				inputLine = stdin.readLine().trim();
				if (inputLine.isEmpty()) {
					continue;
				}
				inputOpt = inputLine.charAt(0);
				inputOpt = Character.toUpperCase(inputOpt);

				switch(inputOpt) {
					case 'A': //Calculate the sum of all elements in an array of doubles
						System.out.print("Enter numbers (0 to finish): ");
						double[] listToCalc = parseDoubles(stdin);
						sumA = CalcSumArray(listToCalc, 0);
						System.out.print("Sum of elements in array: " + sumA + "\n");
						break;
					
					case 'B': //Calculate the sum of all integers between two numbers (including the two numbers)
						System.out.print("Enter the first number: ");
						numB1 = readInteger(stdin);
						numB2 = readInteger(stdin);
						sumB = CalcSumAtoB(numB1, numB2);
						System.out.print("The sum of all integers between " + numB1 + " and " + numB2 + " is: " + sumB + "\n");
						break;

					case 'C':
						System.out.print("Enter an integer to factorize: ");
						numC = readInteger(stdin);
						resultC = NumAFactorize(numC);
						System.out.print("The prime factorization of " + numC + " is: " + resultC + "\n");
						break;

					case 'D':
						System.out.print( "Please enter string: ");
						inputD1 = stdin.readLine().trim();
						System.out.print("Please enter substring to remove: ");
						inputD2 = stdin.readLine().trim();
						resultD = RemoveSubStr(inputD1, inputD2);
						break;

					default:
						System.out.print("Please choose a character between A and E.\n");
						break;

				}

			} while (inputOpt != 'E' || inputLine.length() != 1);
		} catch (IOException ex) {
			System.out.print("IO Exception");
		}
	}

	// A: recursive method that calculates the sum of all elements in an array of
	// doubles and returns the sum
	public static double CalcSumArray(double[] list, int index) {
		if (index >= list.length) {
			return 0.0;
		} else {
			double firstNum = list[index];
			double restSum = CalcSumArray(list, index + 1);
			return firstNum + restSum;
		}

	}

	// B: recursive method that calculates the sum of all integers between two
	// numbers (including the two numbers) and returns the sum
	public static int CalcSumAtoB(int one, int two) {

	}

	// C: recursive method that calculates the prime factorization of an integer and returns a string as a result
	public static String NumAFactorize(int one) {

	}

	// D: recursive method that removes all occurrences of a specified substring in a string and returns the result string
	public static String RemoveSubStr(String remove, String needToRemove) {

	}

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
