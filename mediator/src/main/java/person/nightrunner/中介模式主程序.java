package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式可以实现光环效果!!!
 */
public class 中介模式主程序 {
    public static void main(String[] args) {
        白牛 白牛 = new 白牛();
        大法师 大法师 = new 大法师();
        圣骑士 圣骑士 = new 圣骑士();
        牛头人酋长 牛头人酋长 = new 牛头人酋长();

        团体 团体 = new 团体实现();
        团体.增加成员(白牛);
        团体.增加成员(大法师);
        团体.增加成员(圣骑士);
        团体.增加成员(牛头人酋长);

        白牛.发起团体效果(new 灵魂锁链());
        大法师.发起团体效果(new 辉煌光环());
        圣骑士.发起团体效果(new 守护光环());
        牛头人酋长.发起团体效果(new 耐久光环());
    }
}

interface 效果 {
    String 获取描述();
}

class 辉煌光环 implements 效果 {
    @Override
    public String 获取描述() {
        return "魔法恢复速度提高";
    }
}

class 守护光环 implements 效果 {
    @Override
    public String 获取描述() {
        return "护甲值提高";
    }
}

class 耐久光环 implements 效果 {
    @Override
    public String 获取描述() {
        return "攻击和移动速度增加";
    }
}

class 灵魂锁链 implements 效果 {
    @Override
    public String 获取描述() {
        return "均摊伤害";
    }
}

interface 团体 {
    void 增加成员(成员 成员);

    void 触发(成员 成员, 效果 光环);
}

class 团体实现 implements 团体 {

    private List<成员> 成员们 = new ArrayList<>();

    @Override
    public void 增加成员(成员 成员) {
        成员们.add(成员);
        成员.加入团体(this);
        System.out.println(成员.getClass().getSimpleName() + "加入团体");
    }

    @Override
    public void 触发(成员 成员, 效果 效果) {
        if (成员们.size() > 0) {
            for (成员 各成员 : 成员们) {
                if (!成员.equals(各成员)) {
                    各成员.团体效果(效果);
                }
            }
        }
    }
}

interface 成员 {
    void 加入团体(团体 团体);

    void 团体效果(效果 效果);

    void 发起团体效果(效果 效果);
}

abstract class 默认成员实现 implements 成员 {
    protected 团体 团体;

    @Override
    public void 加入团体(团体 团体) {
        this.团体 = 团体;
    }

    @Override
    public void 团体效果(效果 效果) {
        System.out.println("团队效果:" + 效果.getClass().getSimpleName() + "对" + this.getClass().getSimpleName() + "产生效果:" + 效果.获取描述());
    }

    @Override
    public void 发起团体效果(效果 效果) {
        System.out.println(this.getClass().getSimpleName() + "开启" + 效果.getClass().getSimpleName() + "效果:" + 效果.获取描述());
        团体.触发(this, 效果);
    }
}

class 大法师 extends 默认成员实现 {
}

class 白牛 extends 默认成员实现 {
}

class 牛头人酋长 extends 默认成员实现 {
}

class 圣骑士 extends 默认成员实现 {
}



