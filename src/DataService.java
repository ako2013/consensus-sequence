import java.util.Scanner;

public class DataService {
	
	SequenceData data;
	ConsensusMatrix m;
	ConsensusSeq seq;
	Scanner scan;
	
	public DataService() {
		data = new SequenceData();
	}
	
	public void insertData(String s) {
	    final int ITEM_NAME = 0;
		final int ITEM_SEQ = 1;
		String[] words;
		scan = new Scanner(s);

		while(scan.hasNextLine()) {
			words = scan.nextLine().split(" ");
			//System.out.println("NAME: "+words[ITEM_NAME]);
			//System.out.println("SEQ: "+words[ITEM_SEQ]);
			data.insert(words[ITEM_NAME], words[ITEM_SEQ]);
		}
		
		// creating matrix from data
		ConsensusMatrix m = new ConsensusMatrix(data, data.getSequenceSize());
		// build consensus sequence from matrix
		ConsensusSeq seq = new ConsensusSeq(m.getMatrix(), m.getLength());
		m.printMatrix();
		seq.printSequence();
	}
	
}
