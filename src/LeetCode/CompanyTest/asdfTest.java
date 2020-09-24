package LeetCode.CompanyTest;

public class asdfTest extends Thread{
    String name;
    public static void main(String argv[]){
        asdfTest t = new asdfTest();
        t.execute();
    }

    asdfTest(){}
    asdfTest(String name){
        this.name = name;
    }
    public String getThreadName(){
        return name;
    }

    public void execute(){
        asdfTest first = new asdfTest("one");
        first.start();
        asdfTest second = new asdfTest("two");
        second.start();
    }

    public void start(){
        for(int i = 0; i < 2; i++){
            System.out.println(this.getThreadName() + i);
        }
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}
