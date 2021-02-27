import java.util.Arrays;
import java.util.Scanner;

public class Complexity {
    public static void main(String[] args){
        int[]d = new int[26];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(char c: s.toCharArray()){
            ++d[(int)c - (int)'a'];
        }
        Arrays.sort(d);
        int sum = 0;
        for(int i = 0; i < 24; i++){
            sum+=d[i];
        }
        System.out.println(sum);
    }
}
