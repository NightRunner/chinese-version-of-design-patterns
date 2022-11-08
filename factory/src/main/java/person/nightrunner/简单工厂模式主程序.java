package person.nightrunner;

/**
 * 想要啥?告诉哥,哥给你生产
 */
public class 简单工厂模式主程序 {
    public static void main(String[] args) {
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.SUV)));
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.轿车)));
    }

    private static String getName(Object 对象) {
        return 对象.getClass().getSimpleName();
    }
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



