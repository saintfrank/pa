/**
 * 
 */
package general;

import java.util.Set;

/**
 * @author Riccardo
 *
 */

public class Pair {
	
	private final static int UNKNOWN_VALUE = -1; 
	
	private Set<String> _variable;
	private Integer _label;
	
	public static int getUnknownValue() {
		return UNKNOWN_VALUE;
	}
	
// Constructors:
	public Pair() {
		_label = UNKNOWN_VALUE;
	}
	
	public Pair(Set<String> variableString, int label)
	{
		setVariable(variableString);
		setLabel(label);
	}
	
	public Pair(Pair inputPair) {
		setVariable(inputPair.getVariable());
		setLabel(inputPair.getLabel());
	}
	
// Getters:	
	public Set<String> getVariable() {
		return _variable;
	}
	
	public int getLabel() {
		return _label;
	}
	
// Setters:	
	public void setVariable(Set<String> set) {
		_variable = set;
	}
	
	public void setLabel(int label) {
		_label = label;
	}
	
	public String toString(){
		return  "("+getVariable()+","+getLabel()+")";
	}
	
// Other methods:
	public String printPair() {
		return  "("+getVariable()+","+getLabel()+")";
	}
}
