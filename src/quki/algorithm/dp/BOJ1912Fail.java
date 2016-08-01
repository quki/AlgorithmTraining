
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1912Fail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n + 1];
        long d[][] = new long[n + 1][n + 1]; // �迭 ũ�Ⱑ 10�� X 10�� �̸� �޸𸮰� 38146MB�� ��Ÿ�� ����?
        for (int i = 1; i <= n; i++) {
            int e = sc.nextInt();
            a[i] = e;
        }
        int inf = -1000000000;
        long max = inf;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                d[i][j] = d[i][j-1] + a[j];
                max = Math.max(max, d[i][j]);
            }
        }
        System.out.println(max);
    }

}
