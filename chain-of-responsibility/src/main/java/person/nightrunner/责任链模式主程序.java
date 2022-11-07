package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 山丘之王:看我天神下凡的魔免责任链!!!
 */
public class 责任链模式主程序 {
    public static void main(String[] args) {
        //为山丘之王增加所有状态
        魔兽单位 山丘之王 = new 山丘之王();
        for (状态 状态 : 状态.values()) {
            山丘之王.增加状态(状态);
        }

        //山丘之王使用天神下凡解除魔法状态
        System.out.println("山丘之王使用天神下凡!!!!");
        责任链 魔免责任链 = 创建魔免责任链();
        魔免责任链.执行(山丘之王);

        System.out.println("山丘之王天神下凡不能免疫如下状态:");
        山丘之王.获取所有状态().forEach(System.out::println);
    }

    private static 责任链 创建魔免责任链() {
        责任链 责任链 = new 责任链();
        for (状态 状态 : 状态.values()) {
            if (状态.是否为魔法效果()) {
                责任链.增加状态解除器(new 状态解除器实现(状态));
            }
        }
        return 责任链;
    }
}

class 责任链 {
    List<状态解除器> 状态接触器们;

    责任链() {
        状态接触器们 = new ArrayList<>();
    }

    void 增加状态解除器(状态解除器 状态解除器) {
        状态接触器们.add(状态解除器);
    }

    void 执行(魔兽单位 魔兽单位) {
        for (状态解除器 状态解除器 : 状态接触器们) {
            for (状态 状态 : 魔兽单位.获取所有状态()) {
                if (状态解除器.获取可以处理的状态().equals(状态)) {
                    状态解除器.执行(魔兽单位);
                    break;
                }
            }
        }
    }
}

interface 魔兽单位 {
    default void 移除状态(状态 状态) {
        获取所有状态().remove(状态);
        System.out.printf("%s消除了%s状态%n", this.getClass().getSimpleName(), 状态);
    }

    List<状态> 获取所有状态();

    default void 增加状态(状态 状态) {
        获取所有状态().add(状态);
        System.out.printf("%s增加了%s状态%n", this.getClass().getSimpleName(), 状态);
    }
}

class 山丘之王 implements 魔兽单位 {

    List<状态> 所有状态 = new ArrayList<>();

    @Override
    public List<状态> 获取所有状态() {
        return 所有状态;
    }
}

interface 状态解除器 {
    状态 获取可以处理的状态();

    default void 执行(魔兽单位 魔兽单位) {
        魔兽单位.移除状态(获取可以处理的状态());
    }
}

class 状态解除器实现 implements 状态解除器 {
    状态 状态;

    状态解除器实现(状态 状态) {
        this.状态 = 状态;
    }

    @Override
    public 状态 获取可以处理的状态() {
        return this.状态;
    }
}

enum 状态 {
    物理眩晕(false), 魔法眩晕(true), 冰冻(true), 减速(true), 中毒(false), 心灵之火(true), 灵魂锁链(true), 回春术(true), 放逐(true);

    private boolean 魔法效果;

    状态(boolean 魔法效果) {
        this.魔法效果 = 魔法效果;
    }

    public boolean 是否为魔法效果() {
        return 魔法效果;
    }
}