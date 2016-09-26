package quki.algorithm.graph.search.perfect;

import java.util.Scanner;
/**
 * ����Ž�� �� ����� ����
 * for���� ���� ����ִ� ������ �����.
 * �׸��� 100���� �����ϴ� �ʱⰪ �����ϴ� ��� �����
 * �켱 ���ذ� ������ �ڸ��� ���ϴ� ��ũ���̶� ���̵�� ���ַ� ���캸��
 * 
 * @author quki
 *
 */
public class BOJ1107 {

	/**
	 * �ش� �� c�� �ٷΰ��� ��ư�� ���� �� ���� ��, �ڸ����� return�Ѵ�
	 * 
	 * ��� �ڸ��Ǽ��� ������ �ʾҴٸ� length(�ڸ���)�� return �ϳ��� ���� ��ư�� �־ �� ������ 0 return
	 */
	public static int getLength(boolean broken[], int c) {

		// �ڸ��� ���ϴ� ��ũ��!
		// 10 �����鼭 count
		int length = 0;
		while (c > 0) {
			int k = c % 10;
			if (broken[k]) {
				return 0;
			}
			c /= 10;
			length++;
		}

		// ���� ó��
		if (c == 0) {
			if (broken[c]) {
				return 0;
			} else {
				return 1;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean broken[] = new boolean[10];
		while (M-- > 0) {
			int a = sc.nextInt();
			broken[a] = true;
		}
		int ans = N - 100; // �ʱⰪ�� 100���� ���ڸ� ������ �ʰ� �̵��ϴ� Ƚ�� 
		if (ans < 0) {
			ans = -ans; // n < 100
		}
		for (int i = 0; i <= 1000000; i++) {
			
			int length = getLength(broken, i);
			
			if (length > 0) {
				int plus = N - i; //+,- ��ư! ������ ���ÿ� �ΰ��� ���� �� ����.
				if (plus < 0) {
					plus = -plus;
				}
				length += plus;
				ans = Math.min(length, ans);
			}

		}
		System.out.println(ans);

	}

}
