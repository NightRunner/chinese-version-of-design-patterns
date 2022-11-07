package person.nightrunner;

/**
 * 伊利丹:你们这是自寻死路!!!
 * you are not prepared!!!
 * <p>
 * PS:恶魔猎手有多重攻击策略,当然这取决与是否带了法球和是否变身
 */
public class 策略模式主程序 {
    public static void main(String[] args) {
        恶魔猎手 恶魔猎手 = new 恶魔猎手();
        人族步兵 人族步兵 = new 人族步兵();
        恶魔猎手.攻击(人族步兵);
        人族步兵.攻击(恶魔猎手);

        恶魔猎手.设置攻击策略(new 远程法球攻击策略());
        人族狮鹫 人族狮鹫 = new 人族狮鹫();
        恶魔猎手.攻击(人族狮鹫);
        人族狮鹫.攻击(恶魔猎手);

        恶魔猎手.设置攻击策略(new 远程混乱攻击策略());
        大法师 大法师 = new 大法师();
        恶魔猎手.攻击(大法师);
        大法师.攻击(恶魔猎手);
    }
}

abstract class 魔兽兵种单位接口 {
    魔兽兵种单位接口(攻击策略 攻击策略) {
        this.攻击策略 = 攻击策略;
    }

    攻击策略 攻击策略;

    void 设置攻击策略(攻击策略 攻击策略) {
        this.攻击策略 = 攻击策略;
    }

    void 攻击(魔兽兵种单位接口 被攻击单位) {
        攻击策略.攻击(this, 被攻击单位);
    }
}

class 大法师 extends 魔兽兵种单位接口 {
    大法师() {
        super(new 远程法球攻击策略());
    }
}

class 人族步兵 extends 魔兽兵种单位接口 {
    人族步兵() {
        super(new 近战攻击策略());
    }
}

class 人族狮鹫 extends 魔兽兵种单位接口 {
    public 人族狮鹫() {
        super(new 远程攻击策略());
    }
}

class 恶魔猎手 extends 魔兽兵种单位接口 {

    public 恶魔猎手() {
        super(new 近战攻击策略());
    }

}

interface 攻击策略 {
    default void 攻击(魔兽兵种单位接口 攻击单位, 魔兽兵种单位接口 被攻击单位) {
        System.out.printf("[%s]使用了[%s]攻击了[%s]%n", 攻击单位.getClass().getSimpleName(), this.getClass().getSimpleName(),
                被攻击单位.getClass().getSimpleName());
    }
}

class 近战攻击策略 implements 攻击策略 {
}

class 远程攻击策略 implements 攻击策略 {
}

class 远程法球攻击策略 implements 攻击策略 {
}

class 远程混乱攻击策略 implements 攻击策略 {
}

