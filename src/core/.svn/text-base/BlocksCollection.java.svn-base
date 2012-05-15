package core;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

import org.antlr.runtime.tree.CommonTree;

import blockRepresentation.*;


public class BlocksCollection {
	
	private static int s_label ;
	
	private static int s_next;
	
	private static  Map<Integer, IBlock> s_blocks;

	
	public BlocksCollection(){
		
		s_blocks = new HashMap<Integer, IBlock> ();
		s_label = 1 ;
		
	}
	
	/**
	 * Print to output a textual representation of the inner structure
	 */
	public void print(){}
	

	public void parseTree(CommonTree t) {
		
		//////////// this little snippet aims to avoid the situation when the root of the tree is not a null node, but a block node. 
		//////////// (the root is null whenever there is more than one instruction at first grammar level )
		//////////// For this cases a new root is created
		if( t.getText() != null )
		{
			CommonTree newRoot = new CommonTree();
			newRoot.addChild(t);
			t = newRoot;			
		}
		/////////////////////////////
		
		if ( t != null ) {
		
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				
				IBlock newBlock = createBlock((CommonTree) t.getChild(i));
				
				
				if( ! s_blocks.isEmpty() ) // the first is next to none
				{
						s_blocks.get(s_next).addNext(newBlock);
				}
				
			    addBlock( newBlock , true); 
			    
			}
			
		}	
		
		
		
	}
	
	private IBlock createBlock(CommonTree t) {
		
		if ( t != null ) {
			
			switch ( t.getType() ) {
			
			case 44:
				return new WhileBlock(t); 
			case 17:
				return new IfBlock(t); 
			case 40:
				return new SkipBlock(t); 
			case 5:
				return new AssignmentBlock(t); 
			case 18:
				return new DeclarationBlock(t); 

			}
		
		}
		
		return null;	
		
	}
	
	public static boolean addBlock(IBlock b){
		
		b.setLabel(s_label);		
		s_blocks.put(s_label++, b);
		
		return true ;
	}
	
	
	public static boolean addBlock(IBlock b, boolean l ){
		
		s_next = s_label ;
		b.setLabel(s_label);
		s_blocks.put(s_label++, b);
		
		return true ;
	}

	public static void printTree(CommonTree t, int indent) {
		
		if ( t != null ) {
			StringBuffer sb = new StringBuffer(indent);
			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println( sb.toString() + t.getChild(i).toString()   );
				printTree((CommonTree)t.getChild(i), indent+1);
			}
			
		}	
		
	}

	public String getEdges() {
		
		String result = "" ; 
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    result = result + "\n" + entry.getValue().getLabel() + "\t" + entry.getValue() ;
		    
		    ArrayList<IBlock> nexts = entry.getValue().getImmediateNexts() ;
		    for (int i = 0 ; i < nexts.size(); i++)
		    	result = result + "\t\t " + nexts.get(i).getLabel() + "\t"+nexts.get(i);		    
		    
		}
		
		return result;	
	}
	
	
	
	/**********************************
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 					DEAR ANALYSTS PLEASE LOOK DOWN HERE
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * *********************************
	 */
	
	/** Getter for a block accessing by label
	 *  @param l The label
	 *  @returns The Block with label l
	 */
	public Map<Integer,IBlock> getAllBlocks(){	
		return  new HashMap<Integer,IBlock>(s_blocks) ;
	}
	
	
	
	/** Getter for a block accessing by label
	 *  @param l The label
	 *  @returns The Block with label l
	 */
	public IBlock getBlock(int l){
		return s_blocks.get(l);
	}
	
	/** Retrieves all the previous blocks where the variable var was involved as assignment destination
	 *  @param l The label
	 *  @param var Variable name
	 *  @returns The Block with label l
	 */
	public Set<AssignmentBlock> getAllPreviousAssignmentsWhereIsAtLeft(int l, String var){
		
		Set<AssignmentBlock> s = new HashSet<AssignmentBlock>();	
		
		IBlock b = s_blocks.get(l);
			
		if( b != null)
		{
			// getting all the previous assignments
			Set<IBlock> allPreviouses ;
			allPreviouses = b.getAllPreviousesEver(new HashSet<IBlock>()) ;
				
			// iterating the set
			Iterator<IBlock> i = allPreviouses.iterator();
			
			while ( i.hasNext()) {
			      
				IBlock temp =  i.next() ;
			    
				// Adding the assignemnts
				if ( temp.isAssignmentBlock() ) 
				{
					// casting
					AssignmentBlock a  = (AssignmentBlock) temp;
					
					// Passing jus tif the var is at left
					if( a.isOnLeft(var) )
						s.add(a);
				}      
		    }
			
		}
		
		return s;
	}
	
	/** Retrieves all the previous blocks where the variable var was involved as assignment source
	 *  @param l The label
	 *  @param var Variable name
	 *  @returns The Block with label l
	 */
	public Set<AssignmentBlock> getAllPreviousAssignmentsWhereIsAtRight(int l, String var){
		
		Set<AssignmentBlock> s = new HashSet<AssignmentBlock>();	
		
		IBlock b = s_blocks.get(l);
		
		if( b != null)
		{
			// getting all the previous assignments
			Set<IBlock> allPreviouses ;
			allPreviouses = b.getAllPreviousesEver(new HashSet<IBlock>()) ;
				
			// iterating the set
			java.util.Iterator<IBlock> i = allPreviouses.iterator();
			
			while ( i.hasNext()) {
			      
				IBlock temp =  i.next() ;
			    
				// Adding the assignemnts
				if ( temp.isAssignmentBlock() ) 
				{
					// casting
					AssignmentBlock a  = (AssignmentBlock) temp;
					
					// Passing jus tif the var is at left
					if( a.isOnRight(var) )
						s.add(a);
				}
			      
		    }
			
			
		}
		
		return s;
	}
	

	/** Retrieves all the nexts blocks where the variable var was involved as assignment Destination
	 *  @param l The label
	 *  @param var Variable name
	 *  @returns The Block with label l
	 */
	public Set<AssignmentBlock> getAllNextAssignmentsWhereIsAtLeft(int l, String var){

		Set<AssignmentBlock> s = new HashSet<AssignmentBlock>();	
		
		IBlock b = s_blocks.get(l);
		
		if( b != null)
		{
			// getting all the previous assignments
			Set<IBlock> allNexts = new HashSet<IBlock>() ;
			allNexts = b.getAllNextsEver(allNexts) ;
				
			// iterating the set
			java.util.Iterator<IBlock> i = allNexts.iterator();
			
			while ( i.hasNext()) {
			      
				IBlock temp =  i.next() ;
			    
				// Adding the assignemnts
				if ( temp.isAssignmentBlock() ) 
				{
					// casting
					AssignmentBlock a  = (AssignmentBlock) temp;
					
					// Passing jus tif the var is at left
					if( a.isOnLeft(var) )
						s.add(a);
				}
			      
		    }
			
			
		}
		
		return s;
	}
	
	
	/** Retrieves all the next blocks where the variable var was involved as assignment source
	 *  @param l The label
	 *  @param var Variable name
	 *  @returns The Block with label l
	 */
	public Set<AssignmentBlock> getAllNextAssignmentsWhereIsAtRight(int l, String var){

		Set<AssignmentBlock> s = new HashSet<AssignmentBlock>();	
		
		IBlock b = s_blocks.get(l);
		
		if( b != null)
		{
			// getting all the previous assignments
			Set<IBlock> allNexts = new HashSet<IBlock>() ;
			allNexts = b.getAllNextsEver(allNexts) ;
				
			// iterating the set
			java.util.Iterator<IBlock> i = allNexts.iterator();
			
			while ( i.hasNext()) {
			      
				IBlock temp =  i.next() ;
			    
				// Adding the assignemnts
				if ( temp.isAssignmentBlock() ) 
				{
					// casting
					AssignmentBlock a  = (AssignmentBlock) temp;
					
					// Passing jus tif the var is at left
					if( a.isOnRight(var) )
						s.add(a);
				}
			      
		    }
			
			
		}
		
		return s;
	}
	
	
	/** Retrieves all the blocks where arrays are accessed
	 *  @param var Variable name
	 *  @returns The Blocks where arrays are used
	 */
	public Set<IBlock> getAllBlocksWithArray(){

		Set<IBlock> s = new HashSet<IBlock>();	
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    if(entry.getValue().involvesArray())
				s.add(entry.getValue());
		}
		return s;
	}
	
	/** Retrieves all the blocks where arrays are accessed and the variable var is involved 
	 *  @note This check is not very rigorous, the presence of the variable is checked string-wise on the string representation of the block. More checks should be performed by the caller 
	 *  @param var Variable name
	 *  @returns The Blocks where arrays are used
	 */
	public Set<IBlock> getAllBlocksWithArrayAndVariable( String var){

		Set<IBlock> s = new HashSet<IBlock>();	
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    if(entry.getValue().involvesArray())
		    	if( entry.getValue().toString().contains(var) )
		    		s.add(entry.getValue());
		}
		return s;
	}
	
	/** Retrieves all the next blocks where the variable var was involved as assignment source
	 *  @param l The label
	 *  @param var Variable name
	 *  @returns The Block with label l
	 */
	public Set<AssignmentBlock> getAllAssignments(int l, String var){

		Set<AssignmentBlock> b = new HashSet<AssignmentBlock>();
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    if(entry.getValue().isAssignmentBlock())
				b.add((AssignmentBlock)entry.getValue());
		}
		
		return b;
	}
	
	/** Retrieves all the next blocks where the variable var was involved as assignment source
	 *  @param l The label
	 *  @param var Variable name
	 *  @returns The Block with label l
	 */
	public Set<String> getAllVariables(){

		Set<String> b = new HashSet<String>();
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    if(entry.getValue().isAssignmentBlock())
		    {
		    	AssignmentBlock a = (AssignmentBlock) entry.getValue();
				b.addAll( a.getVariablesLeft());
				b.addAll( a.getVariablesRight());
		    }
		    
		    if(entry.getValue().isControlBlock())
		    {
		    	IControlBlock c = (IControlBlock) entry.getValue();
		    	BooleanExpressionSubBlock a = (BooleanExpressionSubBlock) c.getGuard() ;
				b.addAll( a.getVariablesLeft());
				b.addAll( a.getVariablesRight());
		    }
		    
		    
		}
		
		return b;
	}
	
	
	/** Returns a string representation of the Graph with just Nexts edges
	 * 
	 * @return  a string representation of the Graph with just Nexts edges
	 */
	public String getNextEdges() {
		
		String result = "" ; 
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    result = result + "\n(" + entry.getValue().getLabel()  + ") " + entry.getValue() + "\t-->" ;
		    
		    ArrayList<IBlock> nexts = entry.getValue().getImmediateNexts() ;
		    for (int i = 0 ; i < nexts.size(); i++)
		    	result = result  + "\t(" +nexts.get(i).getLabel() + ")\t"+nexts.get(i);		    
		    
		}
		
		return result;	
	}
	
	/** Returns a string representation of the Graph with just Previouses
	 * 
	 * @return  a string representation of the Graph with just Nexts edges
	 */
	public String getPreviousEdges() {
		
		String result = "" ; 
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
			result = result + "\n(" + entry.getValue().getLabel()  + ") " + entry.getValue() + "\t-->" ;
		    
		    ArrayList<IBlock> nexts = entry.getValue().getImmediatePreviouses() ;
		    for (int i = 0 ; i < nexts.size(); i++)
		    	result = result  + "\t(" +nexts.get(i).getLabel() + ")\t"+nexts.get(i);		    
		    
		}
		
		return result;	
	}
	
	/** retrieves the Initial blocks
	 * 
	 * @return a set of extremal blocks
	 */
	public Set<IBlock> getInitialBlocks(){
		
		Set<IBlock> b = new HashSet<IBlock>();
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    if(entry.getValue().getImmediatePreviouses().isEmpty())
				b.add(entry.getValue());
		}
		
		return b;
	}
	
	/** retrieves the Extreaml blocks
	 * 
	 * @return a set of extremal blocks
	 */
	public Set<IBlock> getExtremalBlocks(){
		
		Set<IBlock> b = new HashSet<IBlock>();
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    if(entry.getValue().getImmediateNexts().isEmpty())
				b.add(entry.getValue());
		}
		
		return b;
	}
	
	/** Goes 
	 * 
	 * @return a set of extremal blocks
	 */
	public static CommonTree getSubTreeWithArray( CommonTree t){
		
		//System.out.println( "getSubTreeWithArray : start with " + t.toStringTree() );
		
		CommonTree newTree = new CommonTree();
		newTree.token = t.getToken();		
		
		for ( int i = 0 ; i < t.getChildCount(); i++ ) 
		{
			if( t.getChild(i).getType() == 16 )
			{
				
				int identifier_index = i ;
				
				//System.out.println( "Found and identifier: " + t.getChild(i).toString()   );
				
				// Creating a new Tree (deleting is very cumbersome, it is safer to create a new one)
				CommonTree identifierTree = new CommonTree( (CommonTree) t.getChild( identifier_index ) );
				
				// The inner if statements have to purpose to guarantee the order of execution
				if( identifier_index + 1 < t.getChildCount() )	// So t.getChild(i+1) will not be null 
					if(t.getChild( identifier_index + 1 ).getType() == 21 )	// If is followed by "[" 
					{
						
						//System.out.println( "Found a parenthesis" + t.getChild( identifier_index + 1 ).toString()   );
						
						int temp_index_node = identifier_index + 2 ;		// Now it is sure that t.getChild(i+2) exists (waiting for ] )
						
						//////////////////// This variable is a pseudo-stack counter 
						//////////////////// keeps track of the nested parenthesis syntax, recognizing the inner parenthesis 
						
						int parenthesis_stack = 0;			
												
						// adding the index blocks as sub-tree of identifier
						while( ! ( t.getChild( temp_index_node ).getType() == 35 && parenthesis_stack == 0 )  )	// Until we find the last "]" 
						{	
							//System.out.println( "Found an index component : " + t.getChild( temp_index_node ).toString()   );
							
							identifierTree.addChild( t.getChild( temp_index_node ) );
							
							//////////////////// This part of the code, together with the variable parenthesis_stack 
							//////////////////// keeps track of the nested parenthesis syntax, recognizing the inner parenthesis 
							if( t.getChild( temp_index_node ).getType() == 21 ) // keeping track of parenthesis
								parenthesis_stack++;
							
							if( t.getChild( temp_index_node ).getType() == 35 ) // keeping track of parenthesis
								parenthesis_stack--;							
							////////////////////////////////////////////////////////////////////////
								
							temp_index_node ++;
						}
						
						//System.out.println( "Here is the closing parenthesis: " + t.getChild( temp_index_node ).toString()   );
													
						i = temp_index_node;
								
					}
				
				CommonTree newIdentifierTree = BlocksCollection.getSubTreeWithArray( identifierTree );
				
				newTree.addChild(newIdentifierTree);
				
			}
			else
			{
				CommonTree newSubTree = BlocksCollection.getSubTreeWithArray( ( CommonTree ) t.getChild(i) );
				newTree.addChild(newSubTree);
			}
		}	
		
		newTree.freshenParentAndChildIndexesDeeply();	
		
		return newTree; // will work as base step
	}
	
	
	
	/** The tostring implementation provides the list of the label/states of the graph
	 * 
	 * @returns the mapping label/block
	 */
	public String toString() {
		
		String result = "" ; 
		
		for (Map.Entry<Integer, IBlock> entry : s_blocks.entrySet())
		{
		    result = result + "\n(" + entry.getValue().getLabel() + ") " + entry.getValue().toString() ;
		}
		
		return result;
		
	}
	
}
