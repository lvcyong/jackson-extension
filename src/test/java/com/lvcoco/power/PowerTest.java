package com.lvcoco.power;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/12/8 14:04
 */
public class PowerTest {

    public static void main(String[] args) {
        int num = new Random().nextInt();
        String s = findPowersOfTwo(num);
        System.out.println(num);
        System.out.println(s);

    }

    /**
     * 定义一个方法，用于找出一个正整数是由哪些2的指数值相加组成的
     * @param num 指数和
     * @return 指数值
     */
    public static String findPowersOfTwo(int num) {
        if (num <= 0) {
            return "None";
        }
        // 创建一个空的列表，用于存放2的指数值
        List<Integer> powersOfTwo = new ArrayList<>();
        // 如果输入的数是正整数，才进行计算
        if (num > 0) {
            // 初始化一个变量，表示当前的2的指数值，从1开始
            int powerOfTwo = 1;
            // 用一个循环，从低位到高位，检查输入的数的每一位是否为1
            while (num > 0) {
                // 如果当前位为1，说明该位对应的2的指数值是输入数的一个组成部分，将其添加到列表中
                if (num % 2 == 1) {
                    powersOfTwo.add(powerOfTwo);
                }
                // 将输入的数右移一位，即除以2，继续检查下一位
                num = num / 2;
                // 将当前的2的指数值左移一位，即乘以2，继续检查下一位对应的2的指数值
                powerOfTwo = powerOfTwo * 2;
            }
        }
        // 返回列表
        return powersOfTwo.toString();
    }
}
