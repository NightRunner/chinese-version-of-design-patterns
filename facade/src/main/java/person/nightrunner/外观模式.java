package person.nightrunner;

/**
 * 看起来简单,实际很复杂!
 */
public class 外观模式 {
    public static void main(String[] args) {
        英雄外观 英雄 = new 英雄外观(new 山丘之王());
        英雄.放技能();
    }
}

class 英雄外观 {

    private 英雄接口 英雄;

    public 英雄外观(英雄接口 英雄) {
        this.英雄 = 英雄;
    }

    public void 放技能() {
        英雄.检查状态();
        英雄.检查蓝量();
        英雄.技能前摇();
        英雄.释放技能();
        英雄.扣减蓝量();
        英雄.技能后摇();
    }
}

interface 英雄接口 {
    void 技能前摇();

    void 技能后摇();

    void 释放技能();

    void 检查蓝量();

    void 检查状态();

    void 扣减蓝量();
}

class 山丘之王 implements 英雄接口 {

    private Integer 蓝量 = 200;

    @Override
    public void 释放技能() {
        System.out.println("山丘之王扔出了风暴之锤!!!");
    }

    @Override
    public void 技能前摇() {
        System.out.println("山丘之王举起锤子");
    }

    @Override
    public void 技能后摇() {
        System.out.println("山丘之王放下锤子");
    }

    @Override
    public void 检查蓝量() {
        System.out.println("山丘之王蓝量检查完毕,可以释放");
    }

    @Override
    public void 检查状态() {
        System.out.println("山丘之王检查状态完毕,没有眩晕,可以释放");
    }

    @Override
    public void 扣减蓝量() {
        System.out.println("山丘之王蓝量减少");
    }
}


