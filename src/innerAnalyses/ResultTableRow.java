package innerAnalyses;

import java.util.*;

public class ResultTableRow {
	
	private int id;
	private Set<String> left;
	private Set<String> right;
	
	public ResultTableRow(){
		
	}
	
	public ResultTableRow(int id, Set<String> left, Set<String> right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<String> getLeft() {
		return left;
	}
	public void setLeft(Set<String> left) {
		this.left = left;
	}
	public Set<String> getRight() {
		return right;
	}
	public void setRight(Set<String> right) {
		this.right = right;
	}
}
