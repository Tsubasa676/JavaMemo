package sample;

import java.util.ArrayList;
import java.util.Collections;

public class Shichinarabe {
    private static int participants = 5;

    public static void main(String[] args) {
        System.out.println("1つのJavaファイルで七並べ");
        //Shichinarabe S = new Shichinarabe();

        Cards C = new Cards(); //トランプを用意
        Field F = new Field(); //トランプの表示形式変更
        F.cOpen(C.cards);
        Player[] P = new Player[participants];
        for (int i = 0; i < P.length; i++) {
            P[i] = new Player();
            P[i].setName("Player" + (i + 1));
        }
        int PNo = 0;
        for (int i = 0; i < C.cards.size(); i++) {
            if (PNo == participants) {
                PNo = 0;
            }
            P[PNo++].setMyHand(C.cards.get(i));
        }
        for (Player p : P) {
            System.out.print(p.getName() + "の手札：");
            for (int i = 0; i < p.myHand.size(); i++) {
                System.out.print("❑");
            }
            System.out.println();
        }
    }

}

class Cards {
    ArrayList<String> cards = new ArrayList<>();
    private int cTotal = 52;
    private int cNo = 1;
    private int cType = 100;
    Cards() {
        for(int i = 1; i <= cTotal; i++){
            if(cNo > 13) {
                cNo = 1;
                cType += 100;
            }
            if(cNo != 7){
                cards.add("" + (cNo + cType));
            }
            cNo++;
        }
        System.out.println(">トランプをシャッフルした");
        Collections.shuffle(cards);
    }

}

class Player {
    private int pass;
    private String name;
    private int lank;
    ArrayList<String> myHand = new ArrayList<>(24);

    public void setMyHand(String hand) {
        myHand.add(hand);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
    public int getPass() {
        return pass;
    }

    public void setLank(int lank) {
        this.lank = this.lank == 0 ? 1 : this.lank;
        this.lank = this.lank + lank;
    }
    public int getLank() {
        return lank;
    }
}

class Field {
    ArrayList<Integer> okList = new ArrayList<>();
    ArrayList<Integer> HList = new ArrayList<>();
    ArrayList<Integer> SList = new ArrayList<>();
    ArrayList<Integer> DList = new ArrayList<>();
    ArrayList<Integer> CList = new ArrayList<>();
    private final String[] type = {"♥" , "♠" , "♦" , "♣"};

    public void cOpen(String card) {
        cFormat(card);
        System.out.println();
    }
    public void cOpen(ArrayList<String> cards) {
        for (String card : cards) {
            cFormat(card);
        }
        System.out.println();
    }

    private void cFormat(String card) {
        try {
            int ct = Integer.parseInt(card.substring(0,1)) - 1;
            System.out.print(type[ct] + Integer.parseInt(card.substring(1,3)));
        } catch (NumberFormatException e) {
            System.out.println("エラーが発生したため終了しまｓ");
            System.exit(-1);
        }
    }

}
