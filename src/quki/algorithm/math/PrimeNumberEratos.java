package quki.algorithm.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �����佺�׳׽��� ä
 * �Է� ���� ������ ������
 * O(nloglogn)
 * 
 * @author quki
 *
 */
public class PrimeNumberEratos {

	public static void main(String[] args) {

		int N = 10000; // 10000�� �� ���� �Ҽ� �Ǻ��� �ϰ� �ʹ�.
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		isPrime[1] = false;
		
		Scanner sc = new Scanner(System.in);
		int question = sc.nextInt();
		
		if(isPrime[question]){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}

	}

}
