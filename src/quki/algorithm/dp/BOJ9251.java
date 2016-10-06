package quki.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * LCS �˰���!
 * �迭 ũ�� ����
 * �迭 ���� �̵���ų ��, ���� �����ϱ�
 * ��� ���ϱ� ����!
 * 
 * @author quki
 *
 */
public class BOJ9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int LCS[][] = new int[a.length() + 1][b.length() + 1];
		int max = 0;
		for (int i = 1; i <= a.length(); i++) {
			
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
					if(max < LCS[i][j]){
						max = LCS[i][j];
					}
				}else{
					LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
				}
				
			}
			
			
		}
		System.out.println(LCS[a.length()][b.length()]);

	}

}
