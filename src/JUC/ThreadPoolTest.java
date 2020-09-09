package JUC;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {

        cachedThread ct = new cachedThread("Test");
        Executor cachedThreadPool = Executors.newCachedThreadPool();

        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct);
        Thread t3 = new Thread(ct);

        t1.setName("Thread1");
        t2.setName("Thread2");
        t3.setName("Thread3");

        cachedThreadPool.execute(t1);
        cachedThreadPool.execute(t2);
        cachedThreadPool.execute(t3);
    }
}

class cachedThread implements Runnable{

    public cachedThread(String str){
        this.str = str;
    }

    private String str;
    private int tickets = 100;

    @Override
    public void run() {
        System.out.println(str);
        while(true){
            synchronized (ThreadMyThread.class){
                if(tickets > 0){
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + ":" + tickets);

                    try {
                        Thread.sleep(5);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
