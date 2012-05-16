/**
 * 
 */
package innerAnalyses;


import general.AnalysisNode;
import general.AnalysisTable;
import general.Pair;

import java.util.*;
import java.util.Map.Entry;
import blockRepresentation.*;
import core.*;

/**
 * @author Johan
 *
 */
public class LiveVariabelAnalysis extends InnerAnalysis {
	
	private AnalysisTable analysisTable;
	private Set<String> holder;
	private String pointOfInterest;
	
	public LiveVariabelAnalysis(String configurationStringParam, BlocksCollection blocksParam, Map<String, ITable> commodityTablesParam) {
		super(configurationStringParam, blocksParam, commodityTablesParam);
		pointOfInterest = configurationStringParam;
		holder = new HashSet<String>();
		setupAnalysisTable(blocksParam);
		analysisTable.printTableLiveVariableAnalysis();
		
	}
	
	private void setupAnalysisTable(BlocksCollection blocksParam){
	
//		Used for generating the Kill-Generate table.
		analysisTable = new AnalysisTable();
		IBlock block;
		AssignmentBlock ab;
		IfBlock ib;
		WhileBlock wb;
		
		for (Iterator<Entry<Integer, IBlock>> iterator = blocksParam.getAllBlocks().entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, IBlock> entry = (Entry<Integer, IBlock>) iterator.next();	
			block = entry.getValue();
			if (block.isAssignmentBlock()) {
//				Cast the block to an assignmentBlock.
				ab = (AssignmentBlock) block;
				
//				Item to go into the row of the Kill-Generate table.				
				AnalysisNode item = new AnalysisNode(ab);	
//				populate the item.				
				item.setId(ab.getLabel());
				
//				Temporary holderConverter variable to make the leftHand variable to a collection
				HashSet<String> holderLeft = new HashSet<String>();
				for(String var : ab.getVariablesLeft()){
					if(!isInteger(var)){
						holderLeft.add(var);
					}
				}
				item.setKill(holderLeft);								
				HashSet<String> holderRight = new HashSet<String>();
				for(String var : ab.getVariablesRight()){
					if(!isInteger(var)){
						holderRight.add(var);
					}
				}
				item.setGen(holderRight);
//				Get the immediate next blocks
				HashSet<Integer> contForward = new HashSet<Integer>();
				for(IBlock node : ab.getImmediateNexts()){
					Integer number = node.getLabel();
					contForward.add(number);
				}
				HashSet<Integer> contBack = new HashSet<Integer>();
				for(IBlock node : ab.getImmediatePreviouses()){
					Integer number = node.getLabel();
					contBack.add(number);
				}
				item.setNextNodes(contForward);
				item.setPreviousNodes(contBack);
				analysisTable.addRow(item);
			} else if(block.isIfBlock()){
				
				ib = (IfBlock) block;
			
				AnalysisNode item = new AnalysisNode(ib);
				item.setId(ib.getLabel());
				HashSet<String> holder = new HashSet<String>();
				
//				Need to handle the left and right hand of the if and while condition.				
				String var1 = ib.getGuard().getVariableLeft();
				Set<String> var2 = ib.getGuard().getVariablesRight();
				HashSet<String> holder2 = new HashSet<String>();
				if(!isInteger(var1)){
					holder.add(var1);
				}
				for(String right : var2){
					if(!isInteger(right)){
						holder.add(right);
					}
				}
				item.setGen(holder);
				item.setKill(holder2);
				
//				Get the immediate next blocks
				HashSet<Integer> contForward = new HashSet<Integer>();
				for(IBlock node : ib.getImmediateNexts()){
					Integer number = node.getLabel();
					contForward.add(number);
				}
				HashSet<Integer> contBack = new HashSet<Integer>();
				for(IBlock node : ib.getImmediatePreviouses()){
					Integer number = node.getLabel();
					contBack.add(number);
				}
				item.setNextNodes(contForward);
				item.setPreviousNodes(contBack);
				analysisTable.addRow(item);
				
			} else if(block.isWhileBlock()){
				wb = (WhileBlock) block;
				
				AnalysisNode item = new AnalysisNode(wb);
				item.setId(wb.getLabel());
				
//				Need to fix while loop.	
				HashSet<String> holder = new HashSet<String>();
				String var1 = wb.getGuard().getVariableLeft();
				Set<String> var2 = wb.getGuard().getVariablesRight();
				if(!isInteger(var1)){
					holder.add(var1);
				}
				for(String right : var2){
					
					if(!isInteger(right)){
						holder.add(right);
					}
				}
				HashSet<String> holder2 = new HashSet<String>();
				item.setGen(holder);
				item.setKill(holder2);
				
//				Get the immediate next blocks
				HashSet<Integer> contForward = new HashSet<Integer>();
				for(IBlock node : wb.getImmediateNexts()){
					Integer number = node.getLabel();
					contForward.add(number);
				}
				HashSet<Integer> contBack = new HashSet<Integer>();
				for(IBlock node : wb.getImmediatePreviouses()){
					Integer number = node.getLabel();
					contBack.add(number);
				}
				item.setNextNodes(contForward);
				item.setPreviousNodes(contBack);
				analysisTable.addRow(item);
			}
		}
	}
	
