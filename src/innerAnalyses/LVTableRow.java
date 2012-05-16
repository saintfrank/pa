package innerAnalyses;

import java.util.Set;

public class LVTableRow {
	
	private int id;
	private Set<String> LVopen;
	private Set<String> LVdot;
	
	public LVTableRow() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<String> getLVopen() {
		return LVopen;
	}

	public void setLVopen(Set<String> lVopen) {
		LVopen = lVopen;
	}

	public Set<String> getLVdot() {
		return LVdot;
	}

	public void setLVdot(Set<String> lVdot) {
		LVdot = lVdot;
	}
	
	public String toString(){
		
		return "ID: " + id + " LVdot: " + LVdot + " LVopen: " + LVopen;
	}
}
