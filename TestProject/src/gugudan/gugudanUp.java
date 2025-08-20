package gugudan;
import java.util.Scanner;

public class gugudanUp {
    public static void main(String[] args){
        //입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("몇단까지 출력할까요?");
        int max = sc.nextInt();
        System.out.print("몇묶음으로 출력할까요?");
        int size = sc.nextInt();
        int total = max - 1;
        int groupSize = (total + size - 1) / size;

        // 구구단
        for (int i = 0; i < size * 9; i++) {
            int row = i % 9 + 1; 
            int group = i / 9;
            int start = 2 + group * groupSize;

            for (int dan = start; dan < start + groupSize && dan <= max; dan++) {
                System.out.print(dan + "X" + row + "=" + (dan * row) + "\t");
            }
            System.out.println();
        }
    }
}
