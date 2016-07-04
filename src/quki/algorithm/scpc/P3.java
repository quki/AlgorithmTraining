
package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P3 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            // �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
            // �˴ϴ�.
            int K = sc.nextInt();
            int L = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            for (int i = 0; i <= N; i++) {
                hm.put(i, new ArrayList<Integer>());
            }
            int[] d = new int[N + 1];
            boolean[] c = new boolean[N + 1];
            while (M-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                hm.get(u).add(v);
                hm.get(v).add(u);
                d[u] = d[u] + 1;
                d[v] = d[v] + 1;
            }
            boolean isAnsExist = true;
            boolean isKChanged = true;
            boolean isAllConneChanged = true;
            int totalVertexNum = N;
            int ans = 0;
            while (isKChanged || isAllConneChanged) {
                
                isKChanged = false;
                isAllConneChanged = false;
                
                for (int i = 1; i <= N; i++) {
                    if (d[i] < K && !c[i]) {
                        
                        // i ����
                        totalVertexNum--;
                        c[i] = true;
                        ans += i;
                        
                        // i ���� ����
                        for(int e: hm.get(i)){
                            if(!c[e])
                            d[e] = d[e]-1;
                        }
                        
                        
                        if (!isKChanged)
                            isKChanged = true;
                    }
                 // check !!
                    if (totalVertexNum < L) {
                        isAnsExist = false;
                        break;
                    }
                    
                    if(d[i]==totalVertexNum-1 && !c[i]){
                        // i ����
                        totalVertexNum--;
                        c[i] = true;
                        ans += i;
                        // i ���� ����
                        for(int e: hm.get(i)){
                            if(!c[e])
                            d[e] = d[e]-1;
                        }
                        if (!isAllConneChanged)
                            isAllConneChanged = true;
                        
                    }
                    // check !!
                    if (totalVertexNum < L) {
                        isAnsExist = false;
                        break;
                    }
                }
                if (!isAnsExist)
                    break;
            }
            if (!isAnsExist) {
                // �� ���ϱ�
                ans = (N+1)*N/2;
            }

            // �� �κп��� ������ ����Ͻʽÿ�.
            System.out.println("Case #" + test_case);
            System.out.println(ans);
        }
    }

}
