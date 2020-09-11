package JUC;

public class RunnableMT {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread t1  =new Thread(myThread);
        Thread t2 = new Thread(myThread);

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {

    int i = 100;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(i > 0){
                    i--;
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
