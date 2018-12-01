public class ConsensusSeq extends Consensus {

	private String consensusSeq;

	/**
	 * Constructor
	 * @param m takes in a matrix array
	 * @param len takes in the length of the dna string
	 */
	public ConsensusSeq(int[][] m, int len){
		super(len);
		this.matrix = m;
		this.buildConsesus(); //invoke the object to build the data
	}

	/**
	 * This method build the Consensus sequence
	 */
	private void buildConsesus(){
		consensusSeq = "";
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
;		}
	}
	
	/**
	 * This method returns a String of analyzed consensus sequence
	 * 
	 * @return
	 */
	public String getSequence() { return "Consensus Sequence :\n"+ this.consensusSeq.toLowerCase(); }
	
	/**
	 * This method output the analyzed consensus sequence to CLI
	 */
	public void printSequence() { System.out.println("Consensus Sequence :\n"+ this.consensusSeq); };
}