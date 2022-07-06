package multithreads;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class writeBuffer<T> implements Runnable{

	private static final SecureRandom 
	generator = new SecureRandom();

	private final buffer<T> sharedLocation;
	
	private List<T> vetor;

	public writeBuffer(buffer<T> sharedLocation, List<T> vetorList) {
		this.sharedLocation = sharedLocation;
		this.vetor = new ArrayList<T>();
		this.vetor.addAll(vetorList);
	}
	public void run() {
		Vector<T> list = new Vector<>();
		for (T element: vetor) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBuffer(element);
				list.add(element);
				System.out.printf("\t%s\n",list);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.println("Escrita do buffer realizada!\n");
	}
}
