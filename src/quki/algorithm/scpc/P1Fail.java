
package quki.algorithm.scpc;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 2�� 63�� �� 8byte�� �Ѿ�Ƿ�, C������ unsigned long long�� �����.(Java������ BigInteger)
 * TC 20������ �°� ���Ĵ� �ð��ʰ���.
 * @author quki
 *
 */
public class P1Fail {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            int k = sc.nextInt();

            Queue<BigInteger> q = new LinkedList<>();
            q.add(BigInteger.ONE);
            BigInteger max = BigInteger.ZERO;
            BigInteger min = new BigInteger("1000000000");
            for (int i = 0; i <= k; i++) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    if (i != k) {
                        BigInteger x = q.poll();
                        q.add(x.multiply(new BigInteger("2")));
                        BigInteger newX = x.subtract(BigInteger.ONE).divide(new BigInteger("3"));// (x-1)/3
                        BigInteger remainder = x.subtract(BigInteger.ONE).remainder(new BigInteger("3")); // (x-1)%3
                        
                        // �������� 0, �������� 1�� �ƴϸ�, �������� ¦���� �ƴѰ��
                        if (remainder.equals(BigInteger.ZERO) && !newX.equals(BigInteger.ONE)
                                && !newX.remainder(new BigInteger("2")).equals(BigInteger.ZERO)) {
                            q.add(newX);
                        }
                    } else {
                        // ��������
                        BigInteger x = q.poll();
                        max = max.max(x);
                        min = min.min(x);
                    }
                }
            }
            // �� �κп��� ������ ����Ͻʽÿ�.
            System.out.println("Case #" + test_case);
            System.out.println(min + " " + max);
        }
    }

}
