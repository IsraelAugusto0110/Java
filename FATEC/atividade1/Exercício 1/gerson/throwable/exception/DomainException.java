package gerson.throwable.exception;

public class DomainException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DomainException (String m) {
		super(m);
	}
}
