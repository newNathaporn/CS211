

import java.util.PriorityQueue;
import java.util.Random;

public class Sorter {
    private static int[] genRandomArray(int size){
        System.out.println("Generating random number");
        int [] arr = new int [size];
        Random ran = new Random();
        for (int i = 0; i < size ; i++){
            arr[i] = ran.nextInt(100);
            System.out.println (" \t No. " + i + " : " + arr[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        int ranArr [] = genRandomArray(20);
        PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
        for (int data:ranArr){
            pq.offer(data);
        }
        while (pq.peek() != null){
            System.out.println("Taking : " + pq.poll());
        }
  }
}
