package JUC;

public class ThreadMT {
    public static void main(String[] args) {
        ThreadMyThread t1 = new ThreadMyThread();
        ThreadMyThread t2 = new ThreadMyThread();

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
    }
}

class ThreadMyThread extends Thread{

    static private int tickets = 100;

    @Override
    public void run() {
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
