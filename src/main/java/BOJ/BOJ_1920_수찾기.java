package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1920_수찾기 {
    public static int[] makeData(String input[], int output[]) {
        for(int i = 0; i < input.length; i++){
            output[i] = Integer.parseInt(input[i]);
        }

        return output;
    }

    public static int binarySearch(int A[], int n){
        int low = 0;
        int high = A.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if(A[mid] == n) return 1;
            else if(A[mid] < n) low = mid + 1;
            else high = mid - 1;
        }

        return 0;
    }

    public static void main(String agrs[]) throws IOException {
        // 1. 입력값 읽고 데이터 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        String input[] = br.readLine().split(" ");
        makeData(input, A);

        int M = Integer.parseInt(br.readLine());
        int num[] = new int[M];
        input = br.readLine().split(" ");
        makeData(input, num);

        // 2. 이분 탐색을 위해 오름차순 정렬
        Arrays.sort(A);

        System.out.println(Arrays.toString(A));

        // 3. 이분 탐색 진행
        for(int i = 0; i < M; i++){
            System.out.println(binarySearch(A, num[i]));
        }
    }
}
