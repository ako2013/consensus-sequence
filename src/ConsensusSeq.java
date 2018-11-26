public class ConsensusSeq extends Consensus {

	private String consensusSeq, cResidueCols;

	/**
	 * Constructor
	 * @param m takes in a matrix array
	 * @param len takes in the length of the dna string
	 */
	public ConsensusSeq(int[][] m, int len, ResidueColumn[] residueCols){
		super(len);
		this.matrix = m;
		this.residueCols = residueCols;
		this.buildConsesus();
	}

	private void buildConsesus(){
		consensusSeq = "";
		cResidueCols = "";
		for(int i = 0; i < this.length; i++){

			//find the largest value each column
			int max1 = Math.max(this.matrix[A_ROW][i], this.matrix[T_ROW][i]);
			int max2 = Math.max(this.matrix[C_ROW][i], this.matrix[G_ROW][i]);
			int largest = Math.max(max1, max2);

			//build the string
			if(matrix[A_ROW][i] == largest) this.consensusSeq += "A";
			else if(matrix[T_ROW][i] == largest) this.consensusSeq += "T";
			else if(matrix[C_ROW][i] == largest) this.consensusSeq += "C";
			else this.consensusSeq += "G";

			//-----build cResidueCols String
			ResidueColumn temp = residueCols[i];
			if(temp.isConserved()) cResidueCols += temp.getConservedLetter();
			else if (temp.canBeAnything()) cResidueCols += 'N';
			else if (temp.canBeCurlyBraced()) cResidueCols += ("{" + temp.getMissedLetters() + "}");
			else cResidueCols += ("[" + temp.getDifferences() + "]");
;		}
		System.out.println("Calculating consensus sequence ... Done");
	}

	public String getSequence() { return this.consensusSeq; }
	public void printSequence() { System.out.println("CS:"+ this.consensusSeq); };
	public void printRCSequence() { System.out.println("RCS:" + cResidueCols); }
}