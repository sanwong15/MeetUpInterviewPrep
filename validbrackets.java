import java.util.Stack;

public class validbrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "((()))";
		System.out.println("Is " + test+ " a valid statment?    " + check(test));
		
		String test1 = "{([<>])}";
		System.out.println("Is " + test1+ " a valid statment?    " + check(test1));
		
		String test2 = "((([[[[)))}}";
		System.out.println("Is " + test2+ " a valid statment?    " + check(test2));

	}
	
	public static boolean check(String s){
		int len = s.length();
		Stack<Character> st = new Stack<>();
		
		String caseString = "";
		for(int i=0; i<len; i++){
			char current = s.charAt(i);
			switch(current){
			case '(':
				st.push(current);
				break;
			case'[':
				st.push(current);
				break;
			case'{':
				st.push(current);
				break;
			case'<':
				st.push(current);
				break;
			case')':
				if (st.peek() == '('){
					st.pop();
				}else{
					return false;
				}
				break;
			case']':
				if (st.peek() == '['){
					st.pop();
				}else{
					return false;
				}
				break;
			case'}':
				if (st.peek() == '{'){
					st.pop();
				}else{
					return false;
				}
				break;
			case'>':
				if (st.peek() == '<'){
					st.pop();
				}else{
					return false;
				}
				break;
			
			}
		}
		
		if (st.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

}
