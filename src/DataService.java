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
		consenSeq = new ConsensusSeq(m.getMatrix(), m.getLength());
		resiSeq = new ResidueSeq(m.getMatrix(),m.length,data);
		pwm = new PositionWeightMatrix(m.getMatrix(),m.getLength(),data.getNumberOfSequences());
	}
	
	public SequenceData getData() { return this.data; }
	
	public String getConsesusSeq() { return this.consenSeq.getSequence(); }
	
	public String getFreqMatrix() { return this.m.toString(); }
	
	public String getResidueSeq() { return this.resiSeq.getSequence(); }
	
	public String getPWMatrix() { return this.pwm.getMatrix(1); }
	
	public String getPPMatrix() { return this.pwm.getMatrix(2); }
	
	public String getScorePWMatrix(String s) { return Double.toString(this.pwm.calcScore(s, 1));}
	
	public String getScorePPMatrix(String s) { return Double.toString(this.pwm.calcScore(s, 2));}
}
