import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	private LinkedBlockingQueue<String> queue;
	public static boolean finished=false;
	private final int _consumer;
	private int _counter = 0;
	
	public Consumer(LinkedBlockingQueue<String> queue, int consumer) {
		this._consumer=consumer;
		this.queue=queue;
	}
	public void  summary() {
		System.out.println("\"Consumer "+_consumer+"\""+": "+"consumes "+_counter+" events.");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count=0;
		String current = "";

		while(finished==false){
			try {
				finished = Producer.finished();
				current=queue.poll(10, TimeUnit.MILLISECONDS);
				
				if(current!=null){
					long delay = (long)(Math.random()*10);
					Thread.sleep(delay);
					count++;
					_counter++;
					
				if(count%100==0){
					System.out.println("\"Consumer "+_consumer+"\""+": "+count+" events consumed");
					}
				}
			}catch (InterruptedException e) {
				System.out.println("error: " + e);
				}
		}
		while(queue.isEmpty()==false){
			if(count%100==0){
				System.out.println("\"Consumer "+_consumer+"\""+": "+count+" events consumed");
			}
			try{
				_counter++;
				current=queue.poll();
				long delay = (long)(Math.random()*10);
				Thread.sleep(delay);
				count++;
			}catch (InterruptedException e) {
				System.out.println("error: " + e);
				}
			}	
		this.summary();
	}

}