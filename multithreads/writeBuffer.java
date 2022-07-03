package multithreads;

import java.util.ArrayList;
import java.util.List;
public class writeBuffer<T> implements Runnable{

	private final buffer<T> sharedLocation;
	
	private List<T> vetor;

	public writeBuffer(buffer<T> sharedLocation, List<T> vetorList) {
		this.sharedLocation = sharedLocation;
		this.vetor = new ArrayList<T>();
		this.vetor.addAll(vetorList);
	}
	public void run() {
		
		for (T element: vetor) {
			try {
				Thread.sleep(1000);
				sharedLocation.putBuffer(element);
				
				System.out.printf("\t%s\n",element);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.println("Escrita do buffer realizada!\n");
	}
}
