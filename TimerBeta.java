ackage sample;

public class Timer {
    final static long INTERVAL = 1000;

    public static void main(String[] args) throws Exception{
        System.out.println("※この方法では正確な測定ができないので注意");
        Timer timer = new Timer();
        timer.timecount();
    }

    public void timecount() throws Exception{
        int count = 100;
        int start = count;
        long startTime = System.currentTimeMillis();
        while (count >= 0){
            if(count == 0){
                System.out.print("TIME UP");
                break;
            }
            System.out.print(count + " ");
            Thread.sleep(INTERVAL);
            count--;
            boolean isNewLine = ((start - count) % 10) == 0;
            if (isNewLine && count != 0) {
                System.out.println("");
            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("\n" + (stopTime - startTime) + "ミリ秒経過");
    }
}
