package gugudan;
import java.util.Scanner;

public class gugudanUp {
    public static void main(String[] args){
        //입력받기
        Scanner sc = new Scanner(System.in);

        System.out.print("몇단까지 출력할까요?");
        int max = sc.nextInt();     // n단까지 출력

        System.out.print("몇묶음으로 출력할까요?");
        int size = sc.nextInt();    // 세로 기준 n묶음 ex) 9단까지 2묶음 2-5 / 6-9
        int total = max - 1;        // 
        int groupSize = (total + size - 1) / size;

        // 구구단
        for (int i = 0; i < size * 9; i++) {
            int row = i % 9 + 1 ;  
            // 1~9 곱할 수 :: 이유를 모르겠는데 %9 + 1 를 제외하면 출력이 망가짐 
            // 첫번째 묶음은 정상적으로 1~9 곱셈으로 출력되는데 두번째 묶음부터 첫번째 10부터 곱하는 걸로 출력이 되는데 뭐가문제지?
            int group = i / 9;
            int start = 2 + group * groupSize;

            for (int dan = start; dan < start + groupSize && dan <= max; dan++) {
                System.out.print(dan + "X" + row + "=" + (dan * row) + "\t");
            }
            System.out.println();
        }
    }
}
