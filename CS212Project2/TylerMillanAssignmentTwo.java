import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class TylerMillanAssignmentTwo{
	public static int[] CreateDenseArray(int length, double density) {
		int[] densearray = new int[length];
		Random random = new Random();
		for (int i=0; length > i; ++i) 
			if (density >= random.nextDouble())
				densearray[i] = random.nextInt(1000000) + 1;
			else 
				densearray[i] = 0;	
	return densearray;}
	
	
	public static ArrayList<int[]> CreateSparseArray(int length, double density) {
		ArrayList<int[]> sparsearray = new ArrayList<>();
		Random random = new Random();
		
		for (int i=0; length > i; ++i) {
			if (density >= random.nextDouble()) {
				int[] innerarray = new int[2];
				innerarray[0]=i;
				innerarray[1]=random.nextInt(1000000) + 1;
				sparsearray.add(innerarray);}}
		
	return sparsearray;}

	
	 public static ArrayList<int[]> DenseToSparse(int[] darray) {
		ArrayList<int[]> newsarray = new ArrayList<>();
		
		for (int i=0; darray.length > i; ++i) {
			if (darray[i]!=0){
				int[] newinnerarray = new int[2];
				newinnerarray[0]=i;
				newinnerarray[1]=darray[i];
				newsarray.add(newinnerarray);}}
	return newsarray;}
	 
	
	public static int[] SparseToDense(ArrayList<int[]> sarray, int length){
		int[] newdarray = new int[length];
		
		for (int i=0; length > i; ++i)
			try {
				newdarray[i]=sarray.get(i)[1];}
			catch (Exception e) {
				newdarray[i] = 0;}
	
	return newdarray;}

	 
	public static int DenseMax(int[] darray) {
		int maxamount = darray[0];
		int maxlocation = 0;
		
		for (int i=0; i < darray.length; ++i) 
			if (darray[i] > maxamount) {
				maxlocation = i+1;
				maxamount = darray[i];}
		System.out.println("find max (dense): "+maxamount+" at location: "+maxlocation);
	return maxamount;}

	
	public static int SparseMax(ArrayList<int[]> sarray) {
		int maxamount = 0;
		int maxlocation = 0;
		
		for (int i=0; i<sarray.size(); ++i) 
			if (sarray.get(i)[1] > maxamount) {
				maxlocation = sarray.get(i)[0];
				maxamount = sarray.get(i)[1];}
		System.out.println("find max (sparse): "+maxamount+" at location: "+maxlocation);
	return maxamount;}

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			
		boolean running = true;
			
		while (running){
			System.out.println("Please enter array length:");
			int arraylength = scan.nextInt();
			System.out.println("Please enter array density:");
			double arraydensity = scan.nextDouble();
			
			if ((arraylength<0) || (arraydensity < 0.0 || arraydensity > 1.0 )) {
				System.out.println("Please enter a valid value!");
				System.out.println();
			}else {
				long InitialTime = System.nanoTime();
				int[] darray = CreateDenseArray(arraylength,arraydensity);
				System.out.println("create dense length: "+arraylength+ " time: "+((System.nanoTime() - InitialTime) /1000000D ));
				
				InitialTime = System.nanoTime();
				ArrayList<int[]> s = DenseToSparse(darray);
				System.out.println("convert to sparse length: "+s.size()+ " time: "+((System.nanoTime() - InitialTime) /1000000D ));
			
			    InitialTime = System.nanoTime();
				ArrayList<int[]> sarray = CreateSparseArray(arraylength,arraydensity);
				System.out.println("create sparse length: "+sarray.size()+ " time: "+((System.nanoTime() - InitialTime) /1000000D ));
				
				InitialTime = System.nanoTime();
				SparseToDense(sarray,arraylength);
				System.out.println("convert to dense length: "+arraylength+ " time: "+((System.nanoTime() - InitialTime) /1000000D ));
				
				InitialTime = System.nanoTime();
				DenseMax(darray);
				System.out.println("dense find time: "+((System.nanoTime() - InitialTime) /1000000D ));
				
				InitialTime = System.nanoTime();
				SparseMax(sarray);
				System.out.println("sparse find time: "+((System.nanoTime() - InitialTime) /1000000D ));
				
				running = false;}
		}
	/*
	 * For testing to compare the speed of both dense and sparse functions, I performed six total tests. Half of the tests were conducted using an array size of 100, while the other half were conducted using an array size of 100,000. I experimented with both array sizes with varying density's, .001,.5, and .9. The conclusion of these results was that creating a sparse length array is consistently faster for all created lengths that were size 100. Finding the max value for all array lengths of size 100 were very similar for all densities using both the sparse and dense array. In all observations, converting from a dense to a sparse is consistently faster then converting a sparse array to a dense array. For the array lengths of size 100,000, with the medium and high density observations, creating the dense array was faster, but the low density experiment had the sparse array being faster.Finding the sparse max of the low density 100,000 experiment was faster, but for the medium and high density observation, the dense max was found faster. 
	*/
	}
}
