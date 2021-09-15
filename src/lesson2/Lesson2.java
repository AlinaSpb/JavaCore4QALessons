package lesson2;

public class Lesson2 {

    /**
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
     * MyArrayDataException и вывести результат расчета.
     */
    public static void main(String[] args) {
        String[][] test = new String[][]
                {
                        {"1", "2", "3", "4"},
                        {"5", "6", "7", "1"},
                        {"5", "6", "7", "8"},
                        {"5", "6", "7", "1"},

                };
        try {
            int sum = task(test);
            System.out.println("SUM = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("1");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("2");
            e.printStackTrace();
        }
    }

    public static int task(String[][] strArray) {
        /*
         * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
         * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
         * */
        if (strArray.length != 4) {
            throw new MyArraySizeException();
        }

        /*
         * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то
         * элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
         * брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
         */
        int sum = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < strArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке: " + i + ":" + j);
                }
            }
        }
        return sum;
    }

}
