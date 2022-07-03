package multithreads;

public interface buffer<B> {
	public void putBuffer(B value) 
			throws InterruptedException;
	public B getBuffer() throws InterruptedException;
}
