package quki.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StringLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = new String[]{
                "d","cc","bbb","aaaa","AAAAA","BBB","C"
        };
        Arrays.sort(s, String.CASE_INSENSITIVE_ORDER); // 1. ���ĺ���, 2. ���̰� ª�� �� 3. ���̰� ���� ��� �ҹ��ڰ� �տ�  
        //Arrays.sort(s); // ������ �빮�ڰ� �տ�
        System.out.println(Arrays.toString(s)); // a -> b -> c order
        Arrays.sort(s,new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length()){
                    return -1;
                }else if(s1.length() == s2.length()){
                    return 0;
                }else{
                    return 1;
                }
            }
            
        });
        System.out.println(Arrays.toString(s)); // d -> cc -> bbb (string length order)
    }

}
