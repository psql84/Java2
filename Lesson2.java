import java.io.IOException;
import java.util.Arrays;

public class Lesson2 {
    /*1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 10 3 1 2
 2 3 2 2
 5 6 7 1
 300 3 1 0
 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 3. Ваши методы должны бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.

     */
    public static String string= "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    public static String [] arr;
    public static String[][] matrix =new String[4][4];


    public static void main(String[] args) throws Exception {
        arr=arrey(string);

        try {
            for (int i=0;i<arr.length;i++)
            Integer.parseInt(arr[i]);
            arrey2(arr,matrix);
            result(matrix);
        }
        catch(NumberFormatException  | ArrayIndexOutOfBoundsException e) {/* исключения Выход индекса за пределы массива
        и Неверное преобразование символьной строки в числовой формат
*/
            e.getMessage();
            e.printStackTrace();
            System.out.println("Бяда");
        }
            finally {
               System.out.println(Arrays.deepToString(matrix));
            }

    }
    private static  String[] arrey(String s) {//исключаем перенос строки, и заганяем строку в одномерный масив

        s=s.replaceAll("\n"," ");
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
    return arr;
    }
    private static void arrey2(String[] arr, String[][] matrix)// из одномерного в дву мерный

    {
        int k=0;
     while (k!=arr.length) {
         for (int i = 0; i < matrix.length; i++)
             for (int j = 0; j < matrix.length; j++) {
                 matrix[i][j] = arr[k++];

             }
     }

    }
    private static void result(String[][] matrix)// сумма элементов масива и результат деления на 2
    {
        int sum=0;
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix.length;j++)
            {
                sum+=Integer.parseInt(matrix[i][j]);
            }
        System.out.println("Результат = "+(sum/2));
    }
}
