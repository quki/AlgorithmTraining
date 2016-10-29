package quki.algorithm.string;

import java.util.Scanner;
/**
 * ���Ͽ��� * �� �׻� ��� �ϳ��� ����
 * Ư������ split�� �� \\ ���� ��!
 * �ݷʴ� �񱳴���� ���Ϻ��� �� ª�� ���
 * 
 * @author quki
 *
 */
public class BOJ9996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String[] pattern = sc.nextLine().split("\\*");
		String head = pattern[0];
		String tail = pattern[1];
		while (T-- > 0) {
			String cmp = sc.nextLine();
			boolean isMatch = true;

			if (head.length() + tail.length() > cmp.length()) {
				isMatch = false;
			}

			// head �˻�
			if (isMatch) {
				for (int i = 0; i < head.length(); i++) {
					if (cmp.charAt(i) != head.charAt(i)) {
						isMatch = false;
						break;
					}
				}
			}

			// tail �˻�
			if (isMatch) {
				for (int i = 0; i < tail.length(); i++) {

					int forCmpIdx = cmp.length() - tail.length() + i;

					if (cmp.charAt(forCmpIdx) != tail.charAt(i)) {
						isMatch = false;
						break;
					}
				}
			}

			if (isMatch) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}

		}
	}

}
