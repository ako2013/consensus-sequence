public class ConsensusSeq extends Consensus {

	private String consensusSeq;
	
	//Constructor
	public ConsensusSeq(int[][] m, int len){
		super(len);
		this.matrix = m;
		this.length = len;
		this.buildConsesus();
		
	}
	
	public void printMatrix(){
		for(int i = 0; i< MAX_ROW;i++){
			
			if(i == 0) System.out.print("A| ");
			else if(i == 1) System.out.print("T| ");
			else if(i == 2) System.out.print("C| ");
			else System.out.print("G| ");
			
			for(int y = 0; y < this.length; y++){				
				System.out.print(matrix[i][y]);
			}
			System.out.println();
		}
	}
	
	private void buildConsesus(){
		this.consensusSeq = "";
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
		//System.out.println("CS:"+ this.consensusSeq);
	}
	
	public String getSequence() { return this.consensusSeq; }
	public void printSequence() { System.out.println("CS:"+ this.consensusSeq); };
}
