import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class OccurrenceSet<T> implements Set<T> {
	
	HashMap<T, Integer> oMap = new HashMap<T, Integer>();
	
	public String toString() {
		ArrayList<T> stringlist = new ArrayList<T>();
		Iterator <T> iter = iterator();
		String str;
		while (iter.hasNext()==true) {
			T nextval = iter.next();
			stringlist.add(nextval);}
		str = stringlist.toString();
	return str;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return oMap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return oMap.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return oMap.containsKey(o);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		ArrayList<T> Sarray = new ArrayList<T>();
		Set<Map.Entry<T, Integer>>input = oMap.entrySet();
		ArrayList<Map.Entry<T, Integer>> toSort = new ArrayList<Map.Entry<T, Integer>>(input);
		
		Collections.sort(toSort, new Comparator<Map.Entry<T, Integer>>() {
			public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}});
		
		for(Map.Entry<T, Integer> key : toSort){
			Sarray.add(key.getKey());}
		return Sarray.iterator();}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		ArrayList<T> sArray = new ArrayList<T>();
		Iterator<T> iter = iterator();
		
		while(iter.hasNext()==true){
			sArray.add(iter.next());}
		return sArray.toArray();
	}
	@Override
	public <S> S[] toArray(S[] a) {
		// TODO Auto-generated method stub
		ArrayList<T> sArray = new ArrayList<T>();
		Iterator<T> iter = iterator();
		
		while(iter.hasNext()==true){
			sArray.add(iter.next());}
		return sArray.toArray(a);}
	
	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		int count = 1;
		if(oMap.containsKey(e)==true){
			count = oMap.get(e) + 1;}
		return oMap.put(e,count) == null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return oMap.remove(o, oMap.get(o));}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean outcome = false;
		
		for (Object t: c) {
			outcome = contains(t);}
		return outcome;}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		boolean outcome = false;
		for (T t: c) {
			outcome = add(t);}
		return outcome;}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean outcome = false;
		for (Object t: c) {
			if(c.contains(oMap.get(t))==false){
				outcome = remove(t);
		}}
		return outcome;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean outcome = false;
		for (Object t: c) {
			outcome = remove(t);
		}
		return outcome;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		oMap.clear();
	}
}
