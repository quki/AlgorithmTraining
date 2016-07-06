
package quki.algorithm.dp;

import java.util.Scanner;

/**
 * �ð����⵵ O(n) �� ä�����ϴ� ĭ�� �� * 1ĭ�� ä��� �� �ʿ��� ���⵵ �׷��Ƿ�, n*1
 * 
 * @author quki
 */
public class BOJ1463bj {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);

    }
}
