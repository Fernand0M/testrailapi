package keywords;

public class CaseFailedException extends RuntimeException {

	private static final long serialVersionUID = -6000935821598126444L;

	public CaseFailedException(String message) {
		super(message);
	}

	public CaseFailedException(Throwable cause) {
		super(cause);
	}

	public CaseFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}
