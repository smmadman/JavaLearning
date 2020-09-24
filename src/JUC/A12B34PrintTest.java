package JUC;

public class A12B34PrintTest {
    public static void main(String[] args) {
        Object lock = new Object();
        a ap = new a(lock);
        b bp = new b(lock);

        Thread apT = new Thread(ap);
        Thread bpT = new Thread(bp);

        apT.start();
        bpT.start();
    }
}
class a implements Runnable{
    int i = 0;
    private Object lock;
    public a(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                if(i <= 50){
                    System.out.print(i);
                    i++;
                    System.out.print(i);
                    i++;
                    notify();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class b implements Runnable{
    char i = 'A';
    private Object lock;
    public b(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        while(true){
            synchronized (lock){
                if(i < 'Z'){
                    System.out.print(i);
                    i++;
                    notify();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}