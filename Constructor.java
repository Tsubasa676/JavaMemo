package inheritance;

public class Constructor {
    //アクセス修飾子なしコンストラクタ
    //初期化子について

    int n;
    String str;

    static {
        System.out.println("Constructor:\t< static > 初期化子　初インスタンス時のみ");
    }

    {
        System.out.println("Constructor:\tインスタンス 初期化子　インスタンス時");
    }

    Constructor() {
        System.out.println("Constructor:\tデフォルトのコンストラクタ");
    }

    Constructor(int n) {
        super();
        this.n = n;
        System.out.println("Constructor:引数 n = " + this.n + " のコンストラクタ");
    }

    Constructor(String str) {
        this(3);
        this.str = str;
        System.out.println("Constructor:引数 str = " + this.str + " のコンストラクタ");
    }

}

class SubC extends Constructor {
    int n;
    String str;

    static {
        System.out.println("SubC:\t< static > 初期化子　初インスタンス時のみ");
    }

    {
        System.out.println("SubC:\tインスタンス 初期化子　インスタンス時");
    }

    SubC() {
        System.out.println("SubC:\tデフォルトのコンストラクタ");
    }

    SubC(int n) {
        super();
        this.n = n;
        System.out.println("SubC:引数 n = " + this.n + " のコンストラクタ");
    }

    SubC(String str) {
        this(3);
        this.str = str;
        System.out.println("SubC:引数 str = " + this.str + " のコンストラクタ");
    }

}

class SubS extends SubC {
    int n;
    String str;

    static {
        System.out.println("SubS:\t< static > 初期化子　初インスタンス時のみ");
    }

    {
        System.out.println("SubS:\tインスタンス 初期化子　インスタンス時");
    }

    SubS() {
        System.out.println("SubS:\tデフォルトのコンストラクタ");
    }

    SubS(int n , String str) {
        this.n = n;
        this.str = str;
        System.out.println("SubS:引数 n,str = " + this.n + " , " + this.str);
    }

}
