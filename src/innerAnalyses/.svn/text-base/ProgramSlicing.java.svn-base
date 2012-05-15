/**
 * 
 */
package innerAnalyses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import GeneralTools.Pair;
import GeneralTools.Row;
import GeneralTools.Table;

import blockRepresentation.AssignmentBlock;
import blockRepresentation.IBlock;
import blockRepresentation.IfBlock;
import blockRepresentation.WhileBlock;
import core.BlocksCollection;
import core.ITable;

/**
 * @author Riccardo
 *
 */

public class ProgramSlicing extends InnerAnalysis {
	
	private Boolean debug = false;
	
	
	
	private BlocksCollection _blocksParam;
	private String _configurationStringParam = "";
	private Set<AssignmentBlock> _T; // Temporal set of blocks
	private Set<String> _V; // Set of variables	= {x, y, ...}
	private Map<Integer, IBlock> _B; // Set of blocks = the final program.
	private Table<Pair> _table; // Table fig3 pag5 of the report
	private Set<String> _allTheVariables;
	
	
	public ProgramSlicing(String configurationStringParam, BlocksCollection blocksParam, Map<String, ITable> commodityTablesParam) {
		super(configurationStringParam, blocksParam, commodityTablesParam);
		
		_blocksParam = blocksParam;
		_configurationStringParam = configurationStringParam;
		
	}
	
	private void startAnalysis() {
		IBlock block = _blocksParam.getBlock(Integer.parseInt(_configurationStringParam.substring(1, _configurationStringParam.length()-1)));
		
		if(!block.isAssignmentBlock()) {
			System.out.println("[" + block.toString() + "] is not an assignment");
			return;
		}
		
		tableCreation();
		
		analysisSetup(block);
		if (debug) {
			printSet("\nAfter analysisSetup:", _B.entrySet());	
		}		
		
		
		sliceFunction(_T, _V);
		
		if (debug) {
			printSet("\nAfter the slicing process:", _B.entrySet());	
		}
		
		controlFinder();	
		
		printSet("\nFinish:", _B.entrySet());
	}
	
	private void tableCreation() {
		
		createRows();
		initiateAnalysis();
		
System.out.println("\nTable:");		
		for ( Iterator<Row<Pair>> allIterator = _table.getRows().iterator(); allIterator.hasNext(); ) {
			Row<Pair> row = (Row<Pair>) allIterator.next();
			row.printAll();
		}
		
		
	}

 	private void createRows() {
			_table = new Table<Pair>(new Pair());
			_allTheVariables = new HashSet<String>();

			Integer label;
			IBlock block;
			Row<Pair> row;
			AssignmentBlock ab;
			
// Find all the variables involved in this program:
			for (Iterator<Entry<Integer, IBlock>> iterator = _blocksParam.getAllBlocks().entrySet().iterator(); iterator.hasNext();) {
				Entry<Integer, IBlock> entry = (Entry<Integer, IBlock>) iterator.next();	
				block = entry.getValue();
				if (block.isAssignmentBlock()) {
					ab = (AssignmentBlock) block;
//					_allTheVariables.add(ab.getVariableLeft());
					_allTheVariables.add(ab.getAssignedVariable());					
					_allTheVariables.addAll(ab.getVariablesRight());
				}
			}
			
			for (Iterator<Entry<Integer, IBlock>> iterator = _blocksParam.getAllBlocks().entrySet().iterator(); iterator.hasNext();) {
				Entry<Integer, IBlock> entry = (Entry<Integer, IBlock>) iterator.next();
				
				label = entry.getKey();
				block = entry.getValue();
				
				_table.getRows().add(new Row<Pair>(block)); 						// <== Add a row
				
				row = _table.getRow(label-1);										// Take the row from the table
				
				if ( block.isAssignmentBlock() ) {
					ab = (AssignmentBlock) row.getBlock();
					
// GEN:					
//					row.setGenPair(new Pair(ab.getVariableLeft(), ab.getLabel()));
					row.setGenPair(new Pair(ab.getAssignedVariable(), ab.getLabel()));			
// KILL:
//					row.addAllToKill(_blocksParam.getAllNextAssignmentsWhereIsAtLeft(1, ab.getVariableLeft())); // Output=Set<Assignment>
					row.addAllToKill(_blocksParam.getAllNextAssignmentsWhereIsAtLeft(1, ab.getAssignedVariable())); // Output=Set<Assignment>
					
					
					if(debug) {
						row.printAll();
					}
						
					
				} // End: if ( block.isAssignmentBlock() )
			} // End: while (iterator.hasNext())		
			
// Printing the table:		
			_table.printThese("Variables involved:", _allTheVariables);
		} // End: createRows()	

