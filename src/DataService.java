import java.util.Scanner;

public class DataService {
	
	InputValidator validator;
	SequenceData data;
	ConsensusMatrix m;
	ConsensusSeq consenSeq;
	ResidueSeq resiSeq;
	PositionWeightMatrix pwm;
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
	}
	
	public void generateData() {
		this.m = new ConsensusMatrix(this.data, this.data.getSequenceSize());
		m.printMatrix();
		consenSeq = new ConsensusSeq(m.getMatrix(), m.getLength());
		consenSeq.printSequence();
		resiSeq = new ResidueSeq(m.getMatrix(),m.length,data);
		resiSeq.printResidueSequence();
		pwm = new PositionWeightMatrix(m.getMatrix(),m.getLength(),data.getNumberOfSequences());
		pwm.printMatrix(1);
		pwm.printMatrix(2);
	}
	
	public SequenceData getData() { return this.data; }
	
}
