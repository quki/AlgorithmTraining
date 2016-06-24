package quki.algorithm.ds.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ #10799
 * Using Stack
 * ������ ��� �Ͱ� ������ ��� ���� ���� ��, ���� ����� Stack�̴�.
 * 
 * @author quki
 */
public class SteelRod {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = line.length();
        int rodCount = 0;
        int ans=0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
                char curr = line.charAt(i);
                if(curr == '('){
                    st.push(curr);
                    rodCount++;
                }else if(curr == ')'){
                    char prev = st.peek();
                    if(prev == '('){
                        rodCount--;
                        ans += rodCount;
                        st.push(curr);
                    }else if(prev ==')'){
                        rodCount--;
                        ans++;
                        st.push(curr);
                    }
                }
        }
        System.out.println(ans);
        
    }

}
