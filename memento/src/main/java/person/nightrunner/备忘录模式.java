package person.nightrunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 备忘录模式可以实现存档
 */
public class 备忘录模式 {
    public static void main(String[] args) {
        List<存档> 存档集合 = new ArrayList<>();
        恶魔猎手 恶魔猎手 = new 恶魔猎手("伊利丹");
        恶魔猎手.显示状态();
        存档集合.add(恶魔猎手.获取存档());

        恶魔猎手.当前地点 = "暴风城";
        恶魔猎手.血量 = 10;
        恶魔猎手.蓝量 = 0;
        恶魔猎手.显示状态();
        存档集合.add(恶魔猎手.获取存档());

        恶魔猎手.血量 = 0;
        恶魔猎手.蓝量 = 0;
        恶魔猎手.显示状态();

        int 存档下标 = -1;
        do {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 存档集合.size(); i++) {
                System.out.println(i + ":" + 存档集合.get(i).摘要);
            }
            System.out.print("请输入要恢复存档的数字：");

            int 下标 = 存档下标 = sc.nextInt();
            if (下标 < 0 || 下标 > (存档集合.size() - 1)) {
                System.out.println("输入错误,请重新输入");
            } else {
                break;
            }
        } while (true);

        恶魔猎手.恢复存档(存档集合.get(存档下标));
        恶魔猎手.显示状态();
    }
}

interface 角色 {
    存档 获取存档();

    void 恢复存档(存档 存档);

    void 显示状态();
}

abstract class 角色默认抽象实现 implements 角色 {
    String 当前地点 = "玛顿";

    Integer 血量 = 200;

    Integer 蓝量 = 300;

    final String 姓名;

    public 角色默认抽象实现(String 姓名) {
        this.姓名 = 姓名;
    }

    @Override
    public 存档 获取存档() {
        存档 存档 = new 存档();
        存档.地点 = 当前地点;
        存档.血量 = 血量;
        存档.蓝量 = 蓝量;
        存档.时间 = new Date();
        存档.摘要 = this.toString();
        System.out.println(this.getClass().getSimpleName() + "保存存档:" + 存档);
        return 存档;
    }

    public void 恢复存档(存档 存档) {
        this.血量 = 存档.血量;
        this.蓝量 = 存档.蓝量;
        this.当前地点 = 存档.地点;
        System.out.println(this.getClass().getSimpleName() + "恢复存档:" + 存档);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + 姓名 + "{" +
                "当前地点=" + 当前地点 +
                ", 血量=" + 血量 +
                ", 蓝量=" + 蓝量 +
                '}';
    }

    @Override
    public void 显示状态() {
        if (血量 < 1) {
            System.out.println(this.getClass().getSimpleName() + ":" + 姓名 + "挂了");
        } else {
            System.out.println(this);
        }
    }
}

class 恶魔猎手 extends 角色默认抽象实现 {
    public 恶魔猎手(String 昵称) {
        super(昵称);
    }
}

interface 备忘录 {
}

class 存档 implements 备忘录 {
    public 存档() {
    }

    Date 时间;

    String 摘要;

    String 地点;

    Integer 血量;

    Integer 蓝量;

    @Override
    public String toString() {
        return "存档{" +
                "时间=" + 时间 +
                ", 摘要='" + 摘要 + '\'' +
                ", 地点=" + 地点 +
                ", 血量=" + 血量 +
                ", 蓝量=" + 蓝量 +
                '}';
    }
}




