package multithreads;

public class readBuffer<R> implements Runnable{

	private final buffer<R> sharedLocation;	
	private int size;
	private R sum;

	public readBuffer(buffer<R> sharedLocation, int size ) {
		this.sharedLocation = sharedLocation;
		this.size = size;
	}
	public void run() {
		
		for (int count =1;count <=size;count ++) {
			try {
				Thread.sleep(1100);
				sum = sharedLocation.getBuffer();
				System.out.printf("\t\t\t%s%n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %2d %n%s%n",
				"Leitura do total de valores: ",size, "Leitura finalizada!");
	}
}