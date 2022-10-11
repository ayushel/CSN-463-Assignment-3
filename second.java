public class second {
    public static void main(String[] args) {
        int[] inputNumberArray = { 1, 10, 2, 3, 4, 2, 14, 4, 19, 0, 4, 17 };

        int[] counter = new int[21];

        for (int number : inputNumberArray) {
            counter[number]++;
        }

        for (int number = 0; number <= 20; number++) {
            if (counter[number] > 0) {
                int count = counter[number];

                while (count > 0) {
                    System.out.print(number + " ");
                    count--;
                }
            }
        }
        System.out.println();
    }
}
