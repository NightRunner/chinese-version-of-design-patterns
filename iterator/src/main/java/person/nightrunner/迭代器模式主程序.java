package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器可以获取小队中的所有单位!!!
 */
public class 迭代器模式主程序 {

    public static void main(String[] args) {
        部队 队列 = new 部队<魔兽可选择单位>();
        队列.增加单位(new 弓箭手());
        队列.增加单位(new 弓箭手());
        队列.增加单位(new 弓箭手());
        队列.增加单位(new 女猎手());
        队列.增加单位(new 女猎手());
        队列.增加单位(new 女猎手());
        队列.增加单位(new 恶魔猎手());
        队列.增加单位(new 战争古树());

        for (单位类型 单位类型 : 单位类型.values()) {
            System.out.printf("部队中的%s单位:%n", 单位类型);
            迭代器<魔兽可选择单位> 获取迭代器 = 队列.获取迭代器(单位类型);
            while (获取迭代器.还有么()) {
                System.out.print(获取迭代器.下一个().getClass().getSimpleName() + " ");
            }
            System.out.println();
        }
    }

}

enum 单位类型 {
    建筑, 英雄, 小兵, 所有
}

interface 魔兽可选择单位 {
    单位类型 获取单位类型();
}

interface 英雄 extends 魔兽可选择单位 {
    @Override
    default 单位类型 获取单位类型() {
        return 单位类型.英雄;
    }
}

interface 建筑 extends 魔兽可选择单位 {
    @Override
    default 单位类型 获取单位类型() {
        return 单位类型.建筑;
    }
}

interface 小兵 extends 魔兽可选择单位 {
    @Override
    default 单位类型 获取单位类型() {
        return 单位类型.小兵;
    }
}

class 弓箭手 implements 小兵 {
}

class 女猎手 implements 小兵 {
}

class 恶魔猎手 implements 英雄 {
}

class 战争古树 implements 建筑 {
}

class 部队<T> {
    List<T> 单位们 = new ArrayList<>();

    public 部队() {
    }

    迭代器<T> 获取迭代器(单位类型 单位类型) {
        return new 迭代器实现(this, 单位类型);
    }

    public List<T> 获取单位们() {
        return 单位们;
    }

    public void 增加单位(T 单位) {
        单位们.add(单位);
    }
}

interface 迭代器<T> {

    T 下一个();

    boolean 还有么();

}

class 迭代器实现<T extends 魔兽可选择单位> implements 迭代器<T> {

    单位类型 单位类型;

    部队<T> 部队;

    int 当前下标;

    迭代器实现(部队 部队, 单位类型 单位类型) {
        this.部队 = 部队;
        this.单位类型 = 单位类型;
        this.当前下标 = -1;
    }

    @Override
    public T 下一个() {
        当前下标 = 获取下一个的下标();
        if (当前下标 != -1) {
            return 部队.获取单位们().get(当前下标);
        }
        return null;
    }

    @Override
    public boolean 还有么() {
        return 获取下一个的下标() != -1;
    }

    private int 获取下一个的下标() {
        List<T> 单位们 = 部队.获取单位们();
        int 临时下标 = 当前下标;
        while (true) {
            临时下标++;
            if (临时下标 >= 单位们.size()) {
                临时下标 = -1;
                break;
            }
            if (单位类型.所有 == 单位类型 || 单位们.get(临时下标).获取单位类型() == 单位类型) {
                break;
            }
        }
        return 临时下标;
    }
}