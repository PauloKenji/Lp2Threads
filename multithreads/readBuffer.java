package multithreads;

import java.lang.reflect.ParameterizedType;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class readBuffer<R> implements Runnable{

	private static final SecureRandom 
	generator = new SecureRandom();
	
	private final buffer<R> sharedLocation;	
	private int size;
	private R element;

	public readBuffer(buffer<R> sharedLocation, int size ) {
		this.sharedLocation = sharedLocation;
		this.size = size;
	}
	public void run() {
		
		Vector<R> list = new Vector<>();
		for (int count =1;count <=size;count ++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				element = sharedLocation.getBuffer();

				list.add(element);

				System.out.printf("\t\t\t%s%n",list);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %s %n%s%n",
				"Leitura do total de valores: ",list.toString(), "Leitura finalizada!");		
		
	}

}