package person.nightrunner;

import lombok.ToString;

/**
 * 用于constructor的"反范式",因为范式型constructor的参数过多,例如本例需要7个参数,后续还有可能增加更多参数,使用构造器这种方式只需要增加代码,不需要修改原有代码
 */
public class 构造器主程序 {
    public static void main(String[] args) {
        角色 角色 = new 角色.构造器(职业.亚马逊, "射射射")
                .设置发型(发型.长马尾)
                .设置发色(发色.红色)
                .设置武器(武器.弓)
                .设置副手(副手.箭袋)
                .设置装甲(装甲.轻甲).构建();
        System.out.println("角色 = " + 角色);
    }
}

@ToString
class 角色 {
    private 职业 职业;
    private 发型 发型;
    private 发色 发色;
    private 武器 武器;
    private 装甲 装甲;
    private 副手 副手;
    private String 角色名称;

    public 角色(构造器 构造器) {
        this.角色名称 = 构造器.角色名称;
        this.发型 = 构造器.发型;
        this.发色 = 构造器.发色;
        this.武器 = 构造器.武器;
        this.装甲 = 构造器.装甲;
        this.职业 = 构造器.职业;
        this.副手 = 构造器.副手;
    }

    public static class 构造器 {
        职业 职业;
        发型 发型;
        发色 发色;
        武器 武器;
        副手 副手;
        装甲 装甲;
        String 角色名称;

        public 构造器(职业 职业, String 角色名称) {
            this.职业 = 职业;
            this.角色名称 = 角色名称;
        }

        public 构造器 设置发色(发色 发色) {
            this.发色 = 发色;
            return this;
        }

        public 构造器 设置发型(发型 发型) {
            this.发型 = 发型;
            return this;
        }

        public 构造器 设置武器(武器 武器) {
            this.武器 = 武器;
            return this;
        }

        public 构造器 设置副手(副手 副手) {
            this.副手 = 副手;
            return this;
        }

        public 构造器 设置装甲(装甲 装甲) {
            this.装甲 = 装甲;
            return this;
        }

        public 角色 构建() {
            return new 角色(this);
        }
    }
}

enum 职业 {
    刺客,
    德鲁伊,
    法师,
    圣骑士,
    野蛮人,
    亚马逊,
    死灵法师
}

enum 发型 {
    秃头,
    披肩长发,
    长马尾,
    短发;
}

enum 发色 {
    红色,
    白色,
    黑色,
    绿色,
    紫色
}

enum 武器 {
    法杖,
    短剑,
    双手剑,
    双手斧,
    双手锤,
    爪子,
    弓,
    弩
}

enum 副手 {
    盾牌,
    死灵法师尿壶,
    爪子,
    箭袋,
    弩袋
}

enum 装甲 {
    布甲,
    轻甲,
    重甲
}




