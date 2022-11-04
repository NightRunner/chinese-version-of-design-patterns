package person.nightrunner;

import java.util.List;

class 兽族地洞静态代理 implements 魔兽容器接口<兽族苦工> {

    private 魔兽容器接口 地洞;

    public 兽族地洞静态代理(魔兽容器接口 地洞) {
        this.地洞 = 地洞;
    }

    @Override
    public void 放入一个单位(兽族苦工 兽族苦工) {
        if (地洞.获取单位们().size() <= 3) {
            地洞.放入一个单位(兽族苦工);
        } else {
            System.out.println("不能在加入更多的苦工啦");
        }
    }

    @Override
    public List<兽族苦工> 获取单位们() {
        return 地洞.获取单位们();
    }


    @Override
    public Integer 获取最大容量() {
        return 4;
    }
}
