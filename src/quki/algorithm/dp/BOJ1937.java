
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1937 {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    /**
     * @return d[i][j]: �ش� ������ �����ϴ� �� �ִ� ��� ��.
     */
    public static int go(int a[][], int d[][], int i, int j) {

        int n = a[0].length - 1;

        if (d[i][j] != 0) 
            return d[i][j];
        for (int k = 0; k < 4; k++) {
            int newI = i + dy[k];
            int newJ = j + dx[k];
            if (newI >= 1 && newI <= n && newJ >= 1 && newJ <= n) {
                if (a[i][j] > a[newI][newJ]) {
                    int t2 = go(a, d, newI, newJ) + 1; // depth 1����(���� ��ġ)
                    d[i][j] = Math.max(d[i][j], t2);
                }
            }
        }
        
        // �� �̻� �� ���� ���� ����(����)���� return�� �ϴµ�
        // �̶�, ���� ��ġ�� ���� 0�� ���(�ش� ������ ó�� �� ���)���� 1�� ����� return �Ѵ�.
        if (d[i][j] == 0) 
            return d[i][j] = 1;
        
        return d[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n + 1][n + 1];
        int d[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        //d[i][j]: �ش� ������ �����ϴ� �� �ִ� ��� ��.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == 0)
                    max = Math.max(max, go(a, d, i, j));
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append("\n");
            for (int j = 1; j <= n; j++) {
                sb.append(d[i][j] + " ");
            }
        }
        System.out.println(sb);
        System.out.println(max);
    }
}
