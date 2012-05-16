package tests;

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

public class RiccardoDetectionOfSigns {
	


	
	@Test
	public void test_riccardo_1() {

		// variable to check
		IAnalysis analysis ;
		
		// variable to check
		boolean found = false;

		
		try {
			
				// STEP 1 : LOADING THE FILE FOR THIS TEST
				// 
				
				analysis = new DataFlowAnalysis("config.cfg");
				analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
				analysis.printGraph();
				
				// STEP 2 : CALLING THE FUNCTIONS FOR THE TEST
				// 
				
				
				// USE MY BLOCKS 
				BlocksCollection myBlocks = analysis.getBlocksModel();
				
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
					
				Set<AssignmentBlock> blocks_prev =  analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtRight(lab_num ,"x") ;
				
				System.out.println( "Previous x from " + lab_num + " - Right : " + blocks_prev ) ;
				
				// STEP 3 : DECLARING THE RESULT, DECIDING WHEN FOUND IS TRUE OR FALSE
				// 
				
				if( blocks_prev.size() == 4 )
					found = true;
															
			}catch (IOException e) {
				e.printStackTrace();
				found = false;
			} catch (RecognitionException e) {
				e.printStackTrace();
				found = false;
			}
			catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	
	@Test
	public void fake_2() {

		// variable to check
		IAnalysis analysis ;
		
		// variable to check
		boolean found = false;

		
		try {
			
				// STEP 1 : LOADING THE FILE FOR THIS TEST
				// 
				
				analysis = new DataFlowAnalysis("config.cfg");
				analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
				analysis.printGraph();
				
				// STEP 2 : CALLING THE FUNCTIONS FOR THE TEST
				// 
				

				// USE MY BLOCKS 
				BlocksCollection myBlocks = analysis.getBlocksModel();
				
				
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
					
				Set<AssignmentBlock> blocks_prev =  analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtRight(lab_num ,"x") ;
				
				System.out.println( "Previous x from " + lab_num + " - Right : " + blocks_prev ) ;
				
				// STEP 3 : DECLARING THE RESULT, DECIDING WHEN FOUND IS TRUE OR FALSE
				// 
				
				if( blocks_prev.size() == 4 )
					found = true;
																											
			}catch (IOException e) {
				e.printStackTrace();
				found = false;
			} catch (RecognitionException e) {
				e.printStackTrace();
				found = false;
			}
			catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	@Test
	public void fake_3() {

		// variable to check
		IAnalysis analysis ;
		
		// variable to check
		boolean found = false;

		
		try {
			
				// STEP 1 : LOADING THE FILE FOR THIS TEST
				// 
				
				analysis = new DataFlowAnalysis("config.cfg");
				analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
				analysis.printGraph();
				
				// STEP 2 : CALLING THE FUNCTIONS FOR THE TEST
				// 
				

				// USE MY BLOCKS 
				BlocksCollection myBlocks = analysis.getBlocksModel();
				
				
				
				int lab_num = analysis.getBlocksModel().getAllBlocks().size();
					
				Set<AssignmentBlock> blocks_prev =  analysis.getBlocksModel().getAllPreviousAssignmentsWhereIsAtRight(lab_num ,"x") ;
				
				System.out.println( "Previous x from " + lab_num + " - Right : " + blocks_prev ) ;
				
				// STEP 3 : DECLARING THE RESULT, DECIDING WHEN FOUND IS TRUE OR FALSE
				// 
				
				if( blocks_prev.size() == 4 )
					found = true;
																												
			}catch (IOException e) {
				e.printStackTrace();
				found = false;
			} catch (RecognitionException e) {
				e.printStackTrace();
				found = false;
			}
			catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	
	
	
}
