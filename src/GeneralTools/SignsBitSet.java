/**
 * 
 */
package GeneralTools;

import java.io.Serializable;
import java.util.BitSet;

import antlr.debug.NewLineEvent;

/**
 * @author Riccardo
 *
 */

public class SignsBitSet extends In_Out<BitSet> {
	
	private final static int MAX_BITS = 3; 
	private String _operatorOnLeftSide ="";
	
// Constructors:	
	public SignsBitSet() {
		_value = new BitSet(MAX_BITS);
	}
	
	public SignsBitSet(String variable) {
		setVariable(variable);
		_value = new BitSet(MAX_BITS);
		_value.clear();
	}
	
	public SignsBitSet(String variable, BitSet bitset) {
		setVariable(variable);
		_value = new BitSet(MAX_BITS);
		setValue(bitset);
	}
	
	public SignsBitSet(String variable, int label) {
		setVariable(variable);
		
		_value = new BitSet(MAX_BITS);
		_value.clear();
		
		setLabel(label);
	}
	
	public SignsBitSet(String variable, String operator) {
		setVariable(variable);
		
		_value = new BitSet(MAX_BITS);
		_value.clear();
		
		setOperator(operator);
	
	}
	
	public SignsBitSet(SignsBitSet signBitSet) {
		setVariable(signBitSet.getVariable());
		
		_value = new BitSet(MAX_BITS);
		_value.clear();
		setValue(signBitSet.getValue());
		
		setOperator(signBitSet.getOperator());
	
	}	
	
	
	
// Setters:
	public void setNegativeBit() {
		getValue().set(0);
	}
	
	public void setZeroBit() {
		getValue().set(1);
	}
	
	public void setPositiveBit() {
		getValue().set(3);
	}
	
	public void setNegativeOnly() {
		getValue().clear();
		getValue().set(0);
	}
	
	public void setZeroBitOnly() {
		getValue().clear();
		getValue().set(1);
	}
	
	public void setPositiveBitOnly() {
		getValue().clear();
		getValue().set(3);
	}	
	
	public void negate() {
		getValue().flip(0);
		getValue().flip(2);
	}
	
	public void setOperator(String operator) {
		_operatorOnLeftSide = operator;
	}
	
	public void setBitSet(BitSet bitset) {
		getValue().clear();
		setValue(bitset);
	}
	
	public void setAllBits() {
		setNegativeBit();
		setPositiveBit();
		setZeroBit();
	}
	
// Getters:
	public String getOperator() {
		return _operatorOnLeftSide;
	}
	
// Printers:
// TODO: substitute false/true with {"-","0","+"} since it's more readable
		public String print() {
			
			String string = "("+ getLabel() + ") (" + getOperator() + getVariable() + ", [" + _value.get(0);
			
			for ( int i=1; i<MAX_BITS-1; i++) {
				string = string + "," + _value.get(i);
			}
			string = string + "," + _value.get(MAX_BITS) + "])";
			
			return  string;
		}
		
	
		public SignsBitSet multi_div (SignsBitSet op2) {
			
			
			
			return op2;
			
		}
		
}
