import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args){
		LinkedBlockingQueue<String> queue= new LinkedBlockingQueue<String>(100);
		
		Producer producer = new Producer(queue, 1);
		
		Consumer consumer1 = new Consumer(queue, 1);
		Consumer consumer2 = new Consumer(queue, 2);
		Consumer consumer3 = new Consumer(queue, 3);
		Consumer consumer4 = new Consumer(queue, 4);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(producer);
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.execute(consumer3);
		executor.execute(consumer4);
		
		executor.shutdown();
		}
	}

