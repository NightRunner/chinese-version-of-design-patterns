package person.nightrunner;

/**
 * 给狮鹫上个心灵之火!!
 */
public class 装饰器模式主程序 {
    public static void main(String[] args) {
        狮鹫接口 狮鹫 = new 狮鹫();
        狮鹫.显示外观();
        System.out.println("狮鹫.获取攻击力() = " + 狮鹫.获取攻击力());
        System.out.println("狮鹫.获取护甲值() = " + 狮鹫.获取护甲值());

        System.out.println();

        狮鹫接口 心灵之火狮鹫 = new 心灵之火狮鹫(狮鹫);
        心灵之火狮鹫.显示外观();
        System.out.println("心灵之火狮鹫.获取攻击力() = " + 心灵之火狮鹫.获取攻击力());
        System.out.println("心灵之火狮鹫.获取护甲值() = " + 心灵之火狮鹫.获取护甲值());
    }
}

interface 狮鹫接口 {
    Double 获取护甲值();

    Double 获取攻击力();

    void 显示外观();
}

class 狮鹫 implements 狮鹫接口 {
    @Override
    public Double 获取护甲值() {
        return 5D;
    }

    @Override
    public Double 获取攻击力() {
        return 40D;
    }

    @Override
    public void 显示外观() {
        System.out.println("我是一只威武的狮鹫,翱翔在天空");
    }
}

class 心灵之火狮鹫 implements 狮鹫接口 {
    狮鹫接口 狮鹫;

    心灵之火狮鹫(狮鹫接口 狮鹫) {
        this.狮鹫 = 狮鹫;
    }

    @Override
    public Double 获取护甲值() {
        return 狮鹫.获取护甲值() + 5;
    }

    @Override
    public Double 获取攻击力() {
        return 狮鹫.获取攻击力() * 1.1;
    }

    @Override
    public void 显示外观() {
        狮鹫.显示外观();
        System.out.println("我头上有一个大大的心灵之火BUFF");
    }
}
