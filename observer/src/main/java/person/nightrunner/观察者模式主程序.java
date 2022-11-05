package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 进入夜晚,野怪们入睡啦!!!
 */
public class 观察者模式主程序 {
    public static void main(String[] args) {

        昼夜转换器 昼夜转换器 = new 昼夜转换器();

        昼夜转换器.增加观察者(new 月井());
        昼夜转换器.增加观察者(new 人马());
        昼夜转换器.增加观察者(new 石头人());
        昼夜转换器.增加观察者(new 巨魔());

        昼夜转换器.时间流逝(50);
    }
}

enum 昼夜 {
    白天,
    夜晚
}

interface 昼夜观察者 {
    void 昼夜变化(昼夜 变化后);
}

abstract class 野怪 implements 昼夜观察者 {
    @Override
    public void 昼夜变化(昼夜 变化后) {
        if (变化后 == 昼夜.夜晚) {
            System.out.printf("进入夜晚,%s慢慢进入沉睡%n", this);
        } else if (变化后 == 昼夜.白天) {
            System.out.printf("进入白天,%s慢慢开始苏醒%n", this);
        }
    }

    @Override
    public String toString() {
        return "野怪{" + this.getClass().getSimpleName() + "}";
    }
}

class 巨魔 extends 野怪 {
}

class 石头人 extends 野怪 {
}

class 人马 extends 野怪 {
}

class 月井 implements 昼夜观察者 {

    @Override
    public void 昼夜变化(昼夜 变化后) {
        if (变化后 == 昼夜.夜晚) {
            System.out.println("进入夜晚,月井开始缓慢恢复水量");
        } else if (变化后 == 昼夜.白天) {
            System.out.println("进入白天,月井无法恢复水量了");
        }
    }
}

class 昼夜转换器 {

    Integer 时钟 = 0;

    昼夜 当前昼夜 = 昼夜.夜晚;

    昼夜转换器() {
    }

    public void 时间流逝(Integer 小时数) {
        for (Integer i = 0; i < 小时数; i++) {
            时钟++;
            时钟 %= 25;

            boolean 昼夜交替时间 = 昼夜交替时间();

            if (昼夜交替时间) {
                System.out.printf("时间流逝了1个小时,现在是%s点,昼夜交替%n", 时钟 % 25, 当前昼夜);
                当前昼夜 = 当前昼夜 == 昼夜.夜晚 ? 昼夜.白天 : 昼夜.夜晚;
                通知观察者们(当前昼夜);
            } else {
                System.out.printf("时间流逝了1个小时,现在是%s点,%s%n", 时钟 % 25, 当前昼夜);
            }

        }
    }

    private boolean 昼夜交替时间() {
        return 时钟 == 7 || 时钟 == 17;
    }

    List<昼夜观察者> 昼夜观察者们 = new ArrayList<>();

    public void 增加观察者(昼夜观察者 昼夜观察者) {
        昼夜观察者们.add(昼夜观察者);
    }

    private void 通知观察者们(昼夜 变化后) {
        for (昼夜观察者 昼夜观察者 : 昼夜观察者们) {
            昼夜观察者.昼夜变化(变化后);
        }
    }

}
