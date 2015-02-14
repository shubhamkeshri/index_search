package com.helsinki;

// TODO: Auto-generated Javadoc
/**
 * The Class InputString.
 */
public class InputString {

	/** The in string. */
	String inString;
	
	/** The index. */
	int suffindex, index;

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Instantiates a new input string.
	 */
	public InputString() {
		inString = null;
		suffindex = 0;
	}

	/**
	 * Instantiates a new input string.
	 *
	 * @param instring the instring
	 * @param suffindex the suffindex
	 * @param index the index
	 */
	public InputString(String instring, int suffindex, int index) {
		instring = this.inString;
		suffindex = this.suffindex;
		index = this.index;

	}

	/**
	 * Gets the in string.
	 *
	 * @return the in string
	 */
	public String getInString() {
		return inString;
	}

	/**
	 * Sets the in string.
	 *
	 * @param inString the new in string
	 */
	public void setInString(String inString) {
		this.inString = inString;
	}

	/**
	 * Gets the suffindex.
	 *
	 * @return the suffindex
	 */
	public int getSuffindex() {
		return suffindex;
	}

	/**
	 * Sets the suffindex.
	 *
	 * @param suffindex the new suffindex
	 */
	public void setSuffindex(int suffindex) {
		this.suffindex = suffindex;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Suffix_Index= " + this.suffindex + "  Suffix= " + this.inString;
	}

}
