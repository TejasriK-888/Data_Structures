import java.util.Stack;
public class infixtopostfix
{
    int prec(char c){
        if (c == '^'){
            return 3;
        }
        else if (c=='/'||c=='*'){
            return 2;
        }
        else if (c=='+'||c=='-'){
            return 1;
        }
        else{
            return -1;
        }
    }
    
    void intopost(String s){
        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
                res.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(st.peek()!='('){
                    res.append(st.pop());
                }
                System.out.println(st);
                System.out.println("hai");
                st.pop();
                System.out.println(st);
            }
            else {
                while(!st.isEmpty() && prec(c) <= prec(st.peek())){
                    res.append(st.pop());
                }
                st.push(c);
            }
            
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        System.out.println(res.toString());
    }
    
	public static void main(String[] args) {
		Mainfixtopostfix m=new infixtopostfix();
		String exp="a+b*(c^d-e)^(f+g*h)-i";
		m.intopost(exp);
	}
}