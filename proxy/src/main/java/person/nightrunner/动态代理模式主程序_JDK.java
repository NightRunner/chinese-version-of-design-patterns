package person.nightrunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 只要是能进人的,我都能管!
 */
public class 动态代理模式主程序_JDK {
    public static void main(String[] args) {
        兽族地洞 地洞 = new 兽族地洞();
        魔兽容器代理类 动态代理 = new 魔兽容器代理类();
        动态代理.设置被代理对象(地洞);
        魔兽容器接口 地洞代理对象 = (魔兽容器接口) 动态代理.获取代理对象();

        地洞代理对象.放入一个单位(new 兽族苦工());
        地洞代理对象.放入一个单位(new 兽族苦工());
        地洞代理对象.放入一个单位(new 兽族苦工());
        地洞代理对象.放入一个单位(new 兽族苦工());
        地洞代理对象.放入一个单位(new 兽族苦工());
        地洞代理对象.放入一个单位(new 兽族苦工());
        地洞代理对象.放入一个单位(new 兽族苦工());

        System.out.println("***********************************************");

        飞艇 飞艇 = new 飞艇();

        动态代理.设置被代理对象(飞艇);
        魔兽容器接口 飞艇代理对象 = (魔兽容器接口) 动态代理.获取代理对象();

        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());
        飞艇代理对象.放入一个单位(new 兽族苦工());

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
                    Method[] methods = 被代理对象.getClass().getMethods();

                    Integer 最大容量 = null;
                    for (Method tempMethod : methods) {
                        if (tempMethod.getName().equals("获取最大容量")) {
                            最大容量 = (Integer) tempMethod.invoke(被代理对象);
                            break;
                        }
                    }

                    List 单位们 = null;
                    for (Method tempMethod : methods) {
                        if (tempMethod.getName().equals("获取单位们")) {
                            单位们 = (List) tempMethod.invoke(被代理对象);
                            break;
                        }
                    }

                    Integer 单位们总计体积 = 0;
                    for (Object 单位 : 单位们) {
                        if (!(单位 instanceof 魔兽单位接口)) {
                            continue;
                        }
                        魔兽单位接口 魔兽单位接口 = (魔兽单位接口) 单位;
                        单位们总计体积 += 魔兽单位接口.获取单位体积();
                    }

                    Integer 本次加入单位体积 = 0;
                    for (Object 单位 : args) {
                        if (!(单位 instanceof 魔兽单位接口)) {
                            continue;
                        }
                        魔兽单位接口 魔兽单位接口 = (魔兽单位接口) 单位;
                        本次加入单位体积 += 魔兽单位接口.获取单位体积();
                    }

                    if (最大容量 != null && 单位们 != null) {
                        if (单位们总计体积 + 本次加入单位体积 >= 最大容量) {
                            System.out.println("已经达到最大容量,别再进来了");
                            return null;
                        }
                    }
                    break;
                }
            }
        }
        Object invoke = method.invoke(被代理对象, args);
        System.out.println("调用成功:" + method.getName());
        return invoke;
    }

    public Object 获取代理对象() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), 被代理对象.getClass().getInterfaces(), this);
    }

}
