package BOJ;

import java.io.*;

public class BOJ_2941_크로아티아_알파벳 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String words[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i < words.length; i++){
            input = input.replaceAll(words[i], ".");
        }

        System.out.println(input.length());
    }
} 
