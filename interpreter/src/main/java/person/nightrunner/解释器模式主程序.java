package person.nightrunner;

import java.util.Random;
import java.util.Scanner;

/**
 * dota中的"-swap","-rd",'-random'等指令就可以这样实现
 */
public class 解释器模式主程序 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("你可以输入如下命令后回车:");
            System.out.println("-random [数字] --摇色子");
            System.out.println("-rd --dota随机英雄模式");
            System.out.println("-swap [数字] --和第N个玩家交换英雄");
            System.out.println("-esc --退出游戏");
            Scanner 录入器 = new Scanner(System.in);
            String 输入的字符 = 录入器.nextLine();
            if (!输入的字符.startsWith("-")) {
                System.out.println("错误的语法");
            } else {
                String 输入的指令 = 输入的字符.substring(1);

                if (null == 输入的指令 || 输入的指令.length() < 1) {
                    System.out.println("未找到相应的指令,请重新输入");
                    continue;
                }

                String[] 指令 = 输入的指令.split(" ");

                String 指令名称 = null;
                String 指令参数 = null;
                if (指令.length > 1) {
                    指令名称 = 指令[0];
                    指令参数 = 指令[1];
                } else if (指令.length == 1) {
                    指令名称 = 指令[0];
                }
                指令 获取到的指令 = 获取指令(指令[0], 指令参数);


                获取到的指令.执行();
            }
        }
    }

    public static 指令 获取指令(String 字符串, String 参数) {
        if (字符串.equalsIgnoreCase("random")) {
            return new 摇色子(Integer.parseInt(参数));
        } else if (字符串.equalsIgnoreCase("esc")) {
            return new 退出();
        } else if (字符串.equalsIgnoreCase("rd")) {
            return new DOTA随机模式();
        } else if (字符串.equalsIgnoreCase("swap")) {
            return new DOTA交换英雄(Integer.parseInt(参数));
        }
        return null;
    }
}

interface 指令 {
    void 执行();
}

class 退出 implements 指令 {
    @Override
    public void 执行() {
        System.exit(0);
    }
}

class 摇色子 implements 指令 {
    Integer 参数;

    public 摇色子(Integer 参数) {
        this.参数 = 参数;
    }

    @Override
    public void 执行() {
        int 随机数 = new Random().nextInt(参数);
        System.out.println(随机数);
    }
}

class DOTA随机模式 implements 指令 {

    @Override
    public void 执行() {
        System.out.println("开启随机英雄模式");
    }
}

class DOTA交换英雄 implements 指令 {

    Integer 参数;

    public DOTA交换英雄(Integer 参数) {
        this.参数 = 参数;
    }

    @Override
    public void 执行() {
        System.out.println("与第" + 参数 + "位玩家交换英雄");
    }
}



