package parser;

import java.io.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public interface IFileParser {
	
	public CommonTree getTreeFromFile ( String fileName) throws IOException, RecognitionException ;
	
}
