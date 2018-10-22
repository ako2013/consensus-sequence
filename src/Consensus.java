
public class Consensus {

	public static final int MAX_ROW = 4; // A T C G
	public static final int A_ROW = 0;
	public static final int T_ROW = 1;
	public static final int C_ROW = 2;
	public static final int G_ROW = 3;

	protected int[][] matrix;
	protected int length;

	/**
	 * Constructor
	 * 
	 * @param len takes in the length of the dna string
	 */
	public Consensus(int len) {
		this.length = len;
	}
}
