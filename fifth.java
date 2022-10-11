import java.util.ArrayList;

public class fifth {
    static int dp[][]; // global dp array

    // create List of lists that will store all sets of operations
    static ArrayList<ArrayList<String>> methodsArrays = new ArrayList<ArrayList<String>>();

    static void printAllChanges(String str1,
            String str2, ArrayList<String> changes) {

        int i = str1.length();
        int j = str2.length();

        // Iterate till end
        while (true) {

            if (i == 0 || j == 0) {

                // Add this list to our List of lists.
                methodsArrays.add(changes);
                break;
            }

            // If same
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                i--;
                j--;
            }

            else {
                boolean condition1 = false, condition2 = false;

                // Replace Operation
                if (dp[i][j] == dp[i - 1][j - 1] + 1) {

                    // Add this step
                    changes.add("Change " + str1.charAt(i - 1)
                            + " to " + str2.charAt(j - 1));
                    i--;
                    j--;

                    condition1 = true;
                }

                // Delete Operation
                if (dp[i][j] == dp[i - 1][j] + 1) {
                    if (condition1 == false) {
                        changes.add("Delete " + str1.charAt(i - 1));
                        i--;
                    } else {
                        // If the previous method was true,
                        // create a new list as a copy of previous.
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);

                        // Remove last operation
                        changes2.remove(changes.size() - 1);

                        // Add this new operation
                        changes2.add("Delete " + str1.charAt(i));

                        // initiate new new instance of this
                        // function with remaining substrings
                        printAllChanges(str1.substring(0, i),
                                str2.substring(0, j + 1), changes2);
                    }

                    condition2 = true;
                }

                // Add Operation
                if (dp[i][j] == dp[i][j - 1] + 1) {
                    if (condition1 == false && condition2 == false) {
                        changes.add("Add " + str2.charAt(j - 1));
                        j--;
                    } else {

                        // Add this step
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);
                        changes2.remove(changes.size() - 1);
                        changes2.add("Add " + str2.charAt(j));

                        // Recursively call for the next steps
                        printAllChanges(str1.substring(0, i + 1),
                                str2.substring(0, j), changes2);
                    }
                }
            }
        }
    }

    static void editDistanceDP(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] DP = new int[l1 + 1][l2 + 1];

        // initializing with maximum edits possible
        for (int i = 0; i <= l1; i++)
            DP[i][0] = i;
        for (int j = 0; j <= l2; j++)
            DP[0][j] = j;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {

                // if characters are same, no edit required
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    DP[i][j] = DP[i - 1][j - 1];
                else {

                    // assign minimum of three possible operations- insertion, deletion, replacement
                    DP[i][j] = min(DP[i - 1][j - 1],
                            DP[i - 1][j], DP[i][j - 1])
                            + 1;
                }
            }
        }

        // initialize to global array
        dp = DP;
    }

    // return minimum of three values
    static int min(int a, int b, int c) {
        int z = Math.min(a, b);
        return Math.min(z, c);
    }

    static void printAllWays(String str1, String str2) {

        // filling up methodsArrays with various methods
        printAllChanges(str1, str2, new ArrayList<String>());

        int i = 1;
        for (ArrayList<String> methodArray : methodsArrays) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String step : methodArray) {
                System.out.println(step);
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdee";
        String str2 = "adcdf";

        // Calculate the edit distance matrix
        editDistanceDP(str1, str2);

        // Printing all the ways to convert str1 to str2
        printAllWays(str1, str2);
    }
}
