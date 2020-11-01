package com.mycompany.hackerrank;

import java.util.*;

//public class Solution {

    //First test
    // Complete the compareTriplets function below.
//    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
//        int alice = 0;
//        int bob = 0;
//        int index = 0;
//        for (int value : a) {
//            if (value > b.get(index)) {
//                alice = alice + 1;
//            }
//            if (value < b.get(index)) {
//                bob = bob + 1;
//            }
//            index = index + 1;
//        }
//        List<Integer> result = new ArrayList<>();
//        result.add(alice);
//        result.add(bob);
//        return result;
//        }
//    
//    public static void main(String[] args) throws IOException {
//        List<Integer> a = new ArrayList<>();
//        a.add(5);
//        a.add(6);
//        a.add(7);
//        List<Integer> b = new ArrayList<>();
//        b.add(3);
//        b.add(6);
//        b.add(10);
//        List<Integer> result = compareTriplets(a, b);
//        System.out.println(result);
//    }
    
    //Second test
//    static long aVeryBigSum(long[] ar) {
//        long sum = 0;
//        for (long i : ar) {
//            sum = i + sum;
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) throws IOException {
//        int arCount = 5;
//        long[] ar = new long[arCount];
//        String[] arItems = new String[] {"1000000001","1000000002","1000000003","1000000004","1000000005"};
//        for (int i = 0; i < arCount; i++) {
//            long arItem = Long.parseLong(arItems[i]);
//            ar[i] = arItem;
//        }   
//        long result = aVeryBigSum(ar);
//        System.out.println(result);
//    }
    
//}

class Result {
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
        int indexRight = 0;
        int stringNumber = 0;
        int sumLeft = 0;
        int sumRight = 0;
        int valueLeft;
        int valueRight;
        for (List<Integer> counter : arr) {
            valueLeft = counter.get(stringNumber);
            if (stringNumber == 0) {
                indexRight = counter.size() - 1;
            } else {
                indexRight = indexRight - 1;
            }
            valueRight = counter.get(indexRight);
            stringNumber = stringNumber + 1;
            sumLeft = sumLeft + valueLeft;
            sumRight = sumRight + valueRight;
        }
        return Math.abs(sumLeft - sumRight);
    }
}

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> String1= new ArrayList<>();
        String1.add(11);
        String1.add(2);
        String1.add(4);
        List<Integer> String2 = new ArrayList<>();
        String2.add(4);
        String2.add(5);
        String2.add(6);
        List<Integer> String3 = new ArrayList<>();
        String3.add(10);
        String3.add(8);
        String3.add(-12);
        
        arr.add(String1);
        arr.add(String2);
        arr.add(String3);
        
        int result = Result.diagonalDifference(arr);
        System.out.println(result);
    }
}
