package exception;
/**
 * 
 * 当起点向目标移动，目标跟起点不是相邻时异常
 *
 */
public class NearCellException extends RuntimeException {
 
	private static final long serialVersionUID = -5973332015600566849L;
 
	public NearCellException(String message){
		super(message);
	}
	
}
