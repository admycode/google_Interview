import java.util.*;


public class Problem3{

private static HashSet<HashSet<Integer>> allSubsets;	

public static void enumerateSubsets(HashSet<Integer> S, HashSet<Integer> cand, int targetsum){
	
	//System.out.println("S: " + S);
	//System.out.println("cand: " + cand);
	//System.out.println("targetsum: " +targetsum);
	//System.out.println();
	if((cand.size() == 0) && (targetsum == 0)){
		allSubsets.add(S);
		return;
	}
	
	Iterator<Integer> it = cand.iterator();
	
	while(it.hasNext()){
		int x = it.next();
		if(x <= targetsum){
			HashSet<Integer> S1 = new HashSet<Integer>(S);
			S1.add(x);
			int tsum = targetsum - x;
			HashSet<Integer> cand1 = new HashSet<Integer>();
			cand1.addAll(cand);
			cand1.remove(x);
			enumerateSubsets(S1, cand1, tsum);
			it.remove();
		} else{
			HashSet<Integer> cand1 = new HashSet<Integer>();
			cand1.addAll(cand);
			cand1.remove(x);
			enumerateSubsets(S, cand1, targetsum);
			it.remove();
		}
	}

}

public static void populateSubsets(int[] array, int targetsum){
	HashSet<Integer> S = new HashSet<Integer>();

	HashSet<Integer> cand = new HashSet<Integer>();

	for(int x : array){
	
		cand.add(x);
	}
	
	enumerateSubsets(S, cand, targetsum);

	for(HashSet<Integer> s : allSubsets){
		System.out.println(s);
	}
}

public static void main(String[] args){
	
	allSubsets = new HashSet<HashSet<Integer>>();

	int[] array = {1,3,4,5,6,15};
	populateSubsets(array, 15);

}



}
