package blockRepresentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;

import core.BlocksCollection;

public class IfBlock extends IBlock implements IControlBlock {

	private ArrayList<IBlock> m_then;
	private ArrayList<IBlock> m_else;
	private BooleanExpressionSubBlock m_guard;

	public IfBlock(CommonTree t) {

		m_then = new ArrayList<IBlock>();
		m_else = new ArrayList<IBlock>();

		if (t.getChildCount() > 1) {

			m_guard = new BooleanExpressionSubBlock((CommonTree) t.getChild(0)); // automatically

			if (t.getChild(1).getType() == 41) { // The then

				int i = 2;

				for (; i < t.getChildCount(); i++) {
					
					if (t.getChild(i).getType() == 9) // else
						break;
					else {

						switch (t.getChild(i).getType()) {

						case 44:
							addThenBlock(new WhileBlock(
									(CommonTree) t.getChild(i)));
							break;
						case 17:
							addThenBlock(new IfBlock((CommonTree) t.getChild(i)));
							break;
						case 40:
							addThenBlock(new SkipBlock(
									(CommonTree) t.getChild(i)));
							break;
						case 5:
							addThenBlock(new AssignmentBlock(
									(CommonTree) t.getChild(i)));
							break;
						}

					}
				}

				for (int j = i + 1; j < t.getChildCount(); j++) {

					switch (t.getChild(j).getType()) {

					case 44:
						addElseBlock(new WhileBlock((CommonTree) t.getChild(j)));
						break;
					case 17:
						addElseBlock(new IfBlock((CommonTree) t.getChild(j)));
						break;
					case 40:
						addElseBlock(new SkipBlock((CommonTree) t.getChild(j)));
						break;
					case 5:
						addElseBlock(new AssignmentBlock(
								(CommonTree) t.getChild(j)));
						break;
					}

				}

			}

		} else {
			/** @todo throw the exception */

		}

	}

	private void addElseBlock(IBlock b) {

		if (this.m_else.isEmpty()) // the first on eis next to while
		{
			this.m_nexts.add(b);
			b.add_Previous(this);
		} 
		else // adding to the list
		{
			this.m_else.get(this.m_else.size() - 1).addNext(b);
			b.add_Previous(this);
		}

		BlocksCollection.addBlock(b);
		
		this.m_else.add(b);
	}

	private void addThenBlock(IBlock b) {

		if (this.m_then.isEmpty()) // the first on eis next to while
		{
			this.m_nexts.add(b);
			b.add_Previous(this);
		} else // adding to the list
		{
			this.m_then.get(this.m_then.size() - 1).addNext(b);
			b.add_Previous(this);
		}

		BlocksCollection.addBlock(b);
		
		this.m_then.add(b);
	}
	
	@Override
	public BooleanExpressionSubBlock getGuard(){
		return this.m_guard;
	}

	@Override
	public void addNext(IBlock b) {
		
		//System.out.println("I am "+ this.getLabel() + "\t " + this.toString() + " Assigning to me next " + b.getLabel() + "\t " + b.toString() );
		
		if (!m_then.isEmpty())
			m_then.get(m_then.size() - 1).addNext(b);

		if (!m_else.isEmpty())
			m_else.get(m_else.size() - 1).addNext(b);

	}

	@Override
	public String toStringSubtree() {

		String result = "if " + m_guard.toString();

		if (m_then.size() != 0) {
			result += "\n\tthen";

			for (int i = 0; i < m_then.size(); i++)
				result += "\n\n\t" + m_then.get(i).toString();

		}

		if (m_else.size() != 0) {
			result += "\n\telse";

			for (int i = 0; i < m_else.size(); i++)
				result += "\n\n\t" + m_else.get(i).toString();

		}

		return result;
	}

	@Override
	public String toString() {

		return m_guard.toString();
	}
	

	/** Returns the set of blocks that are in this block. It includes also inner sub-stacks blocks in case of inner while or if. 
	 * @returns The set of inner blocks
	 */
	public Set<IBlock> getInnerBlocks(){
		
		Set<IBlock> s = new HashSet<IBlock>();
		
		s.addAll(this.m_then);
		s.addAll(this.m_else);
		
		for(int i = 0 ; i < this.m_then.size() ; i++)
		{
			if(this.m_then.get(i).isControlBlock())
				s.addAll( ( (IControlBlock) this.m_then.get(i) ).getInnerBlocks());		
		}	

		for(int i = 0 ; i < this.m_else.size() ; i++)
		{
			if(this.m_else.get(i).isControlBlock())
				s.addAll( ( (IControlBlock) this.m_else.get(i) ).getInnerBlocks());		
		}	
	
		return s;
		
	}
	
	@Override
	public boolean involvesArray (){
		
		return m_guard.involvesArray();
		
	}

	@Override
	public boolean isIfBlock() {
		return true;
	}

	@Override
	public boolean isControlBlock() {
		return true;
	}
	
	

}
