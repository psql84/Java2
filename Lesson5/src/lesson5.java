import java.util.Arrays;

    public class lesson5 {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
       new Thread(() -> one(arr)).start();
       new Thread(() -> two(arr)).start();

    }

        private static void two(float[] arr) {
            float[] a1 = new float[h];
            float[] a2 = new float[h];
        long a = System.currentTimeMillis();
            System.arraycopy(arr, 0, a1, 0, h);
            System.arraycopy(arr, h, a2, 0, h);
                for (int i = 0; i < a1.length; i++)
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                for (int i = 0; i < a2.length; i++)
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                System.arraycopy(a1, 0, arr, 0, h);
                System.arraycopy(a2, 0, arr, h, h);
                System.out.println("Двумя масивами ="+(System.currentTimeMillis()-a));
        }

        private static void one(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Одним масивом ="+(System.currentTimeMillis()-a));
    }
}
