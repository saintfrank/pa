/**
 * 
 */
package GeneralTools;

/**
 * @author Riccardo
 *
 */

public class Pair extends In_Out<Integer>{
	
	private final static int UNKNOWN_VALUE = -1; 
	
	public static int getUnknownValue() {
		return UNKNOWN_VALUE;
	}
	
// Constructors:
	public Pair() {
		_value = UNKNOWN_VALUE;
	}
	
	public Pair(String variableString, int label)
	{
		setVariable(variableString);
		setValue(label);
	}
	
	public Pair(Pair inputPair) {
		setVariable(inputPair.getVariable());
		setValue(inputPair.getValue());
	}
	
// Printers:
	public String print() {
		return  "("+getVariable()+","+getValue()+")";
	}

}
