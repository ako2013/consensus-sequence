import java.util.Set;

public interface SeqDataInterface {

	public void insert(String n, String seq);

	public void delete(String n);

	public String getSequence(String n);

	public Set<String> getKeys();

	public void print();

	public int getSequenceSize();
}