package blockRepresentation;

import org.antlr.runtime.tree.CommonTree;

/**Almost empty class
 * 
 * @author Francesco
 *
 */

public class SkipBlock extends IBlock {
	
	public SkipBlock(CommonTree t){}	
	
	@Override
	public String toString() {
		return "skip";
	}

	@Override
	public boolean isSkipBlock() {
		return true;
	}
	
	

}
