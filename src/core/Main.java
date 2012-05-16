package core;

import java.io.*;
import org.antlr.runtime.*;


public class Main {

  public static void main(String args[]) throws Exception {
    
	// Checking the input parameters
	if( args.length != 2 )
		System.out.println("Wrong parameters. <config_file_path> and <source file path> and as parameters.");

	// Creating a new Analysis Object
	IAnalysis analysis = new DataFlowAnalysis(args[0]);
	
	
	// Loading the Input file
	try 
	{
        analysis.loadSource(args[1]);
        analysis.printGraph();
        //BlocksCollection.printTree((CommonTree) analysis.getTree(), 1);
		analysis.run();
    } 
	catch (IOException e) 
	{
	  System.out.println("\n I/O Error : Please insert valid source file path \n");
      e.printStackTrace();
      System.out.println("\n");
    }
	catch (RecognitionException e) 
	{
	  System.out.println("\n Error : Reading the input file. See errors trace below: \n");
      e.printStackTrace();
      System.out.println("\n");
    }
	
  }
  
}
