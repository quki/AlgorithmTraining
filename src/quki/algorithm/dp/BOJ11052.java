
package quki.algorithm.dp;

import java.util.Scanner;
/**
 * ���⵵
 * 
 * O(N^2)
 * ä�����ϴ� ĭ(N) * �� ĭ�� ä��� ���⵵(N)
 * @author quki
 *
 */
public class BOJ11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int d[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        d[0] = 0;
        d[1] = a[1];
        for (int i = 2; i <= n; i++) {
            int max = -1;
            for (int k = 0; k < i; k++) {
                max = Math.max(max, d[k] + a[i-k]);
            }
            d[i] = max;
        }
        System.out.println(d[n]);
    }

}
