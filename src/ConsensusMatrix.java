public class ConsensusMatrix extends Consensus {
	
	private SequenceData myData;
	
	public ConsensusMatrix(SequenceData d, int len) {
		super(len);
		this.myData = d;
		this.length = len;
		this.matrix = new int[MAX_ROW][this.length];
		this.buildMatrix();
		//this.printMatrix();
	}
	
	/*
	 *  	0 1 2 3 4 5 6 ....
	 *  A
	 *  T
	 *  C 
	 *  G
	 * 
	 * Method to build frequency matrix 
	 */
		private void buildMatrix(){
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
			System.out.println("Building matrix ... Done");
			//this.printMatrix();
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
		
		public int getLength() { return this.length; }
		public int[][] getMatrix(){ return this.matrix; }
}

