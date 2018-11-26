import java.util.Scanner;

public class DataService {
	
	InputValidator validator;
	SequenceData data;
	ConsensusMatrix m;
	ConsensusSeq seq;
	Scanner scan;
	
	public DataService() {
		data = new SequenceData();
	}
	
	public boolean isValidData(String s) {
		validator = new InputValidator(s);
		if(validator.checkInput() == 0) return true; //return true if the data is validated
		return false;
	}
	
	public String getValidateError() {
		return validator.getErrorDef();
	}
	
	public void insertData(String s) {
	    final int ITEM_NAME = 0;
		final int ITEM_SEQ = 1;
		String[] words;
		scan = new Scanner(s);

		while(scan.hasNextLine()) {
			words = scan.nextLine().split(" ");
			data.insert(words[ITEM_NAME], words[ITEM_SEQ]);
		}
		
		// creating matrix from data
		m = new ConsensusMatrix(data, data.getSequenceSize());
		// build consensus sequence from matrix
		seq = new ConsensusSeq(m.getMatrix(), m.getLength());
		m.printMatrix();
		seq.printSequence();
	}
	
}
