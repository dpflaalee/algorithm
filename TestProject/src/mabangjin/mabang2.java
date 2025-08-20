package mabangjin;

import java.util.Scanner;

public class mabang2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size ;
        //홀수 입력받기(짝수면 다시 입력)
        while (true) {
            System.out.print("홀수 마방진 만들기: ");
            size = sc.nextInt();

            if((size%2==1) && size>0) break;
            System.out.println("홀수만 입력해주세요.");
        }

        //마방진 만들기 행의 가운데에서 1부터 시작
        int [][] mat = new int[size][size];
        int col=0, row=(size-1)/2;
        int cnt = 1;
        mat[col][row] = cnt++;

        while (cnt<=size*size) {
            //오른쪽 위로 이동
            col--; row++;
            //1. 행과 열을 벗어나지 않고 그 자리 숫자가 없음 - 정상증가
            if (col>=0 && row<size && mat[col][row]==0) {
                mat[col][row]=cnt++;
            }
            //2. 행과 열을 벗어나지 않고 그 자리에 숫자가 있음 - 제자리로 돌아와 아래로 한칸
            else if (col>=0 && row<size && mat[col][row]!=0) {
                col+=2; row--;
                mat[col][row]=cnt++;
            }
            //3. 행을 벗어남 (행이 음수) - 마지막 행으로 이동
            else if (col<0 && row<size) {
                col=size-1;
                mat[col][row]=cnt++;
            }
            //4. 열을 벗어남 (열이 size-1보다 큼) - 첫번째 열로 이동
            else if (col>=0 && row>size-1) {
                row=0;
                mat[col][row]=cnt++;
            }
            //5. 행과 열 모두 조건에서 벗어남 - 제자리로 돌아와 아래로 한칸
            else if (col<0 && row>size-1) {
                col+=2; row--;
                mat[col][row]=cnt++;
            }
        }

        //출력
        for(int[] m : mat){
            for(int num : m){
                System.out.print(String.format("%5d", num));
            }
            System.out.println();
        }
    }
    
}
