package quki.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;
/**
 * ����Ž��!
 * 
 * isPossible����
 * long�� ���� ����
 * 
 * 
 * @author quki
 *
 */
public class BOJ2805 {

	public static boolean isPossible(int[] a, int M, int mid){
		
		long toHome = 0; // a�� ���ҵ��� ��� 1,000,000,000 ����������, ���� ���� �� �ִ�.
		for(int tree: a){
			if(tree > mid){
				toHome += (tree - mid);
			}
		}

		return toHome >= M;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);
		int left = 0;
		int right = a[N - 1];
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if(isPossible(a,M,mid)){
				// �������� ������ �ణ ���̰�,
				// ���� ���̸� ���� �÷�����
				left = mid + 1;
				ans = Math.max(ans,mid);
			}else{
				// �������� ������ �ø��� ����,
				// ���� ���̸� ���� ���纸��
				right = mid -1;
			}
		}
		
		System.out.println(ans);
	}

}
