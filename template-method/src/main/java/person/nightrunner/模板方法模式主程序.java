package person.nightrunner;

import java.util.HashMap;
import java.util.Map;

/**
 * "山丘:吃我一锤!!!!","恶魔猎手:我吸!!!!",其实都是一套技能模板,步骤一样,只是各个步骤有所区别
 * <p>
 * 释放技能的过程是一个模板,固定的套路,只是每个英雄的前后摇不同,产生效果不一样,甚至有些技能本身不需要前后摇
 */
public class 模板方法模式主程序 {
    public static void main(String[] args) {
        山丘之王 山丘之王 = new 山丘之王(new 风暴之锤(技能等级.一));
        山丘之王.释放技能();
        split();

        山丘之王.设置技能(new 天神下凡());
        山丘之王.释放技能();
        split();

        恶魔猎手 恶魔猎手 = new 恶魔猎手(new 魔法燃烧(技能等级.一));
        恶魔猎手.释放技能();
        split();

        山丘之王.设置技能(new 风暴之锤(技能等级.三));
        山丘之王.释放技能();
        split();

        山丘之王.设置技能(new 雷霆一击(技能等级.一));
        山丘之王.释放技能();
        split();

        山丘之王.设置技能(new 雷霆一击(技能等级.三));
        山丘之王.释放技能();
    }

    public static void split() {
        System.out.println("*************************************************");
    }
}

abstract class 英雄 {

    Integer 蓝量;

    技能 技能;

    public void 扣减蓝量(Integer 蓝量) {
        if (this.蓝量 - 蓝量 < 0) {
            throw new RuntimeException("没那么多蓝可扣");
        }
        this.蓝量 -= 蓝量;
    }

    public Integer 获取蓝量() {
        return 蓝量;
    }

    public 英雄() {
    }

    public 英雄(技能 技能) {
        this.技能 = 技能;
    }

    public void 设置技能(技能 技能) {
        this.技能 = 技能;
    }

    public void 释放技能() {
        技能.释放(this);
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "]";
    }
}

class 恶魔猎手 extends 英雄 {
    public 恶魔猎手(技能 技能) {
        super(技能);
        this.蓝量 = 240;
    }
}

class 山丘之王 extends 英雄 {
    public 山丘之王(技能 技能) {
        super(技能);
        this.蓝量 = 400;//应该是225,不过为了程序效果,用400
    }
}

enum 技能等级 {
    一, 二, 三
}

abstract class 技能 {
    技能() {
    }

    protected 技能等级 技能等级;

    技能(技能等级 技能等级) {
        this.技能等级 = 技能等级;
    }

    public void 设置技能等级(技能等级 技能等级) {
        this.技能等级 = 技能等级;
    }

    abstract Integer 获取消耗蓝量(技能等级 技能等级);

    abstract void 前摇(英雄 英雄);

    abstract void 释放本体(英雄 英雄);

    abstract void 后摇(英雄 英雄);

    abstract void 扣减蓝量(英雄 英雄);

    public final void 释放(英雄 英雄) {
        Integer 消耗蓝量 = 获取消耗蓝量(技能等级);
        System.out.printf("%s准备释放%s,当前蓝量%s,技能需要蓝量%s%n", 英雄, this, 英雄.获取蓝量(), this.获取消耗蓝量(技能等级));
        if (英雄.获取蓝量() - 消耗蓝量 < 0) {
            System.out.printf("%s蓝不够,放不了%s%n", 英雄, this);
            return;
        }
        System.out.println("蓝量充足");
        前摇(英雄);
        释放本体(英雄);
        扣减蓝量(英雄);
        后摇(英雄);
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "]";
    }
}

class 通用技能实现 extends 技能 {

    public static final int 默认耗蓝 = 75;

    通用技能实现() {
    }

    @Override
    Integer 获取消耗蓝量(技能等级 技能等级) {
        return 默认耗蓝;
    }

    public 通用技能实现(技能等级 技能等级) {
        super(技能等级);
    }

    @Override
    void 前摇(英雄 英雄) {
        System.out.printf("%s准备释放技能%s,做出了施法前摇动作%n", 英雄, this);
    }

    @Override
    void 释放本体(英雄 英雄) {
        System.out.printf("%s释放了%s[%s级]%n", 英雄, this, 技能等级);
    }

    @Override
    void 后摇(英雄 英雄) {
        System.out.printf("%s释放技能%s完毕,做出了施法后摇动作%n", 英雄, this);
    }

    @Override
    void 扣减蓝量(英雄 英雄) {
        Integer 消耗蓝量 = 获取消耗蓝量(技能等级);
        英雄.扣减蓝量(消耗蓝量);
        System.out.printf("%s扣减蓝量%s%n", 英雄, 消耗蓝量);
    }
}

class 风暴之锤 extends 通用技能实现 {

    HashMap<技能等级, Integer> 伤害列表;

    public 风暴之锤(技能等级 技能等级) {
        super(技能等级);
        伤害列表 = new HashMap<>();
        伤害列表.put(技能等级.一, 100);
        伤害列表.put(技能等级.二, 200);
        伤害列表.put(技能等级.三, 310);
    }

    @Override
    void 释放本体(英雄 英雄) {
        super.释放本体(英雄);
        System.out.printf("%s向目标单位扔出了[一个巨大的魔法锤子],目标陷入了眩晕,并产生%s点伤害%n", 英雄, 伤害列表.get(技能等级));
    }

}

class 魔法燃烧 extends 通用技能实现 {

    HashMap<技能等级, Integer> 伤害列表;

    public 魔法燃烧(技能等级 技能等级) {
        super(技能等级);
        伤害列表 = new HashMap<>();
        伤害列表.put(技能等级.一, 50);
        伤害列表.put(技能等级.二, 100);
        伤害列表.put(技能等级.三, 150);
    }

    @Override
    Integer 获取消耗蓝量(技能等级 技能等级) {
        return 60;
    }

    @Override
    void 释放本体(英雄 英雄) {
        super.释放本体(英雄);
        Integer 消耗蓝量 = 伤害列表.get(技能等级);
        System.out.printf("%s吸取目标法力值%s，并造成%s伤害%n", 英雄, 消耗蓝量, 消耗蓝量);
    }

}

class 雷霆一击 extends 通用技能实现 {

    Map<技能等级, Integer> 伤害列表;

    public 雷霆一击(技能等级 技能等级) {
        super(技能等级);
        伤害列表 = new HashMap<>();
        伤害列表.put(技能等级.一, 60);
        伤害列表.put(技能等级.二, 110);
        伤害列表.put(技能等级.三, 150);
    }

    @Override
    Integer 获取消耗蓝量(技能等级 技能等级) {
        return 90;
    }

    @Override
    void 释放本体(英雄 英雄) {
        super.释放本体(英雄);
        System.out.printf("%s向目标地面砸下了巨大的魔法锤子!!!,附近的敌人血量减少%s,并减速5秒%n", 英雄, 伤害列表.get(技能等级));
    }

}

class 天神下凡 extends 通用技能实现 {
    public 天神下凡() {
        设置技能等级(技能等级.一);
    }

    @Override
    Integer 获取消耗蓝量(技能等级 技能等级) {
        return 150;
    }

    @Override
    void 释放本体(英雄 英雄) {
        System.out.printf("%s释放了[天神下凡]!!!,这下他可以NB一分钟秒了,他变大了,还魔免了,血量也增加了500,攻击增加了20!!!", 英雄);
    }

    @Override
    void 前摇(英雄 英雄) {
        //没有前摇
    }

    @Override
    void 后摇(英雄 英雄) {
        //没有后摇
    }
}