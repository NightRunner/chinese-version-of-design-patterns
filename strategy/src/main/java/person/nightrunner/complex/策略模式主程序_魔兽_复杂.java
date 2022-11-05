package person.nightrunner.complex;

/**
 * 伊利丹:你们这是自寻死路!!!
 * you are not prepared!!!
 */
public class 策略模式主程序_魔兽_复杂 {
    public static void main(String[] args) {
        恶魔猎手 伊利丹 = new 恶魔猎手();
        伊利丹.攻击(new 人族步兵());
        伊利丹.攻击(new 兽族飞龙());

        伊利丹.带法球();
        伊利丹.攻击(new 人族步兵());
        伊利丹.攻击(new 兽族飞龙());

        伊利丹.变身大恶魔();
        伊利丹.攻击(new 人族步兵());
        伊利丹.攻击(new 兽族飞龙());

        伊利丹.恢复本体();
        伊利丹.攻击(new 人族步兵());
        伊利丹.攻击(new 兽族飞龙());

        伊利丹.不带法球();
        伊利丹.攻击(new 人族步兵());
        伊利丹.攻击(new 兽族飞龙());
    }
}

enum 单位类型 {
    地面, 空中, 建筑
}

interface 单位 {
    单位类型 获取单位类型();
}

abstract class 单位默认实现 implements 单位 {

    单位类型 单位类型;

    @Override
    public 单位类型 获取单位类型() {
        return 单位类型;
    }

    public void 设置单位类型(单位类型 单位类型) {
        this.单位类型 = 单位类型;
    }

    public 单位默认实现() {
    }

    @Override
    public String toString() {
        return 单位类型 + "单位{" + this.getClass().getSimpleName() + "}";
    }
}

class 人族步兵 extends 单位默认实现 {
    public 人族步兵() {
        设置单位类型(单位类型.地面);
    }
}

class 兽族飞龙 extends 单位默认实现 {
    public 兽族飞龙() {
        设置单位类型(单位类型.空中);
    }
}

class 生命之树 extends 单位默认实现 {
    public 生命之树() {
        设置单位类型(单位类型.建筑);
    }
}

class 恶魔猎手 extends 单位默认实现 {

    Boolean 是否有法球 = false;

    private 攻击模式 攻击模式 = new 近战攻击();

    public 恶魔猎手() {
        设置单位类型(单位类型.地面);
    }

    public void 变身大恶魔() {
        攻击模式 = new 远程混乱攻击();
        System.out.println(this + "变身大恶魔");
    }

    public void 恢复本体() {
        攻击模式 = new 近战攻击();
        System.out.println(this + "恢复了本体");
    }

    public void 带法球() {
        是否有法球 = true;
        攻击模式.设置法球(true);

        System.out.println(this + "带上了法球");
    }

    public void 不带法球() {
        是否有法球 = false;
        攻击模式.设置法球(false);

        System.out.println(this + "卸下了法球");
    }

    public void 攻击(单位 被攻击方) {
        攻击模式.设置法球(是否有法球);
        攻击模式.攻击(this, 被攻击方);
    }

}

interface 攻击模式 {
    void 攻击(单位 攻击方, 单位... 被攻击方);

    void 设置法球(boolean 是否有法球);
}

abstract class 默认攻击模式 implements 攻击模式 {

    默认攻击模式() {
    }

    boolean 是否有法球 = false;

    public 默认攻击模式(boolean 是否有法球) {
        this.是否有法球 = 是否有法球;
    }

    @Override
    public void 设置法球(boolean 是否有法球) {
        this.是否有法球 = 是否有法球;
    }

    @Override
    public void 攻击(单位 攻击方, 单位... 被攻击方) {
        System.out.printf("%s使用%s模式攻击了%s%n", 攻击方, this.getClass().getSimpleName(), 被攻击方[0]);
        if (是否有法球) {
            System.out.println("并附带了法球效果");
        }
    }
}

class 近战攻击 extends 默认攻击模式 {

    public 近战攻击() {
    }

    public 近战攻击(boolean 是否有法球) {
        super(是否有法球);
    }

    @Override
    public void 攻击(单位 攻击方, 单位... 被攻击方) {
        单位 主要被攻击单位 = 被攻击方[0];

        if (单位类型.地面.equals(主要被攻击单位.获取单位类型())) {
            super.攻击(攻击方, 被攻击方);
            return;
        } else if (单位类型.空中.equals(主要被攻击单位.获取单位类型())) {
            if (是否有法球) {
                System.out.printf("%s%s攻击了%s%n", 攻击方, "使用法球远程模式", 主要被攻击单位);
            } else {
                System.out.printf("%s无法攻击%s%n", 攻击方, 主要被攻击单位);
                return;
            }
        }

        if (是否有法球) {
            System.out.println("并附带了法球效果");
        }
    }
}


class 远程攻击 extends 默认攻击模式 {
    远程攻击() {
    }

    public 远程攻击(boolean 法球效果) {
        super(法球效果);
    }

}

class 远程混乱攻击 extends 远程攻击 {

    public 远程混乱攻击(boolean 法球效果) {
        super(法球效果);
    }

    public 远程混乱攻击() {
    }

    @Override
    public void 攻击(单位 攻击方, 单位... 被攻击方) {
        super.攻击(攻击方, 被攻击方);
        System.out.println("混乱攻击使附近的单位也收到攻击");
    }
}






