package gugudan;
public class gugudan {
    public static void main(String[] args){
        // for (int i = 1; i < 10; i++) {
        //     for (int j = 2; j < 10; j++) {
        //         if (j <= 5) {System.out.print(j + "x" + i + "=" + (j * i) + "\t");}
        //     }
        //     System.out.println(); 
        // }
        // System.out.println(); 
        // for (int i = 1; i < 10; i++) {
        //     for (int j = 2; j < 10; j++) {
        //         if (j >= 6) {System.out.print(j + "x" + i + "=" + (j * i) + "\t");}
        //     }
        //     System.out.println();
        // }    

        for(int i=0; i<3*9; i++){
            int row = i%9 +1;
            int group = i/9;
            int start = 2+ group*4;

            for(int dan = start; dan<start+4 && dan<=9; dan++){
                System.out.print(dan+"X"+row+"="+dan*row+'\t');
            }
            System.out.println();
        }
    }
}
