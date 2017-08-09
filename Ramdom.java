package sample;

import java.util.Random;

public class RandomTest {
    private static int c0;
    private static int c1;
    private static int c2;
    private static int c3;
    private static int c4;
    private static int c5;
    private static int c6;
    private static int c7;
    private static int c8;
    private static int c9;
    private static final int LOOP = 1000000;

    public static void main(String []args){
        Random Ran = new Random();
        int num = 0;
        System.out.println("純粋にランダム");
        for (int i = 0; i < LOOP; i++) {
            num = Ran.nextInt(10);//0-9
            Probability(num);
        }
        System.out.println(c0+"|"+c1+"|"+c2+"|"+c3+"|"+c4+"|"+c5+"|"+c6+"|"+c7+"|"+c8+"|"+c9);

        System.out.println("４，８の値を０としてカウント");
        c0=c1=c2=c3=c4=c5=c6=c7=c8=c9=0;
        for (int i = 0; i < LOOP; i++) {
            num = Ran.nextInt(10);
            Probability(num % 4 == 0 ? 0 : num);
        }
        System.out.println(c0+"|"+c1+"|"+c2+"|"+c3+"|"+c4+"|"+c5+"|"+c6+"|"+c7+"|"+c8+"|"+c9);
        System.out.println((double)c0 / (double)(c0+c1+c2+c3+c4+c5+c6+c7+c8+c9));

        System.out.println("２、４、６、８の値を０としてカウント");
        c0=c1=c2=c3=c4=c5=c6=c7=c8=c9=0;
        for (int i = 0; i < LOOP; i++) {
            num = Ran.nextInt(10);
            Probability(num % 2 == 0 ? 0 : num);
        }
        System.out.println(c0+"|"+c1+"|"+c2+"|"+c3+"|"+c4+"|"+c5+"|"+c6+"|"+c7+"|"+c8+"|"+c9);
        System.out.println(((double)(c1+c2+c3+c4+c5+c6+c7+c8+c9)) / (double)(c0+c1+c2+c3+c4+c5+c6+c7+c8+c9));

    }
    public static void Probability(int x){
        switch (x){
            case 0:
                c0++;
                break;
            case 1:
                c1++;
                break;
            case 2:
                c2++;
                break;
            case 3:
                c3++;
                break;
            case 4:
                c4++;
                break;
            case 5:
                c5++;
                break;
            case 6:
                c6++;
                break;
            case 7:
                c7++;
                break;
            case 8:
                c8++;
                break;
            case 9:
                c9++;
                break;
        }
    }
}
