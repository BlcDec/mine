package JavaStudy;

import java.util.*;

/**
 * Created by KAI on 2017/9/24.
 */
public class BoardGame {
    int[][] array;
    int count = 1;
    public BoardGame() {
        array = new int[3][3];
    }
    public void showArray() {
        for(int[] i:array) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();

    }
    private boolean check() {
        int[] a=new int[9];
        for(int[] i:array)
            for(int j:i) {
                if(j<1||j>9)
                    return false;
                else
                    a[--j]++;
            }
        for(int i:a)
            if(i!=1)
                return false;
        return true;
    }

    public void setNumbers()
    {
        int sum=1;
        for(int i=1;i<=9;i++)
            for(int j=1;j<=9;j++) {
                if (j == i) continue;
                for (int k = 1; k <= 9; k++) {
                    if (j == i || k == j) continue;
                    array[0][0] = i;
                    array[0][2]=j;
                    array[1][1]=k;
                    array[0][1]=15-array[0][0]-array[0][2];
                    array[2][2]=15-array[0][0]-array[1][1];
                    array[2][0]=15-array[0][2]-array[1][1];
                    array[2][1]=15-array[2][0]-array[2][2];
                    array[1][0]=15-array[0][0]-array[2][0];
                    array[1][2]=15-array[0][2]-array[2][2];
                    if(check()) {
                        System.out.println("==" + sum + "==");
                        sum++;
                        showArray();
                    }
                }
            }
    }
    public static void main(String args[])
    {
        long startTime=System.currentTimeMillis();
        BoardGame t=new BoardGame();
        t.setNumbers();
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");

    }

}
