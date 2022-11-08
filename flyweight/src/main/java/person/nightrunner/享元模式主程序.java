package person.nightrunner;

import java.util.*;

/**
 * 瞎子磕了这么多药,其实每种内存中都只有一份!
 * PS:工厂模式+单例模式的合体?;
 */
public class 享元模式主程序 {
    public static void main(String[] args) {
        药剂工厂 药剂工厂 = new 药剂工厂();

        恶魔猎手 伊利丹 = new 恶魔猎手(Arrays.asList(
                药剂工厂.创建药剂(药剂类型枚举.大血瓶),
                药剂工厂.创建药剂(药剂类型枚举.小血瓶),
                药剂工厂.创建药剂(药剂类型枚举.大蓝瓶),
                药剂工厂.创建药剂(药剂类型枚举.小血瓶),
                药剂工厂.创建药剂(药剂类型枚举.大血瓶),
                药剂工厂.创建药剂(药剂类型枚举.小蓝瓶),
                药剂工厂.创建药剂(药剂类型枚举.大血瓶),
                药剂工厂.创建药剂(药剂类型枚举.大蓝瓶),
                药剂工厂.创建药剂(药剂类型枚举.小蓝瓶)
        ));
        伊利丹.喝药();
    }
}

class 恶魔猎手 {
    List<药剂> 药剂们;

    恶魔猎手(List<药剂> 药剂们) {
        this.药剂们 = 药剂们;
    }

    public void 喝药() {
        药剂们.forEach(药剂::喝);
    }
}

class 药剂工厂 {

    private final Map<药剂类型枚举, 药剂> map;

    public 药剂工厂() {
        map = new EnumMap<>(药剂类型枚举.class);
    }

    药剂 创建药剂(药剂类型枚举 药剂类型枚举) {
        药剂 药剂 = map.get(药剂类型枚举);
        if (药剂 != null) {
            return 药剂;
        }
        switch (药剂类型枚举) {
            case 小蓝瓶:
                药剂 = new 小蓝瓶();
                map.put(药剂类型枚举.小蓝瓶, 药剂);
                break;
            case 大蓝瓶:
                药剂 = new 大蓝瓶();
                map.put(药剂类型枚举.大蓝瓶, 药剂);
                break;
            case 小血瓶:
                药剂 = new 小血瓶();
                map.put(药剂类型枚举.小血瓶, 药剂);
                break;
            case 大血瓶:
                药剂 = new 大血瓶();
                map.put(药剂类型枚举.大血瓶, 药剂);
                break;
            default:
                throw new IllegalArgumentException("错误的药剂类型:" + 药剂类型枚举);
        }

        return map.get(药剂类型枚举);
    }
}

enum 药剂类型枚举 {
    大蓝瓶,
    小蓝瓶,
    大血瓶,
    小血瓶
}

interface 药剂 {
    default int 获取唯一ID() {
        return System.identityHashCode(this);
    }

    void 喝();
}

class 大蓝瓶 implements 药剂 {
    @Override
    public void 喝() {
        System.out.println("你的蓝量增加了很多,药剂ID:" + 获取唯一ID());
    }
}

class 大血瓶 implements 药剂 {
    @Override
    public void 喝() {
        System.out.println("你血量增加了很多,药剂ID:" + 获取唯一ID());
    }
}

class 小血瓶 implements 药剂 {
    @Override
    public void 喝() {
        System.out.println("你血量增加了少许,药剂ID:" + 获取唯一ID());
    }
}

class 小蓝瓶 implements 药剂 {
    @Override
    public void 喝() {
        System.out.println("你蓝量增加了少许,药剂ID:" + 获取唯一ID());
    }
}
