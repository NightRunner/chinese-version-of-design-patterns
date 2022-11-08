package person.nightrunner;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 只有这一辆车啊!
 */
public class 单例模式主程序 {

    public static final int 线程数 = 30;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(线程数 * 5);
        System.out.println("预加载模式");
        for (int i = 0; i < 线程数; i++) {
            executorService.execute(() -> {
                我的车_预加载模式 我的车 = 我的车_预加载模式.获取我的车();
                计数(我的车_预加载模式.class, 我的车);
            });
        }

        System.out.println("懒加载");
        for (int i = 0; i < 线程数; i++) {
            executorService.execute(() -> {
                我的车_懒加载模式 我的车 = 我的车_懒加载模式.获取我的车();
                计数(我的车_懒加载模式.class, 我的车);
            });
        }

        System.out.println("双重校验加载");
        for (int i = 0; i < 线程数; i++) {
            executorService.execute(() -> {
                我的车_双重校验懒加载模式 我的车 = 我的车_双重校验懒加载模式.获取我的车();
                计数(我的车_双重校验懒加载模式.class, 我的车);
            });
        }

        System.out.println("线程安全加载");
        for (int i = 0; i < 线程数; i++) {
            executorService.execute(() -> {
                我的车_线程安全懒加载模式 我的车 = 我的车_线程安全懒加载模式.获取我的车();
                计数(我的车_线程安全懒加载模式.class, 我的车);
            });
        }

        System.out.println("持有者懒加载");
        for (int i = 0; i < 线程数; i++) {
            executorService.execute(() -> {
                我的车_线程安全懒加载持有者模式 我的车 = 我的车_线程安全懒加载持有者模式.获取我的车();
                计数(我的车_线程安全懒加载持有者模式.class, 我的车);
            });
        }

        executorService.shutdown();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Thread.activeCount() <= 2) {
                map.forEach((a, b) -> {
                    System.out.printf("%s加载了%s个不同的对象\n", a, b.size());
                });
                break;
            }
        }
    }

    private static void 计数(Class 类名, 我的车父类 我的车) {
        Set<String> set = map.getOrDefault(类名.getName(), new HashSet<>());
        set.add(我的车.获取唯一ID());
        map.put(类名.getName(), set);
    }

    static Map<String, Set<String>> map = new ConcurrentHashMap<>();
}

class 我的车父类 {

    String 唯一ID;

    public String 获取名称() {
        return "这是夜行者的车" + this.getClass().getName() + ":" + 唯一ID;
    }

    public String 获取唯一ID() {
        return 唯一ID;
    }

    public 我的车父类() {
        this.唯一ID = UUID.randomUUID().toString();
    }
}

//预加载
class 我的车_预加载模式 extends 我的车父类 {

    private 我的车_预加载模式() {
        super();
    }

    private static final 我的车_预加载模式 我的车 = new 我的车_预加载模式();

    public static 我的车_预加载模式 获取我的车() {
        return 我的车;
    }
}

//简单懒加载:线程不安全
class 我的车_懒加载模式 extends 我的车父类 {

    private 我的车_懒加载模式() {
        super();
    }

    private static 我的车_懒加载模式 我的车;

    public static 我的车_懒加载模式 获取我的车() {
        if (null == 我的车) {
            我的车 = new 我的车_懒加载模式();
        }
        return 我的车;
    }
}

//线程安全
class 我的车_双重校验懒加载模式 extends 我的车父类 {

    private static volatile 我的车_双重校验懒加载模式 我的车;

    private 我的车_双重校验懒加载模式() {
        super();
    }

    public static 我的车_双重校验懒加载模式 获取我的车() {
        我的车_双重校验懒加载模式 我的车_双重校验懒加载模式_结果 = 我的车;
        if (我的车_双重校验懒加载模式_结果 == null) {
            synchronized (我的车_双重校验懒加载模式.class) {
                我的车_双重校验懒加载模式_结果 = 我的车;
                if (null == 我的车) {
                    我的车 = 我的车_双重校验懒加载模式_结果 = new 我的车_双重校验懒加载模式();
                }
            }
        }

        return 我的车_双重校验懒加载模式_结果;
    }
}

/**
 * https://github.com/iluwatar/java-design-patterns 中的代码如下,
 * <p>
 * public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {
 * if (instance == null) {
 * synchronized (ThreadSafeLazyLoadedIvoryTower.class) {
 * if (instance == null) {
 * instance = new ThreadSafeLazyLoadedIvoryTower();
 * }
 * }
 * }
 * return instance;
 * }
 * <p>
 * 但经过我的测试(JDK1.8),不需要双重加锁就可以实现线程安全的懒加载,代码如下:
 */
//线程安全
class 我的车_线程安全懒加载模式 extends 我的车父类 {

    private static 我的车_线程安全懒加载模式 我的车;

    private 我的车_线程安全懒加载模式() {
        super();
    }

    public static synchronized 我的车_线程安全懒加载模式 获取我的车() {
        if (我的车 == null) {
            我的车 = new 我的车_线程安全懒加载模式();
        }

        return 我的车;
    }
}

//线程安全:推荐使用
class 我的车_线程安全懒加载持有者模式 extends 我的车父类 {

    public String 获取名称() {
        return "这是夜行者的车" + this.getClass().getName() + ":" + 唯一ID;
    }

    private 我的车_线程安全懒加载持有者模式() {
        super();
    }

    public static 我的车_线程安全懒加载持有者模式 获取我的车() {
        return Holder.我的车;
    }

    private static class Holder {
        public static final 我的车_线程安全懒加载持有者模式 我的车 = new 我的车_线程安全懒加载持有者模式();
    }
}