	private Set<String> generateLVdot(Set<String> LVopen, Set<String> kill, Set<String> gen){
		Set<String> result = new HashSet<String>();
		
		for(String lvopen : LVopen){
				
			if(kill.contains(lvopen)){
				
				result.remove(lvopen);
			} else{
				result.add(lvopen);
			}
		}
		result.addAll(gen);
		return result;
	}
	
	private Set<String> generateLVopen(Set<String> gen, Set<String> var){
		
		Set<String> result = new HashSet<String>();
		
		for(String genVar : gen){
			
			holder.add(genVar);
		
		}
		result.addAll(var);
		return result;
	}
	
    public boolean isInteger( String input )  
    {  
       try  
       {  
          Integer.parseInt( input );  
          return true;  
       }  
       catch( NumberFormatException nfe )  
       {  
          return false;  
       }  
    }  
	
	

	/* (non-Javadoc)
	 * @see core.InnerAnalysis#run()
	 */
	@Override
	public void run() {
		// 
		
		//	See function setup();
		//
		//	Get PP that we are interested in.
		//	Then have the Smallest solution table and find the PP we are interested in.
		//  Display the PP we want and the live variables.
		
		ArrayList<Pair> variables = new ArrayList<Pair>();
		for(int i = analysisTable.size()-1; i>-1; i--){
			AnalysisNode node = analysisTable.getRow(i);
			
			
			Set<String> genNode = node.getGen(); 
			Set<String> killNode = node.getKill();
			Set<String> LVopen = new HashSet<String>();
//			Find the correct pair for this node to generate the LVopen.
			for(Pair pair : variables){
				
					if(pair.getLabel() == node.getId()){
						LVopen = generateLVopen(genNode, pair.getVariable());
					}
				
			}
			node.setLVopen(LVopen);
			
			Set<String> LVdot = generateLVdot(LVopen, killNode, genNode);
			node.setLVdot(LVdot);
			
			
			//Generate the pair to be passed back to right node.
			for(Integer number : node.getPreviousNodes()){
				variables.add(new Pair(LVdot, number));
			}
		}
		
//		Run the loop one more time to check that there is nothing missing.		
		for(int i = analysisTable.size()-1; i>-1; i--){
			AnalysisNode node = analysisTable.getRow(i);
			Set<String> genNode = node.getGen(); 
			Set<String> LVopen = new HashSet<String>();
//			Find the correct pair for this node to generate the LVopen.
			for(Pair pair : variables){
				
					if(pair.getLabel() == node.getId() && node.getLVopen().isEmpty()){
						LVopen = generateLVopen(genNode, pair.getVariable());
						node.setLVopen(LVopen);
					}
			}
		}
		
		int number = 0;;
		
		if(pointOfInterest.contains("All")){
			analysisTable.printTableLiveVariableAnalysis();
		} else if(isInteger(pointOfInterest)){
			number = Integer.parseInt(pointOfInterest);
			System.out.println(analysisTable.getItemByLabel(number).printLVA());
		}else if(!isInteger(pointOfInterest)){
			System.out.println("No a valid input; input must be a number or the word all");
		}
		
		
	}

	/* (non-Javadoc)
	 * @see core.InnerAnalysis#PrintStatus()
	 */
	@Override
	public void PrintStatus() {
		// 

	}

	/* (non-Javadoc)
	 * @see core.InnerAnalysis#PrintResult()
	 */
	@Override
	public void PrintResult() {
		
		

	}

}
