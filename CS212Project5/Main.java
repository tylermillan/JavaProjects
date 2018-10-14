import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
	public static ArrayList<PBentries> readfile() {
		ArrayList<PBentries> phonebook = new ArrayList<PBentries>();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("phonebook_test.txt"));
		    String linetxt;
		    while ((linetxt = in.readLine()) != null) {
		    		String[] words=linetxt.split("\\s|,\\s");
		    		phonebook.add(new PBentries(words[0],words[1],words[2])) ;}
		    in.close();
		} catch (IOException e) {
		}
		return phonebook;
	}
	
	public static void PBsearch(ArrayList<PBentries> phonebook, String search){
		ArrayList<PBentries> matchlist = new ArrayList<PBentries>();
		
		for (int i=0; i<phonebook.size(); ++i) {
			if(phonebook.get(i).getfirstName().contains(search)|| phonebook.get(i).getlastName().contains(search) ) {
				matchlist.add(phonebook.get(i));
			}
		}
		try{
			FileWriter fw= new FileWriter("Output.txt", false );
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);

			for(int i=0; i < matchlist.size();++i){
				pw.println(matchlist.get(i).getentry());}
			bw.flush();
			pw.close( );
		}catch (IOException e){
			System.out.println( "Text errors" );
			}
	}
	
	public static boolean checkIfSorted(ArrayList<PBentries> phonebook) {
	    boolean sorted = true;        
	    for (int i=1; i < phonebook.size(); ++i) {
	        if (phonebook.get(i-1).getlastName().compareTo(phonebook.get(i).getlastName()) > 0) { 
	        		sorted = false;}
	        }
	    return sorted;
	}
	 public static ArrayList<PBentries> sSortLastName(ArrayList<PBentries> phonebook) {
		 ArrayList<PBentries> ssortedphonebook = new ArrayList<PBentries>(phonebook);
		 for (int i = 0; i < ssortedphonebook.size(); ++i) {
			 int position = i;
	         for (int j = i; j < ssortedphonebook.size(); ++j) {
	        	 	if (ssortedphonebook.get(j).getlastName().compareTo(ssortedphonebook.get(position).getlastName())<0) {
	        	 		position = j;
	        	 		}
	            }
	          PBentries min = ssortedphonebook.get(position);
	          ssortedphonebook.set(position, ssortedphonebook.get(i));
	          ssortedphonebook.set(i, min);
	          }
	 return ssortedphonebook;
	 }
	 public static ArrayList<PBentries> mSortLastName(ArrayList<PBentries> phonebook) {
			int middle;
			ArrayList<PBentries> msortedphonebook = new ArrayList<PBentries>(phonebook);
			ArrayList<PBentries> left = new ArrayList<PBentries>();
			ArrayList<PBentries> right = new ArrayList<PBentries>();
			
			if (msortedphonebook.size() == 1) {    
				return msortedphonebook;
			} else {
			    	middle = msortedphonebook.size()/2;
			for (int i=0; i<middle; i++) {
			    left.add(msortedphonebook.get(i));
			}
			 
			for (int i=middle; i<msortedphonebook.size(); i++) {
				right.add(msortedphonebook.get(i));}

			left  = mSortLastName(left);
			right = mSortLastName(right);
			 
			 merge(left, right, msortedphonebook);
			    }
			return msortedphonebook;
			}
		
	 public static void merge(ArrayList<PBentries> left, ArrayList<PBentries> right, ArrayList<PBentries> msortedphonebook) {
		    int leftIndex = 0;
		    int rightIndex = 0;
		    int wholeIndex = 0;
		 
		     while (leftIndex < left.size() && rightIndex < right.size()) {
		    	 	if ( (left.get(leftIndex).getlastName().compareTo(right.get(rightIndex).getlastName())) < 0) {
		    	 		msortedphonebook.set(wholeIndex, left.get(leftIndex));
		    	 		leftIndex+=1;
		    	 	} else {
		    	 		msortedphonebook.set(wholeIndex, right.get(rightIndex));
		            rightIndex+=1;
		        }
		            wholeIndex+=1;
		        }
		 
		        ArrayList<PBentries> rem;
		        int remIndex;
		        if (leftIndex >= left.size()) {
		            rem = right;
		            remIndex = rightIndex;
		        } else {
		            rem = left;
		            remIndex = leftIndex;
		        }
		 
		      for (int i=remIndex; i<rem.size(); i++) {
		        	msortedphonebook.set(wholeIndex, rem.get(i));
		        	wholeIndex+=1;
		        }
		 }

	public static void runBoth() {
		ArrayList<PBentries> phonebook = readfile();
		final long fstartTime = System.nanoTime();
		sSortLastName(phonebook);
		final long fduration = System.nanoTime() - fstartTime;
		final double fseconds = ((double)fduration / 1000000000);
		System.out.println("Selection Sort: " + new DecimalFormat("#.###").format(fseconds));
		final long startTime = System.nanoTime();
		mSortLastName(phonebook);
		final long duration = System.nanoTime() - startTime;
		final double seconds = ((double)duration / 1000000000);
		System.out.println("Merge Sort: " + new DecimalFormat("#.###").format(seconds));
	}
	public static void main(String[] args){
		runBoth();

}



}