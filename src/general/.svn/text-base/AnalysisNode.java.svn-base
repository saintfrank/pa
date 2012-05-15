package general;

import java.util.*;


import blockRepresentation.AssignmentBlock;
import blockRepresentation.IBlock;
import blockRepresentation.IfBlock;
import blockRepresentation.WhileBlock;

public class AnalysisNode {
	
	private IBlock _block;
	private Integer _label;
	private Set<String> _genSet;
	private Set<String> _killSetString;
	private Set<Pair> _in; 
	private Set<Pair> _out;
	private Set<Pair> _killSet; 	
	private Pair _genPair; 
	private Set<Integer> _previousNodes;
	private Set<Integer> _nextNodes;
	private Set<String> _LVdot;
	private Set<String> _LVopen;
	
	private AssignmentBlock _ab = null;
	private IfBlock _ib = null;
	private WhileBlock _wb = null;
	
	public AnalysisNode(){
		_previousNodes = new HashSet<Integer>();
		_nextNodes = new HashSet<Integer>();
	}
	
	public AnalysisNode(IBlock block) {
		_block = block;
		_label = block.getLabel();
		_genPair = new Pair();
		_killSetString = new HashSet<String>();
		_killSet = new HashSet<Pair>();
		_previousNodes = new HashSet<Integer>();
		_nextNodes = new HashSet<Integer>();
		setIn(new HashSet<Pair>());
		setOut(new HashSet<Pair>());
		
				
	}
	
	public IBlock getBlock() {
		return _block;
	}

	public void setBlock(IBlock _block) {
		this._block = _block;
	}

	public int getId() {
		return _label;
	}
	
	public void setId(int id) {
		this._label = id;
	}
	
	public Set<String> getGen() {
		return _genSet;
	}
	
	public void addToGen(String item){
		this._genSet.add(item);
	}
	
	public void setGen(Set<String> left) {
		this._genSet = left;
	}
	
	public Set<String> getKill() {
		return _killSetString;
	}
	
	public void addToKill(String item){
		this._killSetString.add(item);
	}

	public void setKill(Set<String> right) {
		this._killSetString = right;
	}
	
	public Pair getGenPair() {
		return _genPair;
	}

	public void setGenPair(Pair genPair) {
		this._genPair = genPair;
	}

	public Set<Pair> getIn() {
		return _in;
	}

	public void setIn(Set<Pair> _in) {
		this._in = _in;
	}

	public Set<Pair> getOut() {
		return _out;
	}

	public void setOut(Set<Pair> _out) {
		this._out = _out;
	}

	public Set<Integer> getPreviousNodes() {
		return _previousNodes;
	}

	public void setPreviousNodes(Set<Integer> _affectedNodes) {
		this._previousNodes = _affectedNodes;
	}
	
	public Set<Integer> getNextNodes() {
		return _nextNodes;
	}

	public void setNextNodes(Set<Integer> _nextNodes) {
		this._nextNodes = _nextNodes;
	}

	public Set<String> getLVdot() {
		return _LVdot;
	}

	public void setLVdot(Set<String> _LVdot) {
		this._LVdot = _LVdot;
	}

	public String toString(){
		
		return 	"\nlabel=\t\t"+ _label +
				"\nblock=\t\t"+ _block +								
//				"\nisInit=\t\t"+blocksParam.getInitialBlocks().contains(row.getBlock())+
				"\nisAssignment=\t"+
				"\ngen=\t\t"+ _genSet +
				"\nkill=\t\t"+ _killSetString +
				"\nin=\t\t"+
				"\nout=\t\t"+
				"\npreviousNodes=\t\t"+ _previousNodes +
				"\nnextNodes=\t\t" + _nextNodes;
	}
	
	public String printLVA(){
		
		return 	"\nlabel=\t\t"+ _label +
				"\nblock=\t\t"+ _block +								
				"\npreviousNodes=\t\t"+ _previousNodes +
				"\nnextNodes=\t\t" + _nextNodes +
				"\ngen=\t\t"+ _genSet +
				"\nkill=\t\t"+ _killSetString +
				"\nLVdot=\t\t"+ _LVdot +
				"\nLVopen=\t\t"+ _LVopen;
	}
	
	
	public String printKill() {
		String result = "" ;
		for (Pair pair : _killSet) {
		    result = result + pair.printPair() + " "; 
		}
		return result;		
	}
	
	public String printIn() {
		String result = "" ;
		for (Pair pair : _in) {
		    result = result + pair.printPair() + " "; 
		}
		return result;
	}
	
	public String printOut() {
		String result = "" ;
		for (Pair pair : _out) {
		    result = result + pair.printPair() + " "; 
		}
		return result;
	}

	public Set<String> getLVopen() {
		return _LVopen;
	}

	public void setLVopen(Set<String> _LVopen) {
		this._LVopen = _LVopen;
	}	

}
