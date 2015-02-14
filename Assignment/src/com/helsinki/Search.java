package com.helsinki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Shubham Keshri */
/**
 * The Class Search is the class containing main method that initiates the
 * program and call different methods.
 * 
 * This program is for searching character pattern in a long string by assigning
 * index to the suffix of the string and hence searching the key in the string
 * applying the binary search algorithm.
 * 
 */
public class Search {

	/** The input String lengths. */
	static int inStringLength = 0, inkeyStringLength = 0;

	/** The input string array. */
	static InputString inputStringArray[];

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Please Enter The Character String");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String inString = reader.readLine();
		inString = inString.toLowerCase();
		if (inString.length() == 0 || inString.equals(null)) {
			System.out.println("Please Enter A Valid String!! Exiting!!");
			System.exit(0);
		}

		System.out.println("Please Enter The Key To Be Searched");
		String inKey = reader.readLine();
		inKey = inKey.toLowerCase();
		inStringLength = inString.length();
		inkeyStringLength = inKey.length();

		System.out.println("t=" + inString + "\np=" + inKey + "\n");
		inputStringArray = new Search().suffixgen(inString);

		Arrays.sort(inputStringArray, new AlphabeticComparator());

		for (int i = 0; i < inStringLength; i++) {
			inputStringArray[i].setIndex(i + 1);
		}

		new Search().display(inputStringArray);

		new Search().binarySearch(inputStringArray, inKey);

	}

	/**
	 * Suffixgen method to generate suffix of the input string and store in
	 * Array
	 *
	 * @param inString
	 *            the Input String t
	 * @return the Input String Array
	 */
	public InputString[] suffixgen(String inString) {

		InputString inputString;
		inputStringArray = new InputString[inStringLength];
		for (int i = 0; i < inStringLength; i++) {
			inputString = new InputString();
			inputString.setInString(inString.substring(i));
			inputString.setSuffindex(i + 1);
			inputStringArray[i] = inputString;

		}

		return inputStringArray;
	}

	/**
	 * Binary search method to implement the search algorithm for index based
	 * searching
	 *
	 * @param inputStringArray
	 *            the input string array
	 * @param inkeyString
	 *            the input key string
	 */
	public void binarySearch(InputString[] inputStringArray, String inkeyString) {

		double start = 1, end = inStringLength, middle = 1;
		boolean flag = false;
		int matchposition = 0;
		DecimalFormat format = new DecimalFormat("#");

		if (inkeyString.length() == 0 || inkeyString.equals(null)) {
			System.out.println("p doesn't match t and the search ends");
			System.exit(0);
		}

		while (start <= end) {

			System.out.println("Start = " + format.format(start) + " End = "
					+ format.format(end));
			middle = (start + end) / 2;
			middle = Math.ceil(middle);
			System.out.println("Middle = (" + format.format(start) + "+"
					+ format.format(end) + ")/2=" + format.format(middle));
			int middletemp = (int) middle - 1;

			flag = new Search().middleStringCheck(
					inputStringArray[middletemp].inString, inkeyString);
			if (flag == true) {
				matchposition = middletemp + 1;
				break;
			}

			if (inputStringArray[middletemp].inString.compareTo(inkeyString) > 0) {

				end = middle - 1;
				System.out.println("p<t[S[" + format.format(middle) + "].."
						+ inStringLength + "],end=middle-1="
						+ format.format(end));

			}

			if (inputStringArray[middletemp].inString.compareTo(inkeyString) < 0) {

				start = middle + 1;
				System.out.println("p>t[S[" + format.format(middle) + "].."
						+ inStringLength + "],start=middle+1="
						+ format.format(start));

			}

		}

		if (flag == true) {
			System.out.println("p matches t[S[" + format.format(matchposition)
					+ "].." + inStringLength + "] and the search ends");
		} else {
			System.out.println("p doesn't match t and the search ends");
		}

	}

	/**
	 * Middle string checking method to compare S[middle] with the key string.
	 *
	 * @param middlevalue
	 *            the middle string value
	 * @param inkeyString
	 *            the input key string
	 * @return true, if successful
	 */
	public boolean middleStringCheck(String middlevalue, String inkeyString) {

		boolean flag = false;
		if (middlevalue.length() < inkeyStringLength) {
			return flag;
		}

		middlevalue = middlevalue.substring(0, inkeyStringLength);
		if (middlevalue.equals(inkeyString)) {
			flag = true;
		}

		return flag;

	}

	/**
	 * Display method to display the Suffix Table.
	 *
	 * @param inputStringArray
	 *            the input string array
	 */
	public void display(InputString[] inputStringArray) {

		for (int i = 0; i < inStringLength; i++) {
			System.out.println("Index= " + inputStringArray[i].index + "  "
					+ inputStringArray[i].toString());
		}

	}
}
