package LeetCode.CompanyTest;

import java.util.*;

public class QunaerTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Card[] cards = new Card[n];
        sc.nextLine();
        String cardsStr = sc.nextLine();
        String[] cardsArr = cardsStr.split(" ");
        for(int i = 0; i < n; i++){
            cards[i] = new Card(cardsArr[i]);
        }
        Arrays.sort(cards);
        judge(cards);
    }

    public static void judge(Card[] cards){
        boolean HuaJiaAce = false;
        boolean TongHuaShun = false;
        boolean Tonghua = false;
        boolean Sitiao = false;
        boolean hulu = false;
        boolean shunzi = false;
        int n = cards.length;
        Set colorMap = new HashSet();
        Map <Integer, Integer> valueMap = new HashMap<>();

        for(Card card : cards){
            colorMap.add(card.color);
            if(!valueMap.containsKey(card.value)) valueMap.put(card.value, 1);
            else{
                int temp  = valueMap.get(card.value);
                valueMap.put(card.value, temp + 1);
            }
        }
        if(colorMap.size() == 1){// 同花
            if(cards[0].value == 1 && cards[1].value == 10 && cards[4].value == 13){
                HuaJiaAce = true;
            }
            if(cards[n - 1].value - cards[0].value == 4){
                TongHuaShun = true;
            }
            Tonghua = true;
        }
        boolean santiao = false;

        for(int i : valueMap.keySet()){
            if (valueMap.get(i) == 4){
                Sitiao = true;
            }else if(valueMap.get(i) == 3){
                for(int ii : valueMap.keySet()){
                    if(valueMap.get(ii) == 2){
                        hulu = true;
                    }
                }
                santiao = true;
            }
        }

        if(n == 5 && cards[4].value - cards[0].value == 4 || (cards[0].value == 1 && cards[1].value == 10 && cards[4].value == 13)){
            shunzi = true;
        }
        boolean liangdui = false;
        boolean yidui = false;
        for(int i : valueMap.keySet()){
            if(valueMap.get(i) == 2){
                yidui = true;
                for(int ii : valueMap.keySet()){
                    if(valueMap.get(i) == 2 && i != ii){
                        liangdui = true;
                    }
                }
            }
        }


        if(HuaJiaAce){
            System.out.println("HuangJiaTongHuaShun");
            return;
        }
        if(TongHuaShun){
            System.out.println("TongHuaShun");
            return;
        }
        if(Sitiao){
            System.out.println("SiTiao");
            return;
        }
        if(hulu){
            System.out.println("HuLu");
            return;
        }
        if(Tonghua){
            System.out.println("TongHua");
            return;
        }
        if(shunzi){
            System.out.println("ShunZi");
            return;
        }
        if(santiao){
            System.out.println("SanTiao");
            return;
        }
        if(liangdui){
            System.out.println("LiangDui");
            return;
        }
        if(yidui){
            System.out.println("YiDui");
            return;
        }
        System.out.println("GaoPai");



    }
}

class Card implements Comparable<Card>{
    int color;
    int value;

    public Card(String str){

        int tempValue = 0;
        char temp1 = str.charAt(0);
        switch (temp1){
            case 'S':
                this.color = 1;
                break;
            case 'H':
                this.color = 2;
                break;
            case 'C':
                this.color = 3;
                break;
            case 'D':
                this.color = 4;
                break;

        }

        if(str.length() == 3){
            tempValue = 10;
        }else{
            char tempChar = str.charAt(1);
            switch (tempChar){
                case 'K':
                    tempValue = 13;
                    break;
                case 'Q':
                    tempValue = 12;
                    break;
                case 'J':
                    tempValue = 11;
                    break;
                case 'A':
                    tempValue = 1;
                    break;
                default:
                    tempValue = Integer.parseInt(str.substring(1, 2));
                    break;
            }
        }
        this.value = tempValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        if(this.value > o.value) return -1;
        else if(this.value < o.value) return 1;
        else {
            if(this.color > o.color) return -1;
            else if(this.color < o.color) return 1;
            else return 0;
        }
    }
}
