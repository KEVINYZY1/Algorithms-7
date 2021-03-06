package Ch_2_4_Priority_Queues;

import static Tool.ArrayGenerator.*;
import edu.princeton.cs.algs4.StdOut;

public class Practise_2_4_13 {
    static class MaxPQ<Key extends Comparable<Key>> {
        private Key[] keys;
        private int size;
        @SuppressWarnings("unchecked")
        public MaxPQ(int N) {
            keys = (Key[])new Comparable[N + 1];
        }
        public boolean isEmpty() { return size == 0; }
        public void insert(Key key) {
            keys[++size] = key;
            swim(size);
        }
        public Key delMax() {
            Key max = keys[1];
            keys[1] = keys[size--];  // 使用 key[size] 作为哨兵
            sink(1);
            keys[size + 1] = null;
            return max;
        }
        private void sink(int k) {
            while ((k << 1) <= size) {
                int j = k << 1;
                if (less(j, j + 1)) j++; // 使用 key[size] 作为哨兵
                if (greaEqual(k, j)) break;
                exch(k ,j);
                k = j;
            }
        }
        private void swim(int k) {
            while (k > 1 && less(k >> 1, k)) {
                exch(k >> 1, k);
                k >>= 1;
            }
        }
        private void exch(int i, int j) {
            Key t = keys[i]; keys[i] = keys[j]; keys[j] = t;
        }
        private boolean less(int i, int j) {
            return keys[i].compareTo(keys[j]) < 0;
        }
        private boolean greaEqual(int i, int j) {
            return keys[i].compareTo(keys[j]) >= 0;
        }
    }
    public static void main(String[] args) {
        for (int i = 10; i <= 50; i++) {
            MaxPQ<Integer> pq = new MaxPQ<Integer>(i);
            for (Integer ii : Integers(0, i - 1)) {
                pq.insert(ii);
            }
            while (!pq.isEmpty())
                StdOut.print(pq.delMax() + " ");
            StdOut.println();
        }
    }
    // output
    /*
     *  9 8 7 6 5 4 3 2 1 0 
        10 9 8 7 6 5 4 3 2 1 0 
        11 10 9 8 7 6 5 4 3 2 1 0 
        12 11 10 9 8 7 6 5 4 3 2 1 0 
        13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 
        49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 

     */
}
