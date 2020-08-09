package xyz.lius.demo.algorithm.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main foo = new Main();
        Scanner in = new Scanner(System.in);
        String out = "";
        while (in.hasNext()) {
            String next = in.next();
            out = out + foo.reverse(next) + " ";
        }
        System.out.println(out);
    }

    public String reverse(String src) {
        String[] arr = src.split(" ");

        if (arr.length == 1) {
            return reverse0(arr[0]);
        }

        String dest = reverse0(arr[0]);
        for (int i = 1; i < arr.length - 1; i++) {
            dest = dest + " " + reverse0(arr[i]);
        }
        dest = dest + " " + reverse0(arr[arr.length - 1]);
        return dest;
    }

    // 反转给定的字符串
    public String reverse0(String str) {
        String dest = "";
        for (int i = 0; i < str.length(); i++) {
            dest = str.charAt(i) + dest;
        }
        return dest;
    }
}
