package person.nightrunner;

/**
 * 想要啥?告诉哥,哥给你生产
 */
public class 简单工厂模式主程序 {
    public static void main(String[] args) {
        汽车 汽车 = new 汽车工厂().创建(汽车类型.SUV);
        System.out.println("汽车.获取名称() = " + 汽车.获取名称());
        汽车 = new 汽车工厂().创建(汽车类型.轿车);
        System.out.println("汽车.获取名称() = " + 汽车.获取名称());
    }
}

class 汽车工厂 {

    public 汽车 创建(汽车类型 类型) {
        if (汽车类型.SUV.equals(类型)) {
            return new SUV();
        } else if (汽车类型.轿车.equals(类型)) {
            return new 轿车();
        }
        return null;
    }

}

interface 汽车 {
    String 获取名称();
}

class SUV implements 汽车 {
    @Override
    public String 获取名称() {
        return "SUV";
    }
}


class 轿车 implements 汽车 {
    @Override
    public String 获取名称() {
        return "轿车";
    }
}



