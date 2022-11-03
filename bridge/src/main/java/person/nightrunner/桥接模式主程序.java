package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * buff太多,剑圣需要桥接模式!
 */
public class 桥接模式主程序 {
    public static void main(String[] args) {
        List<Buff> buff们 = new ArrayList<>();
        buff们.add(new 嗜血术());
        buff们.add(new 耐久光环());

        游戏单位 剑圣 = new 剑圣(buff们);
        剑圣.移动();
        System.out.println();
        剑圣.攻击();
        System.out.println();
        剑圣.死亡();
        System.out.println();


        buff们 = new ArrayList<>();
        buff们.add(new 心灵之火());
        恶魔猎手 恶魔猎手 = new 恶魔猎手(buff们);
        恶魔猎手.移动();
        System.out.println();
        恶魔猎手.攻击();
        System.out.println();
        恶魔猎手.死亡();
        System.out.println();
    }
}

class 恶魔猎手 implements 游戏单位 {
    public 恶魔猎手(List<Buff> buffs) {
        this.buffs = buffs;
    }

    private List<Buff> buffs = new ArrayList<>();

    @Override
    public List<Buff> 获取Buff们() {
        return buffs;
    }

    public 恶魔猎手(游戏单位 单位, List<Buff> buffs) {
        this.buffs = buffs;
    }

    @Override
    public void 移动() {
        for (Buff buff : buffs) {
            buff.激活();
        }
        System.out.println("恶魔猎手拿着双刀刀跑路呢");
    }

    @Override
    public void 攻击() {
        for (Buff buff : buffs) {
            buff.生效();
        }
        System.out.println("恶魔猎手拿着双刀砍向敌人");
    }


    @Override
    public void 死亡() {
        System.out.println("恶魔猎手缓缓倒下");
        for (Buff buff : buffs) {
            buff.消失();
        }
    }
}

class 剑圣 implements 游戏单位 {
    public 剑圣(List<Buff> buffs) {
        this.buffs = buffs;
    }

    private List<Buff> buffs = new ArrayList<>();

    @Override
    public List<Buff> 获取Buff们() {
        return buffs;
    }

    public 剑圣(游戏单位 单位, List<Buff> buffs) {
        this.buffs = buffs;
    }

    @Override
    public void 移动() {
        for (Buff buff : buffs) {
            buff.激活();
        }
        System.out.println("剑圣拿着西瓜刀跑路呢");
    }

    @Override
    public void 攻击() {
        for (Buff buff : buffs) {
            buff.生效();
        }
        System.out.println("剑圣的西瓜刀砍向敌人");
    }


    @Override
    public void 死亡() {
        System.out.println("剑圣缓缓倒下");
        for (Buff buff : buffs) {
            buff.消失();
        }
    }
}

interface Buff {
    void 激活();

    void 生效();

    void 消失();
}

interface 游戏单位 {

    void 移动();

    void 攻击();

    void 死亡();

    List<Buff> 获取Buff们();
}

class 耐久光环 implements Buff {
    @Override
    public void 激活() {
        System.out.println("单位下方出现耐久光环");
    }

    @Override
    public void 消失() {
        System.out.println("单位下方出现耐久光环消失");
    }

    @Override
    public void 生效() {
        System.out.println("速度和移动速度增加");
    }
}

class 嗜血术 implements Buff {
    @Override
    public void 激活() {
        System.out.println("单位体积变大,双手变红发光");
    }

    @Override
    public void 消失() {
        System.out.println("单位体积恢复,双手黯淡下来");
    }

    @Override
    public void 生效() {
        System.out.println("攻击速度增加");
    }

}

class 心灵之火 implements Buff {
    @Override
    public void 激活() {
        System.out.println("单位上方出现黄色印记");
    }

    @Override
    public void 消失() {
        System.out.println("单位上方黄色印记慢慢黯淡,直至消失");
    }

    @Override
    public void 生效() {
        System.out.println("单位攻击力和护甲增加");
    }
}



