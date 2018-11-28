import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PositionWeightMatrix extends Consensus{
	
	private double[][] positionWeightMatrix;
	private int dataLength;
	
	public PositionWeightMatrix(int[][] m, int len, int dataLen) {
		super(len);
		this.matrix = m;
		this.dataLength = dataLen;
		this.positionWeightMatrix = new double[MAX_ROW][this.length];
		this.buildPWM();
		this.printMatrix();
	}
	
	private void buildPWM() {
		for(int row = 0; row < MAX_ROW; row++) {
			double freqSum = this.findSumUsingStream(this.matrix[row]);
			for(int i = 0; i < this.length; i++) {
				double odd = (double)this.matrix[row][i] / this.dataLength * 100;
				this.positionWeightMatrix[row][i] = 
						this.round(
								//odd
								this.log2(odd/freqSum)
								,2);
			}
		}
	}
	
	// helper method to find the sum of a motif in a sequence
	// author: https://www.baeldung.com/java-array-sum-average
	public int findSumUsingStream(int[] array) {
	    return Arrays.stream(array).sum();
	}
	// helper method to round double to n places
	// author: https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	// helper method to calculate log2 of a number
	// modified version from: https://www.linuxquestions.org/questions/programming-9/log-base-2-function-in-java-594619/
	public double log2(double num){
		double result = (Math.log(num)/Math.log(2));
		if (result == Double.POSITIVE_INFINITY) return 99.0;
		else if(result == Double.NEGATIVE_INFINITY) return -99.0;
		return result;
	}
	
	public void printMatrix() {
		System.out.println("Position-Weighted Matrix: ");
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
				double val = positionWeightMatrix[i][y];
				System.out.print(val +" |");
			}
			System.out.println();
		}
	}
}
