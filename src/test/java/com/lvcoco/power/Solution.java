package com.lvcoco.power;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(decompose(n));
    }

    // 分解n为2的幂次方相加
    public static String decompose(int n) {
        // 如果n是2的幂次方，直接返回n
        if ((n & (n - 1)) == 0) {
            return String.valueOf(n);
        }
        // 用一个列表存储2的幂次方
        List<Integer> powers = new ArrayList<>();
        // 从最大的2的幂次方开始遍历，如果小于等于n，就加入列表，并更新n
        for (int i = 10; i >= 0; i--) {
            int p = 1 << i;
            if (p <= n) {
                powers.add(p);
                n -= p;
            }
        }

        // 用加号连接列表中的元素，返回结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < powers.size(); i++) {
            sb.append(powers.get(i));
            if (i < powers.size() - 1) {
                sb.append("+");
            }
        }
        return sb.toString();
    }
}
