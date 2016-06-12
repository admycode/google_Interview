public class Problem1{

	

	static void print_nonoverlapping(int[] A, int h, String str){
			
			if(-1 == h)
				System.out.println("(" + str + ")");
			else{
				if(h == A.length-1){
					String str1 = String.valueOf(A[h]);
					print_nonoverlapping(A, h-1,str1);
				}
				else{
					String str1 = String.valueOf(A[h]) + str;
					print_nonoverlapping(A,h-1,str1);
					String str2 = String.valueOf(A[h]) + ")(" + str;
					print_nonoverlapping(A,h-1,str2);
				}
			}

	}

	public static void main(String[] args){
	
		int[] A = {1,2,3,4};

		int n = A.length;

		String result = "";

		print_nonoverlapping(A, n-1, result);
	}
}
