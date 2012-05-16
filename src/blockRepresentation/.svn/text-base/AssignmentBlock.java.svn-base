package blockRepresentation;

import java.util.Set;
import org.antlr.runtime.tree.CommonTree;

public class AssignmentBlock extends IBlock {
	
	
	private ExpressionSubBlock m_left ;
	private ExpressionSubBlock m_right;
	

	public AssignmentBlock(CommonTree t){	
		
		if (  t.getChildCount() >= 2 ) {
				
			m_left =  new ExpressionSubBlock((CommonTree) t.getChild(0));
			m_right = new ExpressionSubBlock((CommonTree) t.getChild(1));
		
		}
		else
		{		
			/**@todo throw exception, empty guard*/
		}
		
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
	

	/**Checks whehter the string variable as input is present on Left
	 * 
	 * @return true if is present, false otherwise
	 */
	public boolean isOnLeft(String s) {
		
		Set<String> ss = m_left.getVariables();
		
		return ss.contains(s);
	}
	
	/**Checks whehter the string variable as input is present on Right
	 * 
	 * 
	 * @return true if is present, false otherwise
	 */	
	public boolean isOnRight(String s) {
		
		Set<String> ss = m_right.getVariables();
		
		return ss.contains(s);
	}
	
	/** Getter for the right-side expression
	 * 
	 * @return The right-side expression 
	 */
	public ExpressionSubBlock  getExpressionLeft() {
		
		return m_left;
	}
	
	/** Getter for the right-side expression
	 * 
	 * @return The right-side expression 
	 */
	public ExpressionSubBlock  getExpressionRight() {
		
		return m_right;
	}
	
	/** Getter for the very very variable that is assiged
	 * 
	 * @return A set of variables in string form
	 */
	public String getAssignedVariable() {
		
		if(m_left.isIdentifier())
			return m_left.getIdentifier();
		else
			return "Error, is not an assignment";
		
	}
	
	
	/** Getter for all the variables present on the right hand side of this assignment
	 * 
	 * @return A set of variables in string form
	 */
	public Set<String> getVariablesLeft() {
		
		return m_left.getVariables();
	}
	
	/** Getter for all the variables present on the right hand side of this assignment
	 * 
	 * @return A set of variables in string form
	 */
	public Set<String> getVariablesRight() {
		
		return m_right.getVariables();
	}
	
	/** Creates a string representation of the expression on the right hand side. uses recursion.
	 * 
	 * @return A set of variables in string form
	 */
	public String rightToString() {
		
		return m_right.toString();
	}
	
	@Override
	public String toString() {
				
		return ( m_left + " := " + m_right.toString() );
	}
	
	@Override
	public boolean involvesArray (){		
		
		return m_left.involvesArray() || m_right.involvesArray() ;
				
	}


	@Override
	public boolean isAssignmentBlock() {
		return true;
	}
	
	

}
