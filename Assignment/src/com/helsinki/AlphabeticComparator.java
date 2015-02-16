package com.helsinki;

import java.util.Comparator;

/**
 * The Class AlphabeticComparator, a comparator class to compare two strings
 * alphabetically.
 */
public class AlphabeticComparator implements Comparator<Object> {

	/*
	 * Method compare which returns negative,zero or positive integer if string
	 * string2 is alphabetically
	 */
	@Override
	public int compare(Object arg0, Object arg1) {

		InputString inputString1 = (InputString) arg0;
		InputString inputString2 = (InputString) arg1;
		return inputString1.inString.compareTo(inputString2.inString);
	}

}
