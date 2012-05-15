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

public class ExpressionTools {
	
	// variable to check
	private IAnalysis analysis ;
	private boolean opening_result;
	
	
	public ExpressionTools (){
			
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
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////// 
	//////////////////////// Tests about Expression type
	////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////

	
	
	@Test
	public void check_is_identifier() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					System.out.println( "Checking the isIdentifier() on " + 9 + "th block. ") ;
					
					if( e.isIdentifier() && !(r.isIdentifier()) )
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
	public void check_isRecursiveExpression() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					System.out.println( "Checking isRecursiveExpression() on " + 9 + "th block. ") ;
					
					if( ( ! e.isRecursiveExpression() ) && r.isRecursiveExpression() )
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
	public void check_isConstant() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(3);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					System.out.println( "Checking isConstant() on " + b + " block. ") ;
					
					if( ( ! e.isConstant() ) && r.isConstant() )
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
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	/////////////
	/////////////  Testing the ToString Functionalities
	/////////////
	///////////////////////////////////////////////////////////////////////////////////////////

		

	
	@Test
	public void check_to_string() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					System.out.println( "Checking the toString() on " + 9 + "th block. ") ;
					
					found=true;	
					
					if( e.toString().equals("x [ 4 ]") )
					{
						System.out.println( "FAILED : Left Expression not equal :\nexpected:\nx [ 4 ]___\nreturned:\n" + e +"___" ) ;
						found=false;						  
					}
					
					if( ! r.toString().equals("x - 3 - 4 + 5 - 6") )
					{
						System.out.println( "FAILED : Right Expression not equal :\nexpected:\nx - 3 - 4 + 5 - 6___\nreturned:\n" + r +"___" ) ;
						found=false;						  
					}
					
					if( found )
						System.out.println( "PASSED" ) ;
					
				}
				
																
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	/////////////
	/////////////  Testing the Array Functionalities
	/////////////
	///////////////////////////////////////////////////////////////////////////////////////////

		
	@Test
	public void check_getIndex() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					System.out.println( "Checking get_index() on " + 9 + "th block. ") ;
					
					if( e.isIdentifier() )
						if( (e.getIndex() != null) && ( r.getIndex() == null ) )					
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
	public void check_involvesArray() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					System.out.println( "Checking involvesArray() on " + b + " block. ") ;
					
					if( e.involvesArray() && ( ! r.involvesArray() ) )
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

	
	///////////////////////////////////////////////////////////////////////////////////////////
	/////////////
	/////////////  Testing the Array Functionalities
	/////////////
	///////////////////////////////////////////////////////////////////////////////////////////

	
	@Test
	public void check_is_there_negative_inside() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
						
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					
					ExpressionSubBlock l = a.getExpressionLeft();
					ExpressionSubBlock r = a.getExpressionRight();
					
					boolean neg = r.is_there_negative_inside() ;
					boolean neg_no = l.is_there_negative_inside() ;
					
					System.out.println( "Is there negative in "+ r + " : returned " + neg + " [expected true]" ) ;
					
					if( neg &&  ( ! neg_no ) )
						found=true;
					
				}
				
																
			} catch ( Exception e) {
				e.printStackTrace();
				found = false;
			} 
		
		assertEquals("Result", true, found);

	}	
	
	
	@Test
	public void check_get_negative_inside() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionRight();
					
					ArrayList<ExpressionSubBlock> d = e.get_negative_inside() ;
					
					System.out.println( "The negaive elements in "+ e + " : returned " + d + " [expected 3 elements]" ) ;
					
					if( d.size() == 3)
					{
						found=true;
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
	public void check_get_positive_inside() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionRight();
					
					ArrayList<ExpressionSubBlock> d = e.get_negative_inside() ;
					
					System.out.println( "The negaive elements in "+ e + " : returned " + d + " [expected 3 elements]" ) ;
					
					if( d.size() == 3)
					{
						found=true;
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
	public void check_is_direct_negative_1() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(9);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionRight();
					
					boolean x = e.getExpressionLeft().is_direct_negated() ;
					boolean three = e.getOperator().equals("-") ;
					
					System.out.println( "The negative elements in "+ e + " : returned " + x + "and" + three + " [expected 3 elements]" ) ;
					
					if( (!x) && three)
					{
						found=true;
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
	public void check_is_direct_negative_2() {

		// variable to check
		boolean found = false;

		// Loading the Input file
		try {
				
				IBlock b = analysis.getBlocksModel().getBlock(7);
				
				if( b.isAssignmentBlock() )
				{
					AssignmentBlock a = (AssignmentBlock) b;
					ExpressionSubBlock e = a.getExpressionRight();
					
					boolean x = e.is_direct_negated() ;
					
					System.out.println( "The negative elements in "+ e + " : returned " + x + " [expected 3 elements]" ) ;
					
					if( x )
					{
						found=true;
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
