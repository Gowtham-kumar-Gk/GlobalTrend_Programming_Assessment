package strings;
import java.util.Locale;
import java.util.Scanner;
public class Palindrom
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(palindrom(sc.nextLine()));
    }
    public static boolean palindrom(String s)
    {
        s = s.toLowerCase();
        String t = "";
        String rev= "";
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            {
                t = t + s.charAt(i);
                rev = s.charAt(i) + rev;
            }
        }
        return t.equals(rev);
    }
}
