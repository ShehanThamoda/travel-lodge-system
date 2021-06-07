package lk.wiley.travellodge.exception;

public class SqlDataException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SqlDataException(String message) {
        super(message);
    }

    public SqlDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
