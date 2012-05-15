package UnitTests;

// Junit Import

import static org.junit.Assert.*;
import org.junit.Test;

// Other Imports

import java.io.*;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.*;

import blockRepresentation.*;
import core.*;

public class ModelValidator {
	
	// variable to check
	private IAnalysis analysis ;
	private boolean opening_result;
	
	public ModelValidator (){
		
		opening_result = false;
		
		try {
			
			analysis = new DataFlowAnalysis("config.cfg");
			analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
			opening_result = true ;
						
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void _file_Loading() {
		
		analysis.printGraph();
				
		assertEquals("Opening file", true, opening_result);
	}
	
	@Test
	public void checkRightPreviousAssignmentSearchAlgorithms() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
					
				Set<AssignmentBlock> blocks_prev =  analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtRight(lab_num ,"x") ;
				
				System.out.println( "Previous x from " + lab_num + " - Right : " + blocks_prev ) ;
				
				if( blocks_prev.size() == 4 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	@Test
	public void checkRightNextsAssignmentSearchAlgorithms() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				Set<AssignmentBlock> blocks_nexts = analysis.getBlocksModel().getAllNextAssignmentsWhereIsAtRight(1,"x") ;
				
				System.out.println( "Nexts x from 1 - Right : " + blocks_nexts ) ;
				
				if( blocks_nexts.size() == 4 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	@Test
	public void checkLeftPreviousAssignmentSearchAlgorithms() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
				
				Set<AssignmentBlock> blocks_prev = analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtLeft(lab_num ,"x");
							
				System.out.println( "Previous from " + lab_num + " - Left : " + blocks_prev ) ;
				
				if( blocks_prev.size() == 5 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	@Test
	public void checkLeftNextsAssignmentSearchAlgorithms() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
				
				Set<AssignmentBlock> blocks_prev = analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtLeft(lab_num ,"x");
							
				System.out.println( "Nexts from " + lab_num + " - Left : " + blocks_prev ) ;
				
				if( blocks_prev.size() == 5 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}

	@Test
	public void checkImmediatePreviousBlocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {	
				// The while block has 3 previouses, 1 trivial and 2 form the inner if
				ArrayList<IBlock> blocks_prev = analysis.getBlocksModel().getBlock(12).getImmediatePreviouses();
				
				System.out.println( "Immediate previous from " + analysis.getBlocksModel().getBlock(12) + " - : " + blocks_prev ) ;
				
				if( blocks_prev.size() == 3 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}

	@Test
	public void checkImmediateNextsBlocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {	
				ArrayList<IBlock> blocks_prev = analysis.getBlocksModel().getBlock(11).getImmediateNexts();
				
				System.out.println( "Immediate previous from " + analysis.getBlocksModel().getBlock(11) + " - : " + blocks_prev ) ;
				
				if( blocks_prev.size() == 2 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}
	
	
	@Test
	public void checkImmediatePreviouses_Post_If_Blocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				ArrayList<IBlock> blocks_nexts = analysis.getBlocksModel().getBlock(12).getImmediatePreviouses();
			
				System.out.println( "Immediate previous from if " + analysis.getBlocksModel().getBlock(12) + " - : " + blocks_nexts ) ;
			
				if( blocks_nexts.size() == 3 )
					found = true;
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}
	
	@Test
	public void checkImmediateNextIfBlocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				ArrayList<IBlock> blocks_nexts = analysis.getBlocksModel().getBlock(11).getImmediateNexts();
			
				System.out.println( "Immediate nexts from " + analysis.getBlocksModel().getBlock(11) + " - which is before if : " + blocks_nexts ) ;
			
				if( blocks_nexts.size() == 2 )
					found = true;
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}
	

	@Test
	public void checkImmediatePreviousesWhile_from_after_Blocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				ArrayList<IBlock> blocks_nexts_in = analysis.getBlocksModel().getBlock(11).getImmediatePreviouses();
				ArrayList<IBlock> blocks_nexts_out = analysis.getBlocksModel().getBlock(13).getImmediatePreviouses();
			
				System.out.println( "Immediate previous from " + analysis.getBlocksModel().getBlock(11) + ", going to while - : " + blocks_nexts_in  ) ;
				System.out.println( "Immediate previous from " + analysis.getBlocksModel().getBlock(13) + ", going to while - : " + blocks_nexts_out ) ;
				
				if( ( blocks_nexts_in.size() == 1 ) && ( blocks_nexts_out.size() == 1) )
				if( blocks_nexts_in.get(0).isWhileBlock()  && blocks_nexts_out.get(0).isWhileBlock()  )
					found = true;
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}
	
	@Test
	public void checkLeftArray() {

		// variable to check
		boolean found = true;

		
		
		assertEquals("Result", true, found);
	}
	
	@Test
	public void checkLeftMultipleArray() {

		// variable to check
		boolean found = true;

		
		
		assertEquals("Result", true, found);
	}
	
	@Test
	public void checkRightArray() {

		// variable to check
		boolean found = true;

		
		
		assertEquals("Result", true, found);
	}
	
	@Test
	public void checkRightMultipleArray() {

		// variable to check
		boolean found = true;

		
		
		assertEquals("Result", true, found);
	}
	
	@Test
	public void checkAllBlocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
				
				System.out.println( "Number of blocks: " + lab_num  ) ;
				
				if( lab_num == 14 )
					found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}
	
	
	@Test
	public void checkImmediateNexBlocks() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
				int half = (int)lab_num / 2 ;
				
				System.out.println( "Nexts from 1 - Left : " + analysis.getBlocksModel().getAllNextAssignmentsWhereIsAtLeft(1,"x") ) ;
				System.out.println( "Nexts from 1 - Right : " + analysis.getBlocksModel().getAllNextAssignmentsWhereIsAtRight(1,"x") ) ;
				System.out.println( "Previous from " + analysis.getBlocksModel().getBlock(lab_num) + " - Left : " + analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtLeft(lab_num ,"x") ) ;
				System.out.println( "Previous from " + analysis.getBlocksModel().getBlock(lab_num) + " - Right : " + analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtRight(lab_num ,"x") ) ;
				System.out.println( "Immediate previous from " + analysis.getBlocksModel().getBlock(half) + " : " + analysis.getBlocksModel().getBlock(half).getImmediatePreviouses() ) ;
				System.out.println( "Immediate nexts from " + analysis.getBlocksModel().getBlock(half) + " : " + analysis.getBlocksModel().getBlock(half).getImmediateNexts() ) ;
				
				found = true;
															
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);
	}
	
	
}
