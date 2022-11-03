package 个人.夜行者;

public class 抽象工厂主程序_汽车 {
    public static void main(String[] args) {
        汽车工厂 工厂 = new 一汽大众汽车工厂();
        System.out.println("工厂.生产MPV().获取名称() = " + 工厂.生产MPV().获取名称());
        System.out.println("工厂.生产SUV().获取名称() = " + 工厂.生产SUV().获取名称());
        System.out.println("工厂.生产轿车().获取名称() = " + 工厂.生产轿车().获取名称());

        工厂 = new 上汽大众汽车工厂();
        System.out.println("工厂.生产MPV().获取名称() = " + 工厂.生产MPV().获取名称());
        System.out.println("工厂.生产SUV().获取名称() = " + 工厂.生产SUV().获取名称());
        System.out.println("工厂.生产轿车().获取名称() = " + 工厂.生产轿车().获取名称());
    }
}

class 一汽大众汽车工厂 implements 汽车工厂 {
    @Override
    public SUV 生产SUV() {
        return new 一汽大众探岳();
    }

    @Override
    public MPV 生产MPV() {
        return new 一汽大众揽境();
    }

    @Override
    public 轿车 生产轿车() {
        return new 一汽大众迈腾();
    }
}

class 上汽大众汽车工厂 implements 汽车工厂 {
    @Override
    public SUV 生产SUV() {
        return new 上汽大众途观();
    }

    @Override
    public MPV 生产MPV() {
        return new 上汽大众威然();
    }

    @Override
    public 轿车 生产轿车() {
        return new 上汽大众帕萨特();
    }
}

interface 汽车工厂 {
    SUV 生产SUV();

    MPV 生产MPV();

    轿车 生产轿车();
}

interface SUV {
    String 获取名称();
}

interface 轿车 {
    String 获取名称();
}

interface MPV {
    String 获取名称();
}

class 一汽大众揽境 implements MPV {
    @Override
    public String 获取名称() {
        return "一汽大众揽境";
    }
}

class 上汽大众威然 implements MPV {
    @Override
    public String 获取名称() {
        return "上汽大众威然";
    }
}

class 一汽大众迈腾 implements 轿车 {
    @Override
    public String 获取名称() {
        return "一汽大众迈腾";
    }
}

class 一汽大众探岳 implements SUV {
    @Override
    public String 获取名称() {
        return "一汽大众探岳";
    }
}

class 上汽大众帕萨特 implements 轿车 {
    @Override
    public String 获取名称() {
        return "上汽大众帕萨特";
    }
}

class 上汽大众途观 implements SUV {
    @Override
    public String 获取名称() {
        return "上汽大众途观";
    }
}


