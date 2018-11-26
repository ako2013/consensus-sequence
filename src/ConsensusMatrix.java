import java.util.ArrayList;
public class ConsensusMatrix extends Consensus {

	private SequenceData myData;
	private int numberOfSeq; // number of sequences for alignment

	/**
	 * Constructor
	 *
	 * @param d   takes in a HashMap of dna strings
	 * @param len takes in the length of the dna string
	 */
	public ConsensusMatrix(SequenceData d, int len) {
		super(len);
		this.myData = d;
		this.matrix = new int[MAX_ROW][this.length];
		this.buildMatrix();
		numberOfSeq = d.getNumberOfSequences();
		residueCols = new ResidueColumn[d.getSequenceSize()];
	}

	/*
	 * 0 1 2 3 4 5 6 .... A T C G
	 *
	 * Method to build frequency matrix
	 */
	private void buildMatrix() {
		for (String item : myData.getKeys()) {

			String s = myData.getSequence(item);
			System.out.println(item + " " + s);

			for (int i = 0; i < this.length; i++) {
				// System.out.println(i);
				char letter = s.charAt(i);
				switch (letter) {
				case 'A':
					matrix[A_ROW][i] += 1;
					break;
				case 'T':
					matrix[T_ROW][i] += 1;
					;
					break;
				case 'C':
					matrix[C_ROW][i] += 1;
					;
					break;
				case 'G':
					matrix[G_ROW][i] += 1;
					;
					break;
				}
			}
		}
		System.out.println("Building matrix ... Done");
		// this.printMatrix();
	}

	public void printMatrix() {
		char residueLetter;
		for (int i = 0; i < MAX_ROW; i++) { // max row = 4
			if (i == 0){
				System.out.print("A| ");
				residueLetter = 'A';
			} else if (i == 1){
				System.out.print("T| ");
				residueLetter = 'T';
			} else if (i == 2) {
				System.out.print("C| ");
				residueLetter = 'C';
			} else {
				System.out.print("G| ");
				residueLetter = 'G';
			}

			for (int y = 0; y < this.length; y++) { // length
				if(residueCols[y] == null) residueCols[y] = new ResidueColumn();

				int val = matrix[i][y];
				if(val == numberOfSeq) {
					residueCols[y].setIsConserved();
					residueCols[y].setConservedLetter(residueLetter);
				}
				else if(val > 0) residueCols[y].setDifferences(residueLetter);
				else residueCols[y].setMissedLetters(residueLetter);

				System.out.print(val);
			}
			System.out.println();
		}
	}

	public ResidueColumn[] getResidueCols() { return this.residueCols; }

	public int getLength() {
		return this.length;
	}

	public int[][] getMatrix() {
		return this.matrix;
	}
}