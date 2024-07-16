package Test;
import java.util.*;
public class KthLargest
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> li = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            li.add(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(largest(li,k));
    }

    public static int largest(List<Integer> li, int n)
    {
        int x = (li.size() - n)+1;
        for(int i = 0; i < li.size()-1; i++)
        {
            int h = 0, e = li.size()-i-1;
            for(int j = 1; j <=e; j++)
            {
                if(li.get(j) > li.get(h))
                {
                    h = j;
                }
            }
            if(x > 0)
            {
                int m = li.get(e);
                li.set(e,li.get(h));
                li.set(h,m);
                x--;
            }
            else
                break;
        }
        return li.get(n-1);
    }
}
