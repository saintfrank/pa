package core;

import innerAnalyses.InnerAnalysis;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public interface IAnalysis {

	
	public void loadSource ( String fileName) throws IOException, RecognitionException ;
	
	public BlocksCollection getBlocksModel() ;

	public CommonTree getTree();
	
	public void printGraph();
	
	public InnerAnalysis getAnalysis(String name);

	public void run() throws IOException;

	
}
