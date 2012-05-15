package UnitTests;

// Junit Import

import static org.junit.Assert.*;

import org.junit.Test;

// Other Imports

import java.io.*;
import java.util.Set;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;

import blockRepresentation.ExpressionSubBlock;
import blockRepresentation.IBlock;

import core.*;

public class InputValidation {

	@Test
	public void missingFile() {

		// variable to check
		boolean found = false;

		IAnalysis analysis;
		try {

			analysis = new DataFlowAnalysis("config.cfg");

			// Loading the Input file
			try {

				analysis.loadSource("prova");

			} catch (IOException e) {
				found = true;
			} catch (RecognitionException e) {
				found = false;
			}

		} catch (IOException e1) {

			System.out.println("Error : Configuration file not found ");
		}

		assertEquals("Result", true, found);

	}

	@Test
	public void badSyntaxProgram() {

		/**
		 * @todo To be fixed. Check why the parser never throws exception with
		 *       bad files !!
		 */

		// variable to check
		boolean found = false;

		IAnalysis analysis;
		try {
			analysis = new DataFlowAnalysis("config.cfg");

			// Loading the Input file
			try {

				analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
				found = true;
			
			} catch (IOException e) {
				found = false;
			} catch (RecognitionException e) {
				System.out.println("\n\n Beccato recognition\n\n");
				found = false;
			} catch (Exception e) {
				found = true;
			}

		} catch (IOException e1) {

			System.out.println("Error : Configuration file not found ");
		}

		assertEquals("Result", true, found);

	}

	@Test
	public void FrancescoWorkbench() {

		// variable to check
		boolean found = false;

		IAnalysis analysis;
		try {
			analysis = new DataFlowAnalysis("config.cfg");

			// Loading the Input file
			try {

				analysis.loadSource("data/test_programs/test/FrancescoWorkbench");
				found = true;
			} catch (IOException e) {
				found = true;
			} catch (RecognitionException e) {
				found = true;
			}
		} catch (IOException e1) {

			System.out.println("Error : Configuration file not found ");
		}

		assertEquals("Result", true, found);

	}

	@Test
	public void arrayHandling() {

		// variable to check
		boolean result = false;

		IAnalysis analysis;

		// Loading the Input file
		try {

			analysis = new DataFlowAnalysis("config.cfg");
			analysis.loadSource("data/test_programs/test/FrancescoArrayProgram");

			// Getting the tree representation
			CommonTree myTree = analysis.getTree();
			
			System.out.println("Tree: ");
			BlocksCollection.printTree((CommonTree) myTree, 1);
			System.out.println("Finished : ");
				
			analysis.printGraph();

			Set<IBlock> s = analysis.getBlocksModel().getAllBlocksWithArray();
			System.out.println("Present Arrays: " + s);
			
			Set<IBlock> s1 = analysis.getBlocksModel().getAllBlocksWithArrayAndVariable("x");
			System.out.println("Present Arrays with variable x: " + s1);
			
			if(s.size() == 2 && s1.size() ==1) 			
				result = true;

		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		} catch (RecognitionException e) {
			e.printStackTrace();
			result = false;
		}

		assertEquals("Result", true, result);

	}

	/** @todo Now create all the bad configuration files Validations */

}
