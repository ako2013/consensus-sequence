import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PositionWeightMatrix extends Consensus{
	
	private double[][] positionWeightMatrix;
	private double[][] positionProbabilityMatrix;
	private int dataLength;
	private final int PWMatrix = 1;
	private final int PPMatrix = 2;
	
	public PositionWeightMatrix(int[][] m, int len, int dataLen) {
		super(len);
		this.matrix = m;
		this.dataLength = dataLen;
		this.positionWeightMatrix = new double[MAX_ROW][this.length];
		this.positionProbabilityMatrix = new double[MAX_ROW][this.length];
		this.buildMatrix();
	}
	
	private void buildMatrix() {
		for(int row = 0; row < MAX_ROW; row++) {
			for(int i = 0; i < this.length; i++) {
				double odd = (double)this.matrix[row][i] / this.dataLength;
				this.positionWeightMatrix[row][i] = 
						this.round(
								//odd
								this.log2(odd/0.25)
								,2);
				this.positionProbabilityMatrix[row][i] = odd;
			}
		}
	}
	
	// helper method to round double to n places
	// author: https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	// helper method to calculate log2 of a number
	// modified version from: https://www.linuxquestions.org/questions/programming-9/log-base-2-function-in-java-594619/
	private double log2(double num){
		double result = (Math.log(num)/Math.log(2));
		if (result == Double.POSITIVE_INFINITY) return 99.0;
		else if(result == Double.NEGATIVE_INFINITY) return -99.0;
		return result;
	}
	
	// this method calculate score of input seq based on PWM scores
	public double calcScore(String seq, int type) {
		seq = seq.toUpperCase();
		double score = 0.0;
		
		if(type == this.PWMatrix) {
		
			for(int pos = 0; pos < seq.length(); pos++) {
				if(seq.charAt(pos) == 'A') score += this.positionWeightMatrix[A_ROW][pos];
				else if(seq.charAt(pos) == 'T') score += this.positionWeightMatrix[T_ROW][pos];
				else if(seq.charAt(pos) == 'C') score += this.positionWeightMatrix[C_ROW][pos];
				else if(seq.charAt(pos) == 'G') score += this.positionWeightMatrix[G_ROW][pos];
			}
		}
		else if(type == this.PPMatrix) {
			for(int pos = 0; pos < seq.length(); pos++) {
				if(seq.charAt(pos) == 'A') score += this.positionProbabilityMatrix[A_ROW][pos];
				else if(seq.charAt(pos) == 'T') score += this.positionProbabilityMatrix[T_ROW][pos];
				else if(seq.charAt(pos) == 'C') score += this.positionProbabilityMatrix[C_ROW][pos];
				else if(seq.charAt(pos) == 'G') score += this.positionProbabilityMatrix[G_ROW][pos];
			}
		}
		return this.round(score,2);
	}
	
	public void printMatrix(int type) {
		if(type == this.PPMatrix) {
			System.out.println("Position-Probability Matrix(%) : ");
		}
		else if(type == this.PWMatrix) {
			System.out.println("Position-Weighted Matrix: ");
		}
		
		
		for (int i = 0; i < MAX_ROW; i++) { // max row = 4
			if (i == 0){
				System.out.print("A| ");
			} else if (i == 1){
				System.out.print("T| ");
			} else if (i == 2) {
				System.out.print("C| ");
			} else {
				System.out.print("G| ");
			}

			for (int y = 0; y < this.length; y++) { // length
				double val = 0.0;
				if(type == this.PPMatrix) {
					 val = positionProbabilityMatrix[i][y];
				}
				else if(type == this.PWMatrix) {
					 val = positionWeightMatrix[i][y];
				}
				
				System.out.print(val +" |");
			}
			System.out.println();
		}
	}
	public String getMatrix(int type) {
		String s ="";
		if(type == this.PPMatrix) {
			s += "Position-Probability Matrix: \n";
		}
		else if(type == this.PWMatrix) {
			s += "Position-Weighted Matrix: \n";
		}
		
		
		for (int i = 0; i < MAX_ROW; i++) { // max row = 4
			if (i == 0){
				s += "A| ";
			} else if (i == 1){
				s += "T| ";
			} else if (i == 2) {
				s += "C| ";
			} else {
				s += "G| ";
			}

			for (int y = 0; y < this.length; y++) { // length
				double val = 0.0;
				if(type == this.PPMatrix) {
					 val = positionProbabilityMatrix[i][y];
				}
				else if(type == this.PWMatrix) {
					 val = positionWeightMatrix[i][y];
				}
				
				s += val +" |";
			}
			s += "\n";
		}
		return s;
	}
}
