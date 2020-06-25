package StructureLearning.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubliLinkedList{
    private HeroNode2 head =new HeroNode2(0, "", "");
    
}

class HeroNode2{
    public int number;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode pre;

    public HeroNode2(int Number, String Name, String Nickname){
        this.number = Number;
        this.name = Name;
        this.nickname = Nickname;
    }

    public String toString(){
        return "HeroNode2 [no=" + number + ", name=" + name + ", nickname=" + nickname + "]";
    }
}