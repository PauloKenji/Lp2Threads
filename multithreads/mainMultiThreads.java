/*
 Paulo Kenji - SP3045382
 Ryan Salomão - SP3044521
 Thiago César - SP3044823
 Henrique Baesa - SP3045048
 Yoane Miyamura - SP3046117
 Isabelle Gomes - SP3045374
*/

package multithreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class mainMultiThreads {

	public static void main(String[] args) 
			throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService  threadRun = Executors.newCachedThreadPool();
		buffer<String> sharedLocationString = new unsysnchronizedBuffer<String>();

		List<String> vetorString = new ArrayList<>(Arrays.asList("ab","cd","ef","gh","ij","kl"));
		
		System.out.printf("Thread running\t\tValue\t "+ "Sum write\tSum read\n");
		System.out.println("-------------------------------------------------------------------");
		threadRun.execute(new writeBuffer<String>(sharedLocationString,vetorString));
		threadRun.execute(new readBuffer<String>(sharedLocationString,vetorString.size()));
		
		threadRun.awaitTermination(vetorString.size()*3, 	TimeUnit.SECONDS);		
		
		buffer<Integer> sharedLocationInt = new unsysnchronizedBuffer<Integer>();

		List<Integer> vetorInteger = new ArrayList<>(Arrays.asList(10,15,20,30,90));
		
		System.out.printf("Thread running\t\tValue\t "+ "Sum write\tSum read\n");
		System.out.println("-------------------------------------------------------------------");
		threadRun.execute(new writeBuffer<Integer>(sharedLocationInt,vetorInteger));
		threadRun.execute(new readBuffer<Integer>(sharedLocationInt,vetorInteger.size()));
		
		threadRun.awaitTermination(vetorInteger.size()*3, TimeUnit.SECONDS);	

		buffer<Float> sharedLocationFloat = new unsysnchronizedBuffer<Float>();

		List<Float> vetorFloat = new ArrayList<>(Arrays.asList(1.1f,2.5f,3.5f,10.6f,10.200f));
		
		System.out.printf("Thread running\t\tValue\t "+ "Sum write\tSum read\n");
		System.out.println("-------------------------------------------------------------------");
		threadRun.execute(new writeBuffer<Float>(sharedLocationFloat,vetorFloat));
		threadRun.execute(new readBuffer<Float>(sharedLocationFloat,vetorFloat.size()));
		threadRun.shutdown();
		threadRun.awaitTermination(vetorFloat.size()*3, TimeUnit.SECONDS);	
		
		
	}
}
