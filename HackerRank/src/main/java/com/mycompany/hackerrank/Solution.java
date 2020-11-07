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

//Third test
//class Result {
//    /*
//     * Complete the 'diagonalDifference' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
//     */
//    public static int diagonalDifference(List<List<Integer>> arr) {
//    // Write your code here
//        int indexRight = 0;
//        int stringNumber = 0;
//        int sumLeft = 0;
//        int sumRight = 0;
//        int valueLeft;
//        int valueRight;
//        for (List<Integer> counter : arr) {
//            valueLeft = counter.get(stringNumber);
//            if (stringNumber == 0) {
//                indexRight = counter.size() - 1;
//            } else {
//                indexRight = indexRight - 1;
//            }
//            valueRight = counter.get(indexRight);
//            stringNumber = stringNumber + 1;
//            sumLeft = sumLeft + valueLeft;
//            sumRight = sumRight + valueRight;
//        }
//        return Math.abs(sumLeft - sumRight);
//    }
//}
//
//public class Solution {
//    public static void main(String[] args) {
//        List<List<Integer>> arr = new ArrayList<>();
//        List<Integer> String1= new ArrayList<>();
//        String1.add(11);
//        String1.add(2);
//        String1.add(4);
//        List<Integer> String2 = new ArrayList<>();
//        String2.add(4);
//        String2.add(5);
//        String2.add(6);
//        List<Integer> String3 = new ArrayList<>();
//        String3.add(10);
//        String3.add(8);
//        String3.add(-12);
//
//        arr.add(String1);
//        arr.add(String2);
//        arr.add(String3);
//
//        int result = Result.diagonalDifference(arr);
//        System.out.println(result);
//    }
//}

//Fourth test
//public class Solution {
//    /*
//     * Complete the simpleArraySum function below.
//     */
//    static int simpleArraySum(int[] ar) {
//        int result = Arrays.stream(ar).sum();
//        return result;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int arCount = Integer.parseInt(scanner.nextLine().trim());
//
//        int[] ar = new int[arCount];
//
//        String[] arItems = scanner.nextLine().split(" ");
//
//        for (int arItr = 0; arItr < arCount; arItr++) {
//            int arItem = Integer.parseInt(arItems[arItr].trim());
//            ar[arItr] = arItem;
//        }
//
//        int result = simpleArraySum(ar);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//    }
//}

//Fifth test
//public class Solution {
//
//    // Complete the plusMinus function below.
//    static void plusMinus(int[] arr) {
//        long positiveCount = Arrays.stream(arr).filter(s->s>0).count();
//        long negativeCount = Arrays.stream(arr).filter(s->s<0).count();
//        long zeroCount = Arrays.stream(arr).filter(s->s==0).count();
//        double positiveRatio = (double)positiveCount/arr.length;
//        double negativeRatio = (double)negativeCount/arr.length;
//        double zeroRatio = (double)zeroCount/arr.length;
//        System.out.println(new DecimalFormat("#0.000000").format(positiveRatio));
//        System.out.println(new DecimalFormat("#0.000000").format(negativeRatio));
//        System.out.println(new DecimalFormat("#0.000000").format(zeroRatio));
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        plusMinus(arr);
//
//        scanner.close();
//    }
//}

//Sixth Test
//public class Solution {
//
//    // Complete the staircase function below.
//    static void staircase(int n) {
//        for (int i = 1; i < n+1; i++) {
//            for (int y = n-i; y > 0; y--) {
//                System.out.print(" ");
//            }
//            for (int y = 1; y < i+1; y++) {
//                System.out.print("#");
//            }
//            System.out.println();
//        }
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        staircase(n);
//
//        scanner.close();
//    }
//}

//Test Seven
//public class Solution {
//
//    static void weird(int n) {
//        boolean b = (n%2 != 0);
//        if(b) {
//            System.out.println("Weird");
//        }
//        else {
//            if ((n >= 2) & (n <= 5)) {
//                System.out.println("Not Weird");
//            }
//            if ((n >= 6) & (n <= 20)) {
//                System.out.println("Weird");
//            }
//            if (n > 20) {
//                System.out.println("Not Weird");
//            }
//        }
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        weird(n);
//
//        scanner.close();
//    }
//}

//Test Eight без использования regex :)
//class UsernameValidator {
//
//    public static String regularExpression = null;
//
//    public static String Validator(String username) {
//        char[] arr = username.toCharArray();
//        //Проверка на длину имени
//        if (username.length() < 8) return regularExpression = "Invalid";
//        if (username.length() > 30) return regularExpression = "Invalid";
//        //Проверка на буквы, цифры, знак подчеркивания и первый символ
//        boolean flag = true;
//        for (int i = 0; i < arr.length; i++) {
//            int ascii = arr[i];
//            if (i==0) {
//                if (((ascii >= 48) && (ascii <= 57)) || (ascii == 95)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if ((ascii >= 48) && (ascii <= 57)) {}
//            else if ((ascii >= 65) && (ascii <= 90)) {}
//            else if (ascii == 95) {}
//            else if ((ascii >= 97) && (ascii <= 122)) {}
//            else {
//                flag = false;
//                break;
//            }
//        }
//        if (!flag) return regularExpression = "Invalid";
//        else return regularExpression = "Valid";
//    }
//
//}
//
//public class Solution {
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        String[] arr = new String[n];
//        for (int i = 0; i < arr.length; i++)
//        {
//            String Item = scanner.nextLine();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//            arr[i] = Item;
//        }
//
//        scanner.close();
//
//        for (int i = 0; i < arr.length; i++)
//        {
//            String result = UsernameValidator.Validator(arr[i]);
//            System.out.println(result);
//        }
//
//    }
//}

//Test Eight - с использованием regex (20 баллов на HackerRank за это задание)
//class UsernameValidator {
//
//    public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9-_]{7,29}$";
//}
//
//public class Solution {
//    private static final Scanner scan = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = Integer.parseInt(scan.nextLine());
//        while (n-- != 0) {
//            String userName = scan.nextLine();
//
//            if (userName.matches(UsernameValidator.regularExpression)) {
//                System.out.println("Valid");
//            } else {
//                System.out.println("Invalid");
//            }
//        }
//    }
//}
