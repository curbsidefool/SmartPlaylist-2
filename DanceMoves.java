
public class DanceMoves {

	int key;
	double tempo;
	String title;
	
	public DanceMoves(int key, double tempo, String title){
		this.key = key; 
		this.tempo = tempo;
		this.title = title;
		
	}
	
	public String toString(){
		return "Song Title is" + title + ", Song Artist";
	}
	
	public int getKey(){
		return key;
	}
	
	public double getTempo(){
		return tempo;
	}
}
