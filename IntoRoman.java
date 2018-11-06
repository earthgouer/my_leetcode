package leetcodecn;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public class IntoRoman {

    public static void main(String[] args) {
        /*String s = "asdfg";
        System.out.println(s.contains("sd"));*/
        System.out.println(new IntoRoman().inToRoman(5));
    }

    public String inToRoman(int num){
        Map<String ,String> partten = new LinkedHashMap<>();
        partten.put("IIII", "IV");
        partten.put("VIIII", "IX");
        partten.put("XXXX", "XL");
        partten.put("LXXXX", "XC");
        partten.put("CCCC", "CD");
        partten.put("DCCCC", "CM");

/*
        if (num == 4) return "IV";
        if (num == 9) return "IX";
        if (num == 40) return "XL";
        if (num == 90) return "XC";
        if (num == 400) return "CD";
        if (num == 900) return "CM";

        */


        StringBuffer res = new StringBuffer();

        while (num >= 1000){
            num -= 1000;
            res.append("M");
        }
        while (num >= 500){
            num -= 500;
            res.append("D");
        }
        while (num >= 100){
            num -= 100;
            res.append("C");
        }
        while (num >= 50){
            num -= 50;
            res.append("L");
        }
        while (num >= 10){
            num -= 10;
            res.append("X");
        }
        while (num >= 5){
            num -= 5;
            res.append("V");
        }
        while (num >= 1){
            num -= 1;
            res.append("I");
        }
        String s = res.toString();


        ListIterator<Map.Entry> i=
                new ArrayList<Map.Entry>(
                        partten.entrySet()).listIterator(partten.size());
        while(i.hasPrevious()) {
            Map.Entry entry = i.previous();
            if (s.contains((String)entry.getKey())) s = s.replaceAll((String)entry.getKey(),(String)entry.getValue());
        }
        return s;
    }
}
