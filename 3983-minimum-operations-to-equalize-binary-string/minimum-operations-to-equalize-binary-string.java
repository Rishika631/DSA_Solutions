class Solution {
    public int minOperations(String s, int k) {
        long n = s.length();
        long zero = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zero++;
        }

        if (zero == 0) return 0;

        long one = n - zero;

        for (long ops = 1; ops <= n; ops++) {
            long totalFlip = ops * 1L * k;

            // Parity condition
            if ((totalFlip - zero) % 2 != 0) continue;

            if (ops % 2 == 1) {
                if (totalFlip >= zero &&
                    totalFlip <= zero * ops + one * (ops - 1)) {
                    return (int) ops;
                }
            } else {
                if (totalFlip >= zero &&
                    totalFlip <= zero * (ops - 1) + one * ops) {
                    return (int) ops;
                }
            }
        }

        return -1;
    }
}