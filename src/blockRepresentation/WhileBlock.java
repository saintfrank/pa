package blockRepresentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;

import core.BlocksCollection;

public class WhileBlock extends IBlock implements IControlBlock {
	

	private BooleanExpressionSubBlock		m_guard;
	private ArrayList<IBlock> 	m_subBlocks;
		
	
	public WhileBlock(CommonTree t){
		
		m_subBlocks = new ArrayList<IBlock> ();
		
		if ( t.getChildCount() != 0)
		{
			/** @todo throw exception */
		}
		
		
		//if ( t.getChild(0).getType() == 40 )
		//	m_guard = new SkipBlock((CommonTree) t.getChild(0));
		///else 
			m_guard = new BooleanExpressionSubBlock((CommonTree) t.getChild(0)); // automatically it is going to be a guard
		
		
		for ( int i = 1; i < t.getChildCount(); i++ ){
			
			switch ( t.getChild(i).getType() ) {
			
			case 44:
				addBlock(new WhileBlock((CommonTree) t.getChild(i)));
				break;
			case 17:
				addBlock(new IfBlock((CommonTree) t.getChild(i))); 
				break;
			case 40:
				addBlock(new SkipBlock((CommonTree) t.getChild(i))); 
				break;
			case 5:
				addBlock(new AssignmentBlock((CommonTree) t.getChild(i))); 
				break;
			}
		
		}
		
		rechain();
		
	}
	
	/**
	 *  Brings back an edge to the while block
	 */
	private void rechain() { 
		
		if(  !this.m_subBlocks.isEmpty() ) // the first on eis next to while
		{
			this.m_subBlocks.get(this.m_subBlocks.size()-1).addNext(this);
		}
	}

	private void addBlock(IBlock b){
		
		if( this.m_subBlocks.isEmpty() ) // the first on eis next to while
		{
			this.addNext(b);
		}
		else // adding to the list
		{
			this.m_subBlocks.get(this.m_subBlocks.size()-1).addNext(b);
		}
		
		BlocksCollection.addBlock(b);
		this.m_subBlocks.add(b);
		
	}
	
	@Override
	public String toStringSubtree() {
		
		String result = "while" + m_guard.toString() ;
		
		for(int i = 0 ; i < m_subBlocks.size() ; i ++ )
			result +=  "\n\t" + m_subBlocks.get(i).toString() ;
		
		return result;
	}
	
	@Override
	public String toString() {
		
		return m_guard.toString();
		
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
	

	/** Returns the set of blocks that are in this block. It includes also inner sub-stacks blocks in case of inner while or if. 
	 * @returns The set of inner blocks
	 */
	public Set<IBlock> getInnerBlocks(){
		
		Set<IBlock> s = new HashSet<IBlock>();
		
		s.addAll(this.m_subBlocks);
		
		for(int i = 0 ; i < this.m_subBlocks.size() ; i++)
		{
			if(this.m_subBlocks.get(i).isControlBlock())
				s.addAll( ( (IControlBlock) this.m_subBlocks.get(i) ).getInnerBlocks());		
		}	
		
		return s;
		
	}
	

	/** Getter for the guard block
	 * 
	 * @return The guard element
	 */
	@Override
	public BooleanExpressionSubBlock getGuard(){
		return this.m_guard;
	}

	@Override
	public boolean involvesArray (){
		
		return m_guard.involvesArray();
		
	}
	
	@Override
	public boolean isWhileBlock() {
		return true;
	}
	
	@Override
	public boolean isControlBlock() {
		return true;
	}
	
	

}
