package mabangjin;

import java.util.Scanner;

public class mabang {
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("마방진 크기: ");
        int size = scan.nextInt();

        //행 0, 열 가운데에서 1부터 시작
        int [][] mat = new int[size][size];
        int col = 0, row = (size-1)/2;
        int cnt = 1;

        mat[col][row] = cnt++;

        //cnt가 마방진 크기만큼 증가하면 나와야 하니까...
        while (cnt<=size*size) {
            //오른쪽 위로 이동
            col--; row++;
            if((col>=0 && col<size) && (row>=0 && row<size) && mat[col][row]==0){ //1. 행과 열을 벗어나지 않고 그 자리에 숫자가 없음
                mat[col][row] = cnt++ ;

            }else if((col>=0 && col<size) && (row>=0 && row<size) && mat[col][row]!=0){ //2. 행과 열을 벗어나지 않았는데 그 자리에 숫자가 있음
                //원상태로 돌아와서 한칸 내리기
                col+=2; row--;
                mat[col][row] = cnt++;

            }else if(col<0 && (row>=0 && row<size)){ //3. 행이 음수값
                //마지막 행으로 이동
                col = size-1;
                mat[col][row] = cnt++;

            }else if((col>=0 && col<size) && row>size-1){ //4. 열이 size-1보다 큼
                //첫번째 열로 이동
                row = 0;
                mat[col][row] = cnt++;

            }else if(col<0 && row>size-1){ //5. 행 열 모두 조건에서 벗어남
                //되돌아와 한칸 아래로
                col+=2; row--;
                mat[col][row] = cnt++;
            }
        }
        //오른쪽 위로 이동
        //이동가능하고 그 자리에 숫자가 없음 - 정상증가
        //이동가능한데 그 자리에 숫자가 있음 - 원상태로 돌아가서 한칸 내려감
        //행이 음수값 (행<0)- 맨 아래로 이동 행=size-1
        //열이 size-1보다 큼 (열>size-1) - 맨 왼쪽으로 이동 열=0
        //행이 음수인데 열도 size-1보다 큼 (행<0 && 열>size-1) - 원상태로 돌아와서 한칸 아래로 내려감

        //출력
        for(int[] m : mat){
            for(int num: m){
                System.out.print(String.format("%4d", num));
            }
            System.out.println();
        }

        /*for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.printf("%3d ", mat[i][j]);
            }
            System.out.println();
        }*/

    }
}

/* 
n*n의 행렬 col-row
1.  진행방향은 오른쪽 위. 시작점은 행의 중간지점에서 시작 [0][(0+size-1)/2] cnt=1
2.  행이 음수값(행<0, 0<=열<3) 열 고정 행 맨밑으로 > 행=size-1; 행렬[행][열]=cnt++
2-1. 열이 n을 벗어남(0<=행<3, 열>3) 행 고정 열 맨끝으로 > 열=0; 행렬[행][열]=cnt++
3.  이동 위치에 이미 숫자가 있을 때, 제자리로 돌아와서(왼쪽대각선으로 한칸내려와) 바로 밑으로
4.  행이 음수 열이 n을 벗어났을 때(행<0 , 열>2), 제자리로 돌아와 아래로
    지금 조건을 걸어야 하는게... 행이 음수값이 아닐 것, 열이 size-1보다 크지 않을것, [행][열] 위치에 다른 숫자가 있지 않을 것
*/

/*
    1. 행 중앙에 1 위치...
        > 랜덤지정 or 입력받게?

    기본형태참고
    https://why-dev.tistory.com/56
    https://bigfat.tistory.com/42
 */