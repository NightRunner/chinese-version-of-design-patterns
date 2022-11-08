package person.nightrunner.auto;

/**
 * 想要南大众还是北大众?
 */
public class 工厂方法模式主程序_汽车 {
    public static void main(String[] args) {

        汽车工厂 汽车工厂 = new 一汽大众工厂();
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.SUV)));
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.轿车)));

        汽车工厂 = new 上汽大众工厂();
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.SUV)));
        System.out.println("汽车 = " + getName(汽车工厂.创建(汽车类型.轿车)));
    }

    private static String getName(Object 对象) {
        return 对象.getClass().getSimpleName();
    }
}

interface 汽车工厂 {
    汽车 创建(汽车类型 汽车类型);
}

class 一汽大众工厂 implements 汽车工厂 {
    @Override
    public 汽车 创建(汽车类型 类型) {
        if (汽车类型.轿车.equals(类型)) {
            return new 一汽大众迈腾();
        } else if (汽车类型.SUV.equals(类型)) {
            return new 一汽大众探岳();
        }
        return null;
    }
}

class 上汽大众工厂 implements 汽车工厂 {
    @Override
    public 汽车 创建(汽车类型 类型) {
        if (汽车类型.轿车.equals(类型)) {
            return new 上汽大众帕萨特();
        } else if (汽车类型.SUV.equals(类型)) {
            return new 上汽大众途观();
        }
        return null;
    }
}

interface 汽车 {
}

class 一汽大众迈腾 implements 汽车 {
}

class 一汽大众探岳 implements 汽车 {
}

class 上汽大众帕萨特 implements 汽车 {
}

class 上汽大众途观 implements 汽车 {
}

enum 汽车类型 {
    SUV,
    轿车
}



