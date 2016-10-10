package quki.algorithm.graph.search.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759 {
	static int L;
	static int C;
	/**
	 * ���
	 * @param full ���� ���ڿ�
	 * @param making ������� ���ڿ�
	 */
	static void go(String full, String making){
		
		if(making.length() == L){
			
			int aCount = 0;
			int splCount = 0;
			//�ּ� �Ѱ��� ������ �ּ� �ΰ��� ����(��������)
			for(int i = 0; i<L; i++){
				char c = making.charAt(i);
				if(c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'){
					aCount++;
				}else{
					splCount++;
				}
			}
			if(aCount >=1 && splCount >=2)
				System.out.println(making);
			
			return;
		}
		
		int currIdx = full.indexOf(making.charAt(making.length()-1)); // indexOf �Լ�: �ش� char�� index�� ����
		for(int next = currIdx + 1; next <= C-1; next++){
			StringBuilder temp = new StringBuilder(making);
			temp.append(full.charAt(next));
			go(full, temp.toString());
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); // �������ϴ� ����
		C = sc.nextInt(); // �־��� ���ڿ��� ����
		char a[] = new char[C];
		for(int i = 0; i<C;i++){
			a[i] = sc.next().charAt(0);
		}
		Arrays.sort(a); // �������� ����
		String full = String.valueOf(a);
		
		for(int start = 0; start <= C-L; start++){
			go(full, Character.toString(full.charAt(start)));
		}
	}

}
