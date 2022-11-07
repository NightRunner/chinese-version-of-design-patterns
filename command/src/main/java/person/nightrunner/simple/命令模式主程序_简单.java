package person.nightrunner.simple;

import person.nightrunner.指令;

/**
 * 用遥控器执行开空调,关空调命令!!!
 */
public class 命令模式主程序_简单 {
    public static void main(String[] args) {
        空调 空调 = new 空调("格力立式空调");
        遥控器 遥控器 = new 遥控器();
        遥控器.执行命令(new 开(空调));
        遥控器.执行命令(new 调整温度(空调, 10));
        遥控器.执行命令(new 关(空调));
    }
}

class 遥控器 {
    public void 执行命令(指令 指令) {
        指令.执行();
    }
}

class 空调 {

    private String 名称;

    public 空调(String 名称) {
        this.名称 = 名称;
    }

    public void 开启() {
        System.out.println(this + "开了");
    }

    public void 关闭() {
        System.out.println(this + "关了");
    }

    public void 设置温度(Integer 温度) {
        System.out.println(this + "设置到了" + 温度 + "度");
    }

    @Override
    public String toString() {
        return "空调{" + "名称='" + 名称 + '\'' + '}';
    }
}


abstract class 空调指令 implements 指令 {
    空调 空调;

    public 空调指令(空调 空调) {
        this.空调 = 空调;
    }

    public void 设置空调(空调 空调) {
        this.空调 = 空调;
    }
}

class 开 extends 空调指令 {

    public 开(person.nightrunner.simple.空调 空调) {
        super(空调);
    }

    @Override
    public void 执行() {
        空调.开启();
    }
}

class 关 extends 空调指令 {


    public 关(空调 空调) {
        super(空调);
    }

    @Override
    public void 执行() {
        空调.关闭();
    }
}


class 调整温度 extends 空调指令 {

    public 调整温度(空调 空调, Integer 温度) {
        super(空调);
        this.温度 = 温度;
    }

    final Integer 温度;

    @Override
    public void 执行() {
        空调.设置温度(温度);
    }
}