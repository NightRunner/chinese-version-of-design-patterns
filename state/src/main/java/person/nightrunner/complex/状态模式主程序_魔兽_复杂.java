package person.nightrunner.complex;

/**
 * Hello world!
 */
public class 状态模式主程序_魔兽_复杂 {
    public static void main(String[] args) {
        恶魔猎手 恶魔猎手 = new 恶魔猎手();
        恶魔猎手.移动();
        恶魔猎手.攻击();
        split();

        恶魔猎手.变身();
        恶魔猎手.移动();
        恶魔猎手.攻击();
        split();

        恶魔猎手.上飞艇();
        恶魔猎手.移动();
        恶魔猎手.攻击();
        split();

        恶魔猎手.下飞艇();
        恶魔猎手.移动();
        恶魔猎手.攻击();
        split();

        恶魔猎手.恢复普通状态();
        恶魔猎手.移动();
        恶魔猎手.攻击();
        split();
    }

    private static void split() {
        System.out.println("********************************");
    }
}

interface 魔兽作战单位 {
    状态 获取状态();

    void 变更状态(状态 状态);

    void 进入代理状态(状态 状态);

    void 进入载具();

    void 退出载具();

    void 攻击();

    void 移动();
}

abstract class 魔兽作战单位抽象实现 implements 魔兽作战单位 {
    状态 状态 = new 普通状态();

    public void 进入载具() {
        this.状态 = new 载具状态(状态);
    }

    @Override
    public void 退出载具() {
        this.状态 = ((载具状态) this.状态).获取原状态();
    }

    @Override
    public 状态 获取状态() {
        return 状态;
    }

    @Override
    public void 攻击() {
        状态.攻击(this);
    }

    @Override
    public void 移动() {
        状态.移动(this);
    }

    @Override
    public void 变更状态(状态 新状态) {
        状态 原状态 = this.状态;

        boolean 新状态是否为代理状态 = 新状态.是否为代理状态();
        if (!新状态是否为代理状态) {
            原状态.退出状态(this);
        }

        boolean 原状态是否为代理状态 = 原状态.是否为代理状态();
        if (!原状态是否为代理状态) {
            新状态.进入状态(this);
        }

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
    boolean 是否为代理状态();

    void 进入状态(魔兽作战单位 单位);

    void 退出状态(魔兽作战单位 单位);

    void 攻击(魔兽作战单位 单位);

    void 移动(魔兽作战单位 单位);
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
    public void 移动(魔兽作战单位 单位) {
        System.out.println(单位 + "在" + this + "状态下移动");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean 是否为代理状态() {
        return false;
    }
}

class 载具状态 extends 状态默认实现 {

    状态 原状态;

    载具状态(状态 原状态) {
        this.原状态 = 原状态;
    }

    public 状态 获取原状态() {
        return 原状态;
    }

    @Override
    public void 进入状态(魔兽作战单位 单位) {
        System.out.println(单位 + "进入" + this + ",从地图上消失");
    }

    @Override
    public void 退出状态(魔兽作战单位 单位) {
        System.out.println(单位 + "退出" + this + ",从地图上出现");
    }

    @Override
    public void 攻击(魔兽作战单位 单位) {
        System.out.println(单位 + "载具状态下,无法攻击");
    }

    @Override
    public void 移动(魔兽作战单位 单位) {
        System.out.println(单位 + "在载具状态下,无法移动");
    }

    @Override
    public boolean 是否为代理状态() {
        return true;
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

    public void 上飞艇() {
        this.进入代理状态(new 载具状态(this.获取状态()));
    }

    public void 下飞艇() {
        this.变更状态(((载具状态) this.获取状态()).获取原状态());
    }
}
