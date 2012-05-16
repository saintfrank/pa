/**
 * 
 */
package innerAnalyses;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import GeneralTools.Pair;
import GeneralTools.Row;
import GeneralTools.SignsBitSet;
import GeneralTools.Table;
import blockRepresentation.AssignmentBlock;
import blockRepresentation.DeclarationBlock;
import blockRepresentation.ExpressionSubBlock;
import blockRepresentation.IBlock;

import core.BlocksCollection;
import core.ITable;

/**
 * @author Riccardo
 *
 */

public class BufferOverflow extends InnerAnalysis {
	
	private BlocksCollection _blocksParam;
	private boolean debug = true;
	private Set<String> _allTheVariables;
	private Table<SignsBitSet> _table;
	private Set<String> _allTheArrays;
	private Calculator _calculator;
	private Set<IBlock> _ArrayKO;
	private LinkedList<SignsBitSet> _queue;
	
	public BufferOverflow(String configurationStringParam,
			BlocksCollection blocksParam,
			Map<String, ITable> commodityTablesParam) {
		
		super(configurationStringParam, blocksParam, commodityTablesParam);

		_blocksParam = blocksParam;
	}
	
	private void startAnalysis() {
		if (debug)
			System.out.println("\nstartAnalysis");
		
		createCalculator();
		
		createTable();
		analysis();

		
		if (debug) {
			System.out.println("\nlast printTable()");
		}
		
//		_table.printTable();
	
		arrayChecker();
	}
	

	private void createCalculator() {
 		_calculator = new Calculator();
 		_queue = new LinkedList<SignsBitSet>();
	}

	private void createTable() {
 		if (debug)
 			System.err.println("\ncreateTable");
 		
 		Row<SignsBitSet> row;
// New instance of a table: 		
		_table = new Table<SignsBitSet>(new SignsBitSet());
		 		
// Find all the variables involved:		
 		findAllVariables();
 		
// FOR ALL THE BLOCKS 		
// Create all the ROWS: 		
		for (Iterator<Entry<Integer, IBlock>> iterator = _blocksParam.getAllBlocks().entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, IBlock> entry = (Entry<Integer, IBlock>) iterator.next();
			IBlock block = entry.getValue();
			
			_table.getRows().add(new Row<SignsBitSet>(block)); 					// <== Add a row
			row = _table.getRowFromBlock(block);
			String variable ="";
			
// TODO: SKIP:	
			if (block.isSkipBlock()) { 
				
			}				
			
// TODO: CONTROLS:
			if (block.isControlBlock()) { 
				
			}	
			
// TODO: DECLARATIONS:			
			if (block.isDeclarationBlock()) { 
				DeclarationBlock db = (DeclarationBlock) block;
				
				// Array				
				if (db.involvesArray()) { 
					variable = db.getVariable();
				}
				// Variable				
				else { 
					variable = db.getVariable();
				}
				
				
				// Add GEN:					
				row.setGenPair(new Pair(variable, db.getLabel()));					
				
				// Add KILL:
				row.addAllToKill(_blocksParam.getAllNextAssignmentsWhereIsAtLeft(1, variable)); // Output=Set<Assignment>	
				
//				System.err.println("IN = "+ row.printIn() + ", OUT = "+ row.printOut());				
			}
			
			
			
// ASSIGNMENTS:			
			if (block.isAssignmentBlock()) { 
				AssignmentBlock ab = (AssignmentBlock) block;
				
				// Array				
				if (ab.involvesArray()) { 
					variable = ab.getExpressionLeft().getIdentifier();
				}
				// Variable				
				else { 
					variable = ab.getVariablesLeft().toString();
				}
				
				
				// Add GEN:					
				row.setGenPair(new Pair(variable, ab.getLabel()));					
				
				// Add KILL:
				row.addAllToKill(_blocksParam.getAllNextAssignmentsWhereIsAtLeft(1, variable)); // Output=Set<Assignment>	
				
//				System.err.println("IN = "+ row.printIn() + ", OUT = "+ row.printOut());
			}
			
			
// Create all the entries for IN and OUT:		
			for (String allVariables : _allTheVariables) {
				if ( allVariables.equals(variable) ) {
					row.addToIn(new SignsBitSet(variable,row.getLabel()));
					row.addToOut(new SignsBitSet(variable,row.getLabel()));	
				}
				else {
					row.addToIn(new SignsBitSet(allVariables,row.getLabel()));
					row.addToOut(new SignsBitSet(allVariables,row.getLabel()));
				}
			}
			
			for (String allArrays : _allTheArrays) {
				if ( allArrays.equals(variable) ) {
					row.addToIn(new SignsBitSet(variable,row.getLabel()));
					row.addToOut(new SignsBitSet(variable,row.getLabel()));	
				}
				else {
					row.addToIn(new SignsBitSet(allArrays,row.getLabel()));
					row.addToOut(new SignsBitSet(allArrays,row.getLabel()));
				}
			}			
		}
		
//Print the table:	
		if (debug) {
			_table.printThese("Variables involved", _allTheVariables);
			_table.printThese("Arrays involved", _allTheArrays);
//			_table.printTable();
			System.out.println();
		}
		
 		
 	}
 	
