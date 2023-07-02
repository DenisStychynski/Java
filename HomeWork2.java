
// /*
// Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
// - Расширение файла: txt
// - Расширение файла: pdf
// - Расширение файла:
// - Расширение файла: jpg
// */


// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;

// public class HomeWork2 {
//     public static void main(String[] args) {
//         List<String> files = get_files();
//         for (String file : files)
//             System.out.println(file + " - Расширение: " + get_extention(file));
//     }

//     /**
//      * получает расширение из имени файла
//      * 
//      * @param file название файла
//      * @return строка содержащая расширение файла file
//      */
//     public static String get_extention(String file) {
//         int index = file.lastIndexOf(".");
//         if (index == -1)
//             return "";
//         return file.substring(index + 1);
//     }

//     /**
//      * Возвращает список из имен файлов в текущей дирректории.
//      * 
//      * @return список из имен файлов
//      */
//     public static List<String> get_files() {

//         File dir = new File(".");

//         File[] files;
//         try {
//             files = dir.listFiles();
//         } catch (Exception ex) {
//             ex.printStackTrace();
//             return null;
//         }
//         if (files == null)
//             return null;

//         List<String> list = new ArrayList<String>();
//         for (File file : files)
//             if (file.isFile())
//                 list.add(file.getName());

//         return list;
//     }
    
// }

///////////////////////////////////////////////////////////////////////////////////////////////////////
// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.logging.*;
public class HomeWork2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(HomeWork2.class.getName());
        FileHandler fh = new FileHandler("logTask2.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Sort Array");
        int [] array = {2, 5, 1, -7, 3, 64, 0};
        lib.printArrayInt(array);
        int[] newArr = listSort(array);
        System.out.printf("\n Отсортированный массив: \n");
        lib.printArrayInt(newArr);
    }
    public static int[] listSort(int [] arr){
        for(int k = 0; k < arr.length-1; k++) {
            
            for (int i = 0; i < arr.length - k-1; i++){
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }
    
}