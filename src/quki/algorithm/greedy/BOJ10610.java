package quki.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �׸��� �˰����̶�� ���� �����п� ����� ���� 30�� ��� = 2,3,5 ����� ��������Ѵ�
 * ��, 10�� ��� �̸鼭 3�ǹ�� 3�ǹ���� �Ƿ��� �� �ڸ����� ���� 3�� ����� �Ǿ���Ѵ�.
 * 
 * @author quki
 *
 */
public class BOJ10610 {
	/**
	 * �迭 ������ �⺻������ Comparator�� ����Ϸ��� �迭�� ���Ұ� Object�����Ѵ�. ��, Integer�̱� ������ �迭��
	 * ������ int�� ���Ľ�Ű���� Comparator�� ���Ұ�.
	 * 
	 * @param a
	 */
	public static void reverseArray(int[] a) {
		for (int i = 0; i * 2 < a.length; i++) {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int a[] = new int[line.length()];
		boolean isExistZero = false;
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			int num = Integer.parseInt(String.valueOf(line.charAt(i)));
			a[i] = num;
			sum += num;
			if (num == 0)
				isExistZero = true;
		}

		if (!isExistZero || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			Arrays.sort(a); // ��������
			reverseArray(a); // ����� ��������
			StringBuffer sb = new StringBuffer();
			for (int e : a) {
				sb.append(e);
			}
			System.out.println(sb);

		}

	}

}
