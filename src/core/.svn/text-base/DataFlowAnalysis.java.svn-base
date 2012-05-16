package core;

import innerAnalyses.*;
import parser.* ;


import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

// Antlr Imports
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;


public class DataFlowAnalysis implements IAnalysis {
	
	// Data Members

	private CommonTree m_tree;

	private BlocksCollection m_blocks;
	
	private IFileParser m_parser ;
	
	private HashMap<String, InnerAnalysis> m_subAnalyses ;
	//private HashMap<String, IResult> m_results ;
	
	private String m_configFile ;
	
	private Map<String, ITable> m_tables;
	
	
	/** The constructor
	 *  
	 * @param fileName The input file name 
	 * @throws IOException 
	 */
	public DataFlowAnalysis ( String configFile ) throws IOException{
		
		// Initializing the parser
		m_parser = new AntlrFileParser() ;
		m_configFile = configFile ;
		m_blocks = new BlocksCollection();
		m_subAnalyses = new HashMap<String,InnerAnalysis> ();
					
	}
	
	
	/** Getter for the model
	 * 
	 * @return returns the Blocks Model
	 */
	public BlocksCollection getBlocksModel(){ return m_blocks; }
	
	
	/** Performs the input program file loading
	 * 
	 */
	public void loadSource ( String fileName) throws IOException, RecognitionException{
		
		m_tree = BlocksCollection.getSubTreeWithArray( (CommonTree)  m_parser.getTreeFromFile(fileName) );
		
		createBlocksFromAST ();		
	}
	
	
	
	@Override
	public void run() throws IOException {
		
		System.out.println("DataFlow Running ");
		
		loadAnalyses();
	
		for (Map.Entry<String, InnerAnalysis > entry :m_subAnalyses.entrySet())
		{
			System.out.println("Running");
			   
		    entry.getValue().run();
		}		
	}
	

	/** Creates the program Data Graph representation from the input program
	 * 
	 */
	public void createBlocksFromAST () {
		m_blocks.parseTree( m_tree );
	}
	
	/** Prints to standard output a debug Graph representation
	 * 
	 */
	public void printGraph(){
		
		System.out.println( "\n\nThe Program Blocks Representation\n\n " + m_blocks.toString() );
		System.out.println( "\n\nForward edges Representation\n\n " + m_blocks.getNextEdges());
		System.out.println( "\n\nBackward edges nodes Representation\n\n " + m_blocks.getPreviousEdges() + "\n\n");		
	}
	
	/** Public getter for the tree representation
	 * 
	 * @return
	 */
	public CommonTree getTree(){
		return m_tree;
	}
	
	// private mothods
	
	/**
	 * Creates inner analyses parsing configuration file
	 * @throws IOException 
	 */
	private void loadAnalyses() throws IOException {
		
		Properties prop = new Properties();
	    InputStream is = new FileInputStream(m_configFile);

	    prop.load(is);
	    
	    String bo = prop.getProperty("BO_ACTIVE");
	    String lv = prop.getProperty("LV_ACTIVE");
	    String ps = prop.getProperty("PS_ACTIVE");

	    System.out.print("Checking Configuration file for BufferOverflow Analysis activation .. ");
	        
	    // adding the inner analyses
	    if( bo != null && bo.equals("YES") )
	    {
	    	System.out.println("Creating BO Analysis");
		    m_subAnalyses.put("BufferOverflow", new BufferOverflow ( prop.getProperty("BO_PARAM"), m_blocks, m_tables ) ) ;
	    }
	    else
	    {
	    	System.out.println("Not creating BO Analysis");
	    }
	    
	    System.out.print("Checking Configuration file for Live Variables Analysis activation .. ");
	    	    
	    if( lv != null && lv.equals("YES") )
	    {
	    	System.out.println("Creating Live Variable Analysis");
		    m_subAnalyses.put("LiveValiables", new LiveVariabelAnalysis	( prop.getProperty("LV_PARAM"), m_blocks, m_tables ) ) ;    
	    }
	    else
	    {
	    	System.out.println("Not creating Live Variables Analysis");
	    }
	    
	    System.out.print("Checking Configuration file for Program Slicing activation .. ");
	    
	    if( ps != null && ps.equals("YES") )
	    {
	    	System.out.println("Creating Program Slicing Analysis");
	    	  
		    m_subAnalyses.put("ProgramSlicing", new ProgramSlicing ( prop.getProperty("PS_PARAM"), m_blocks, m_tables ) ) ;   
	    }
	    else
	    {
	    	System.out.println("Not creating Program Slicing Analysis");
	    }
	     
	}
	
	public InnerAnalysis getAnalysis(String name){
		
		return this.m_subAnalyses.get(name);
		
	}
	
}
