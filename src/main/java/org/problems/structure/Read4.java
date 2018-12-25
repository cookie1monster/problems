package org.problems.structure;

//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/submissions/
public class Read4 {

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    private boolean eof = false;
    private char[] tmp = new char[4];
    private int lo = 4;
    private int hi = 4;

    public int read(char[] buf, int n) {
        int total = 0;
        int to = Math.min(hi, lo + n);
        for (; lo < to; ++lo)
            buf[total++] = tmp[lo];

        while (!eof && total < n) {
            int len = 0;//read4(tmp);
            eof = len < 4;
            hi = len;
            len = Math.min(len, n - total);
            lo = len;
            for (int i = 0; i < len; ++i)
                buf[total++] = tmp[i];
        }
        return total;
    }

}
