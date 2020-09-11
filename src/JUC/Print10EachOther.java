package JUC;

public class Print10EachOther {
    public static void main(String[] args) {
        MyThreadPrint myThreadPrint = new MyThreadPrint();

        Thread t1 = new Thread(myThreadPrint);
        Thread t2 = new Thread(myThreadPrint);

        t1.setName("T1");
        t2.setName("T2");

        t1.start();
        t2.start();
    }
}

class MyThreadPrint implements Runnable{

    int i = 10;

    @Override
    public void run() {
        synchronized (this){
            while(i >= 0){

                notify();

                System.out.println(Thread.currentThread().getName() +": "+ i--);

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
