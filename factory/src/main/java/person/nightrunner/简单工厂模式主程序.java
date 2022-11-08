package person.nightrunner;

/**
 * 想要啥?告诉工厂,它就可以给你生产
 */
public class 简单工厂模式主程序 {
    public static void main(String[] args) {
        System.out.println("兵种 = " + getName(汽车工厂.创建(兵种类型.弓箭手)));
        System.out.println("兵种 = " + getName(汽车工厂.创建(兵种类型.女猎手)));
    }

    private static String getName(Object 对象) {
        return 对象.getClass().getSimpleName();
    }
}

enum 兵种类型 {
    弓箭手,
    女猎手
}

class 汽车工厂 {

    public static 兵种 创建(兵种类型 兵种类型) {
        if (兵种类型.弓箭手.equals(兵种类型)) {
            return new 弓箭手();
        } else if (兵种类型.女猎手.equals(兵种类型)) {
            return new 女猎手();
        }
        return null;
    }

}

interface 兵种 {
}

class 弓箭手 implements 兵种 {
}


class 女猎手 implements 兵种 {
}
