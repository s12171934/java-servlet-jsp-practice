package week4.mon;

import java.util.Arrays;

public class InAndOut {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++) {
                    System.out.println("딩");
                    try { Thread.sleep(500); } catch(Exception e) {}
                }
            }
        });

        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
