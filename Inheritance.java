package sample;

public class Inheritance {

    private int num = 0;

    public static void main(String[] args){
        System.out.println("----------------同一クラス内でのセッターゲッター-----------------");
        test t1 = new test();
        t1.setNum(111);
        System.out.println(t1.getNum());
        test t2 = new test();
        t2.setNum(222);
        System.out.println(t2.getNum());
        System.out.println("----------------インターフェース-----------------");
        inte inter = new inte();
        inter.display();
        System.out.println("----------------seihinA抽象クラスを継承した具象クラスのインスタンス生成-----------------");
        seihinA c = new seihinA();//抽象クラスを継承した具象クラスのインスタンス生成
        c.abs1();
        c.abs2();
        c.abs3();
        System.out.println("----------------Parent p = new Parent();-----------------");
        Parent p = new Parent();
        System.out.println("---------------- Child1 c1 = new Child1();-----------------");
        Child1 c1 = new Child1();
        System.out.println("----------------Child2 c2 = new Child2();-----------------");
        Child2 c2 = new Child2();
        System.out.println("----------------Child2 c22 = new Child2();-----------------");
        Child2 c22 = new Child2();
        System.out.println("--------------- Parent pc1 = new Child1();------------------");
        Parent pc1 = new Child1();
        System.out.println("--------------- Parent pc2 = new Child2();------------------");
        Parent pc2 = new Child2();
        //Child1 c1p = new Parent(); 親のインスタンスを子に代入できない
        System.out.println("----------------ClassCastException-----------------");
        try {
            System.out.println("Child1 cc1 = (Child1)p;親クラスのインスタンスを子クラスでキャストしている");
            Child1 cc1 = (Child1)p;//問題あり　親クラスのインスタンスを子クラスでキャストしている
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("----------------ClassCastException２-----------------");
        try {
            System.out.println("OK ： Child1 cs1 = (Child1)pc1;");
            Child1 cs1 = (Child1)pc1;//問題ない　Child1のインスタンスをChild1でキャストしている
            System.out.println("NG ： Child1 cs2 = (Child1)pc2;");
            Child1 cs2 = (Child1)pc2;//問題あり　Child2のインスタンスをChild1でキャストしている
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("--------------END-------------------");
    }

//以下インターフェース
    static class inte implements I1,I2{
        @Override
        public void display() {//必ずpublic がつく
            System.out.println("HELLO" + Iint2);
        }
    }
    interface I1 {
        //int Iint1;　　初期化しないとコンパイルエラー
        void display();//暗黙的に　public abstract void display();
        //protected void display();　public abstractが暗黙的に付与されるのでprotectedは使用できない
    }
    interface I2{
        int Iint2 = 4649;//暗黙的にstaticな変数になる public static final int Iint2 = 100;
        void display();//暗黙的に抽象メソッドになる　public abstract void display();
    }

//以下同クラス内でのgetset
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

}

//以下アブストラクト
abstract class absClass {//抽象クラス
    abstract public void abs1();
    public void abs2(){
        System.out.println("抽象クラスです");
    }
}
class seihinA extends absClass {//抽象クラスを継承した具象クラス
    public void abs1(){
        System.out.println("抽象クラスを継承した具象クラスのメソッドです");
    }
    @Override
    public void abs2() {
        super.abs2();
        System.out.println("抽象クラスですのメソッドをオーバーライド");
    }
    public void abs3(){
        System.out.println("抽象クラスを継承した具象クラスのメソッドです２");
    }
}
//普通の親子クラス
class Parent {
    // インスタンス初期化ブロック　staticの次（2番手）に実行
    {
        System.out.print("Parent インスタンス ");
    }
    // static初期化ブロック　これが最初に実行
    // static初期化ブロックは"クラスロード時"に"自動的"に"一度だけ実行"され、オーバーライドできない。
    static {
        System.out.println("Parent static一度きり ");
    }
    //コンストラクタ　staticとインスタンス初期化の次（3番手）に実行
    public Parent() {
        System.out.println("Parent コンストラクタ ");
    }
}
class Child1 extends Parent {
    // インスタンス初期化ブロック
    {
        System.out.print("Child1 インスタンス ");
    }
    // static初期化ブロック
    // static初期化ブロックは複数インスタンス生成したとしても、最初にインスタンス生成した時しか処理されない。
    static {
        System.out.println("Child1 static一度きり ");
    }
    public Child1() {
        System.out.println("Child1 コンストラクタ ");
    }
}
class Child2 extends Parent {
    // インスタンス初期化ブロック
    {
        System.out.print("Child2 インスタンス ");
    }
    // static初期化ブロック
    static {
        System.out.println("Child2 static一度きり ");
    }

    public Child2() {
        System.out.println("Child2 コンストラクタ ");
    }
}
