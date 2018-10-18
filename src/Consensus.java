import java.util.HashSet;
import java.util.Set;

public class Consensus {
	
	private static final int MAX_ROW = 4; // A T C G
	private static final int A_ROW = 0;
	private static final int T_ROW = 1;
	private static final int C_ROW = 2;
	private static final int G_ROW = 3;
	
	private String consensusSeq;
	private SequenceData myData;
	private int[][] matrix;
	private int length; // string length of the sequence
	
	//Constructor
	public Consensus(SequenceData d, int len){
		this.myData = d;
		this.length = len;
		this.matrix = new int[MAX_ROW][this.length];
		this.buildMatrix();
		this.printMatrix();
		this.buildConsesus();
	}
	
	/*
	 *  	0 1 2 3 4 5 6 ....
	 *  A
	 *  T
	 *  C 
	 *  G
	 * 
	 */
	//Method to build frequency matrix 
	public void buildMatrix(){
		for(String item: myData.getKeys()){
			
			String s = myData.getSequence(item);
			System.out.println(item+ " "+s);
						
			for(int i = 0; i < this.length; i++){
				//System.out.println(i);
				char letter = s.charAt(i);
				switch(letter){
				case 'A':
					matrix[A_ROW][i] += 1;
					break;
				case 'T':
					matrix[T_ROW][i] += 1;;
					break;
				case 'C':
					matrix[C_ROW][i] += 1;;
					break;
				case 'G':
					matrix[G_ROW][i] += 1;;
					break;
				}
			}
		}
		System.out.println("Done");
		//this.printMatrix();
	}
	
	public void printMatrix(){
		for(int i = 0; i< MAX_ROW;i++){
			
			if(i == 0) 		System.out.print("A| ");
			else if(i == 1) System.out.print("T| ");
			else if(i == 2) System.out.print("C| ");
			else 		    System.out.print("G| ");
			
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
			if(matrix[A_ROW][i] == largest)		 this.consensusSeq += "A";
			else if(matrix[T_ROW][i] == largest) this.consensusSeq += "T";
			else if(matrix[C_ROW][i] == largest) this.consensusSeq += "C";
			else 								 this.consensusSeq += "G";
;		}
		
		System.out.println("CS:"+ this.consensusSeq);
	}
}
