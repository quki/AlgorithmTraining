
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long dp[] = new long[1001]; // ����!! n+1
        dp[1] = 1L; // L�Ⱥٿ�����
        dp[2] = 2L;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
