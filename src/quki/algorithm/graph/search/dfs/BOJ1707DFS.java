
package quki.algorithm.graph.search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ1707DFS {

    /**
     * @param hm: graph����
     * @param color: vertex�� ���� array
     * @param u: ���� vertex
     * @param c: �� �׷��� �ٸ� color�� ��ĥ�Ѵ�. 1 or -1
     */
    public static void dfs(HashMap<Integer, ArrayList<Integer>> hm, int[] color, int u, int c) {
        color[u] = c;
        for (int v : hm.get(u)) {
            if (color[v] == 0) {
                dfs(hm, color, v, (~c) + 1);
            }
        }
    }

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
            while (m-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                hm.get(u).add(v);
                hm.get(v).add(u);
            }
            int color[] = new int[n + 1];

            for (int start = 1; start <= n; start++) {
                if (color[start] != 0)
                    continue;
                dfs(hm, color, start, 1);
            }
            boolean isBipartite = true;
            for (int u = 1; u <= n; u++) {
                for( int v: hm.get(u)){
                    if(color[u] == color[v]){
                        isBipartite = false;
                    }
                }
            }
            
            String ans = (isBipartite ? "YES" : "NO");
            System.out.println(ans);

        }
    }

}
