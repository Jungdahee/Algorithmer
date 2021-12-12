package PRO;

import java.util.*;

public class PRO_72412_순위_검색 {
    public static HashMap<String, ArrayList<Integer>> applicant;

    public static int[] solution(String[] info, String[] query) {
        int answer[] = new int[query.length];
        applicant = new HashMap<>();

        // 1. 지원 항목의 조합으로 나올 수 있는 모든 경우 구하기
        for(String input : info) makeCombination("", input.split(" "), 0);

        // 2. 같은 경우에 있는 지원자의 점수 정렬하기
        for(String key : applicant.keySet()) Collections.sort(applicant.get(key));

        // 3. 조건에 해당하는 지원자가 몇명인지 구하기
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String str[] = query[i].split(" ");
            answer[i] = binarySearch(str[0], Integer.parseInt(str[1]));
        }

        return answer;
    }

    public static void makeCombination(String key, String input[], int cnt) {
        if(cnt == 4) {
            if(applicant.containsKey(key)) {
                applicant.get(key).add(Integer.parseInt(input[4]));
            }
            else {
                ArrayList<Integer> score = new ArrayList<Integer>();
                score.add(Integer.parseInt(input[4]));
                applicant.put(key, score);
            }

            return;
        }

        makeCombination(key + "-", input, cnt + 1);
        makeCombination(key + input[cnt], input, cnt + 1);
    }

    public static int binarySearch(String key, int score) {
        if(!applicant.containsKey(key)) return 0;

        ArrayList<Integer> scoreList = applicant.get(key);
        int low = 0;
        int high = scoreList.size() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(scoreList.get(mid) < score) low = mid + 1;
            else high = mid - 1;
        }

        return scoreList.size() - low;
    }

    public static void main(String args[]) {
        String info[] = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String query[] = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
}