 	 // Find all the variables involved in this program:
 		private void findAllVariables() {
 			IBlock block;
 			AssignmentBlock ab;
 			_allTheVariables = new HashSet<String>();
 			_allTheArrays = new HashSet<String>();
 			
 			for (Iterator<Entry<Integer, IBlock>> iterator = _blocksParam.getAllBlocks().entrySet().iterator(); iterator.hasNext();) {
 				Entry<Integer, IBlock> entry = (Entry<Integer, IBlock>) iterator.next();	
 				block = entry.getValue();
 				
// TODO: DECLARATION
// DECLARATION: 				
 				if (block.isDeclarationBlock()) { // Declaration ==> "int x;" or "int A[3];" 
 					DeclarationBlock db = (DeclarationBlock) block;
 					
 					if ( db.isArray() ) { // Declaration of an ARRAY: "int A[3];"
// 						System.out.println("["+db.toString() + "] is a Declaration of an ARRAY");
 						_allTheArrays.add(db.getVariable());
 					}
 					else { // Declaration of a VARIABLE: "int x;"
// 						System.out.println("["+db.toString() + "] is a Declaration of a VARIABLE");
 						_allTheVariables.add(db.getVariable());
 					}
 				}
 				
// ASSIGNMENT: 				
 				if (block.isAssignmentBlock()) {
 					ab = (AssignmentBlock) block;
 					if ( !ab.getExpressionLeft().involvesArray()) { // Assignment of a VARIABLE
// 						System.out.println("["+ab.toString() + "] is a Assignment of a VARIABLE");
 	 					_allTheVariables.addAll(ab.getVariablesLeft());
 	 					_allTheVariables.addAll(ab.getVariablesRight());
 					}
 					else { // Assignment of a ARRAY
// 						System.out.println("["+ab.toString() + "] is a Assignment of a ARRAY");
 						_allTheArrays.add(ab.getExpressionLeft().getIdentifier());
 					}
 					

 				}
 				
// CONTROLS: 				
 				if (block.isControlBlock()) {
// 					System.out.println("["+block.toString() + "] is a CONTROL");
 				}
 			}		
 			
// 			System.err.println("All the variables");
// 			for (String variable : _allTheVariables) {
//				System.err.println(variable);
//			}
// 			
// 			System.err.println("All the arrays");
// 			for (String array : _allTheArrays) {
//				System.err.println(array);
//			} 			
 			
 		}
 		 	
	
	private void analysis() {
		if (debug)
			System.err.println("\nanalysis\n");		

// Fill the first row of the table, the one with all the unknown values:		
//		firstRow();
		
// Initiate the recursive way to fill the table:		
		
		if(debug)
			System.out.println("\nFirst call for recursion:");
		
		
		
// Incognito input for the FIRST row:	"(0) (x, [false,false,false])"
		HashSet<SignsBitSet> set = new HashSet<SignsBitSet>();
		for (String variable : _allTheVariables) {
			set.add(new SignsBitSet(variable, 0));
		}
		for (String array : _allTheArrays) {
			set.add(new SignsBitSet(array, 0));
		}
		
// Start recursion:		
		recursion(_table.getRow(0), set);
		
// print LAST ROW:
		
		System.out.println("OUT: \n"+_table.getRowFromBlock(_blocksParam.getExtremalBlocks().iterator().next()).printOut());
		
	}
	
//	while (the newInput != oldIn) DO:
// 1. READ IN
// 2. COMPUTE TRANSFORMATION
// 3. WRITE OWN OUTPUT
// 4. CURRENT.OUT ==> SUCCESSOR.IN		
// OD
	private void recursion(Row<SignsBitSet> currentRow, HashSet<SignsBitSet> inputSet) {
		
		if (debug) {
			System.out.println("visit ==> ("+ currentRow.getLabel() +") [" + currentRow.getBlock().toString()+"]");
		}
		
		HashSet<SignsBitSet> backupIn = currentRow.getIn();	// Backup for later
		
//		if (debug) {
//			
//			System.out.println("inputSet:\n"+ currentRow.printThese(inputSet)
//									+"old IN=backupInput:\n" + currentRow.printIn()
//									+ "old OUT:\n" + currentRow.printOut()
//									);
//		
//			System.out.println("backupInput = inputSet ?");
//		
//		}

		boolean equals = compareSet(backupIn, inputSet);
//		System.err.println(equals);
		
//		if ( !compareSet(backupIn, inputSet) && (!_blocksParam.getExtremalBlocks().contains(currentRow.getBlock())) ) {
// TODO: look if it's necessary to handle the last row in a separate way even in ProgramSlicing, since here it doesn't seem to be.		
		
		
		
// Criterion TO CONTINUE or NOT:	
		if ( !equals ) { // If they are different
				
// TODO: change is not a simple add of new pairs:
			currentRow.unionOfEntriesIN(inputSet); // Modification of addAllToIN	
			
// 1) output <= inputset
			currentRow.unionOfEntriesOUT(currentRow.getIn());
			
// 2) output.remove all the same pairs 		
			if (currentRow.getBlock().isAssignmentBlock() && !currentRow.getBlock().involvesArray()) {  // Is an assignment but NOT an array
//				for ( Iterator<SignsBitSet> outIterator = currentRow.getOut().iterator(); outIterator.hasNext(); ) {
//					SignsBitSet outSignBitSet = (SignsBitSet) outIterator.next();
//					if ( (outSignBitSet.getVariable().equals(currentRow.getLeft())) && (currentRow.getBlock().isAssignmentBlock()) ) { // If it's an assignment, remove all the (x,1)(x,6)(x,12)...
//						outIterator.remove();
//					}
//				}
				
// 3) output.add(gen)
				HashSet<SignsBitSet> tempHashSet = new HashSet<SignsBitSet>();
				SignsBitSet result = _calculator.judgeAssignment(currentRow, new SignsBitSet(currentRow.getLeft(),currentRow.getLabel()));
//				System.err.println("recursion. result = "+result.print());
				tempHashSet.add(result);
				currentRow.unionOfEntriesOUT(tempHashSet);
			}
			
			if (currentRow.getBlock().involvesArray()) {
				SignsBitSet result = _calculator.judgeAssignment(currentRow, new SignsBitSet(currentRow.getLeft(),currentRow.getLabel()));
//				System.err.println("recursion. result = "+result.print());				
				HashSet<SignsBitSet> tempHashSet = new HashSet<SignsBitSet>();
				tempHashSet.add(result);
				currentRow.unionOfEntriesOUT(tempHashSet);
			}
			
	
			// For every next block
			for ( Iterator<IBlock> nextsIterator = currentRow.getBlock().getImmediateNexts().iterator(); nextsIterator.hasNext(); ) {
				IBlock nextBlock = (IBlock) nextsIterator.next();
				Row<SignsBitSet> nextRow = _table.getRowFromBlock(nextBlock);
				// At this point, the output must be already have been modified.
				
	// Recursive call:
				if(debug)
					System.out.println("OUT:\n" +currentRow.printOut());
				
				recursion(nextRow, currentRow.getOut()); 
			}
		}
	}	
	

	
	private boolean compareSet(HashSet<SignsBitSet> s1, HashSet<SignsBitSet> s2) {
		
//		if (debug)
//			System.err.println("compareSet");
		
		boolean answer = true;
		
//		System.err.println("s1 = ");
//		for (SignsBitSet signsBitSet : s1) {
//			System.err.println(signsBitSet.print());
//		}
//		
//		System.err.println("s2 = ");
//		for (SignsBitSet signsBitSet : s2) {
//			System.err.println(signsBitSet.print());
//		}
		
		
		if (s1.isEmpty() ^ s2.isEmpty()) { // If one of the is empty and the other one no, I'm sure the are not equal [XOR]
			return false;
		}
		
		for (SignsBitSet signsBitSet1 : s1) {
			String var = signsBitSet1.getVariable();
			for (SignsBitSet signsBitSet2 : s2) {
				if (signsBitSet2.getVariable().equals(var)) {
					if ( (!signsBitSet1.getValue().equals(signsBitSet2.getValue())) || ( signsBitSet1.getLabel() != signsBitSet2.getLabel() ) ){ // If I enter here, the sets are different, so the answer is: NO
						answer = false;
					}
				}
			}
		}
		
		return answer;
	}
	



