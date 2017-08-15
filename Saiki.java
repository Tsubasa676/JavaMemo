package sample;

public class Saiki {
    public static void main(String[] args){
        int no = 4;
        int co = 1;
        System.out.println("・「" + no +"」を使った再帰");
        Saiki(no , co);
    }

    private static void Saiki(int no, int co) {
        for(int i = 1; i <= no; i++){
            if(co!=1) {
                for (int j = 1; j < co; j++) {
                    System.out.print("   ");
                }
            }
            //System.out.println("i = " + i);
            System.out.println(i);
            if(no != co){
                co ++;
                Saiki(no,co);//これ呼ばれた後
                co--;//デクリメント
            }
        }
    }
}
