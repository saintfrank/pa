/**
 * 
 */
package GeneralTools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import blockRepresentation.IBlock;

/**
 * @author Riccardo
 *
 */

public class Table <T>{
	
	private ArrayList<Row<T>> _tableRows;
	private T _type;
	
	public Table(T type) {
		_type = type; // Avoid type erasure
		_tableRows = new ArrayList<Row<T>>();
	}

	public ArrayList<Row<T>> getRows(){
		return _tableRows;
	}
	
	public Row<T> getRow(int index) {
		return _tableRows.get(index);
	}
	
	public void printThese(String announcement, Set<String> variables) {
		String result = "";
		System.out.println(announcement+":");
		for (String variable : variables) {
			result = result + variable + "\t " ;
		}
		result = result + "\n";
		System.out.println(result);
	}
	
	public void printTable() {
		String result = "" ; 
		
		if (_type instanceof SignsBitSet) {
//			System.out.println("instanceof SignsBitSet");
			for (Row<T> row : getRows()) {
				result = result + "("+ row.getLabel() +")"
						+ "\t" + row.getBlock() 
//						+ "\t LEFT = " + row.getLeft()
						+ "\nIN:\n" + row.printIn() 
						+ "OUT:\n" + row.printOut() 
						+ "\n"; 
			}
		}
		
		if (_type instanceof Pair) {
			System.out.println("instanceof Pair");
			System.out.println("\n index \t block \t \t label \t kill \t gen \t left \t right \t in \t\t\t\t out ");	
			for (Row<T> row : getRows()) {
			    result = result +
			    		"\n[" + row.getBlock()  
			    		+ "] \t "+row.getLabel() + "\t"
			    		+ row.printKill() + "\t"
			    		+ "("+row.getGenPair().getVariable()+","+row.getGenPair().getValue()+") \t"
			    		+ row.getLeft() + "\t"
			    		+ row.getRight() + "\t"
			    		+ row.printIn() + "\t"
			    		+ row.printOut();
			}				
		}
		
		result = result + "\n";
		System.out.println(result);
	}	
	
	public Row<T> getRowFromBlock(IBlock inputBlock) {
		Row<T> row;
		for (Iterator<Row<T>> iterator = _tableRows.iterator(); iterator.hasNext();) {
			row = (Row<T>) iterator.next();
			if (row.getBlock().equals(inputBlock))
				return row;
		}
		return null;
	}
	
	public void addRow(Row<T> row) {
		getRows().add(row);
	}
	
	public Row<T> getLastRow() {
		return _tableRows.get(_tableRows.size()-1);
		
	}
	
}
