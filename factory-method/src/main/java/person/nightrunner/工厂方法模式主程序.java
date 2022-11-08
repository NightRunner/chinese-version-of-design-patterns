package person.nightrunner;

/**
 * 想要哪个种族的近战兵就使用哪个种族的兵营(工厂)
 */
public class 工厂方法模式主程序 {
    public static void main(String[] args) {
        兵营 兵营 = new 暗夜兵营();
        System.out.println("兵种 = " + getName(兵营.创建(兵种类型.近战兵)));
        System.out.println("兵种 = " + getName(兵营.创建(兵种类型.远程兵)));

        兵营 = new 兽族兵营();
        System.out.println("兵种 = " + getName(兵营.创建(兵种类型.近战兵)));
        System.out.println("兵种 = " + getName(兵营.创建(兵种类型.远程兵)));
    }

    private static String getName(Object 对象) {
        return 对象.getClass().getSimpleName();
    }
}

interface 兵营 {
    汽车 创建(兵种类型 兵种类型);
}

class 暗夜兵营 implements 兵营 {
    @Override
    public 汽车 创建(兵种类型 类型) {
        if (兵种类型.远程兵.equals(类型)) {
            return new 弓箭手();
        } else if (兵种类型.近战兵.equals(类型)) {
            return new 利爪德鲁伊();
        }
        return null;
    }
}

class 兽族兵营 implements 兵营 {
    @Override
    public 汽车 创建(兵种类型 类型) {
        if (兵种类型.远程兵.equals(类型)) {
            return new 猎头者();
        } else if (兵种类型.近战兵.equals(类型)) {
            return new 兽族步兵();
        }
        return null;
    }
}

interface 汽车 {
}

class 弓箭手 implements 汽车 {
}

class 利爪德鲁伊 implements 汽车 {
}

class 猎头者 implements 汽车 {
}

class 兽族步兵 implements 汽车 {
}

enum 兵种类型 {
    近战兵,
    远程兵
}
