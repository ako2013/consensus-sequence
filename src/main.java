
public class main {

	public static void main(String[] args) {
		
		SequenceData data = new SequenceData(); // build data storage

		data.insert("human", "agtctgtcgtc");
		data.insert("dog", 	 "agctacgtagcc");
		data.insert("cat",   "agccggtaggaa");
		data.insert("rat",   "agcccgtcgggt");
		data.insert("pig",   "agtctgtcgcgt");

		// creating matrix from data
		ConsensusMatrix m = new ConsensusMatrix(data, data.getSequenceSize());
		m.printMatrix();
		// build consensus sequence from matrix
		ConsensusSeq seq = new ConsensusSeq(m.getMatrix(), m.getLength());
		seq.printSequence();
		// build residue sequence from matrix
		//ResidueSeq r = new ResidueSeq(m.getMatrix(),m.length,data);
		//r.printResidueSequence();
		
		//m.buildPWM();
		//m.printMatrix();
		
		PositionWeightMatrix m2 = new PositionWeightMatrix(m.getMatrix(),m.getLength(),data.getNumberOfSequences());
		
		//ApplicationGUI window = new ApplicationGUI(seq.getSequence());		
		//ApplicationGUI window = new ApplicationGUI();
	}

}