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

public class DeclarationTools {
	
	// variable to check
	private IAnalysis analysis ;
	private boolean opening_result;
	
	public DeclarationTools (){
		
		opening_result = false;
		
		try {
			
			analysis = new DataFlowAnalysis("config.cfg");
			analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
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
	//////////////////////// Tests about Declaration type
	////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////

	
	
	@Test
	public void check_isDeclaration() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(1);
				
				System.out.println( "Checking the isDeclarationBlock() on block " + b ) ;
				
				if( b.isDeclarationBlock() )
				{
					DeclarationBlock a = (DeclarationBlock) b;
					
					if( a.isDeclarationBlock() )
					{
						found = true;	
						System.out.println( "PASSED\n ") ;	
					}
					else
						System.out.println( "FAILED\n ") ;	
				}
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	

	
	@Test
	public void check_isArray() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(1);
				
				if( b.isDeclarationBlock() )
				{
					
					DeclarationBlock c = (DeclarationBlock) b;
					boolean arr = c.isArray() ;
					
					System.out.println( "Checking the isArray() on block " + b + " - Expected true, returned " + arr ) ;
							
					if( arr )
					{
						found = true;	
						System.out.println( "PASSED\n ") ;	
					}
					else
						System.out.println( "FAILED\n ") ;	
				}
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	@Test
	public void check_get_size() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(1);
				
				if( b.isDeclarationBlock() )
				{
					
					DeclarationBlock c = (DeclarationBlock) b;
					int d = c.getSize() ;
					
					System.out.println( "Checking the getSize() on block " + b + " - Expected 10, returned " + d ) ;
							
					if( d == 10 )
					{
						found = true;	
						System.out.println( "PASSED\n ") ;	
					}
					else
						System.out.println( "FAILED\n ") ;	
				}
														
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
}
