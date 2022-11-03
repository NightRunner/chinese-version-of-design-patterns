package person.nightrunner.complex;

/**
 * 原型模式+构造器模式
 */
public class 原型模式加构造器模式主程序 {
    public static void main(String[] args) {
        工厂接口 工厂接口 = new 工厂实现.构造器().设置战士(new 人族战士()).设置法师(new 人族法师()).设置飞行兵(new 人族飞行兵()).构建();
        System.out.println("工厂.创建战士() = " + 工厂接口.创建战士());
        System.out.println("工厂.创建法师() = " + 工厂接口.创建法师());
        System.out.println("工厂.创建飞行兵() = " + 工厂接口.创建飞行兵());

        工厂接口 = new 工厂实现.构造器().设置战士(new 兽族战士()).设置法师(new 兽族法师()).设置飞行兵(new 兽族飞行兵()).构建();
        System.out.println("工厂.创建战士() = " + 工厂接口.创建战士());
        System.out.println("工厂.创建法师() = " + 工厂接口.创建法师());
        System.out.println("工厂.创建飞行兵() = " + 工厂接口.创建飞行兵());
    }
}

interface 工厂接口 {
    战士 创建战士();

    法师 创建法师();

    飞行兵 创建飞行兵();
}

class 工厂实现 implements 工厂接口 {

    private 战士 战士;

    private 法师 法师;

    private 飞行兵 飞行兵;

    private 工厂实现() {
    }

    public 工厂实现(构造器 构造器) {
        this.战士 = 构造器.战士;
        this.法师 = 构造器.法师;
        this.飞行兵 = 构造器.飞行兵;
    }

    @Override
    public 战士 创建战士() {
        return 战士.复制();
    }

    @Override
    public 法师 创建法师() {
        return 法师.复制();
    }

    @Override
    public 飞行兵 创建飞行兵() {
        return 飞行兵.复制();
    }

    public static class 构造器 {

        private 战士 战士;

        private 法师 法师;

        private 飞行兵 飞行兵;

        构造器 设置战士(战士 战士) {
            this.战士 = 战士;
            return this;
        }

        构造器 设置法师(法师 法师) {
            this.法师 = 法师;
            return this;
        }

        构造器 设置飞行兵(飞行兵 飞行兵) {
            this.飞行兵 = 飞行兵;
            return this;
        }

        工厂实现 构建() {
            return new 工厂实现(this);
        }
    }

}

abstract class 战士 extends 原型接口<战士> {
    abstract String 获取名称();
}

abstract class 法师 extends 原型接口<法师> {
    abstract String 获取名称();
}

abstract class 飞行兵 extends 原型接口<飞行兵> {
    abstract String 获取名称();
}

class 人族战士 extends 战士 {
    @Override
    String 获取名称() {
        return "人族步兵";
    }
}

class 兽族战士 extends 战士 {
    @Override
    String 获取名称() {
        return "手足步兵";
    }
}

class 人族法师 extends 法师 {
    @Override
    String 获取名称() {
        return "女巫";
    }
}

class 兽族法师 extends 法师 {
    @Override
    String 获取名称() {
        return "萨满";
    }
}

class 兽族飞行兵 extends 飞行兵 {
    @Override
    String 获取名称() {
        return "飞龙";
    }
}

class 人族飞行兵 extends 飞行兵 {
    @Override
    String 获取名称() {
        return "狮鹫";
    }
}

abstract class 原型接口<T> implements Cloneable {
    public T 复制() {
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
