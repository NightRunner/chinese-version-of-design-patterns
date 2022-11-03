package person.nightrunner;

public class 工厂方法主程序 {
    public static void main(String[] args) {

        汽车工厂 汽车工厂 = new 一汽大众工厂();
        汽车 汽车 = 汽车工厂.创建(汽车类型.SUV);
        System.out.println("个人.夜行者.汽车.获取名称() = " + 汽车.获取名称());
        汽车 = 汽车工厂.创建(汽车类型.轿车);
        System.out.println("个人.夜行者.汽车.获取名称() = " + 汽车.获取名称());

        汽车工厂 = new 上汽大众工厂();
        汽车 = 汽车工厂.创建(汽车类型.SUV);
        System.out.println("个人.夜行者.汽车.获取名称() = " + 汽车.获取名称());
        汽车 = 汽车工厂.创建(汽车类型.轿车);
        System.out.println("个人.夜行者.汽车.获取名称() = " + 汽车.获取名称());
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
    String 获取名称();
}

class 一汽大众迈腾 implements 汽车 {
    @Override
    public String 获取名称() {
        return "个人.夜行者.一汽大众迈腾";
    }
}

class 一汽大众探岳 implements 汽车 {
    @Override
    public String 获取名称() {
        return "个人.夜行者.一汽大众探岳";
    }
}


class 上汽大众帕萨特 implements 汽车 {
    @Override
    public String 获取名称() {
        return "个人.夜行者.上汽大众帕萨特";
    }
}

class 上汽大众途观 implements 汽车 {
    @Override
    public String 获取名称() {
        return "个人.夜行者.上汽大众途观";
    }
}



