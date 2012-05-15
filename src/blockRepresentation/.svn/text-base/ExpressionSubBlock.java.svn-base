package blockRepresentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;


/**
 * @author Francesco
 * 
 * This class represent an expression in the program input tree.
 * Massive use of recursion is uden in this data representation.
 * 
 * An object ExpressionSubBlock can be of tree different types:
 * - "identifier" : eg. [ x ], or [ A[10] ]
 * - "constant" : eg. [ 4 ], or [ -4 ]
 *  - "recursiveExpression" : eg. [ x + 2 ] or [ x + ( ( 4 + 5 ) * 6 ) ]
 *
 */
public class ExpressionSubBlock extends IBlock {
	
	/** Possible type values :
	 *  - "identifier" : eg. [ x ], or [ A[10] ]
	 *  - "constant" : eg. [ 4 ], or [ -4 ]
	 *  - "recursiveExpression" : eg. [ x + 2 ] or [ x + ( ( 4 + 5 ) * 6 ) ]
	 */
	private String m_type;
	
	// Identifier related variables
	private String 				m_identifier			;
	private boolean 			m_identifier_is_array	;
	private ExpressionSubBlock  m_identifier_index		;
	
	// Negation related variables
	private ExpressionSubBlock  m_negated_expression	;
	private boolean				m_is_negated			;
	
	private int m_constant;
	
	// RecursiveExpression related variables
	private String m_operator;
	private ExpressionSubBlock m_l_operand;
	private ExpressionSubBlock m_r_operand;
	
	 
	/** Constructor
	 * @param t the tree to start
	 */
	public ExpressionSubBlock(CommonTree t){
		
		// initialization
		m_identifier_is_array = false;
		m_is_negated		  = false;
		
		switch(t.getType())
		{
		case 16:
			m_identifier = t.getText();
			m_type = "identifier";
			if( t.getChildCount() > 0) // then it is an array
			{
				m_identifier_is_array = true;
				
				m_identifier_index = new ExpressionSubBlock( (CommonTree) t.getChild(0) );
			}			
			break;			
		case 19:
				m_constant = Integer.parseInt(t.getText());
				m_type = "constant";
				break;
		default:
			if(t.getType() == 26 && t.getChildCount() == 1 )
			{
				m_negated_expression = new ExpressionSubBlock( (CommonTree) t.getChild(0) );
				m_is_negated = true;
				m_type = m_negated_expression.getType();
				break;
			}
			else if( t.getChildCount() == 2)
			{
				m_operator = t.getText();
				m_type = "expression";
				m_l_operand = new ExpressionSubBlock( ( CommonTree)  t.getChild(0) );
				m_r_operand = new ExpressionSubBlock(  (CommonTree)  t.getChild(1) );
			}else 
				System.out.println("ERROR : Unrecognized Expression Type : "+ t.getType() );
			
		
			break;
		}
		
		
	}
	

