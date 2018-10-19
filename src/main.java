
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		SequenceData data = new SequenceData();
		
		data.insert("human", "agtcagtcagtc");
		data.insert("dog", "agctacgtagcc");
		data.insert("cat", "aaccggttggaa");

		ConsensusMatrix m = new ConsensusMatrix(data, data.getSequenceSize());
		ConsensusSeq seq = new ConsensusSeq(m.getMatrix(), m.getLength());
		
		m.printMatrix();
		seq.printSequence();

	}

}
