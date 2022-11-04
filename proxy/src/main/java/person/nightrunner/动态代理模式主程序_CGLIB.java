package person.nightrunner;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
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

//        System.out.println("增强开始~~~");
        if (method.getName().equals("放入一个单位")) {
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