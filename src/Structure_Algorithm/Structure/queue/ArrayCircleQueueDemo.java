package Structure_Algorithm.Structure.queue;

import java.util.Scanner;

public class ArrayCircleQueueDemo {
    public static void main(String[] args) {
        ArrayCircleQueue aCQ = new ArrayCircleQueue(4);

        aCQ.queueTest();
    }
}

class ArrayCircleQueue{
    int maxsize;
    int rear;
    int front;
    int[] arr;

    public ArrayCircleQueue(int maxSize){
        maxsize = maxSize;
        rear = -1;
        front = -1;

        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear - front == maxsize;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int data){
        if (isFull()){
            System.out.println("Error: The queue is full.");
            return;
        }

        rear++;
        arr[rear % maxsize] = data;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("Error: The queue is empty.");
        }

        front++;
        return arr[front % maxsize];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("Show method: The queue is empty.");
        }
        else{
            int amount = rear - front;
            for(int i = 1; i <= amount;i ++){
                System.out.println(arr[(front+i) % maxsize]);
            }
            System.out.println();
        }
    }

    public void showRearFront(){
        System.out.println("Rear: "+rear+"   Front: "+front);
    }

    public void queueTest(){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到a队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("r(show-rear-front)");
            char key = scanner.next().charAt(0);
            int res;
            switch(key) {
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    this.addQueue(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        res = this.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 's':
                    this.showQueue();
                    break;
                case 'r':
                    this.showRearFront();
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
