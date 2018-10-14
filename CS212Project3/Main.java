import java.util.Random;
import java.util.ArrayList;

public class Main {
	private static double NextDouble() {
		Random random = new Random();
	return random.nextDouble();}

	private static double calculateSum(ArrayList<Measurable> mlist) {
		double sum = 0;
		for(int i=0; i < mlist.size();++i){
			sum += mlist.get(i).getArea();}
	return sum;}
	
	public static void main(String[] args) {
		ArrayList<Measurable> mlist = new ArrayList<Measurable>();
		final int length = 1000;
		int reccount=0;
		int boxcount=0;
		int ccount=0;
		int scount=0;
		
		for (int i=0;i < length;++i){
			int result = new Random().nextInt(5-1)+1;
			if (result==1){
				mlist.add(new Rectangle(NextDouble(),NextDouble()));
				reccount+=1;}
			else if(result==2){
				mlist.add(new Box(NextDouble(),NextDouble(),NextDouble()));
				boxcount+=1;}
			else if(result==3) {
				mlist.add(new Circle(NextDouble()));
				ccount+=1;}
			else if(result==4) {
				mlist.add(new Sphere(NextDouble()));
				scount+=1;}}
		
	System.out.println("rects: "+reccount+" boxes: "+ boxcount+ " circles: "+ccount+ " spheres: "+ scount);
	System.out.println("sum: "+calculateSum(mlist));
	

	}
}
