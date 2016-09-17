package quki.algorithm.greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * �׸��� ���� + ���ڿ� ������
 * 
 * @author quki
 *
 */
public class BOJ1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		// �� �迭�� ���̴� ���ƾ��Ѵ�.
		ArrayList<String> num = new ArrayList<>(); // ���� ����
		ArrayList<String> sign = new ArrayList<>(); // �� ���ڿ� ���� ��ȣ ����
		sign.add("+"); // ���� ���ǿ� ���� ù°���� ������ + �̹Ƿ�
		String temp = "";
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '+' || c == '-') {
				sign.add(String.valueOf(c));
				num.add(temp);
				temp = "";
			} else {
				temp += c;
			}
		}
		// �������� ������ �� �迭�� ����
		if (!temp.equals("")) {
			num.add(temp);
		}
		int ans = 0;
		boolean isMinus = false; // ������ �ѹ� ������ �����ϸ� �� ���ĺ��� ��� ���ָ� ��
		for (int i = 0; i < num.size(); i++) {
			String s = sign.get(i);
			int a = Integer.parseInt(num.get(i));
			if (!isMinus && s.equals("-")) {
				isMinus = true;
			}
			if (isMinus) {
				ans -= a;
			} else {
				ans += a;
			}

		}

		System.out.println(ans);
	}

}
