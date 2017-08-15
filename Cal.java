package sample;

import java.util.Random;
import static java.lang.Thread.sleep;

public class Cal {
    //変数を用意する
    final private static String WEEK = "Sun Mon Tue Wed Thu Fri Sat";//日曜日からのスタート
    private static int year = 0;  //表示したい年、
    private static int month = 0;    //月のカレンダー指定
    private static final int BEGIN_YEAR = 1873;  //定数
    private static final int END_YEAR = 3000;  //定数
    private static int total = 0;    //1873/01/01から指定した前月までの総日数
    private static int weekend = 0;  //カレンダー表示時の改行指定
    final private static String SPACE= "    ";//カレンダー表示時、1日が始まるまでの間を埋める
    private static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};//1～12月の各日数（平年時）
    private static Random Ra = new Random();
    
    public static void main(String[] args){
        
        System.out.println("出力を開始");
        //好きな年・月を指定する。
        System.out.println("有効範囲：年「1873 ～ 3000 」月「1 ～ 12 」");
        year = Ra.nextInt(1127) + BEGIN_YEAR;
        month = Ra.nextInt(13);

        month--;//指定月が中央に来るように
        for(int i = 0; i < 3; i++){
            //年月妥当チェック
            //System.out.println("指定した「年：" + year + " 」「月：" + month + " 」をチェック");
            cheackYearMonth(year , month);
            //totalを求める処理
            totalDays(year,month);
            System.out.println("1873/1から" + total + "日経過");
            //カレンダーを出力
            calPrint();
            month++;
        }
        //END
        System.gc();
        System.out.println("\n\n終わり");
    }

    private static void cheackYearMonth(int y, int m) {
        //if3000年で月が12だった時の処理が必要
        if(m == 0 && year > BEGIN_YEAR){
            month = 12;
            year -= 1;
        }else if(m == 0 && year == BEGIN_YEAR){
            month = 1;
        }else if(m < 1 || m > 12){
            month = 1;
            year += 1;
        }
        if(y < BEGIN_YEAR){
            year = BEGIN_YEAR;
        }else if(y > END_YEAR){
            year = END_YEAR;
        }
        if(false /* y != year || m != month  一時無効化 */){
            System.out.print("　　　　");
            if(y != year){
                System.out.print("「年：" + year + " 」");
            }
            if(m != month){
                System.out.print("「月：" + month + " 」に変更されました");
            }
            System.out.println("");
        }
    }

    private static void totalDays(int year , int month){
        total = 0;//値の初期化
        for(int i = 1873; i < year; i++){//1873年から指定の前年までの日数を求めて
            total += isLeapYear(i) ? 366: 365; //i年が閏年か否かを判断してtotalに足していく
        }
        for(int i = 0; i < month-1; i++) {//指定年1月から指定の前月までの日数を足して総日数を求める
            if (isLeapYear(year) && i == 1) {
                total += 29;     //指定した年が閏年で2月をカウントするなら29日分足す
            } else {
                total += days[i];
            }
        }
        if(month == 2 && isLeapYear(year)){//もし指定した年月が「閏年かつ2月」
            days[1] = 29;//だったら、2月の日数を29日に変更する
        }
    }

    private static void calPrint(){
        System.out.print("★" + year + "年 " + month + "月のカレンダー");
        System.out.println("(" + (isLeapYear(year)?"閏年":"平年") + ")★\n" + WEEK);
        weekend = 0;//値の初期化
        for(int i = 0; i < (total + 3) % 7; i++){ //1日が始まるまでスペースで埋める
            //(total + 3) % 7の部分
            //1日が日曜なら余り０、月曜なら余り１、火曜なら余り２...てな感じにするために「+3」して(total + 3) % 7
            weekend++; //　カウント：何日目／７日間（一週間）
            System.out.print(SPACE);
        }
        for(int day = 1; day <= days[month-1]; day++) { //指定した月の日数分ループ
            weekend++; //　カウント：何日目／７日間（一週間）
            try {
                sleep(0);
            } catch (InterruptedException e) {
                System.out.println(e);
            }//スリープ
            if (day < 10) {
                System.out.print("  " + day + " ");//桁合わせるための処理
            } else {
                System.out.print(" " + day + " ");
            }
            if (weekend == 7) { //土曜日の日を表示したから
                System.out.println("");//改行して
                weekend = 0;    //カウントを初期化
            }
        }
        if(weekend != 0)
            System.out.println("");
    }

    private static boolean isLeapYear(int year) { //うるう年（LeapYear）の判定
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);//true or false
    }

}
