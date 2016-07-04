
package quki.algorithm.scpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 2�� DP: dp[i][k] = i��° ������ �������� k�� ���������� ����Ǽ�
 * dp[i+k][k]= dp[i] - dp[i][k]
 * for(int i=0;i<N;i++)
for(int k=0;k<=K;k++)
for(int j=1;j<=K;j++)
dp[i+j][j]+=dp[i][k];
 * @author quki
 *
 */
public class P2 {

    public static class Point {
        int vertex;

        int prevPath;

        Point(int vertex, int prevPath) {
            this.vertex = vertex;
            this.prevPath = prevPath;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            // �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
            // �˴ϴ�.

            int n = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            int a[] = new int[n + 1];
            while (l-- > 0) {
                int ln = sc.nextInt();
                a[ln] = -1;
            }
            Queue<Point> q = new LinkedList<>();
            for (int i = 1; i <= k; i++) { // �ʱ�ȭ
                if (i <= n && a[i] != -1) {
                    q.add(new Point(i, i));
                    a[i] = a[i] + 1;
                }
            }

            while (!q.isEmpty()) {

                Point p = q.poll();
                int currV = p.vertex;
                int prevPathNum = p.prevPath;
                for (int i = 1; i <= k; i++) {
                    
                    if(i != prevPathNum){
                        int nextV = currV + i;
                        if(nextV <= n && a[nextV] !=-1){
                            q.add(new Point(nextV,i));
                            a[nextV]=a[nextV]+1;
                        }
                    }
                    
                }

            }

            // �� �κп��� ������ ����Ͻʽÿ�.
            System.out.println("Case #" + test_case);
            System.out.println(a[n]%1000000009);
        }
    }

}
