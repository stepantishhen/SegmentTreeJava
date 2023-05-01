package sw2;

class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];
        buildTree(nums);
    }

    // Построение занимает O(n).
    // Это связано с тем, что нам нужно посетить
    // каждый узел в дереве один раз и вычислить значения сегментов
    private void buildTree(int[] nums) {
        int counter = 0;
        long startTime = System.nanoTime();
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            tree[i] = nums[j];
            counter++;
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
            counter++;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration);
        System.out.println(counter);
        System.out.println();
    }
    // Обновление значения занимает O(log n).
    // Это связано с тем, что мы можем пройти по дереву от корня до листьев,
    // используя двоичный поиск, посещая не более n узлов журнала в худшем случае.
    public void update(int pos, int val) {
        int counter = 0;
        long startTime = System.nanoTime();
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
            counter++;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
//        System.out.println(duration);
//        System.out.println(counter);
//        System.out.println();
    }
    // Сумма на отрезке тоже занимает O(log n)
    public int query(int l, int r) {
        int counter = 0;
        long startTime = System.nanoTime();
        l += n;
        r += n;
        int sum = 0;
        while (l <= r) {
            if (l % 2 == 1) {
                sum += tree[l];
                l++;
            }
            if (r % 2 == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
            counter++;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
//        System.out.println(duration);
//        System.out.println(counter);
//        System.out.println();
        return sum;
    }
}
