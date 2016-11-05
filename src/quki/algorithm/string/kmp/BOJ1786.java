package quki.algorithm.string.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * KMP, O(N+M): N: text ����, M: pattern ����, pi ���ϴµ� O(M) + text ���� ��ŭ for�� O(N)
 *
 */
public class BOJ1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();

		ArrayList<Integer> ans = kmp(text, pattern);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size() + "\n");

		for (int index : ans) {
			sb.append(index + " ");
		}
		System.out.println(sb.toString());
	}

	public static ArrayList<Integer> kmp(String text, String pattern) {

		int[] pi = getPi(pattern);

		ArrayList<Integer> list = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < text.length(); i++) {

			// �߰� �ܰ� �پ�ѱ�
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1]; // index - 1 : ��ġ���� �ʴ� ���� �ٷ� ��
			}
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					// j�� �� �ε����ν�, �ε����� ã�� ���ڿ��� ũ�⿡ �����ϸ� ���ڿ� ã��.
					list.add(i - pattern.length() + 2);

					// ���� ���� ã�� ���ڿ��� ���� �� �ֱ� ����.
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		return list;
	}

	/**
	 * pattern�� pi �迭 ���ϱ�, ���� KMP ���� �̿�
	 */
	public static int[] getPi(String pattern) {

		int j = 0;
		int[] pi = new int[pattern.length()];

		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}

		}
		return pi;

	}

}
