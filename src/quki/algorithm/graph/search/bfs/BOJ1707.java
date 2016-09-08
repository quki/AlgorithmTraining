
package quki.algorithm.graph.search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �̺б׷��� �Ǻ� BFS
 * 
 * @author quki
 */
public class BOJ1707 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            for (int i = 0; i <= n; i++) {
                hm.put(i, new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                hm.get(u).add(v);
                hm.get(v).add(u);
            }
            boolean isBipartite = true;
            int color[] = new int[n + 1]; // �� �׷��� �ٸ� color�� ��ĥ�Ѵ�. 1 or -1
            // start ������ ��� ���� ���� �������ش�. ������ �׷����� ���ؼ��� ����������ϱ� ������...
            for (int start = 1; start <= n; start++) {
                if (color[start] != 0)
                    continue; // �̹� ��ĥ�� �� ������ �ٸ� � ������ ������ �Ǿ��ִٴ� �ǹ��̹Ƿ�.
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                color[start] = 1;
                while (!q.isEmpty() && isBipartite) {
                    int u = q.poll();
                    int currColor = color[u];
                    for (int v : hm.get(u)) {
                        if (color[v] == 0) {
                            color[v] = (~currColor) + 1; // 1->-1, -1->1
                            q.add(v);
                        }else if(color[v] == currColor){
                            isBipartite = false;
                            break;
                        }
                    }
                }
                if(!isBipartite) break;
            }
            if (isBipartite){
                for (int u = 1; u <= n; u++) {
                    for (int v : hm.get(u)) {
                        if (color[u] == color[v]) {
                            isBipartite = false;
                            break;
                        }
                    }
                    if (!isBipartite)
                        break;
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
