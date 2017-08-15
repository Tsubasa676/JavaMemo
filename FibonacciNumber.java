package sample;

import java.math.BigDecimal;

public class FibonacciNumber {
    public static int num1 = 0;
    public static int num2 = 1;

    public static void main(String []args) {
        System.out.println("・フィボナッチ");
        System.out.println(0 + "　,　（黄金比：1.618033988749895）");
        int count = 0;
        while ( count < 30) {
            Fibonacci(num1 , num2);
            count++;
        }

        System.out.println("\n変数をひとつだけ使ってフィボナッチ(再帰)");
        for (int i = 0; i < 30; i++) {
            System.out.print(Fibonacci(i) + " ");
        }

        System.out.println();
        //小数点の桁、四捨五入等のテスト
        Round();
        int[] aaa = new int[0];
        System.out.println("aaa = " + aaa);
    }

    private static int Fibonacci(int f1) {
        return (f1==1||f1==0) ? f1 : Fibonacci(f1-2) + Fibonacci(f1-1);
    }

    static void Fibonacci(int f1 , int f2) {
        num1 = f2;
        num2 = f1 + f2;
        System.out.print(num1 + ", ");
        /*double d1 = num1;
        double d2 = num2;
        double ddd = d2 / d1;
        String after = String.format("%.10f", ddd);
        System.out.print(after);*/
    }

    static void Round() {
        //元データ
        double val = 42.195;
        //元データをBigDecimal型にする
        BigDecimal bd = new BigDecimal(val);

        //四捨五入する
        BigDecimal bd1 = bd.setScale(0, BigDecimal.ROUND_HALF_UP);  //小数第１位
        BigDecimal bd2 = bd.setScale(1, BigDecimal.ROUND_HALF_UP);  //小数第２位

        //切り捨てする
        BigDecimal bd3 = bd.setScale(0, BigDecimal.ROUND_DOWN);  //小数第１位
        BigDecimal bd4 = bd.setScale(1, BigDecimal.ROUND_DOWN);  //小数第２位

        //切り上げする
        BigDecimal bd5 = bd.setScale(0, BigDecimal.ROUND_UP);  //小数第１位
        BigDecimal bd6 = bd.setScale(1, BigDecimal.ROUND_UP);  //小数第２位

        //画面表示
        System.out.println("四捨五入（小数第１位）:" + bd1.doubleValue());
        System.out.println("四捨五入（小数第２位）:" + bd2.doubleValue());

        System.out.println("切捨て（小数第１位）:" + bd3.doubleValue());
        System.out.println("切捨て（小数第２位）:" + bd4.doubleValue());

        System.out.println("切上げ（小数第１位）:" + bd5.doubleValue());
        System.out.println("切上げ（小数第２位）:" + bd6.doubleValue());

    }
}
