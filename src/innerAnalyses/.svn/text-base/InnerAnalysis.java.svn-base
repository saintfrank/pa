package innerAnalyses;

import java.util.Map;

import core.BlocksCollection;
import core.ITable;



/**
 * 
 * @author Francesco 
 *
 * @class This class represent inner analysis as Detection of sign
 */
public abstract class InnerAnalysis {
	
	
	/**
	 * 
	 * @param configurationStringParam A string represnting the parameters for this inner analysis read on the configuration file
	 * @param blocksParam The Program Blocks container Representation, see BlocksCollection public methods
	 * @param commodityTablesParam Map of Tables that might be useful, accessed via name 
	 */
	InnerAnalysis(String configurationStringParam, BlocksCollection blocksParam, Map<String, ITable> commodityTablesParam ){
		
		m_configurationString = configurationStringParam;
		m_blocks = blocksParam;
		m_commodityTables = commodityTablesParam ;
		
	}
	
	/**
	 * Start the analysis
	 */
	public abstract void run();
	
	/**
	 * Prints a text representation of the status of the analysis
	 */
	public abstract void PrintStatus();
	
	/**
	 * Prints a text representation of the result of the analysis status of the analysis
	 */
	public abstract void PrintResult();


	
	private String 				m_configurationString;
	protected BlocksCollection 	m_blocks;
	private Map<String, ITable> m_commodityTables;
	
}
