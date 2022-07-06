package multithreads;

public class unsysnchronizedBuffer<E> implements buffer<E> {
	private E buffer;
	
	public void putBuffer(E value) 
			throws InterruptedException{
		System.out.printf("Escrevendo valor: \t %s", value);
		buffer = value;
	}
	public E getBuffer() throws InterruptedException{
		System.out.printf("Leitura valor: \t\t %s", buffer);
		return buffer;
	}
}
