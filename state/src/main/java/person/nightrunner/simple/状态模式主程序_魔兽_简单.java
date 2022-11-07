package person.nightrunner.simple;

/**
 * 恶魔猎手在不同状态下攻击方式不同
 */
public class 状态模式主程序_魔兽_简单 {
    public static void main(String[] args) {
        恶魔猎手 恶魔猎手 = new 恶魔猎手();
        恶魔猎手.攻击();
        split();

        恶魔猎手.变身();
        恶魔猎手.攻击();
        split();

        恶魔猎手.恢复普通状态();
        恶魔猎手.攻击();
        split();
    }

    private static void split() {
        System.out.println("********************************");
    }
}

interface 魔兽作战单位 {

    void 变更状态(状态 状态);

    void 进入代理状态(状态 状态);

    void 攻击();

}

abstract class 魔兽作战单位抽象实现 implements 魔兽作战单位 {
    状态 状态 = new 普通状态();

    @Override
    public void 攻击() {
        状态.攻击(this);
    }

    @Override
    public void 变更状态(状态 新状态) {
        状态 原状态 = this.状态;
        原状态.退出状态(this);
        新状态.进入状态(this);
        this.状态 = 新状态;
    }

    @Override
    public void 进入代理状态(状态 状态) {
        this.状态 = 状态;
        状态.进入状态(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

interface 状态 {

    void 进入状态(魔兽作战单位 单位);

    void 退出状态(魔兽作战单位 单位);

    void 攻击(魔兽作战单位 单位);

}

abstract class 状态默认实现 implements 状态 {
    @Override
    public void 进入状态(魔兽作战单位 单位) {
    }

    @Override
    public void 退出状态(魔兽作战单位 单位) {
        System.out.println(单位 + "退出" + this + "状态");
    }

    @Override
    public void 攻击(魔兽作战单位 单位) {
        System.out.println(单位 + "在" + this + "状态下发动攻击");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}

class 普通状态 extends 状态默认实现 {
}

class 大恶魔状态 extends 状态默认实现 {
    @Override
    public void 进入状态(魔兽作战单位 单位) {
        System.out.println(单位 + "进入大恶魔状态,恶魔猎手这下NB了,完全黑化,还长出了犄角和恶魔翅膀");
    }

    @Override
    public void 退出状态(魔兽作战单位 单位) {
        System.out.println(单位 + "退出大恶魔状态");
    }

    @Override
    public void 攻击(魔兽作战单位 单位) {
        System.out.println(单位 + "在大恶魔状态发动了远程混乱攻击!!!绿色的火球划过天际,砸向目标,目标受到混乱伤害,周边的地方单位也受到了波及!!");
    }

}

class 恶魔猎手 extends 魔兽作战单位抽象实现 implements 魔兽作战单位 {

    public void 变身() {
        this.变更状态(new 大恶魔状态());
    }

    public void 恢复普通状态() {
        this.变更状态(new 普通状态());
    }

}
