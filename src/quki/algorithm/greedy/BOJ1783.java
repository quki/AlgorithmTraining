package quki.algorithm.greedy;

import java.util.Scanner;
/**
 * ���� ����Ʈ ����
 * ������ �����ϴµ� �ټ� �����
 * ���� ��츦 ������ ����
 * �״� �߿䵵�� ���� ������ �ƴѵ�
 * 
 * @author quki
 *
 */
public class BOJ1783 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ����
		int M = sc.nextInt(); // �ʺ�
		int ans = 0;
		if(N == 1){
			ans = 1;
		}else if(N == 2){
			ans = Math.min(4, (M+1)/2);
		}else if(N>=3){
			if(M>=7){
				ans = M-2;
			}else{
				ans = Math.min(4, M);
			}
		}
		System.out.println(ans);
	}

}
