package sample;

import java.util.ArrayList;
import java.util.List;

public class ListSample {

    public static void main(String[] args) {
        //ArrayListはList（インターフェース）を実装したクラス（他にも〇〇Listがある）
        //ArrayListから〇〇Listに変換する可能性がある場合Listで宣言
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(234);
        list.add(345);

        //ArrayListのみを使う場合は、宣言ArrayListかつインスタンス生成ArrayList
        //それによりArrayList「固有のメソッド」を使える
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(987);
        arr.add(876);
        arr.add(765);

        //参照型の動作確認
        ArrayList<Integer> arr2 = arr;
        arr2.add(222);
        //参照先が同じだからarr,arr2は同じ出力になる
        System.out.println(arr);//出力：[987, 876, 765, 222]

        ArrayList<Integer> arr3 = (ArrayList<Integer>)arr.clone();
        arr3.add(333);
        System.out.println(arr);//出力：[987, 876, 765, 222]
        System.out.println(arr3);//出力：[987, 876, 765, 222, 333]


    }

}

