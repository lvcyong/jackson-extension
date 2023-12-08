package com.lvcoco.power;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
        // 创建一个扫描器对象，用于从控制台读取输入
        Scanner scanner = new Scanner(System.in);
        int num;

        // 提示用户输入一个正整数
        System.err.print("请输入一个正整数：");

        // 读取用户输入的数
        while ((num = scanner.nextInt()) != -1) {
            // 调用findPowersOfTwo方法，传入用户输入的数，得到一个包含所有2的指数值的列表
            List<Integer> powersOfTwo = findPowersOfTwo(num);
            // 如果列表不为空，说明用户输入的数是由2的指数值相加组成的，打印列表
            if (!powersOfTwo.isEmpty()) {
                System.out.println("你给的数是由以下2的指数值相加组成的：" + powersOfTwo);
            }
            // 否则，说明用户输入的数不是正整数，打印错误信息
            else {
                System.out.println("你输入的数不是正整数，请重新输入。");
            }

            // 提示用户输入一个正整数
            System.err.println("请输入一个正整数：");
        }

        // 关闭扫描器
        scanner.close();


    }

    /**
     * 定义一个方法，用于找出一个正整数是由哪些2的指数值相加组成的
     * @param num 指数和
     * @return 指数值
     */
    public static List<Integer> findPowersOfTwo(int num) {
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
        return powersOfTwo;
    }
}