	private void initiateAnalysis() {
		Row<Pair> row = _table.getRow(0);
		Set<Pair> setOfPairs = new HashSet<Pair>();
		
		// IN:			
		for (String variable : _allTheVariables) {
			Pair unknownPair = new Pair(variable, Pair.getUnknownValue());
			row.addToIn(unknownPair); // Add to input:
			
// OUT:		
//						out = getin - ("out")				
			// getin:
			if ( !unknownPair.getVariable().equals(row.getLeft())) { // If the pair is not the one created by this row [so, not the pair (x,-1)]
				setOfPairs.add(unknownPair);
			}
		}	
		
		for ( Iterator<Pair> setOfPairsIterator = setOfPairs.iterator(); setOfPairsIterator.hasNext(); ) {
			Pair outPair = (Pair) setOfPairsIterator.next();
			if (outPair.getVariable().equals("out")) {
				setOfPairsIterator.remove();
			}
		}		

		setOfPairs.add(row.getGenPair());
		
// Call for the RECURSIVE FUNCTION:
		recursion(row, setOfPairs);
		
// Terminate with the last blocks:
		Set<Pair> pairsForTheLastOne = new HashSet<Pair>();
		for ( Iterator<IBlock> finalBlockIterator = _blocksParam.getExtremalBlocks().iterator(); finalBlockIterator.hasNext(); ) {
			IBlock finalBlock = (IBlock) finalBlockIterator.next();
			for ( Iterator<IBlock> lastButOneIterator = finalBlock.getImmediatePreviouses().iterator(); lastButOneIterator.hasNext(); ) {
				IBlock lastButOneBlock = (IBlock) lastButOneIterator.next();
				pairsForTheLastOne.addAll(_table.getRowFromBlock(lastButOneBlock).getOut());
			}
			Row<Pair> lastRow = _table.getRowFromBlock(finalBlock);
			lastRow.addAllToIn(pairsForTheLastOne);
			lastRow.addAllToOut(lastRow.getIn());
			for ( Iterator<Pair> lastOutPairsIterator = lastRow.getOut().iterator(); lastOutPairsIterator.hasNext(); ) {
				Pair outPair = (Pair) lastOutPairsIterator.next();
				if (outPair.getVariable().equals(lastRow.getGenPair().getVariable())) {
					lastOutPairsIterator.remove();
				}
			}
			lastRow.addToOut(lastRow.getGenPair());
			
		}
	}

	private void recursion(Row<Pair> currentRow, Set<Pair> inputSet) {
		Set<Pair> backupIn = currentRow.getIn();	// Backup for later
		
		if ( !backupIn.equals(inputSet) && (!_blocksParam.getExtremalBlocks().contains(currentRow.getBlock())) ) {

			currentRow.addAllToIn(inputSet);

			// 1) output <= inputset
			currentRow.addAllToOut(inputSet);
			
			// 2) output.remove all the same pairs 		
			for ( Iterator<Pair> outIterator = currentRow.getOut().iterator(); outIterator.hasNext(); ) {
				Pair outPair = (Pair) outIterator.next();
				if ( (outPair.getVariable().equals(currentRow.getLeft())) && (currentRow.getBlock().isAssignmentBlock()) ) { // If it's an assignment, remove all the (x,1)(x,6)(x,12)...
					outIterator.remove();
				}
			}
			
			// 3) output.add(gen) only is is NOT a control. Or in other words, only if it's an assignment
			if (currentRow.getBlock().isAssignmentBlock()) {
				currentRow.addToOut(currentRow.getGenPair());	
			}
			
	
			// For every next block
			for ( Iterator<IBlock> nextsIterator = currentRow.getBlock().getImmediateNexts().iterator(); nextsIterator.hasNext(); ) {
				IBlock nextBlock = (IBlock) nextsIterator.next();
				Row<Pair> nextRow = _table.getRowFromBlock(nextBlock);
				// At this point, the output must be already been modified.
				
				// Recursive call:
				recursion(nextRow, currentRow.getOut()); 
			}
		}
	}

	private void analysisSetup(IBlock inputblock) {
		AssignmentBlock block = (AssignmentBlock) inputblock;
//System.out.println(	"\nPOI = <"+block.getVariableLeft()+","+block.getLabel()+">");
		
		_V = new HashSet<String>();
		_T = new HashSet<AssignmentBlock>();
		_B = new HashMap<Integer, IBlock>();
		
		_V.add(block.getAssignedVariable());
		_T.addAll(ud(block.getAssignedVariable(), block.getLabel()));
		
		
		_T.add(block);		
		}
	
