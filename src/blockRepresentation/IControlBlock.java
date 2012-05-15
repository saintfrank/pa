package blockRepresentation;

import java.util.Set;

/** This Class is to keep what while and if blocks have in common as control blocks
 * 
 * @author Francesco
 *
 */
public interface IControlBlock  {

	
	/** Returns the set of blocks that are in this block. It includes also inner sub-stacks blocks in case of inner while or if. 
	 * @returns The set of inner blocks
	 */
	public Set<IBlock> getInnerBlocks();

	public BooleanExpressionSubBlock getGuard();
	
	

}
