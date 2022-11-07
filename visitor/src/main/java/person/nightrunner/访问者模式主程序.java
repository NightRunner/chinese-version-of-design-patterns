package person.nightrunner;

/**
 * 访问者可以统计魔兽大部分单位!!!
 * PS:欢迎补充!
 */
public class 访问者模式主程序 {
    public static void main(String[] args) {
        种族[] 种族 = new 种族[]{
                获取人族所有单位(),
                获取兽人所有单位(),
                获取暗夜精灵所有单位(),
                获取不死族所有单位(),
                获取中立所有单位()};

        种族访问者 种族访问者 = new 种族访问者();
        建筑访问者 建筑访问者 = new 建筑访问者();
        兵种访问者 兵种访问者 = new 兵种访问者();
        英雄访问者 英雄访问者 = new 英雄访问者();
        for (种族 各种族 : 种族) {
            各种族.接受访问(种族访问者);
            各种族.接受访问(建筑访问者);
            各种族.接受访问(兵种访问者);
            各种族.接受访问(英雄访问者);
        }

        System.out.println("魔兽争霸中共有:");
        System.out.printf("%s个种族%n", 种族访问者.数量);
        System.out.printf("%s种建筑%n", 建筑访问者.数量);
        System.out.printf("%s种英雄%n", 英雄访问者.数量);
        System.out.printf("%s种兵种%n", 建筑访问者.数量);
    }

    private static 种族 获取中立所有单位() {
        return new 种族("中立",
                new 建筑("酒馆",
                        new 英雄("娜迦海妖"),
                        new 英雄("黑暗游侠"),
                        new 英雄("熊猫酒仙"),
                        new 英雄("火焰领主", new 兵("小火人")),
                        new 英雄("深渊领主"),
                        new 英雄("地精修补匠", new 兵("小机器人")),
                        new 英雄("炼金术士"),
                        new 英雄("兽王", new 兵("豪猪"), new 兵("战鹰"))
                ),
                new 建筑("地精实验室", new 兵("地精飞艇"), new 兵("伐木机器人"), new 兵("炸弹人")),
                new 建筑("雇佣兵营地", new 兵("黄皮"), new 兵("绿皮"), new 兵("小石头人"), new 兵("白胖子")),
                new 建筑("市场"),
                new 建筑("地精商店"),
                new 建筑("巨龙栖地"),
                new 建筑("泉水"),
                new 建筑("地精船坞"),
                new 建筑("传送门")
        );
    }

    private static 种族 获取不死族所有单位() {
        return new 种族("不死族",
                new 建筑("黑暗祭坛",
                        new 英雄("死亡骑士"),
                        new 英雄("恐惧魔王", new 兵("地狱火")),
                        new 英雄("巫妖"),
                        new 英雄("地穴领主", new 兵("腐尸甲虫"))),
                new 建筑("大墓地", new 兵("侍僧")),
                new 建筑("亡者大厅"),
                new 建筑("黑色城堡"),
                new 建筑("地穴", new 兵("食尸鬼"), new 兵("地穴恶魔"), new 兵("石像鬼")),
                new 建筑("屠宰场", new 兵("憎恶"), new 兵("绞肉车"), new 兵("黑曜石像"), new 兵("毁灭者")),
                new 建筑("诅咒神庙", new 兵("亡灵巫师", new 兵("骷髅法师"), new 兵("骷髅战士")), new 兵("女妖")),
                new 建筑("牺牲深渊", new 兵("阴影")),
                new 建筑("埋骨地", new 兵("冰霜巨龙")),
                new 建筑("坟场"), new 建筑("闹鬼金矿"), new 建筑("通灵塔"), new 建筑("幽魂之塔"),
                new 建筑("蛛网怪塔"), new 建筑("古墓废墟")
        );
    }

    private static 种族 获取人族所有单位() {
        return new 种族("人族",
                new 建筑("列王祭坛",
                        new 英雄("大法师", new 兵("水元素")),
                        new 英雄("山丘之王"),
                        new 英雄("圣骑士"),
                        new 英雄("血法师", new 兵("火凤凰"))),
                new 建筑("兵营", new 兵("步兵"), new 兵("火枪手"), new 兵("骑士")),
                new 建筑("神秘圣地", new 兵("牧师"), new 兵("女巫"), new 兵("破法者")),
                new 建筑("车间", new 兵("飞行器"), new 兵("迫击炮"), new 兵("攻城坦克")),
                new 建筑("狮鹫笼", new 兵("狮鹫"), new 兵("龙鹰")),
                new 建筑("城市大厅", new 兵("农民"), new 兵("民兵")),
                new 建筑("议政厅"),
                new 建筑("城堡"),
                new 建筑("伐木场"), new 建筑("神秘宝库"), new 建筑("铁匠铺"), new 建筑("箭塔"),
                new 建筑("哨塔"), new 建筑("神秘之塔"), new 建筑("炮塔"), new 建筑("农场")
        );
    }

