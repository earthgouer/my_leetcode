package leetcodecn;

import java.util.ArrayList;
import java.util.List;

public class ZConvert {
    public static void main(String[] args) {
        System.out.println(new ZConvert().convert("PAYPALISHIRING", 1));
    }
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        List<StringBuffer> ls = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ls.add(new StringBuffer());
        }
        int row = 0;
        int flag = -1;
        for (int i = 0; i < len; i++) {
            ls.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows-1) flag *= -1;
            row += flag;
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < ls.size(); i++) {
            res.append(ls.get(i));
        }
        return res.toString();
    }
}
