package GeneralTools;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import blockRepresentation.AssignmentBlock;
import blockRepresentation.IBlock;
import blockRepresentation.IfBlock;
import blockRepresentation.WhileBlock;

/**
 * @author Riccardo
 *
 */


public class Row <Unit> { // Unit = atom used In&Out fields
	
// Properties:	
	// Figure 3, pag 5.
	protected IBlock _block; // Column 1
	protected Integer _label; // Column 2
	
	protected Set<Pair> _kill; // Column 3	
	protected Pair _gen; // Column 4	
	
	protected String _left;	// Column 5
	protected Set<String> _right;	// Column 6
	
	protected AssignmentBlock _ab = null;
	protected IfBlock _ib = null;
	protected WhileBlock _wb = null;
	
	private HashSet<Unit> _inSet; // Column 7 
	private HashSet<Unit> _outSet;	// Column 8
	
// Constructors:	
	public Row() {
	}
	
	public Row(IBlock block) {
		_block = block;
		_label = block.getLabel();
		_gen = new Pair();
		_right = new HashSet<String>();
		_kill = new HashSet<Pair>();
		_inSet = new HashSet<Unit>();
		_outSet = new HashSet<Unit>();
		
		if (block.isAssignmentBlock()) {
			_ab = (AssignmentBlock) block;
			
			_gen.setVariable(_ab.getVariablesLeft().toString());
			_gen.setValue(_ab.getLabel());
			

			setLeft(_ab.getVariablesLeft().toString().substring(1, 2)); 
			setRight(_ab.getVariablesRight());
			
		}
		
		if (block.isIfBlock()) {
			_ib = (IfBlock) block;
			setLeft(_ib.getGuard().getVariableLeft());
			
			setRight(_ib.getGuard().getVariablesRight());
			setGenPair(new Pair("/", Pair.getUnknownValue()));
		}
		
		if (block.isWhileBlock()) {
			_wb = (WhileBlock) block;
			setLeft(_wb.getGuard().getVariableLeft());
			setRight(_wb.getGuard().getVariablesRight());
			setGenPair(new Pair("/", Pair.getUnknownValue()));
		}
		
	}

	
// Getters:	
	public IBlock getBlock() {
		return _block;
	}
	
	public int getLabel() {
		return _label;
	}
	
	public Set<Pair> getKillset() {
		return _kill;
	}
	
	public Pair getGenPair() {
		return _gen;
	}
	
	public String getLeft() {
		return _left;
	}
	
	public Set<String> getRight() {
		return _right;
	}
	
	public HashSet<Unit> getIn() {
		return _inSet;
	}
	
	public HashSet<Unit> getOut() {
		return _outSet;
	}	
	
	public SignsBitSet getSpecificBitSetInINField(String variable) {
		
		for ( Iterator<Unit> iterator = getIn().iterator(); iterator.hasNext(); ) {
			SignsBitSet bitset = (SignsBitSet) iterator.next();
			if (bitset.getVariable().equals(variable)) {
				return bitset;
			}
		}
		
		return null;
	}
	
	public SignsBitSet getSpecificBitSetInOUTField(String variable) {
		
		for ( Iterator<Unit> iterator = getOut().iterator(); iterator.hasNext(); ) {
			SignsBitSet bitset = (SignsBitSet) iterator.next();
			if (bitset.getVariable().equals(variable)) {
				return bitset;
			}
		}
		
		return null;
	}	

// Setters:
	public void setBlock(IBlock block) {
		_block = block;
	}
	
	public void setLabel(int label) {
		_label = label;
	}
	
	public void setKillSet(Set<Pair> killSet) {
		_kill.addAll(killSet);
	}
	
	public void addToKillSet(Pair pair) {
		_kill.add(pair);
	}
	
	public void setGenPair(Pair genPair) {
		_gen = genPair;
	}
	
	public void setLeft(String left) {
		_left = left;
	}
	
	public void setRight( Set<String> rightSet) {
		_right.addAll(rightSet);
	}
	
	public void addAllToKill(Set<AssignmentBlock> allNext) {
		for (AssignmentBlock assignmentBlock : allNext) {
				getKillset().add(new Pair(assignmentBlock.getAssignedVariable(), assignmentBlock.getLabel()));
		}
	}		
	
