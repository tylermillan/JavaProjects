import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
	private final LinkedBlockingQueue<String> queue;
	private static boolean _finished = false;
	private final int _producer;
	private static final int max_count = 1000;
	private int _counter = 0;
	
	public Producer(LinkedBlockingQueue<String> queue, int producer){
		this.queue=queue;
		this._producer=producer;
	}
	
	public static boolean finished() {
		return _finished;
	}
	
	public void  summary() {
		System.out.println("\"Producer "+_producer+"\""+": "+"produces "+_counter+" events.");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		for (int i=0; i<max_count;++i ) {
			if(i % 100 == 0 & i !=0){
				System.out.println("\"Producer "+_producer+"\""+": "+i+" events produced");
			}
			try{
				double x =  random.nextDouble();
				queue.put(Double.toString(x));
				++_counter;
			} catch(InterruptedException e){
				System.out.println("error: " + e);
				}
			}
			System.out.println("\"Producer "+_producer+"\""+": "+_counter+" events produced");
			_finished = true;
			System.out.println("Summary: ");
			this.summary();
	}
}
