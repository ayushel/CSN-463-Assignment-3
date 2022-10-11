import java.util.Arrays;

public class third {
    public static void main(String[] args) {
        String unsortedString = "javaprogramming";

        System.out.println("String before sorting: " + unsortedString);

        char[] tempArray = unsortedString.toCharArray();

        Arrays.sort(tempArray);

        String sortedString = new String(tempArray);

        System.out.println("String after sorting: " + sortedString);

    }
}
