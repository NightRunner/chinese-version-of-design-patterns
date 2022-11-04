package person.nightrunner;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 只要是能进人的,我都能管!
 */
public class 动态代理模式主程序_CGLIB {
    public static void main(String[] args) {
        兽族地洞 地洞 = new 兽族地洞();

        CGLIB动态代理 cglib动态代理 = new CGLIB动态代理();
        cglib动态代理.设置CGLIB动态代理(地洞);
        兽族地洞 地洞代理 = (兽族地洞) cglib动态代理.获取代理对象();

        for (int i = 0; i < 地洞.获取最大容量() + 2; i++) {
            地洞代理.放入一个单位(new 兽族苦工());
        }

        System.out.println("***********************************************");

        地精飞艇 飞艇 = new 地精飞艇();

        cglib动态代理.设置CGLIB动态代理(飞艇);
        魔兽容器接口 飞艇代理 = (魔兽容器接口) cglib动态代理.获取代理对象();

        for (int i = 0; i < 飞艇.获取最大容量() + 2; i++) {
            飞艇代理.放入一个单位(new 兽族苦工());
        }

        System.out.println("***********************************************");

        /*
         *这个时候,被代理对象已经无法正常获取成员属性的值了,只能使用代理对象调用,也就是说对原对象进行了修改,这是与JDK动态代理不同的地方
         */
        System.out.println("地洞.获取单位们() = " + 地洞.获取单位们());
        System.out.println("飞艇.获取单位们() = " + 飞艇.获取单位们());
        System.out.println("地洞动态代理.获取单位们() = " + 地洞代理.获取单位们());
        System.out.println("飞艇代理.获取单位们() = " + 飞艇代理.获取单位们());
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

//        System.out.println("增强开始~~~");
        if (method.getName().equals("放入一个单位")) {
            //这个地方不能传"被代理对象",需要传o,因为动态代理对象已经被修改了
            if (!反射工具.看看能不能放下(o, objects)) {
                System.out.println("已经达到最大容量,别再进来了");
                return null;
            }
        }


        Object result = methodProxy.invokeSuper(o, objects);
//        System.out.println("增强结束~~~");
        return result;
    }


}