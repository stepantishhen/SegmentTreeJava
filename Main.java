package sw2;

import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
        // построение - 413400 наносекунд, 19999 число итераций
        SegmentTree tree = new SegmentTree(arr);
        // суммирование - 576 среднее время, 4 среднее количество итераций
        System.out.println(tree.query(12, 600));
        // обновление - 544 среднее время, 15 среднее количество итераций
        tree.update(200, 10000);
    }
}
