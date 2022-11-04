package person.nightrunner;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 只要是能进人的,我都能管!
 */
public class 动态代理模式主程序_CGLIB {
    public static void main(String[] args) {
        兽族地洞 兽族地洞 = new 兽族地洞();
        CGLIB动态代理 cglib动态代理 = new CGLIB动态代理();
        cglib动态代理.设置CGLIB动态代理(兽族地洞);

        兽族地洞 兽族地洞代理 = (兽族地洞) cglib动态代理.获取代理对象();
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());
        兽族地洞代理.放入一个单位(new 兽族苦工());

        System.out.println("***********************************************");

        飞艇 飞艇 = new 飞艇();
        cglib动态代理.设置CGLIB动态代理(飞艇);
        魔兽容器接口 飞艇代理对象 = (魔兽容器接口) cglib动态代理.获取代理对象();

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

class CGLIB动态代理 implements MethodInterceptor {

    private Object 被代理对象;

    public CGLIB动态代理() {
    }

    public void 设置CGLIB动态代理(Object 被代理对象) {
        this.被代理对象 = 被代理对象;
    }

    //返回一个代理对象:    是 target对象的代理对象
    public Object 获取代理对象() {
        //1. 创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(被代理对象.getClass());
        //3. 设置回调函数
        enhancer.setCallback(this);
        //4. 创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if (method.getName().equals("放入一个单位")) {
            List 单位们 = null;

            Method[] methods = 被代理对象.getClass().getMethods();

            Integer 最大容量 = null;
            for (Method tempMethod : methods) {
                if (tempMethod.getName().equals("获取最大容量")) {
                    //这里只能用o,不能使用 "被代理对象"变量
                    最大容量 = (Integer) tempMethod.invoke(o);
                }
                if (tempMethod.getName().equals("获取单位们")) {
                    //这里只能用o,不能使用 "被代理对象"变量
                    单位们 = (List) tempMethod.invoke(o);
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
            for (Object 单位 : objects) {
                if (!(单位 instanceof 魔兽单位接口)) {
                    continue;
                }
                魔兽单位接口 魔兽单位接口 = (魔兽单位接口) 单位;
                本次加入单位体积 += 魔兽单位接口.获取单位体积();
            }

            if (单位们总计体积 + 本次加入单位体积 > 最大容量) {
                System.out.println("已经达到最大容量,别再进来了");
                return null;
            }
        }

//        System.out.println("增强开始~~~");
        Object result = methodProxy.invokeSuper(o, objects);
//        System.out.println("增强结束~~~");
        return result;
    }

}