package UnitTests;

// Junit Import

import static org.junit.Assert.*;
import org.junit.Test;

// Other Imports

import innerAnalyses.BufferOverflow;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;

import org.antlr.runtime.*;

import blockRepresentation.*;
import core.*;

public class DataFlowAccess {
	
	// variable to check
	private IAnalysis analysis ;
	private boolean opening_result;
	
	public DataFlowAccess (){
		
		opening_result = false;
		
		try {
			
			analysis = new DataFlowAnalysis("config.cfg");
			
			
			analysis.loadSource("data/test_programs/OK/DetectionOfSign");
				
			opening_result = true ;
			
			//analysis.printGraph(); <---- It's printed by the first test. check down
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void _file_Loading() {
		// Printing jus for the first
		analysis.printGraph();
		
		assertEquals("Opening file", true, opening_result);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////// 
	//////////////////////// Tests about Expression type
	////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void access_analysys() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
			analysis.run();
			
			
			
					BufferOverflow a = (BufferOverflow) analysis.getAnalysis("BufferOverflow");
					
					if(a != null)
					 found=true;
			
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	
	
	
}
