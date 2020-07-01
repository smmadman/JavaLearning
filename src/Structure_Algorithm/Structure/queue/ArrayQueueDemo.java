package Structure_Algorithm.Structure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue aQ = new ArrayQueue(10);

        aQ.queueTest();
    }
}

class ArrayQueue{
    int maxsize;
    int rear;
    int front;
    int[] arr;

    public ArrayQueue(int maxSize){
        maxsize = maxSize;
        rear = -1;
        front = -1;

        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear == maxsize-1;
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
        arr[rear] = data;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("Error: The queue is empty.");
        }

        front++;

        int temp = arr[front];

        if (isEmpty()){
            front = -1;
            rear = -1;

            for (int i: arr){
                i = 0;
            }
        }
        else{
            front -= 1;
            for (int i=0; i<rear; i++){
                arr[i] = arr[i+1];
                if (i == rear-1){
                    arr[i+1] = 0;
                }
            }
            rear -= 1;
        }
        return temp;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("Show method: The queue is empty.");
        }
        else{
            for(int i: arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void queueTest(){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到a队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
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
            }
        }
        System.out.println("程序退出~~");
    }
}
