package general;

import java.util.ArrayList;
import java.util.Set;


public class AnalysisTable {

	private ArrayList<AnalysisNode> _table;
	
	public AnalysisTable(){
		
		_table = new ArrayList<AnalysisNode>();
	}
	
	public ArrayList<AnalysisNode> getTable() {
		return _table;
	}

	public void set_table(ArrayList<AnalysisNode> table) {
		this._table = table;
	}
	
	public AnalysisNode getRow(int index) {
		return _table.get(index);
	}
	
	public void addRow(AnalysisNode item){
		this._table.add(item);
	}
	public AnalysisNode getItemByLabel(int label){
		AnalysisNode result = null;
		for(AnalysisNode node : this._table){
			if(node.getId() == label){
				result = node;
			} 
		}
		
		if(result == null){
			result = new AnalysisNode();
		}
		
		return result;
	}
	
	public int size(){
		return this._table.size();
	}
	
	public void printTableBufferOverflow(){
		String print = "";
		System.out.println("\n Block \t\t\t\t" +
				" label \t\t\t PreviousNodes \t\t\t NextNodes \t\t\t Gen \t\t\t kill");
		for(AnalysisNode node : getTable()){
			print = print 
					+ "\n[" + node.getBlock()
					+ "]\t\t\t" + node.getId()
					+ "\t\t\t" + node.getPreviousNodes()
					+ "\t\t\t\t" + node.getNextNodes()
					+ "\t\t\t\t" + node.getGen()
					+ "\t\t\t" + node.getKill();
					
		}
		System.out.println(print);
	}
	

	public void printTableLiveVariableAnalysis(){
		String print = "";
		System.out.println("\n block \t \t label \t PreviousNodes \t NextNodes \t Gen \t\t Kill \t\t\t LVdot \t\t\t LVopen");
		for(AnalysisNode row : getTable()){
			print = print
					+ "\n[" + row.getBlock()
					+ "] \t " + row.getId()
					+ "\t" + row.getPreviousNodes().toString()
					+ "\t\t" + row.getNextNodes().toString()
					+ "\t\t " + row.getGen()
					+ "\t\t" + row.getKill()
					+ "\t\t\t" + row.getLVdot()
					+ "\t\t\t" + row.getLVopen();
		}
		System.out.println(print);
	}
	
	public void printTable(){
		String print = "";
		System.out.println("\n index \t block \t \t label \t kill \t gen \t left \t right \t in \t\t\t\t out ");
		for (AnalysisNode row : getTable()) {
			print = print +
					"\n[" + row.getBlock()  
		    		+ "] \t " +row.getId() 
		    		+ "\t" + row.printKill() 
		    		+ "\t" + "("+row.getGenPair().getVariable()+","+row.getGenPair().getLabel()
		    //		+") \t" + row.getLeft() 
		    //		+ "\t" + row.getRight()
		    		+ "\t" + row.printIn() 
		    		+ "\t" + row.printOut();
		}		
		System.out.println(print);
	}

}
