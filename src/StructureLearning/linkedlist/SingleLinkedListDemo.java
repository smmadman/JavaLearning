package StructureLearning.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

//        HeroNode updateHero1 = new HeroNode(1, "songjiang", "jishiyu");
//        HeroNode updateHero2 = new HeroNode(2, "lujunyi", "yuqilin");
//        HeroNode updateHero6 = new HeroNode(6, "luzhishen", "huaheshang");

//        System.out.println("After updating a invalid hero.");
//        singleLinkedList.updataByNumber(updateHero1);

        singleLinkedList.addByNumber(hero1);
        singleLinkedList.addByNumber(hero2);
        singleLinkedList.addByNumber(hero3);
        singleLinkedList.addByNumber(hero4);

        System.out.println("After create 4 heroes");

        singleLinkedList.showSingleList();

//        System.out.println("After updating.");
//
//        singleLinkedList.updateByNumber(updateHero1);
//        singleLinkedList.updateByNumber(updateHero2);
//        singleLinkedList.updateByNumber(updateHero6);
//
//        singleLinkedList.showSingleList();
//
//        System.out.println("After deleting.");
//
//        singleLinkedList.deleteByNumber(hero3);
//        singleLinkedList.deleteByNumber(hero4);
//
//        singleLinkedList.showSingleList();

        System.out.println("After reverse:");
        singleLinkedList.reverse1();
        singleLinkedList.showSingleList();
        System.out.println("Reverse printing:");
        singleLinkedList.reversPrint();

    }
}

class SingleLinkedList{
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByNumber(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            else if(temp.next.number > heroNode.number){
                break;
            }
            else if(temp.next.number == heroNode.number){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("There has already been this value, can not add this object.");
        }
        else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void updateByNumber(HeroNode updateHeroNode){
        if(head.next == null){
            System.out.println("The list is empty.");
            return;
        }

        boolean flag = false;
        HeroNode temp = head;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.number == updateHeroNode.number){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.nickname = updateHeroNode.nickname;
            temp.name = updateHeroNode.name;
        }
        else{
            System.out.println("There is no hero's number equals to this hero's number.");
        }
    }

    public void deleteByNumber(HeroNode deleteHero){
        if (head.next == null){
            System.out.println("The list is empty.");
            return;
        }

        boolean flag = false;
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            else if(temp.next.number == deleteHero.number){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }
        else{
            System.out.println("There is no hero's number equal to this hero's number.");
        }
    }

    public void showSingleList(){
        if(head.next == null){
            System.out.println("List is empty.");
            return;
        }

        HeroNode temp = head.next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void reverse1(){
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "","");
        HeroNode cur = this.head.next;
        HeroNode cur_next = null;

        while(cur != null){ // 头插法
            cur_next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = cur_next;
        }
        head.next = reverseHead.next;
    }
    public void reversPrint(){
        if(head.next == null){
            return;
        }

        Stack<HeroNode> stack = new Stack<HeroNode>();

        HeroNode cur = head.next;

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while(stack.size() > 0){
            cur = stack.pop();
            System.out.println(cur);
        }
    }
}

class HeroNode{
    public int number;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int Number, String Name, String Nickname){
        this.number = Number;
        this.name = Name;
        this.nickname = Nickname;
    }

    public String toString(){
        return "HeroNode [no=" + number + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
