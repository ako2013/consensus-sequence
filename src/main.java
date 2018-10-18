
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		SequenceData data = new SequenceData();
		
		data.insert("human", "agtcagtcagtc");
		data.insert("dog", "agctacgtagcc");
		data.insert("cat", "aaccggttggaa");

		Consensus seq = new Consensus(data, data.getSequenceSize());
		//seq.printMatrix();

	}

}