	// TODO: NEED REACHING DEFINITION ANALYSIS
	private Set<AssignmentBlock> ud(String variableName, int blockLabel) {
		// Must return the set in the REVERSED order.
		AssignmentBlock block = (AssignmentBlock) _blocksParam.getBlock(blockLabel);
		Set<AssignmentBlock> temp = _blocksParam.getAllPreviousAssignmentsWhereIsAtLeft(block.getLabel(), variableName);		
		return temp;
	}

	private void sliceFunction(Set<AssignmentBlock> T1, Set<String> V1) {
		
		Set<String> tempRight = new HashSet<String>();
		Set<String> tempVar = new HashSet<String>();
		
		_V.addAll(V1);
		
		for (IBlock block : T1) { // For every block in the set ...
			_B.put(block.getLabel(), block); // Add the current block to the final set
			
			if (block.isAssignmentBlock()) {
				AssignmentBlock ab = (AssignmentBlock) block;
				tempRight = ab.getVariablesRight(); // Set of "variables=string". Retrieves the variables used on the right-hand side of an assignment

				if ( !tempRight.isEmpty()) {  // If the right side is NOT empty, that is, there's something to look at...
					for (String variable : tempRight) 
						if ( !_V.contains(variable) ) { // If the variable on the right side, is NOT already in the _V set of all the variable that we need... 
							tempVar.add(variable);
							sliceFunction(ud(variable, ab.getLabel()), tempVar); // Maybe I can delete the tempVar: adding "variable" to "_V" directly from here, instead of doing that at the beginning of the sliceFunction...
						}
				}
			}
		}
	}	
	
	private void printSet(String whatToWrite, Set set) {
		System.out.println(whatToWrite);
		for ( Map.Entry<Integer, IBlock> entry : _B.entrySet() ) {
			Integer label = entry.getKey();
			IBlock block = entry.getValue();
			
			System.out.println("("+label+") \t"+block.toString());
			
		}
	}
	
	private void controlFinder() {
    	IfBlock ifBlock;
    	WhileBlock whileBlock;
    	Set<String> tempSetOfVariables = new HashSet<String>();	
		
      	Map<Integer, IBlock> tempMapOfBlocks = new HashMap<Integer, IBlock>(_blocksParam.getAllBlocks()); 

      	tempMapOfBlocks.entrySet().removeAll(_B.entrySet()); // now "temp" contains only blocks that are not already in the "set of blocks _B"
    	
		for ( Iterator<Entry<Integer, IBlock>> iterator = tempMapOfBlocks.entrySet().iterator(); iterator.hasNext(); ) {	
			Entry<Integer, IBlock> entry = iterator.next();
			
    		tempSetOfVariables.clear(); // Reset the set of variable strings
    		
	    	// Look whether these controls use "important" variables or not. 
	    	if (entry.getValue().isIfBlock()) {
	    		ifBlock = (IfBlock) entry.getValue();
	    		tempSetOfVariables.add(ifBlock.getGuard().getVariableLeft());
	    		tempSetOfVariables.addAll(ifBlock.getGuard().getVariablesRight());
	    		
	    	}
				
	    	else if (entry.getValue().isWhileBlock()) {
				whileBlock = (WhileBlock) entry.getValue();
	    		tempSetOfVariables.add(whileBlock.getGuard().getVariableLeft());
	    		tempSetOfVariables.addAll(whileBlock.getGuard().getVariablesRight());					
			}
			
	    	else {
	    		iterator.remove();
	    	}
			if ( !tempSetOfVariables.isEmpty()) { // If I can find variables in those controls, I need to add the control to the final set:
				_B.put(entry.getKey(), entry.getValue());
			}

		}	
    	
		if (debug) {
			printSet("controlFinder() ended:", tempMapOfBlocks.entrySet());	
		}
		
		
	}
	

	/* (non-Javadoc)
	 * @see innerAnalyses.InnerAnalysis#run()
	 */
	@Override
	public void run() {
		startAnalysis();
	}

	/* (non-Javadoc)
	 * @see innerAnalyses.InnerAnalysis#PrintStatus()
	 */
	@Override
	public void PrintStatus() {

	}

	/* (non-Javadoc)
	 * @see innerAnalyses.InnerAnalysis#PrintResult()
	 */
	@Override
	public void PrintResult() {

	}	

}
