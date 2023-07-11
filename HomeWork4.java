    //Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.

import java.util.ArrayDeque;
import java.util.Deque;


public class HomeWork4 {
     public static void main(String[] args) {
       
        Deque<Integer> num1 = new ArrayDeque<>();
        num1.addLast(3);
        num1.addLast(2);
        num1.addLast(1);
        num1.addLast(-1); 

        
        Deque<Integer> num2 = new ArrayDeque<>();
        num2.addLast(5);
        num2.addLast(4);
        num2.addLast(3);

        
        Deque<Integer> product = multiply(num1, num2);
        System.out.println("Умножение: " + product);

        
        Deque<Integer> sum = sum(num1, num2);
        System.out.println("Сложение: " + sum);
    }

    public static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        
        Deque<Integer> result = new ArrayDeque<>();

        
        boolean isNegative = (num1.getLast() < 0) ^ (num2.getLast() < 0);

        
        num1.removeLast();
        num2.removeLast();

        
        int[] intermediateResults = new int[num1.size() + num2.size()];

       
        for (int i = 0; i < num1.size(); i++) {
            int digit1 = num1.removeFirst();
            int carry = 0;

            for (int j = 0; j < num2.size(); j++) {
                int digit2 = num2.removeFirst();
                int product = digit1 * digit2 + intermediateResults[i + j] + carry;

                intermediateResults[i + j] = product % 10;
                carry = product / 10;
                num2.addLast(digit2);
            }

            if (carry > 0) {
                intermediateResults[i + num2.size()] += carry;
            }

            num1.addLast(digit1);
        }

        
        int i = intermediateResults.length - 1;
        while (i >= 0 && intermediateResults[i] == 0) {
            i--;
        }

        
        if (isNegative) {
            result.addLast(-1);
        }

        while (i >= 0) {
            result.addLast(intermediateResults[i]);
            i--;
        }

        return result;
    }

    
    public static Deque<Integer> sum(Deque<Integer> num1, Deque<Integer> num2) {
       
        Deque<Integer> result = new ArrayDeque<>();

       
        

       

        int carry = 0;

       
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int sum = carry;
            if (!num1.isEmpty()){
                sum +=num1.removeFirst();
            }
            if (!num2.isEmpty()){
                sum +=num2.removeFirst();
            }

            result.addLast(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            result.addLast(carry);
        }

       
       

        return result;
    }

   
   
}
   