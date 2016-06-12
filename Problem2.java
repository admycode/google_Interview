//Given the number of parenthesis pairs, print all possible combination of Balanced Paranthesis
//Suppose no. of parenthesis pairs = 3
//Possible combinations of Balanced Parenthesis are:
//{}{}{} | {}{{}} | {{}}{} | {{}{}} | {{{}}}

public class Problem2{

	static char[] str;

	//pos -> current position to write
	//n -> number of pairs in question
	//open -> number of opening parenthesis
	//close -> number of closing parenthesis
	static void printAll(int pos, int n, int open, int close){

		if(close == n){
			System.out.println(str);
		}
		else{
			if(open > close){
				str[pos] = '}';
				printAll(pos+1, n, open, close+1);
			}
			if(open < n){
				str[pos] = '{';
				printAll(pos+1, n, open+1, close);
			}
		}
	}

	static void printParenthesis(int n){

		str = new char[1000];
		printAll(0,n,0,0);
	}

	public static void main(String[] args){

		int n = 3;
		System.out.println("Possible combinations are:");
		printParenthesis(n);
	}
}
