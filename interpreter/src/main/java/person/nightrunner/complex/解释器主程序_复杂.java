package person.nightrunner.complex;

import java.util.Stack;

/**
 * 魔兽争霸中输入-random 100,摇色子可以这样实现
 * 参考:
 * https://github.com/iluwatar/java-design-patterns/interpreter
 */
public class 解释器主程序_复杂 {
    public static void main(String[] args) {

        String 字符串 = "400 3 2 - 1 + *";

        Stack<表达式> stack = new Stack<>();

        String[] 字符串们 = 字符串.split(" ");
        for (String 各字符串们 : 字符串们) {
            if (是操作符(各字符串们)) {
                表达式 右 = stack.pop();
                表达式 左 = stack.pop();
                表达式 表达式 = 获取表达式(各字符串们, 左, 右);

                System.out.println(表达式);

                Integer 结果 = 表达式.解释();
                表达式 结果表达式 = new 数字(结果);
                stack.push(结果表达式);
            } else {
                表达式 表达式 = new 数字(各字符串们);
                stack.push(表达式);
            }
        }
        System.out.println("结果" + stack.pop().解释());
    }

    private static boolean 是操作符(String 字符串) {
        return 字符串.equals("+") || 字符串.equals("-") || 字符串.equals("*");
    }

    public static 表达式 获取表达式(String 字符, 表达式 左, 表达式 右) {
        switch (字符) {
            case "+":
                return new 加(左, 右);
            case "-":
                return new 减(左, 右);
            default:
                return new 乘(左, 右);
        }
    }
}


interface 表达式 {
    int 解释();
}

class 数字 implements 表达式 {

    private final int 数;

    数字(Integer 数) {
        this.数 = 数;
    }

    数字(String 字符串) {
        this.数 = Integer.parseInt(字符串);
    }

    @Override
    public int 解释() {
        return 数;
    }

    @Override
    public String toString() {
        return Integer.toString(数);
    }
}

abstract class 二元表达式 implements 表达式 {

    public 二元表达式(表达式 左, 表达式 右) {
        this.左 = 左;
        this.右 = 右;
    }

    protected 表达式 左;
    protected 表达式 右;

}

class 加 extends 二元表达式 {
    @Override
    public int 解释() {
        return 左.解释() + 右.解释();
    }

    public 加(表达式 左, 表达式 右) {
        super(左, 右);
    }

    @Override
    public String toString() {
        return "加";
    }
}

class 减 extends 二元表达式 {
    @Override
    public int 解释() {
        return 左.解释() - 右.解释();
    }

    public 减(表达式 左, 表达式 右) {
        super(左, 右);
    }

    @Override
    public String toString() {
        return "减";
    }
}

class 乘 extends 二元表达式 {
    @Override
    public int 解释() {
        return 左.解释() * 右.解释();
    }

    public 乘(表达式 左, 表达式 右) {
        super(左, 右);
    }

    @Override
    public String toString() {
        return "乘";
    }
}
