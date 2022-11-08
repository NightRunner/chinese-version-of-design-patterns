package person.nightrunner.auto;

/**
 * 想要啥?告诉工厂,它就可以给你生产
 */
public class 简单工厂模式主程序_汽车 {
    public static void main(String[] args) {
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.SUV)));
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.轿车)));
    }

    private static String getName(Object 对象) {
        return 对象.getClass().getSimpleName();
    }
}

enum 汽车类型 {
    SUV,
    轿车
}

class 汽车工厂 {

    public static 汽车 创建(汽车类型 类型) {
        if (汽车类型.SUV.equals(类型)) {
            return new SUV();
        } else if (汽车类型.轿车.equals(类型)) {
            return new 轿车();
        }
        return null;
    }

}

interface 汽车 {
}

class SUV implements 汽车 {
}


class 轿车 implements 汽车 {
}
