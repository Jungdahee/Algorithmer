package PRO;

public class PRO_72410_신규_아이디_추천 {

    public static String makeId1(String input){
        // step 1. 소문자로 치환
        input = input.toLowerCase();

        // step 2. 소문자, 숫자, -, _, . 제외하고 제거
        String input2 = "";
        for(int i = 0; i < input.length(); i++){
            char tmp = input.charAt(i);
            if(Character.isLowerCase(tmp) || Character.isDigit(tmp) || tmp == '-' || tmp == '_' || tmp == '.'){
                input2 += tmp;
            }
        }

        // step 3. 두 번 이상 연속된 . 하나로 치환
        while(input2.contains("..")){
            input2 = input2.replace("..", ".");
        }

        // step 4. "."이 처음과 끝에 있으면 제거
        if(input2.length() > 0 && input2.charAt(0) == '.'){
            input2 = input2.substring(1);
        }
        if(input2.length() > 0 && input2.charAt(input2.length() - 1) == '.'){
            input2 = input2.substring(0, input2.length() - 1);
        }

        // step 5. 빈 문자열이면 "a" 대입
        if(input2.length() == 0) {
            input2 += "a";
        }

        // step 6. 16 글자 이상이면 15까지 추출, 끝에 "."가 있으면 제거
        if(input2.length() > 15) {
            input2 = input2.substring(0, 15);

            if(input2.charAt(input2.length() - 1) == '.') {
                input2 = input2.substring(0, input2.length() - 1);
            }
        }

        // step 7. 마지막 글자 반복해서 3 글자로 생성
        if(input2.length() <= 2){
            while(input2.length() < 3){
                input2 += input2.charAt(input2.length() - 1);
            }
        }

        return input2;
    }

    public static String makeId2(String input){
        // step 1
        input = input.toLowerCase(); // 1단계

        // step 2
        input = input.replaceAll("[^-_.a-z0-9]", "");

        // step 3
        input = input.replaceAll("[.]{2,}", ".");

        // step 4
        input = input.replaceAll("^[.]|[.]$", "");

        // step 5
        if(input.length() == 0) {
            input += "a";
        }

        // step 6
        if (input.length() > 15) {
            input = input.substring(0, 15);
            input = input.replaceAll("[.]$", "");
        }

        if (input.length() <= 2) {  // 7단계
            while (input.length() < 3) {
                input += input.charAt(input.length() - 1);
            }
        }

        return input;
    }

    public static void main(String argsp[]){
        System.out.println(makeId1("abcdefghijklmn.p"));
        System.out.println(makeId2("...!@BaT#*..y.abcdefghijklm"));
    }
}