	public class Calculator {
		
		private SignsBitSet _signBitSet;
		
		public Calculator() {
			_ArrayKO = new HashSet<IBlock>();
		}
		
		public SignsBitSet judgeAssignment(Row<SignsBitSet> currentRow, SignsBitSet signBitSet) {
			
			_signBitSet = signBitSet;
			IBlock block = currentRow.getBlock();
			
			if( !block.isAssignmentBlock()) { // Exit immediately if for some reason it's NOT an assignment
				System.err.println(block.toString() + " is NOT an assignment");
				return null;
			} 
// In all the other cases, it can keep going
		
			
			
// Left part:		
			AssignmentBlock ab = (AssignmentBlock) block;
			ExpressionSubBlock leftPart = ab.getExpressionLeft();
			
// CONSTANT		
			if (leftPart.isConstant()) { // It's not possible to have a constant on the left side of an assignment ==>  "3 := z + 3"
				System.err.println("Constant on the left side of an assignment?!");
				return null;
			}
			
			// If I'm here everything is ok.
			
// ARRAY		
			if (ab.involvesArray()) { // Assignment of an array
				if (ab.getExpressionLeft().getIndex().isConstant()) {
					if (ab.getExpressionLeft().is_there_negative_inside()) {
						_ArrayKO.add(ab);
					}
					// If I reach this point, the index in the array is NOT negative: ">=0", so it's ok.
				}
				else { // The index is not a single constant: it can still be a variable or a complex expression:
// CALL TO EVALUATE:				
					_signBitSet = returnAdequateBitSet(ab.getExpressionLeft(), currentRow);
				}
				
			}
// VARIABLE		
			else { // Assignment to a variable
// CALL TO EVALUATE:				
				_signBitSet = returnAdequateBitSet(ab.getExpressionRight(), currentRow);
			}
				
			return _signBitSet;
		}

