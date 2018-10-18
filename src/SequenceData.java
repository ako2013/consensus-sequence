
import java.util.HashMap; 
import java.util.Map;
import java.util.Set; 

public class SequenceData {
	
	private HashMap<String,String> map;;
	
	//Constructor
	public SequenceData(){
		this.map = new HashMap<>();
	}
	
	public void insert(String n, String seq){
		seq = seq.toUpperCase();
		this.map.put(n, seq);
	}
	
	public void delete(String n){
		if(this.map.containsKey(n)) this.map.remove(n);
		else System.out.println("ERROR DELETE");
	}
	
	public String getSequence(String n){
		if(this.map.containsKey(n)) return this.map.get(n);
		else return "ERROR GETSEQ";
	}
	
	public Set<String> getKeys(){
		return this.map.keySet();
	}
	
	public void print(){
		if(this.map.isEmpty()) System.out.println("Data is empty");
		else{System.out.println(map);}
	}
	
	public int getSequenceSize(){
		Map.Entry<String,String> entry = this.map.entrySet().iterator().next(); //get first entry 
		return entry.getValue().length();
	}
	
}
