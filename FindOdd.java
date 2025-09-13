public class FindOdd {
    public static int findIt(int[] a) {
        // Loop through each element in the array
        for (int i = 0; i < a.length; i++) {
            int count = 0; // reset counter for this number

            // Count how many times a[i] appears in the array
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }

            // If count is odd, return this number
            if (count % 2 != 0) {
                return a[i];
            }
        }

        // Should never reach here because one odd number is guaranteed
        return -1;
    }
}
