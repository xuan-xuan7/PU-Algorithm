// Bob has encountered a difficult problem, and hope you design an algorithm to calculate pow(a,b) mod 1337, where a is a positive integer, b is a very large positive integer and will be given in the form of an array. For example, pow(2,3) mod 1337 is 8.
// 十进制快速幂，模运算性质

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FastModExponentiation {
    public int fastMod(int a, int[] b){
        int i, j;
        int length = b.length;
        int ans = 1;
        int cnt;
        int con = a % 1337;
        int res;

        for(i=length-1; i>=0; i--){
            cnt = b[i];
            res = con;
            for(j=0; j<cnt; j++){
                ans = ans * res % 1337;
            }
            for(j=1; j<10; j++){
                res = res * con % 1337;
            }
            con = res;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine().toString();
        int n = Integer.parseInt(s1);
        String s = input.nextLine().toString();
        s = s.substring(1, s.length()-1);
        String arr[] = s.split(",");
        int[] num = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            num[i] = Integer.parseInt(arr[i]);
        }
        FastModExponentiation res = new FastModExponentiation();
        int ans = res.fastMod(n, num);
        System.out.println(ans);
    }
}