		private SignsBitSet returnAdequateBitSet(ExpressionSubBlock expression, Row<SignsBitSet> currentRow) {
			
			_signBitSet.getValue().clear(); // Clear the bitset ==> [0,0,0]
			addExpressionToQueue(expression, currentRow, "");
			
			_signBitSet.setLabel(currentRow.getLabel());
			_signBitSet.setVariable(currentRow.getLeft());
			
			return _signBitSet = calculateSign(expression,  currentRow);
		}
		
		
		
		private SignsBitSet calculateSign(ExpressionSubBlock expression, Row<SignsBitSet> currentRow) {

			
// ONE ELEMENT ONLY:			
			if (_queue.size() == 1) { 
				Iterator<SignsBitSet> queueIterator = (Iterator<SignsBitSet>) _queue.iterator();
				SignsBitSet elementOfTheQueue = (SignsBitSet) queueIterator.next();
				
				BitSet bitset = elementOfTheQueue.getValue();
				_signBitSet.setBitSet(bitset);
				
				if (elementOfTheQueue.getOperator().equals("-")) {
//					_signBitSet.negate();
					_signBitSet.setNegativeBit();
				}
				
				queueIterator.remove();
				System.out.println("queue.size = " + _queue.size());
			}
			
			
			
			
// MORE ELEMENTS:			
			else { 
				for ( Iterator<SignsBitSet> queueIterator = _queue.iterator(); queueIterator.hasNext(); ) {
//					System.out.println("queue.size = " + _queue.size());
					
// FIRST ELEMENT:					
					SignsBitSet elementOfTheQueue = (SignsBitSet) queueIterator.next();
//					System.out.println("first element = " + elementOfTheQueue.print());
					SignsBitSet firstElement = new SignsBitSet(elementOfTheQueue);
					
//					if (debug)
//						System.out.println("variableA = [" + firstElement.getVariable()+"]");
					
					boolean thereIsAVariable = false;
					
					Integer constantA = 0;
					if ( (constantA = tryParse(elementOfTheQueue.getVariable())) == null) {
						thereIsAVariable = true;
					}
					
// SECOND ELEMENT:					
					elementOfTheQueue = (SignsBitSet) queueIterator.next();
//					System.out.println("second element = " + elementOfTheQueue.print());
					SignsBitSet secondElement = new SignsBitSet(elementOfTheQueue);
					
//					if (debug)
//						System.out.println("variableB = [" + secondElement.getVariable()+"]");
//					
					Integer constantB = 0;
					if ( (constantB = tryParse(elementOfTheQueue.getVariable())) == null) {
						thereIsAVariable = true;
					}	
					
					
					
					
					
					
					
					
// DO THE MATHS:					
					
// VARIABLE SOMEWHERE:					
					if (thereIsAVariable) { 
//						System.out.println("Variable somewhere");
						
						// If there is a subtraction to do:
						if (secondElement.getOperator().equals("-") || firstElement.getValue().get(0) || secondElement.getValue().get(0)) {
							_signBitSet.setAllBits();
						}
						else {
							firstElement.getValue().or(secondElement.getValue());
							_signBitSet.setBitSet(firstElement.getValue());
						}
					}
					
 // ONLY CONSTANTS:					
					else {
						int result = 0;
//						System.out.println("Only constants involved");
						
						if (elementOfTheQueue.getOperator().equals("-")) {
							result = constantA-constantB;
						}
						else {
							result = constantA+constantB;
						}
						
						
						if (result == 0) {
							_signBitSet.setZeroBitOnly();
						}
						if (result > 0) {
							_signBitSet.setPositiveBitOnly();
						}
						if (result < 0) {
							_signBitSet.setNegativeOnly();
						}
						
//						System.out.println("result = " + result);
					}
						
					_queue.removeFirst();
					_queue.removeFirst();
//					System.out.println("queue.size = " + _queue.size());
				}				
			}
			
			return _signBitSet;
		}
		
