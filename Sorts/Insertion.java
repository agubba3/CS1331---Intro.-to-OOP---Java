public class Insertion {

    public static void insertAndSort(int[] arr) {
        for(int pivot = 1; pivot < arr.length; pivot++) {
            int current = pivot-1;
            while(current >= 0 && arr[current] > arr[current + 1]) { //while the order is wrong
                int a = arr[current+1];
                arr[current + 1] = arr[current];
                arr[current] = a;
                current--; //shows that you are sorting the rest going down from the current index
                //since current decrements the element is inserted in the right place
            }
        }
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{4,7,3,4,8,1,2,9,3};
        insertAndSort(myArr);
        for(int item : myArr) {
            System.out.println(item);
        }

    }
}