	/** Private Getter for the type
	 * 
	 */
	private String getType() {
		return m_type;
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

	//////////////
	////////////// The following function check the Expression type [ identifier, constant, recursiveExpression]
	//////////////
	
	
	/** Checks if the type is "identifier".  eg. "x" or "A[10]"
	 * @return true if the type is correct, false otherwise
	 */
	public boolean isIdentifier(){
		
		return ( this.m_type.equals("identifier") );
	}

	/** Checks if the type is "constant".  eg. "4" or "-4"
	 * @return true if the type is correct, false otherwise
	 */
	public boolean isConstant(){
		
		return ( this.m_type.equals("constant") );
	}
	
	/** Checks if the type is "expression".  eg. "x + (4 + Y[2])" or "(a*b) +2"
	 * @return true if the type is correct, false otherwise
	 */
	public boolean isRecursiveExpression(){
		
		return ( this.m_type.equals("expression") );
	}

	
	@Override
	public String toString() {

		if ( m_is_negated)
		{
			return " - " + m_negated_expression.toString();			
		}
				
		if( isIdentifier() )
		{
			if( m_identifier_is_array )
				{
					return m_identifier + " [ " + this.m_identifier_index + " ] " ;
				}
				else
				{
					return m_identifier ;
				}	
			
		}
		
		if( isConstant() )
			return ( new Integer(m_constant) ).toString();
			
			
		// Ii is surely and expression
		return m_l_operand.toString() + " " + m_operator + " " +  m_r_operand.toString() ;
			
	}
	
	/////////////
	///////////// Identifier type specific functions, with 
	/////////////
	
	/**This methods returns the string form of the identifier, in case this expression is of type "identifier", eg. x, or A 
	 * 
	 * @return the string form of the identifier in case this expression is of the type "identifier", the empty string otherwise
	 */
	public String getIdentifier(){
		
		if ( m_is_negated)
		{
			return " - " + m_negated_expression.getIdentifier();			
		}
		
		if(this.m_type== "identifier")
			return this.m_identifier;
		else
			return "ERROR: requested identifier on non-identifier expression";
	}	
	
	/**Returns the index expression for the array identifier
	 * 
	 * @return the index expression in case this expression is an array identifier
	 */
	public ExpressionSubBlock getIndex(){
		
		if ( m_is_negated)
		{
			return m_negated_expression.getIndex();			
		}
				
		if(this.m_identifier_is_array)
			return m_identifier_index;
		
		else return null;
	}

	/** Getter for the left-side expression. 
	 * @warning The method caller has to have checked that the expression is a constant
	 * 
	 * @return the value contained, -1000000 otherwise
	 */
	public int  getConstantValue() {
		
		if ( m_is_negated)
		{
			return m_negated_expression.getConstantValue();			
		}
		
		if( isConstant() )
		{
			return m_constant;			
		}	
		else 
			return -100000;
	}
	
	/** Getter for the left-side expression
	 * 
	 * @return The right-side expression 
	 */
	public ExpressionSubBlock  getExpressionLeft() {
			
		return m_l_operand;
		
	}
	
	/** Getter for the right-side expression
	 * 
	 * @return The right-side expression 
	 */
	public ExpressionSubBlock  getExpressionRight() {
		
		return m_r_operand;
	}
	
	/** Getter for the operator in case it is a RecursiveExpression
	 * 
	 * @return The right-side expression 
	 */
	public String  getOperator() {
		
		return m_operator;
	}
	
	
	
	////////////
	//////////// This function is inherited by IBlock , in this class is particularly important
	////////////
	

	@Override
	public boolean involvesArray (){
		
		if( m_is_negated )
			return m_negated_expression.involvesArray() ;		
				
		if( isIdentifier() )
			return m_identifier_is_array;
		
		if( isRecursiveExpression() )
		{
			return m_identifier_is_array || m_l_operand.involvesArray() ||  m_r_operand.involvesArray() ;
		}
				
		// default
		return false;
		
	}

	////////////
	//////////// Signs related functions
	////////////
	
	/** Checks if there is a negative value in the expression
	 * 
	 * @return true if there is a negative value in the expression, false otherwise 
	 */
	public boolean is_there_negative_inside() {

		if( m_is_negated )
			return true;
				
		if( isIdentifier() )
		{
			if( m_identifier_is_array )
			{
				return m_is_negated || m_identifier_index.is_there_negative_inside() ;
			}
			else
			{
				return m_is_negated ;
			}				
		}
		
		if( isConstant() )
			return false;
		
		// Ii is surely and expression
		return m_l_operand.is_there_negative_inside() || ( m_operator.equals("-") ) || m_r_operand.is_there_negative_inside() ;
			
	}

	/** Extracts the negated inner expressions form this expression. Every element of the ArrayList has to be considered negative as a whole
	 * 
	 * @return The ArrayList of the negated expressions
	 */
	public ArrayList<ExpressionSubBlock> get_negative_inside() {

		ArrayList<ExpressionSubBlock> arr = new ArrayList<ExpressionSubBlock>() ;		
		
		if( m_is_negated )
		{
			arr.add( this.m_negated_expression ) ;
			return arr ;
		}	
		
		if( isRecursiveExpression() )
		{
			
			ArrayList<ExpressionSubBlock> temp = this.m_l_operand.get_negative_inside() ;
			if ( temp != null )
				arr.addAll( temp );
			
			temp = this.m_r_operand.get_negative_inside() ;
			if ( temp != null )
				arr.addAll( temp );
			
			if( m_operator.equals("-") )
			{
				arr.add( this.m_r_operand );
			}
			
			return arr ;
		}
		
		// if is constant or identifier
		return arr;
	}

	/** Returns Checks if the expression is the negation of another expression
	 * 
	 * @return A Set of variables represented as string
	 */
	public boolean is_direct_negated(){
		
		return m_is_negated;
		
	}
	
	///////////
	///////////  Utility recursive functions : Variable getters and constant getters
	///////////
	
	/** Returns all the variable involved in this expressions, scanned recursively.
	 * 
	 * @return A Set of variables represented as string
	 */
	public Set<String> getVariables() {
		
		Set<String> result = new HashSet<String>() ;
		
		if( m_is_negated )
			return m_negated_expression.getVariables() ;		
		
		if( isIdentifier() )
			result.add(this.m_identifier);
		
		if( isRecursiveExpression() )
		{
			result.addAll( this.m_l_operand.getVariables() );
			result.addAll( this.m_r_operand.getVariables() );
		}
			
		return result;
	}
	
	/** Returns all the constants involved in this expressions, scanned recursively.
	 * 
	 * @return A Set of constants 
	 */
	public Set<Integer> getConstants() {
		
		HashSet<Integer> result = new HashSet<Integer>() ;
		
		if( m_is_negated )
			return m_negated_expression.getConstants() ;		
			
		if( isConstant() )
			result.add(this.m_constant);
				
		if( isRecursiveExpression() )
		{
			result.addAll( this.m_l_operand.getConstants() );
			result.addAll( this.m_r_operand.getConstants() );
		}
		
		return result;		
	}
	
	
	@Override
	public boolean isExpressionSubBlock() {
		return true;
	}

}
