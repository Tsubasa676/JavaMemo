package sample;

public class StringUni {
    public static void main(String[] args) {
        System.out.println("----------------'A'文字コードからint型への暗黙的変換('A'は 65(0x41))-----------------");
        int a = 'A';
        System.out.println(a);//65
        System.out.println("文字 '0' は 0x30 = 48 詳しくはASCIIコード表（文字コード表）");
        a = '0';
        System.out.println(a);//48

        System.out.println("\n----------------String（参照型）の同一判定（配列も同様）-----------------");
        String str1 = new String("asd");
        String str2 = new String("asd");
        System.out.println("str1 != str2      :\t" + (str1 != str2));
        System.out.println("str1.equals(str2) :\t" + (str1.equals(str2)));//文字列を比べるから同一

        System.out.println("\n----------------String（参照型）length()isEmpty()contains()----------------");
        String str3 = "hogehoge";
        System.out.println("str3 =\t" + str3 + "\t文字数:\t" + str3.length());
        str3 = "";//参照先を変える
        System.out.println("str3=[" + str3 + "]は空文字？：" + str3.isEmpty());
        System.out.println("※isEmpty()ではnullは判定できない。\n　StringUtilsクラスを利用すればnullも判定可能でそれらのライブラリをインストール・インポートする必要あり");
        str3 = "hogepiyo";
        System.out.println("str3=[" + str3 + "]に”piyo”は含まれる？：" + (str3.contains("piyo")));

        System.out.println("\n----------------String StringBuilder文字列の結合 concat()append()----------------");
        String str4 = "hoge3";
        String str5 = "piyo3";
        String scon = str4.concat(str5);
        System.out.println("str4 = " + str4 + "\tstr5 = " + str5);
        System.out.println("scon = str4.concat(str5) : " + scon);
        StringBuilder sb1 = new StringBuilder(str4);
        System.out.println("sb1.append(str5) :\t" + sb1.append(str5));
        System.out.println("concat() より append()　の方が結合処理が早い");
        System.out.println("String型は一度宣言すると変更できず無駄になるので、可変長になるなら");
        System.out.println("StringBuilder（シングルスレッド）やStringBufffer（マルチスレッド）を使う");

        System.out.println("\n----------------String　空白の削除----------------");
        String str6 = " 半 全　半 全　タ\tブ全　改\n行全　\t\n";
        System.out.println("str6\n「" + str6 + "」\n => \n「" + str6.trim() + "」");
        System.out.println("trim()で消えるのは文字列前後の半角スペース,\\t,\\nが消える。文字列内では無効");

        System.out.println(" - END -");

    }
}
