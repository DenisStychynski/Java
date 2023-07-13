// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class HomeWork5 {
    public static void main(String[] args) {
numbersAndSubscribers();
    }

    static void sortedPrint(Map<String, ArrayList> map) {
        Set<String> keySet = map.keySet();
        int maxCount = 0;
        int minCount = 1_000_000;      
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();           
        }
         
        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }  
            }
            num += 1;
        }

        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }
    static void numbersAndSubscribers() {
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Семенов", new ArrayList<Integer>() {
                    {
                        add(938209);
                        add(811178);
                        add(909099);
                    }
                });
                put("Чекан", new ArrayList<Integer>() {
                    {
                        add(871206);
                    }
                });
                put("Иванов", new ArrayList<Integer>() {
                    {
                        add(774433);
                        add(282822);

                    }
                });
                put("Купцова", new ArrayList<Integer>() {
                    {
                        add(836709);
                        add(502862);
                        add(134340);
                        add(866449);
                    }
                });
            }
        };
        System.out.println();
        System.out.println("Исходные данные: ");
        sortedPrint(abon);
        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Введите номер операции (1 - добавить абонента, 9 - выход):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите фамилию абонента:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Неверный ввод!!!Такая фамилия уже есть");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item : arr) {
                            arrInt.add(Integer.parseInt(item.trim()));
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "9": {
                    getOut = true;
                    System.out.println();
                    System.out.println("До свидания!!!");
                    System.out.println();
                    break;
                }
            }
        }
        scan.close();
    }
}