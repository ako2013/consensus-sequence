// to print as desired (support to print [ ] and {}, and N)
class ResidueColumn{
	Boolean isConserved;
	char conservedLetter;
	String missedLetters;
	String differences;

	ResidueColumn(){
		isConserved = false;
		conservedLetter = ' ';
		missedLetters = "";
		differences = "";
	}

	void setIsConserved() { isConserved = true; }
	Boolean isConserved() { return isConserved; }

	void setConservedLetter(char conservedLetter) { this.conservedLetter = conservedLetter; }
	char getConservedLetter(){ return conservedLetter; }

	 // if there is a different nucleic acid at a position, record here
	void setDifferences(char diff) { differences += diff; }
	String getDifferences() { return differences; }

	Boolean canBeAnything() { return differences.length() == Consensus.MAX_ROW; }
	Boolean canBeCurlyBraced(){ return differences.length() == Consensus.MAX_ROW - 1; }

	void setMissedLetters(char missed){ missedLetters += missed; }
	String getMissedLetters() { return missedLetters; }
}