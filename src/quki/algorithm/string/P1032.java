
package quki.algorithm.string;

import java.util.Scanner;

public class P1032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String ans = "";
        for (int j = 0; j < n; j++) {
            String line = sc.nextLine();
            // String[] s = line.split("\\."); //����!!
            if (j == 0) { // ���� �ʱ� ���ڿ� �ʱ�ȭ
                ans = line;
            } else {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < line.length(); i++) {
                    char orig = ans.charAt(i);
                    char curr = line.charAt(i);
                    if (orig != curr) {
                        orig = '?';
                    }
                    sb.append(orig);
                }
                ans = sb.toString();
            }
        }
        System.out.println(ans);
    }
}
