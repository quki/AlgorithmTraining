package quki.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * ���� ������ �Ĳ��� ����ó���� �ʿ���
 * ���, ����, 0, 1�� ������ ��ũ��
 * 
 * @author quki
 *
 */
public class BOJ1744 {

	static Comparator cmp = new Comparator<Integer>() {

		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.compareTo(i1);
		}

	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		int zero = 0;
		int one = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a > 0) {
				if (a == 1) {
					one++;
				} else {
					plus.add(a);
				}

			} else if (a == 0) {
				zero++;
			} else {
				minus.add(a);
			}
		}

		Collections.sort(plus, cmp); // �������� ����
		Collections.sort(minus); // �������� ����
		int ans = 0;

		// ��� ���
		// ������ Ȧ����� 1�� �߰�������
		if (plus.size() % 2 == 1) {
			plus.add(1);
		}
		for (int i = 0; i < plus.size() - 1; i = i + 2) {
			int curr = plus.get(i);
			int next = plus.get(i + 1);
			ans += (curr * next);
		}
		ans += one;

		// ���� ���
		// ������ Ȧ����� 0�� ���� ū���� ������(��������)
		// ��, 0�� ���� ��쿡�� 1�� �߰�������
		if (minus.size() % 2 == 1) {
			if (zero > 0) {
				int last = minus.remove(minus.size()-1);
			} else {
				minus.add(1);
			}
		}
		for (int i = 0; i < minus.size() - 1; i = i + 2) {
			int curr = minus.get(i);
			int next = minus.get(i + 1);
			ans += (curr * next);
		}
		
		System.out.println(ans);

	}

}
