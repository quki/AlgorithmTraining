
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ2666Fail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int k = sc.nextInt(); //�̵��ؾ��ϴ� ���幮 ����
        
        int a[] = new int[k];
        int d[] = new int[k]; // ���� ���幮���� ���� ���� �� �ּڰ� ����
        
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < k; i++) {
            
            int t1 = Math.abs(a[i]-A);
            int t2 = Math.abs(a[i]-B);
            
            if(t1>t2){
                int temp1 = t1;
                t1 = t2;
                t2 = temp1;
                int temp2 = A;
                A = B;
                B = temp2;
            }
            
            d[i] = t1;
            A = a[i];
        }
        
        int ans = 0;
        for(int i = 0; i<d.length;i++){
            ans+=d[i];
        }
        System.out.println(ans);
    }

}
