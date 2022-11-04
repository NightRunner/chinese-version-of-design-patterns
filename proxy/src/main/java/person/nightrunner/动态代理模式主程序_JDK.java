package person.nightrunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 只要是能进人的,我都能管!
 */
public class 动态代理模式主程序_JDK {
    public static void main(String[] args) {
        兽族地洞 地洞 = new 兽族地洞();
        魔兽容器代理类 地洞动态代理 = new 魔兽容器代理类();
        地洞动态代理.设置被代理对象(地洞);
        魔兽容器接口 地洞代理 = (魔兽容器接口) 地洞动态代理.获取代理对象();

        for (int i = 0; i < 地洞.获取最大容量() + 2; i++) {
            地洞代理.放入一个单位(new 兽族苦工());
        }

        System.out.println("***********************************************");

        地精飞艇 飞艇 = new 地精飞艇();

        魔兽容器代理类 飞艇动态代理 = new 魔兽容器代理类();
        飞艇动态代理.设置被代理对象(飞艇);
        魔兽容器接口 飞艇代理 = (魔兽容器接口) 飞艇动态代理.获取代理对象();

        for (int i = 0; i < 飞艇.获取最大容量() + 2; i++) {
            飞艇代理.放入一个单位(new 兽族苦工());
        }


        /*
         *这个时候,被代理对象和代理对象都能获取成员属性的值,这是与CGLIB不同的地方
         */
        System.out.println("地洞.获取单位们() = " + 地洞.获取单位们());
        System.out.println("飞艇.获取单位们() = " + 飞艇.获取单位们());
        System.out.println("地洞动态代理.获取单位们() = " + 地洞代理.获取单位们());
        System.out.println("飞艇代理.获取单位们() = " + 飞艇代理.获取单位们());
    }
}

class 魔兽容器代理类 implements InvocationHandler {

    魔兽容器代理类() {
    }

    private Object 被代理对象;

    public void 设置被代理对象(Object 被代理对象) {
        this.被代理对象 = 被代理对象;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入动态代理调用:" + method.getName());
        Class<?>[] interfaces = proxy.getClass().getInterfaces();
        if (method.getName().equals("放入一个单位")) {
            for (Class<?> anInterface : interfaces) {
                boolean 是容器 = anInterface.getName().equals(魔兽容器接口.class.getName());
                if (是容器) {
                    if (!反射工具.看看能不能放下(被代理对象, args)) {
                        System.out.println("已经达到最大容量,别再进来了");
                        return null;
                    }
                    break;
                }
            }
        }
        return method.invoke(被代理对象, args);
    }

    public Object 获取代理对象() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), 被代理对象.getClass().getInterfaces(), this);
    }

}
