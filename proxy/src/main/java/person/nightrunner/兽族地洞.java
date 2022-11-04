package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

class 兽族地洞 implements 魔兽容器接口<兽族苦工> {

    List<兽族苦工> 苦工们 = new ArrayList<>();

    @Override
    public void 放入一个单位(兽族苦工 兽族苦工) {
        苦工们.add(兽族苦工);
        System.out.println("成功放入一个单位");
    }

    @Override
    public List<兽族苦工> 获取单位们() {
        return 苦工们;
    }

    @Override
    public Integer 获取最大容量() {
        return 4;
    }
}
