package person.nightrunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class 反射工具 {

    public static boolean 看看能不能放下(Object o, Object[] objects) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = o.getClass().getMethods();
        Integer 最大容量 = null;
        for (Method tempMethod : methods) {
            if (tempMethod.getName().equals("获取最大容量")) {
                //这里只能用o,不能使用 "被代理对象"变量
                最大容量 = (Integer) tempMethod.invoke(o);
            }
        }

        List 单位们 = null;
        for (Method tempMethod : methods) {
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
            return false;
        }
        return true;
    }

}
