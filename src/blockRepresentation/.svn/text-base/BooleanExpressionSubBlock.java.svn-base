package blockRepresentation;

import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;


public class BooleanExpressionSubBlock extends IBlock {
	
	// in case of 
	private String m_boolean_value ;
	private BooleanExpressionSubBlock m_bool_expr_left ;
	private BooleanExpressionSubBlock m_bool_expr_right ;
	
	// in case of negated expression
	private BooleanExpressionSubBlock m_neg_expression ;
	
	// in case expression and operator
	private ExpressionSubBlock m_expression_left;
	private ExpressionSubBlock m_expression_right;
	
	private String m_operator;
	
	/** This variable encapsulates the type of this object from the bexpr syntactical category. 
	 * (The option of 4 sub-classes seemed a bit overkill)
	 * The encoding :
	 * 0 = OR_AND
	 * 1 = boolean
	 * 2 = Negation
	 * 3 = Double expression
	 */	
	private int m_type = 0 ; // 0 = OR_AND // 1 = boolean // 2 
	
	public BooleanExpressionSubBlock(CommonTree t){
		
		if ( t.getChildCount() >= 0 ) {
			
			switch ( t.getType() ){
			// bexpr and bexpr1 - cases ( x || y ) , and , ( x && y )
			case 31: 
			case 4: 
				m_type = 0;
				m_operator = t.getText();
				m_bool_expr_left = new BooleanExpressionSubBlock((CommonTree) t.getChild(0)) ;
				m_bool_expr_right = new BooleanExpressionSubBlock((CommonTree) t.getChild(1)) ;
				break;
			//bexpr2 - case true and false
			case 41: 
			case 12: 
				m_type = 1;
				m_boolean_value = t.getChild(0).getText() ;
				break;
			//bexpr2 - case not - ( ! (x > 4) )
			case 29: 
				m_type = 2;
				m_neg_expression = new BooleanExpressionSubBlock((CommonTree) t.getChild(0)) ;
				break;
			case 14: 
			case 15: 
			case 25: 
			case 22: 
			case 11: 
			case 28: 
				
				m_type = 3;
				m_operator = t.getText();
				m_expression_left = new ExpressionSubBlock((CommonTree) t.getChild(0)) ;
				m_expression_right = new ExpressionSubBlock((CommonTree) t.getChild(1)) ;
				break;
				
			}
					
		}
		else
		{	
			/**@todo throw exception, empty guard*/
		}
		
	}
	
	public String getVariableLeft(){
		
		switch ( m_type ){
				
		case 3 :
			return ( m_expression_left.toString()  ) ;
		
		default:
			return "Not Expression";
	
		}
	}
	
	public Set<String> getVariablesLeft(){
		
		Set<String> s = new HashSet<String>();
		
		switch ( m_type ){
				
		case 3 :
			return ( m_expression_right.getVariables() ) ;
		
		default:
			return s;
	
		}
	}
	

	public Set<String> getVariablesRight(){
		
		Set<String> s = new HashSet<String>();
		
		switch ( m_type ){
				
		case 3 :
			return ( m_expression_right.getVariables() ) ;
		
		default:
			return s;
	
		}
	}
	
	@Override
	public String toString() {
	
		switch ( m_type ){
		
		case 0 :
			return ( m_bool_expr_left.toString() + " " + m_operator + " " + m_bool_expr_right.toString()  );
						
		case 1 :
			return this.m_boolean_value;
						
		case 2 : 
			return ( "-" + this.m_neg_expression ) ;
						
		case 3 :
			return ( m_expression_left + " " + m_operator + " " + m_expression_right.toString() ) ;
		
		default:
			return "error";
	
		}
		
	}
	
	@Override
	public boolean involvesArray (){
		
		switch ( m_type ){
		
		case 0 :
			return m_bool_expr_left.involvesArray() || m_bool_expr_right.involvesArray() ;
						
		case 1 :
			return false;
						
		case 2 : 
			return m_neg_expression.involvesArray() ;
						
		case 3 :
			return m_expression_left.involvesArray() ||  m_expression_right.involvesArray() ;
		
		default:
			return false;
	
		}
		
	}

	@Override
	public boolean isGuardBlock() {
		return true;
	}

	
	
}
