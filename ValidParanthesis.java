package Stack;
import java.util.*;
public class ValidParanthesis
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        String s = sc.next();
        int n = s.length();
        if(n <= 1 || n % 2 == 1)
        {
            System.out.println("Invalid Parantesis");
            return;
        }
        int i = 0;
        for(i = 0; i< s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(')
            {
                st.push(ch);
            }
            else if(!st.isEmpty())
            {
                if(ch == ')' && st.pop() != '(')
                    break;
                if(ch == '}' && st.pop() != '{')
                    break;
                if(ch == ']' && st.pop() != '[')
                    break;
            }
            else
                break;
        }
        if(st.isEmpty() && i == s.length())
        {
            System.out.println("Valid Paranthesis");
        }
        else
            System.out.println("Invalid Paranthesis");

    }
}
