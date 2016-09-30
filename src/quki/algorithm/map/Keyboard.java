package quki.algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Keyboard {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		// �⺻������ �ΰ��� Ű���带 HashMap���� ����ϴ�.
		// �ΰ��� HashMap�� ����Ǿ��ֽ��ϴ�.
		HashMap<Integer, String> num = new HashMap<>(); // key: ���� (���� Ű����), val: charSet
		HashMap<String, Integer> charSet = new HashMap<>(); // key: ����(����==1), val: ���� Ű���忡 �����Ǵ� ����

		// HashMap �ʱ�ȭ
		num.put(0, ",.?!");
		num.put(1, "_");
		num.put(2, "abc");
		num.put(3, "def");
		num.put(4, "ghi");
		num.put(5, "jkl");
		num.put(6, "mno");
		num.put(7, "pqrs");
		num.put(8, "tuv");
		num.put(9, "wxyz");

		charSet.put("h", 4);
		charSet.put("i", 4);
		charSet.put("d", 3);
		charSet.put("a", 2);
		charSet.put("r", 7);
		charSet.put("k", 5);
		
		// ����ϱ� ����
		StringBuffer ans = new StringBuffer();
		
		// input�� ��� character�� �˻��մϴ�
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			String key = Character.toString(c); // char -> String
			int numKey = charSet.get(key); // �ش� ����(����==1)�� �����Ǵ� ���� Ű������ ����
			String strSet = num.get(numKey); // ���� Ű���忡�� ã����
			
			// strSet���� ���� ���ϴ� char�� ���° �ִ��� �˾ƾ��ϰ�
			// Ƚ����ŭ append
			for (int j = 0; j < strSet.length(); j++) {
				ans.append(charSet.get(key));
				if (key.equals(String.valueOf(strSet.charAt(j)))) {
					break;
				}
			}
		}
		
		System.out.println(ans);

	}

}
