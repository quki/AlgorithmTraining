
package quki.algorithm.boj;

import java.util.Scanner;

/**
 * BOJ #2344 Mirror
 * 
 * @author quki
 */
public class P2344 {

    public static int moveChange(int k, boolean isMirror) {

        if (isMirror) {
            if (k == 0) {
                return 1;
            } else if (k == 1) {
                return 0;
            } else if (k == 2) {
                return 3;
            } else if (k == 3) {
                return 2;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 2][m + 2];

        // ��, ����, �Ʒ�, ���� ���� ȭ��ǥ
        int dy[] = {
                -1, 0, 1, 0
        };
        int dx[] = {
                0, 1, 0, -1
        };
        int count =1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n || j == n) {
                    a[i][j] = count;
                    count++;
                } else {
                    a[i][j] = sc.nextInt();
                }
            }
        }
        // �ſ��� ���ʿ��� ���� ���

        // ����
        for (int i = 1; i <= n; i++) {

        }
        // �Ʒ���
        for (int i = n + 1; i <= n + m; i++) {

        }
        // ������
        for (int i = n + m + 1; i <= 2 * n + m; i++) {

        }
        // ����
        for (int i = 2 * n + m + 1; i <= 2 * n + 2 * m; i++) {

        }

    }

}
