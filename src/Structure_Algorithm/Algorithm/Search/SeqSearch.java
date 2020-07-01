package Structure_Algorithm.Algorithm.Search;

public class SeqSearch {//顺序查找,数组可无序
    public static void main(String[] args) {

    }

    public static int seqSearch(int[] arr, int find_value){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == find_value){
                return i;
            }
        }

        return -1;
    }

}
