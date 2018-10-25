
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceData data = new SequenceData(); // build data storage

		data.insert("human", "agtcagtcagtc");
		data.insert("dog", "agctacgtagcc");
		data.insert("cat", "aaccggttggaa");

		// creating matrix from data
		ConsensusMatrix m = new ConsensusMatrix(data, data.getSequenceSize());
		// build consensus sequence from matrix
		ConsensusSeq seq = new ConsensusSeq(m.getMatrix(), m.getLength());

		m.printMatrix();
		seq.printSequence();
		
		//ApplicationGUI window = new ApplicationGUI();

	}

}
