package 个人.夜行者;

import java.util.Scanner;

public class 抽象工厂主程序_魔兽争霸 {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            for (种族枚举 种族 : 种族枚举.values()) {
                System.out.println(种族.索引 + ":" + 种族.名称);
            }
            System.out.println("请输入一个代表种族的数字：");
            int 索引 = sc.nextInt();
            种族枚举 种族 = 种族枚举.通过索引获取种族(索引);
            建筑工厂 工厂实例 = 获取建筑工厂(种族);
            System.out.println("工厂实例.创建兵营().获取名称() = " + 工厂实例.创建兵营().获取名称());
            System.out.println("工厂实例.创建祭坛().获取名称() = " + 工厂实例.创建祭坛().获取名称());
            System.out.println("工厂实例.创建商店().获取名称() = " + 工厂实例.创建商店().获取名称());
        } while (true);
    }

    public static 建筑工厂 获取建筑工厂(种族枚举 枚举) {
        if (种族枚举.人族.equals(枚举)) {
            return new 人族建筑工厂();
        } else if (种族枚举.兽族.equals(枚举)) {
            return new 兽族建筑工厂();
        } else if (种族枚举.精灵.equals(枚举)) {
            return new 精灵建筑工厂();
        } else if (种族枚举.不死族.equals(枚举)) {
            return new 不死族建筑工厂();
        }

        throw new RuntimeException("不支持类型:" + 枚举);
    }

}

enum 种族枚举 {
    人族(0, "人族"),
    精灵(1, "精灵"),
    兽族(2, "兽族"),
    不死族(3, "不死族");

    Integer 索引;
    String 名称;

    private 种族枚举(Integer 索引, String 名称) {
        this.索引 = 索引;
        this.名称 = 名称;
    }

    static 种族枚举 通过索引获取种族(Integer 索引) {
        for (种族枚举 value : 种族枚举.values()) {
            if (value.索引.equals(索引)) {
                return value;
            }
        }

        throw new RuntimeException("错误的种族索引:" + 索引);
    }

}

class 兽族建筑工厂 implements 建筑工厂 {
    @Override
    public 祭坛 创建祭坛() {
        return new 兽族祭坛();
    }

    @Override
    public 兵营 创建兵营() {
        return new 兽族兵营();
    }

    @Override
    public 商店 创建商店() {
        return new 兽族商店();
    }
}

class 精灵建筑工厂 implements 建筑工厂 {
    @Override
    public 祭坛 创建祭坛() {
        return new 精灵祭坛();
    }

    @Override
    public 兵营 创建兵营() {
        return new 精灵兵营();
    }

    @Override
    public 商店 创建商店() {
        return new 精灵商店();
    }
}

class 人族建筑工厂 implements 建筑工厂 {
    @Override
    public 祭坛 创建祭坛() {
        return new 人族祭坛();
    }

    @Override
    public 兵营 创建兵营() {
        return new 人族兵营();
    }

    @Override
    public 商店 创建商店() {
        return new 人族商店();
    }
}

class 不死族建筑工厂 implements 建筑工厂 {
    @Override
    public 祭坛 创建祭坛() {
        return new 不死族祭坛();
    }

    @Override
    public 兵营 创建兵营() {
        return new 不死族兵营();
    }

    @Override
    public 商店 创建商店() {
        return new 不死族商店();
    }
}


interface 建筑工厂 {
    祭坛 创建祭坛();

    兵营 创建兵营();

    商店 创建商店();
}

interface 祭坛 {
    String 获取名称();
}

interface 兵营 {
    String 获取名称();
}

interface 商店 {
    String 获取名称();
}

class 人族祭坛 implements 祭坛 {
    @Override
    public String 获取名称() {
        return "人族祭坛";
    }
}

class 兽族祭坛 implements 祭坛 {
    @Override
    public String 获取名称() {
        return "兽族祭坛";
    }
}

class 不死族祭坛 implements 祭坛 {
    @Override
    public String 获取名称() {
        return "不死族祭坛";
    }
}

class 精灵祭坛 implements 祭坛 {
    @Override
    public String 获取名称() {
        return "精灵祭坛";
    }
}

class 人族兵营 implements 兵营 {
    @Override
    public String 获取名称() {
        return "人族兵营";
    }
}

class 精灵兵营 implements 兵营 {
    @Override
    public String 获取名称() {
        return "精灵兵营";
    }
}

class 不死族兵营 implements 兵营 {
    @Override
    public String 获取名称() {
        return "不死族兵营";
    }
}

class 兽族兵营 implements 兵营 {
    @Override
    public String 获取名称() {
        return "兽族兵营";
    }
}

class 不死族商店 implements 商店 {
    @Override
    public String 获取名称() {
        return "不死族商店";
    }
}

class 精灵商店 implements 商店 {
    @Override
    public String 获取名称() {
        return "精灵商店";
    }
}

class 人族商店 implements 商店 {
    @Override
    public String 获取名称() {
        return "人族商店";
    }
}

class 兽族商店 implements 商店 {
    @Override
    public String 获取名称() {
        return "兽族商店";
    }
}