
package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4 {
    static class Point {
        int v;

        int c;

        Point(int v, int c) {
            this.v = v;
            this.c = c;
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
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int inf = 1000000000;
            int[] dtemp = new int[N+1];
            
            HashMap<Integer, ArrayList<Point>> hm = new HashMap<>();
            for (int i = 0; i <= N; i++) {
                hm.put(i, new ArrayList<Point>());
            }
            while (M-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int c = sc.nextInt();
                hm.get(u).add(new Point(v,c));
                hm.get(v).add(new Point(u,c));
                
             // ���� ī��Ʈ ��Ű�� �� ������ 
             // ���ͽ�Ʈ��, �÷��̵�ͼ�, SPFA, ��������� �ʿ� ����!
                dtemp[u] = dtemp[u]+1; 
                dtemp[v] = dtemp[v]+1;
            }
            
            boolean e[] = new boolean[N+1];
            boolean c[] = new boolean[N+1];
            
            while (K-- > 0) {
                int exit = sc.nextInt();
                e[exit] = true;
                for(Point p :hm.get(exit)){
                    int y = p.v;
                    dtemp[y] = dtemp[y]-1;
                }
            }
            int[] d = new int[N+1];
            int[] s = new int[N+1];
            Queue<Integer> q = new LinkedList<>();
            int sumDistance = 0;
            int sumVertex = 0;
            for(int i = 1; i<=N;i++){
                if(!e[i]){
                    for (int k = 0; k <= N; k++) {
                        s[k] = inf;
                        c[k] = false;
                        d[k] = dtemp[k];
                    }
                    q.add(i);
                    c[i] = true;
                    s[i] = 0;
                    d[i] = 0;
                    while(!q.isEmpty()){
                        int x = q.poll();
                        for(Point p : hm.get(x)){
                            int cost = p.c;
                            int y = p.v;
                            if(s[y]>s[x]+cost)
                                s[y] = s[x]+cost;
                            d[y] = d[y]-1;
                            if(!c[y] && !e[y]){
                                q.add(y);
                                c[y] = true;
                            }
                            
                            
                            
                        }
                    }
                    int min = inf;
                    int minV = 0;
                    for(int j = 1; j<=N;j++){
                        if(e[j]){
                           min =  Math.min(s[j], min);
                           if(min == s[j]){
                               minV = j;
                           }
                        }
                    }
                    sumDistance+= min;
                    sumVertex+= minV;
                }
                
            }
            for(int i = 1; i<=N;i++){
                if(e[i])
                sumVertex+=i;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(sumDistance);
            sb.append("\n");
            sb.append(sumVertex);
            // �� �κп��� ������ ����Ͻʽÿ�.
            System.out.println("Case #" + test_case);
            System.out.println(sb);
        }
    }

}
