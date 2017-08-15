package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSample {
    public static void main(String[] args) throws IOException {

        String spath = "C:\\Users\\xxx\\Desktop\\java";
        File dir = null;
        File file = null;

        try {
            dir = new File(spath);
            if (dir.mkdir() == true) {
                System.out.println("ディレクトリ作成成功");
            } else {
                System.out.println("ディレクトリ作成失敗");
            }
            if (dir.exists() == true) {
                System.out.println(dir.toString() + "     \t<は存在します\n");
            } else {
                System.out.println(dir.toString() + " <は存在しません\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            file = new File(spath + "\\java.txt");
            if (file.createNewFile() == true) {
                System.out.println("ファイル作成成功");
            } else {
                System.out.println("ファイル作成失敗");
            }
            if (file.exists() == true) {
                System.out.println(file.toString() + " <は存在します\n");
            } else {
                System.out.println(file.toString() + " <は存在しません\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.print("「" + dir.toString() + "」の作成日時は：");
            Path path = Paths.get(spath);
            System.out.println(Files.getAttribute(path, "creationTime") + " でした。\n");
        } catch (Exception e) {
            System.out.println("\nエラー：：" + e + "\n");
        }

        try {
            // PrintWriterクラス 追記モード
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.println("その１");
            pw.println("その２");
            pw.println("その３");
            pw.close();
            //FileWriterクラスのみ　追記モード
            FileWriter fw = new FileWriter(file, true);
            fw.write("おはようございます\n");
            fw.write("こんにちは\n");
            fw.write("こんばんは\n");
            fw.close();
            System.out.println("追記完了しました。文字コードの指定をする必要あり\n");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("- END -");
        
    }
}
