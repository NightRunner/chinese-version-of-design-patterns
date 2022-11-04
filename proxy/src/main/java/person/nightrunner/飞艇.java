package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

class 飞艇 implements 魔兽容器接口<魔兽单位接口> {

    List<魔兽单位接口> 魔兽单位们 = new ArrayList<>();

    @Override
    public void 放入一个单位(魔兽单位接口 兽族苦工) {
        魔兽单位们.add(兽族苦工);
        System.out.println("成功放入一个单位");
    }

    @Override
    public List<魔兽单位接口> 获取单位们() {
        return 魔兽单位们;
    }

    @Override
    public Integer 获取最大容量() {
        return 8;
    }
}