	public void addToIn(Unit unit) {
		_inSet.add(unit);
	}
	
	public void addAllToIn(Set<Unit> setOfUnits) {
		_inSet.addAll(setOfUnits);
	}
	
	public void addToOut(Unit unit) {
		_outSet.add(unit);
	}
	
	public void addAllToOut(Set<Unit> setOfUnits) {
		_outSet.addAll(setOfUnits);
	}	
	
	public void unionOfEntriesIN(HashSet<SignsBitSet> inputSetForIN) {
		
		if (inputSetForIN.contains(null)) { // Avoid unexpected errors:
			return;
		}		
		
		boolean createEmptyIN = false;
		
		if (getIn().isEmpty()) {
			createEmptyIN = true;
		}
		
		for ( Iterator<SignsBitSet> iterator = inputSetForIN.iterator(); iterator.hasNext(); ) {
			SignsBitSet signBitSetIN = (SignsBitSet) iterator.next();
			
			if (createEmptyIN) {
				SignsBitSet emptySignBitSet = new SignsBitSet(signBitSetIN.getVariable());
// ADD TO IN:				
				addToIn((Unit) emptySignBitSet); 
			}
			
			SignsBitSet oldBitSet = getSpecificBitSetInINField(signBitSetIN.getVariable());
			oldBitSet.getValue().or(signBitSetIN.getValue());
			oldBitSet.setLabel(signBitSetIN.getLabel());
			
		}
		
	}	
		
	
	public void unionOfEntriesOUT(HashSet<SignsBitSet> inputSetForOUT) {
		
		if (inputSetForOUT.contains(null)) { // Avoid unexpected errors:
			return;
		}		
		
		boolean createEmptyOUT = false;
		
		if (getIn().isEmpty()) {
			createEmptyOUT = true;
		}
		
		for ( Iterator<SignsBitSet> iterator = inputSetForOUT.iterator(); iterator.hasNext(); ) {
			SignsBitSet signBitSet = (SignsBitSet) iterator.next();
			
			if (createEmptyOUT) {
				SignsBitSet emptySignBitSet = new SignsBitSet(signBitSet.getVariable());
// ADD TO OUT:				
				addToOut((Unit) emptySignBitSet); 
			}
			
			SignsBitSet oldBitSet = getSpecificBitSetInOUTField(signBitSet.getVariable());
			oldBitSet.getValue().or(signBitSet.getValue());
			oldBitSet.setLabel(signBitSet.getLabel());			
		}
		
	}		

// Printers:	
	public String printKill() {
		
//		if (unit instanceof Pair) {
////			System.out.println(((Pair) unit).print());
//			result = result + ((Pair) unit).print();
//		}			
		
		System.out.println("KILL");
		
		String result = "" ;
		for (Pair pair : _kill) {
		    result = result + pair.print(); 
		}
		return result;		
	}
	
	public String printGen() {
		return "("+_gen.getVariable()+","+_gen.getValue()+")";
	}
	
	public String printKillset() {
		String result = "" ;
		for (Pair pair : getKillset()) {
			result = result + pair.print();
		}
		return result;	
	}	

	public String printIn() {
		return printThese(_inSet);
	}
	
	public String printOut() {
		return printThese(_outSet);
	}	
	
	public String printThese(Set<Unit> collectionOfUnits ) {
		String result = "" ;
		for (Unit unit : collectionOfUnits) {
			if (unit instanceof Pair) {
//				System.out.println(((Pair) unit).print());
				result = result + ((Pair) unit).print();
			}			
			if (unit instanceof SignsBitSet) {
				result = result + ((SignsBitSet) unit).print() + "\n";
			}				
		}
		return result;
	}
	
	public void printAll() {
		System.out.println(
				"\nlabel=\t\t"+getLabel()+
				"\nblock=\t\t"+getBlock()+								
//				"\nisInit=\t\t"+blocksParam.getInitialBlocks().contains(row.getBlock())+
				"\nisAssignment=\t"+getBlock().isAssignmentBlock()+
				"\ngen=\t\t"+printGen()+
				"\nkill=\t\t"+printKillset()+
				"\nin=\t\t"+printIn()+
				"\nout=\t\t"+printOut()
				);		
	}


	
}
