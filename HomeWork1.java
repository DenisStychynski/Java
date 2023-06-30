import java.util.Scanner;

public class HomeWork1 {

    public static void main(String[] args) {
        // TriangleNumberAndFactorial();
        // OutputNumberSimple();
        // Calculator();
        RestoreExpression();
    }
//    1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    static int getTriangleNumber(int n) {
        int sum = 0;
        for (int index = 0; index < n; index++) {
            sum += index + 1;
        }
        return sum;
    }

    static int getFactorial(int n) {
        int result = 1;
        for (int index = 0; index < n; index++) {
            result *= index + 1;
        }
        return result;
    }

    static void  TriangleNumberAndFactorial(){
        Scanner scn = new Scanner(System.in);
        int n = 0;
        System.out.printf("Enter natural number: ");
        if (!scn.hasNextInt()) {
            System.out.println("You entered wrong number!");
        } else {
            n = scn.nextInt();
            if (n < 1)
                System.out.println("You should enter positive number only!");
            else {
                System.out.printf("The triangle number of %d is: %s ", n, getTriangleNumber(n));
                System.out.println();
                System.out.printf("The factorial of %d is: %s ", n, getFactorial(n));
            }
        }
        scn.close();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 2) Вывести все простые числа от 1 до 1000
    static boolean NumberSimple(int n) {
        for (int index = 2; index < n; index++) {
            if (n % index == 0 )
                return false;
        }
        return true;

    }
    static void OutputNumberSimple(){
        StringBuilder st = new StringBuilder();
        st = st.append("1");
        for (int i = 2; i < 1000; i++) {
            if (NumberSimple(i))
                st = st.append(", ").append(i);
        }
    System.out.println("This is order of simple numbers from 1 to 1000:");   
    System.out.println(st);   
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 3) Реализовать простой калькулятор


    static int getSum(int a, int b) {
        return a + b;
    }

    static int getSubtraction(int a, int b) {
        return a - b;
    }

    static int getProduct(int a, int b) {
        return a * b;
    }

    static double getDivision(int a, int b) {
        return (double) a / (double) b;
    }

    static void printResultOfOperation(int a, int b, String signOperation) {
        switch (signOperation) {
        case "+":
            System.out.printf("%d %s %d = %d \n", a, signOperation, b, getSum(a, b));
            break;
        case "-":
            System.out.printf("%d %s %d = %d \n", a, signOperation, b, getSubtraction(a, b));
            break;
        case "*":
            System.out.printf("%d %s %d = %d \n", a, signOperation, b, getProduct(a, b));
            break;
        case "/":
            if (b != 0) {
                System.out.printf("%d %s %d = %.4f \n", a, signOperation, b, getDivision(a, b));
            } else {
                System.out.println("ERROR: division by zero!!!");
            }
            break;
        }
    }

    static void Calculator() {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Enter first number: ");
        int a = 0;
        if (!scn.hasNextInt()) {
            System.out.println("You entered wrong number!!!");
        } else {
            a = scn.nextInt();
            Scanner sc = new Scanner(System.in);
            System.out.printf("Enter sign of operation from list: +, -, *, / \n");
            String signOperation = "";
            if (sc.hasNextLine()) {
                signOperation = sc.nextLine();
            }
            if (signOperation.equals("+") || signOperation.equals("-") || signOperation.equals("*")
                    || signOperation.equals("/")) {
                int b = 0;
                System.out.printf("Enter second number: ");
                if (!scn.hasNextInt()) {
                    System.out.println("You entered wrong number!!!");
                } else {
                    b = scn.nextInt();
                    printResultOfOperation(a, b, signOperation);
                }
            } else {
                System.out.println("You entered wrong operation!!!");
            }
            scn.close();
            sc.close();
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства.
//  Предложить хотя бы одно решение или сообщить, что его нет.
     static boolean isRightEquation(String q, String w, String e) {
        int a = Integer.parseInt(q);
        int b = Integer.parseInt(w);
        int c = Integer.parseInt(e);
        if (a + b == c) {
            return true;
        }
        return false;
    }

     static void RestoreExpression () {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Enter equition as (q + w = e): ");
        String equation = scn.nextLine();
        equation = equation.replace(" ", "");
        String[] numbersArray = equation.split("[+=]");
        boolean isCorrectInput = true;

        for (String element : numbersArray) {
            element = element.replace("?", "0");
            int number = Integer.parseInt(element);
            if (number < 0) {
                isCorrectInput = false;
                break;
            }           
        }

        if (!isCorrectInput || numbersArray.length != 3) {
            System.out.println("You enter wrong equation!!!");
        } else {
            boolean isSolution = false;
            for (int x = 0; x < 10; x++) {
                String[] tempArray = numbersArray.clone();
                for (int i = 0; i < 3; i++) {
                    String c = Integer.toString(x);
                    tempArray[i] = tempArray[i].replace("?", c);
                }

                if (isRightEquation(tempArray[0], tempArray[1], tempArray[2])) {
                    System.out.printf("%s + %s = %s", tempArray[0], tempArray[1], tempArray[2]);
                    isSolution = true;
                    break;
                }                
            }
            if (! isSolution) {
               System.out.println("Solution of equation is absent!!!"); 
            } 
        }
        scn.close();
    }
}














