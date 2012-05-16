package blockRepresentation;

import org.antlr.runtime.tree.CommonTree;

public class DeclarationBlock extends IBlock {
	

	private String m_identifier;
	private int m_size;

	
	public DeclarationBlock(CommonTree t){
		
		if (t.getChildCount() == 1)
		{
			m_identifier = t.getChild(0).getText();	
			m_size = 0;
		}
		if (t.getChildCount() == 2)
		{
			m_identifier = t.getChild(0).getText();			
			m_size = Integer.parseInt(t.getChild(1).getText());
		}
		else
		{
			/**@todo Throw exception*/
		}
			
		
	}

	@Override
	public String toString() {

		String result = "";
		
		result += "int " + m_identifier; 
		
		if(m_size != 0 )
			result += " [" + m_size + "]";
				
		return result ;
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
	

	
	
	/** Getter for the varaible
	 * 
	 * @return The variable involved
	 */
	public String getVariable(){
		return m_identifier ;
	}

	/** Getter for the size (in case is array it will be > 0)
	 * 
	 * @return 0 in case is a simple variable, an integer > 0 otherwise
	 */
	public int getSize(){
		return m_size;
	}
	
	/** Checks if the variable is an array
	 * 
	 * @return false in case is a simple variable, true otherwise
	 */
	public boolean isArray(){
		return ( m_size != 0 );
	}

	@Override
	public boolean isDeclarationBlock() {
		return true;
	}
	
}
