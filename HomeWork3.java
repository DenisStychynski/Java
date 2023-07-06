
//1. 1.Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение


import static java.util.Collections.max;
import static java.util.Collections.min;
import java.util.*;

public class HomeWork3 {
    public static void main(String[] args) {
    //   numericalOperations();
    planetsCounter(7);
    }
    static void numericalOperations(){
        Random rnd = new Random();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int val = rnd.nextInt(-100, 100);
            list1.add(val);
        }
        System.out.printf("Первоначальный список %s\n", list1);
        int i = 0;
         int max = max(list1);
        int min = min(list1);
        int maxItem = list1.get(0);
        int minItem = list1.get(0);
        int sumItems = 0;
        for (int item : list1) {
            if (item > maxItem) {
                maxItem = item;
            }
            if (item < minItem) {
                minItem = item;
            }
            sumItems += item;
        }
        
        while (i < list1.size()) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i);
            }
            else {
                i++;
            }
        }
        System.out.printf("Список с удаленными четными числами %s", list1);
        float average = (float)sumItems/list1.size();
        System.out.printf("Максимальный элемент при помощи max %s\n", max);
        System.out.printf("Максимальный элемент %s\n", maxItem);
        System.out.printf("Минимальный элемент при помощи min %s\n", min);
        System.out.printf("Минимальный элемент %s\n", minItem);
        System.out.printf("Сумма элементов %s\n", sumItems);
        System.out.printf("Среднее арифметическое %s\n", average);
    }


static void planetsCounter(int n){
    List<String> listPlanets = List.of("Mercury", "Venus", "Earth", "Mars","Jupiter","Saturn","Uranus","Neptune");
    List<String> randPlanets = new ArrayList<String>(n); 
    int[] counts = new int[listPlanets.size()];
 
      
    


    Random rand = new Random();

    for (int i = 0; i < n; i++) {
        randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
        System.out.print(randPlanets.get(i)+ " ");
        counts[listPlanets.indexOf(randPlanets.get(i))]++;
    }
     System.out.println();

     for (int i = 0; i < counts.length; i++)
     System.out.printf("%s - %s\n",listPlanets.get(i),counts[i]);     
    

     
     Set<String> set = new LinkedHashSet<>(randPlanets);
    List<String> listWithoutDuplicates = new ArrayList<>(set);
  System.out.println(listWithoutDuplicates);
    }
}






