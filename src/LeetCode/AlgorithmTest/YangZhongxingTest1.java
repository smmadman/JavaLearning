package LeetCode.AlgorithmTest;

public class YangZhongxingTest1 {
    public void printA(){
        System.out.println("baseA");
    }

    private void printB(){
        System.out.println("baseB");
    }

    public void printAB(){
        printA();
        printB();
    }
}

class derived extends YangZhongxingTest1{
    public void printA(){
        System.out.println("Derived A");
    }

    private void printB(){
        System.out.println("Dervied B");
    }

    public static void main(String[] args) {
        derived de = new derived();
        de.printAB();
    }
}
