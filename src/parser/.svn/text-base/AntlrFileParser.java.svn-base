package parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class AntlrFileParser implements IFileParser {

	@Override
	public CommonTree getTreeFromFile(String fileName) throws  RecognitionException, IOException {
		
		
		TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(fileName));
	    CommonTokenStream tokens = new CommonTokenStream(lex);
	    TheLangParser parser = new TheLangParser(tokens);

	    TheLangParser.program_return parserResult = parser.program();
	    
	    if (parserResult == null) {
	    	throw new RecognitionException();	       
	    }
	    
	    CommonTree tree = (CommonTree) parserResult.tree;
	    
        return tree;
	      
	}

}
