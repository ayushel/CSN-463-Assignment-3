public class first {
    public static void main(String[] args) {
        String one = "Colder";
        String two = "Coldest";
        int comparison = 0;
        for (int index = 0; index < Math.min(one.length(), two.length()); index++) { // iterate for as long as the
                                                                                     // shorter string
            if ((int) one.charAt(index) == (int) two.charAt(index)) { // unicode value comparison of the characters at
                                                                      // index of two strings
                continue;
            } else {
                comparison = (int) one.charAt(index) - (int) two.charAt(index);
            }
        }

        if (comparison > 0) {
            System.out.println(one + " is lexicographically greater than " + two);
        } else if (comparison < 0) {
            System.out.println(one + " is lexicographically smaller than " + two);
        } else {
            if (one.length() == two.length()) {
                System.out.println(one + " is lexicographically equal to " + two);
            } else {
                if (one.length() - two.length() < 0) {
                    System.out.println(one + " is lexicographically smaller than " + two);
                } else {
                    System.out.println(one + " is lexicographically greater than " + two);
                }
            }
        }
    }
}
