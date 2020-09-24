package LeetCode.CompanyTest;

public class JiadeLangchaoTest {
    private int x,y,z;

    public void JiadeLangchaoTest(){
        x = 1;
        y = 2;
        z = y - x;
    }

    public void display(){
        System.out.println("z=" + z);
    }

    public static void main(String[] args) {
        JiadeLangchaoTest t = new JiadeLangchaoTest();
        t.display();
    }
}
