package exception;
/**
 * 
 * 当起点向目标移动，但是不能3消异常
 *
 */
public class NoSpoilageException extends RuntimeException {
	
	private static final long serialVersionUID = 3129338536664414593L;
	
	public NoSpoilageException(String message) {
		super(message);
	}
}