		public Integer tryParse(String text) {
			  try {
			    return new Integer(text);
			  } catch (NumberFormatException e) {
				  
			    return null;
			  }
			}		
		
		
		private void addExpressionToQueue(ExpressionSubBlock expression, Row<SignsBitSet> currentRow, String operator) {
			
			if (expression == null) {
				if (debug)
					System.err.println("expression = NULL");
				
				return;
			}
			
			SignsBitSet tempBitSet = new SignsBitSet("", operator);
			
// Constant:		
			if (expression.isConstant()) { // [-2 + ...] ==> queue entry = (2, [1,0,0], "-")
				
				tempBitSet.setVariable(expression.getConstants().iterator().next().toString()); 
				
				tempBitSet.setPositiveBit();
				if(expression.toString().contains("-") ) {
					tempBitSet.negate();
				}
				if (expression.getConstantValue() == 0) {
					tempBitSet.setZeroBitOnly();
				}
			}
			
// Variable:		
			if (expression.isIdentifier()) { // [-x + ...] ==> queue entry = (x, [0,1,1], "-")
				tempBitSet.setVariable(expression.getIdentifier());
				
				String var = expression.getIdentifier();
				
				if ( var.contains("-") || var.contains("+") || var.contains("*") || var.contains("/")) {
//					System.err.println("HELP");
					var = var.substring(1); // Cut of the sign
				}
				
				
				tempBitSet.setValue(currentRow.getSpecificBitSetInINField(var).getValue());
			}
			
			if (expression.is_direct_negated()) {
//				System.err.println("expression " + expression.toString() + " is_direct_negated");
				tempBitSet.setNegativeOnly();
				tempBitSet.setOperator("-");
			}	
			
// Expression: Recursive call
			if ( expression.isRecursiveExpression() ) {
				addExpressionToQueue(expression.getExpressionLeft(), currentRow, "+");
				addExpressionToQueue(expression.getExpressionRight(), currentRow, expression.getOperator());
			} 
			else {
				tempBitSet.setLabel(currentRow.getLabel());
				_queue.add(tempBitSet);
			}
			
			return;
		}
		
	}
	
	
	
	private void arrayChecker() {
		if (debug) 
			System.out.println("\narrayChecker");
		
		for ( Iterator<IBlock> arrayIterator = _blocksParam.getAllBlocksWithArray().iterator(); arrayIterator.hasNext(); ) {
			IBlock blockWithArray = (IBlock) arrayIterator.next();
			Row<SignsBitSet> row = _table.getRowFromBlock(blockWithArray);
			
			if (blockWithArray.isAssignmentBlock()) {
				AssignmentBlock ab = (AssignmentBlock) blockWithArray;
				Set<String> variables = ab.getExpressionLeft().getIndex().getVariables();
				
				for (String var : variables) {
					SignsBitSet bitSet = row.getSpecificBitSetInINField(var);
					if (bitSet.getValue().get(0)) { // If the left-most bit is true ==> this
						_ArrayKO.add(blockWithArray);
					}
				}
			}
		}
		
		for (IBlock blockWithProblems : _ArrayKO) {
			System.err.println("Line ["+_table.getRowFromBlock(blockWithProblems).getBlock().toString()+"] contains an array with a possible negative index");
		}
		
	}
	
	public Table<SignsBitSet> getTable() {
		return _table;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	




	@Override
	public void run() {
		startAnalysis();
		
	}

	@Override
	public void PrintStatus() {
		
	}

	@Override
	public void PrintResult() {
		
	}

}
