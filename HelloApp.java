package helloapp;

//import java.util.Scanner;

public class HelloApp {
 
    public static void main(String[] args) {
           
//        try (Scanner in = new Scanner(System.in)) {
//            System.out.print("Input name: ");
//            String name = in.nextLine();
//            System.out.print("Input age: ");
//            int age = in.nextInt();
//            System.out.print("Input height: ");
//            float height = in.nextFloat();
//            System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
//        }
//        try {
//            int[] numbers = new int[3];
//            numbers[4]=45;
//            System.out.println(numbers[4]);
//        }
//        catch(ArrayIndexOutOfBoundsException ex){
//
//            System.out.println("Выход за пределы массива");
//        }
//        finally{
//            System.out.println("Блок finally");
//        }
//        System.out.println("Программа завершена");        

        Person undef;
        undef = new Person();
        undef.displayInfo();
         
        Person Anders; // создание объекта
        Anders = new Person("Anders", 46);
        Anders.displayInfo();
         
    }
     
}
