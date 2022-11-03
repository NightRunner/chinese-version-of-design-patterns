package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 我来帮你管理地洞里放几个人!
 */
public class 代理模式主程序 {
    public static void main(String[] args) {
        兽族地洞代理 代理 = new 兽族地洞代理(new 兽族地洞());
        代理.加入一个苦工(new 兽族苦工());
        代理.加入一个苦工(new 兽族苦工());
        代理.加入一个苦工(new 兽族苦工());
        代理.加入一个苦工(new 兽族苦工());
        代理.加入一个苦工(new 兽族苦工());
        代理.加入一个苦工(new 兽族苦工());
        代理.加入一个苦工(new 兽族苦工());
    }
}

interface 兽族地洞接口 {
    void 加入一个苦工(兽族苦工 苦工);

    List<兽族苦工> 获取苦工们();
}

class 兽族苦工 {
}

class 兽族地洞 implements 兽族地洞接口 {

    List<兽族苦工> 苦工们 = new ArrayList<>();

    @Override
    public void 加入一个苦工(兽族苦工 兽族苦工) {
        苦工们.add(兽族苦工);
        System.out.println("加入了一个兽族苦工");
    }

    @Override
    public List<兽族苦工> 获取苦工们() {
        return 苦工们;
    }
}

class 兽族地洞代理 implements 兽族地洞接口 {

    private 兽族地洞接口 地洞;

    public 兽族地洞代理(兽族地洞接口 地洞) {
        this.地洞 = 地洞;
    }

    @Override
    public void 加入一个苦工(兽族苦工 兽族苦工) {
        if (地洞.获取苦工们().size() <= 3) {
            地洞.加入一个苦工(兽族苦工);
        } else {
            System.out.println("不能在加入更多的苦工啦");
        }
    }

    @Override
    public List<兽族苦工> 获取苦工们() {
        return 地洞.获取苦工们();
    }
}
