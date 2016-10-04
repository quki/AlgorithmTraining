package quki.algorithm.math;

/**
 * ���ڸ��� �ٲٱ�
 * 
 * @author quki
 *
 */
public class DigitChange {

	/**
	 * origin�� index �ڸ��� �ִ� ���� digit���� �ٲٱ�
	 * 
	 */
	public static int change(int index, int digit, int origin){
		
		String temp = Integer.toString(origin);
		StringBuilder sb = new StringBuilder(temp);
		sb.setCharAt(index, (char) (digit + '0'));
				
		return Integer.parseInt(sb.toString());
		
	}
	
	public static void main(String[] args) {
		int origin = 1234;
		System.out.println(change(0, 9, origin));
		
		
	}

}
