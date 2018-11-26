
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceData data = new SequenceData(); // build data storage

		data.insert("human", "agtcagtcagtc");
		data.insert("dog", "agctacgtagcc");
		data.insert("cat", "aaccggtaggaa");
		data.insert("rat", "aaccagtcgggt");

		// creating matrix from data
		ConsensusMatrix m = new ConsensusMatrix(data, data.getSequenceSize());
		m.printMatrix();
		// build consensus sequence from matrix
		ConsensusSeq seq = new ConsensusSeq(m.getMatrix(), m.getLength(), m.getResidueCols());
		seq.printSequence();
		seq.printRCSequence();

		//ApplicationGUI window = new ApplicationGUI(seq.getSequence());

	}

}