    private static 种族 获取兽人所有单位() {
        return new 种族("兽人",
                new 建筑("风暴祭坛",
                        new 英雄("剑圣"), new 英雄("先知",
                        new 兵("幽灵之狼"), new 兵("恐惧之狼"), new 兵("暗影之狼")),
                        new 英雄("牛头人酋长"),
                        new 英雄("暗影猎手", new 兵("蛇棒"))),
                new 建筑("兵营",
                        new 兵("兽人步兵"), new 兵("猎头者"), new 兵("狂暴猎头者"), new 兵("投石车")),
                new 建筑("灵魂归宿", new 兵("萨满祭司"), new 兵("巫医"), new 兵("灵魂行者")),
                new 建筑("兽栏",
                        new 兵("狼骑兵"), new 兵("科多兽"), new 兵("双足飞龙"), new 兵("巨魔蝙蝠骑士")),
                new 建筑("牛头人图腾", new 兵("牛头人哦")),
                new 建筑("大厅", new 兵("苦工")),
                new 建筑("据点"),
                new 建筑("堡垒"),
                new 建筑("战争磨坊"), new 建筑("地洞"), new 建筑("瞭望塔")
        );
    }

    private static 种族 获取暗夜精灵所有单位() {
        return new 种族("暗夜精灵",
                new 建筑("长者祭坛",
                        new 英雄("丛林守护者", new 兵("树人")),
                        new 英雄("月之女祭司", new 兵("猫头鹰")),
                        new 英雄("恶魔猎手"),
                        new 英雄("守望者", new 兵("复仇天神"), new 兵("复仇之魂"))
                ),
                new 建筑("生命之树", new 兵("小精灵")),
                new 建筑("岁月之树"),
                new 建筑("永恒之树"),
                new 建筑("战争古树", new 兵("弓箭手"), new 兵("女猎手"), new 兵("弩车")),
                new 建筑("风之古树",
                        new 兵("猛禽德鲁伊"), new 兵("角鹰兽"), new 兵("精灵龙"), new 兵("角鹰骑士")),
                new 建筑("知识古树", new 兵("树妖"), new 兵("利爪德鲁伊"), new 兵("山岭巨人")),
                new 建筑("奇美拉栖树", new 兵("奇美拉")),
                new 建筑("远古守护者"), new 建筑("猎手大厅"), new 建筑("月井"), new 建筑("奇迹古树")
        );
    }
}

interface 访问者 {
    void 访问(兵 兵);

    void 访问(建筑 建筑);

    void 访问(种族 种族);

    void 访问(英雄 英雄);
}

abstract class 默认访问者 implements 访问者 {
    protected Integer 数量 = 0;

    @Override
    public void 访问(建筑 建筑) {
    }

    @Override
    public void 访问(英雄 英雄) {
    }

    @Override
    public void 访问(兵 兵) {
    }

    @Override
    public void 访问(种族 种族) {
    }
}

class 建筑访问者 extends 默认访问者 {
    @Override
    public void 访问(建筑 对象) {
        数量++;
        System.out.println("这是:" + 对象.getClass().getSimpleName() + ":" + 对象.获取名称() + ",这个第" + 数量 + "个");
    }
}

class 英雄访问者 extends 默认访问者 {
    @Override
    public void 访问(英雄 对象) {
        数量++;
        System.out.println("这是:" + 对象.getClass().getSimpleName() + ":" + 对象.获取名称() + ",这个第" + 数量 + "个");
    }
}

class 兵种访问者 extends 默认访问者 {
    @Override
    public void 访问(兵 对象) {
        数量++;
        System.out.println("这是:" + 对象.getClass().getSimpleName() + ":" + 对象.获取名称() + ",这个第" + 数量 + "个");
    }
}

class 种族访问者 extends 默认访问者 {
    @Override
    public void 访问(种族 对象) {
        数量++;
        System.out.println("这是:" + 对象.getClass().getSimpleName() + ":" + 对象.获取名称() + ",这个第" + 数量 + "个");
    }
}

abstract class 魔兽单位 {

    private final String 名称;

    private final 魔兽单位[] 下级单位;

    public 魔兽单位(String 名称, 魔兽单位... 下级单位) {
        this.名称 = 名称;
        this.下级单位 = 下级单位;
    }

    public void 接受访问(访问者 访问者) {
        for (魔兽单位 魔兽单位 : 下级单位) {
            魔兽单位.接受访问(访问者);
        }
    }

    public String 获取名称() {
        return 名称;
    }
}


class 种族 extends 魔兽单位 {

    public void 接受访问(访问者 访问者) {
        访问者.访问(this);
        super.接受访问(访问者);
    }

    public 种族(String 名称, 魔兽单位... 下级单位) {
        super(名称, 下级单位);
    }
}

class 建筑 extends 魔兽单位 {

    public void 接受访问(访问者 访问者) {
        访问者.访问(this);
        super.接受访问(访问者);
    }

    public 建筑(String 名称, 魔兽单位... 下级单位) {
        super(名称, 下级单位);
    }
}

class 英雄 extends 魔兽单位 {

    public 英雄(String 名称, 魔兽单位... 下级单位) {
        super(名称, 下级单位);
    }

    @Override
    public void 接受访问(访问者 访问者) {
        访问者.访问(this);
        super.接受访问(访问者);
    }
}

class 兵 extends 魔兽单位 {

    public 兵(String 名称, 魔兽单位... 下级单位) {
        super(名称, 下级单位);
    }

    @Override
    public void 接受访问(访问者 访问者) {
        访问者.访问(this);
        super.接受访问(访问者);
    }
}
