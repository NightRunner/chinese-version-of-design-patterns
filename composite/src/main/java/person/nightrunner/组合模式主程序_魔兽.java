package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 魔兽的单位体系可以用组合模式表示,就像一个树!
 */
public class 组合模式主程序_魔兽 {
    public static void main(String[] args) {
        种族 种族 = new 种族("暗夜精灵",
                new 单位组[]{
                        new 分类("英雄", 单位.创建多个("恶魔猎手", "守望者", "老鹿", "白虎")),
                        new 分类("一本兵", 单位.创建多个("弓箭手", "女猎手", "投刃车")),
                        new 分类("二本兵", 单位.创建多个("小鹿", "肉熊", "角鹰兽", "风德", "精灵龙")),
                        new 分类("三本兵", 单位.创建多个("趴下的熊", "奇美拉", "山岭巨人"))
                });
        种族.打印();
    }
}


abstract class 单位组 {

    static int 空格个数 = 0;

    public String 生成空格() {
        String 空格 = "";
        for (int i = 0; i < 空格个数; i++) {
            空格 += "   ";
        }
        return 空格;
    }

    protected String 名称;

    public void 增加(单位组 单位组) {
        子节点.add(单位组);
    }

    List<单位组> 子节点 = new ArrayList<>();

    protected void 打印前() {
        System.out.println(生成空格() + 名称 + ":{");
        空格个数++;
    }

    protected void 打印后() {
        空格个数--;
        System.out.println();
        System.out.println(生成空格() + "}");
    }

    protected void 打印() {
        打印前();
        for (单位组 单位组 : 子节点) {
            单位组.打印();
        }
        打印后();
    }
}

class 单位 extends 单位组 {

    public static 单位[] 创建多个(String... 字符串) {
        单位[] 字们 = new 单位[字符串.length];

        for (int i = 0; i < 字符串.length; i++) {
            字们[i] = new 单位(字符串[i]);
        }

        return 字们;
    }

    public 单位(String 名称) {
        this.名称 = 名称;
    }

    @Override
    protected void 打印() {
        System.out.print(生成空格() + 名称 + " ");
    }

    @Override
    protected void 打印前() {
    }

    @Override
    protected void 打印后() {
    }
}

class 分类 extends 单位组 {


    public 分类(String 名称, 单位... 单位们) {
        this.名称 = 名称;
        for (单位 单位 : 单位们) {
            this.增加(单位);
        }
    }

}

class 种族 extends 单位组 {

    public 种族(String 名称, 单位组... 词们) {
        this.名称 = 名称;
        for (单位组 单位组 : 词们) {
            this.增加(单位组);
        }
    }

    @Override
    protected void 打印后() {
        System.out.print("\n");
    }
}
