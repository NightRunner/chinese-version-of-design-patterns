package person.nightrunner;

/**
 * 我来帮你管理地洞里放几个人!
 */
public class 静态代理模式主程序 {
    public static void main(String[] args) {
        兽族地洞静态代理 代理 = new 兽族地洞静态代理(new 兽族地洞());
        代理.放入一个单位(new 兽族苦工());
        代理.放入一个单位(new 兽族苦工());
        代理.放入一个单位(new 兽族苦工());
        代理.放入一个单位(new 兽族苦工());
        代理.放入一个单位(new 兽族苦工());
        代理.放入一个单位(new 兽族苦工());
        代理.放入一个单位(new 兽族苦工());
    }
}

