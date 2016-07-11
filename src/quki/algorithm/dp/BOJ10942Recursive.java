package quki.algorithm.dp;

import java.util.Scanner;

/**
 * �Ӹ����?
 * ��� (����)
 * ����!
 * ��� ȣ���� �ð����⵵�� �Ҹ��� Ƚ���� �¿��.
 * �׷��Ƿ� O(N)
 * ������, �������� ������ M�̹Ƿ�,
 * O(NM)
 * 
 * cf) Manacher's algorithm �� O(N+M)
 * @author quki
 *
 */
public class BOJ10942Recursive {
    
    public static boolean isPalindrome(int[] a, int start, int end){
        
        if(start == end)return true;
        if(start+1 == end){
           if( a[start] == a[end] ){
               return true;
           }else{
               return false;
           }
        }
        
        if(a[start] == a[end]){
            return isPalindrome(a, start+1, end-1);
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n;i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        while(m-->0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int ans = isPalindrome(a, start-1, end-1) ? 1:0;
            System.out.println(ans);
        }
    }

}
