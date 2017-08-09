package sample;

public class StringUni {
    public static void main(String[] args) {
        System.out.println("----------------'A'文字コードからint型への暗黙的変換('A'は 65(0x41))-----------------");
        int a = 'A';
        System.out.println(a);//65
        System.out.println("文字 '0' は 0x30 = 48 詳しくはASCIIコード表（文字コード表）");
        a = '0';
        System.out.println(a);//48
        
        System.out.println("----------------String（参照型）の同一判定（配列も同様）-----------------");
        String str1 = new String("asd");
        String str2 = new String("asd");
        if (str1 == str2) {
            System.out.println("str1 == str2");//参照先が異なるから同一でない
        } else {
            System.out.println("str1 != str2");
        }
        if (str1.equals(str2)) {
            System.out.println("str1.equals(str2)");//文字列を比べるから同一
        } else {
            System.out.println("!(str1.equals(str2))");
        }
        
    }
}
