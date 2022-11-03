package 个人.夜行者;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 单例方法主程序 {

    public static final int THREADS = 10;

    public static void main(String[] args) {
        Runnable[] rs = new Runnable[THREADS];
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        System.out.println("预加载模式");
        for (int i = 0; i < THREADS; i++) {
            rs[i] = () -> {
                我的专车_预加载模式 我的专车 = 我的专车_预加载模式.获取我的专车();
                System.out.println("我的专车 = " + 我的专车.获取名称());
            };
        }
        for (int i = 0; i < rs.length; i++) {
            executorService.execute(rs[i]);
        }

        System.out.println("懒加载");
        for (int i = 0; i < THREADS; i++) {
            rs[i] = new Runnable() {
                public void run() {
                    我的专车_懒加载模式 我的专车 = 我的专车_懒加载模式.获取我的专车();
                    System.out.println("我的专车 = " + 我的专车.获取名称());
                }
            };
        }
        for (int i = 0; i < rs.length; i++) {
            executorService.execute(rs[i]);
        }

        System.out.println("双重校验加载");
        for (int i = 0; i < THREADS; i++) {
            rs[i] = new Runnable() {
                public void run() {
                    我的专车_双重校验懒加载模式 我的专车 = 我的专车_双重校验懒加载模式.获取我的专车();
                    System.out.println("我的专车 = " + 我的专车.获取名称());
                }
            };
        }
        for (int i = 0; i < rs.length; i++) {
            executorService.execute(rs[i]);
        }

        System.out.println("线程安全加载");
        for (int i = 0; i < THREADS; i++) {
            rs[i] = new Runnable() {
                public void run() {
                    我的专车_线程安全懒加载模式 我的专车 = 我的专车_线程安全懒加载模式.获取我的专车();
                    System.out.println("我的专车 = " + 我的专车.获取名称());
                }
            };
        }
        for (int i = 0; i < rs.length; i++) {
            executorService.execute(rs[i]);
        }


        System.out.println("持有者懒加载");
        for (int i = 0; i < THREADS; i++) {
            rs[i] = new Runnable() {
                public void run() {
                    我的专车_线程安全懒加载持有者模式 我的专车 = 我的专车_线程安全懒加载持有者模式.获取我的专车();
                    System.out.println("我的专车 = " + 我的专车.获取名称());
                }
            };
        }
        for (int i = 0; i < rs.length; i++) {
            executorService.submit(rs[i]);
        }

        executorService.shutdown();

        while (Thread.activeCount() > 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.activeCount());
        }

    }
}

class 我的专车父类 {

    String uuid;

    public String 获取名称() {
        return "这是夜行者的专车" + this.getClass().getName() + ":" + uuid;
    }

    public 我的专车父类() {
        this.uuid = UUID.randomUUID().toString();
    }
}

//预加载
class 我的专车_预加载模式 extends 我的专车父类 {

    private 我的专车_预加载模式() {
        super();
    }

    private static final 我的专车_预加载模式 我的专车 = new 我的专车_预加载模式();

    public static 我的专车_预加载模式 获取我的专车() {
        return 我的专车;
    }
}

//简单懒加载:线程不安全
class 我的专车_懒加载模式 extends 我的专车父类 {

    private 我的专车_懒加载模式() {
        super();
    }

    private static 我的专车_懒加载模式 我的专车;

    public static 我的专车_懒加载模式 获取我的专车() {
        if (null == 我的专车) {
            我的专车 = new 我的专车_懒加载模式();
        }
        return 我的专车;
    }
}

//线程安全
class 我的专车_双重校验懒加载模式 extends 我的专车父类 {

    private static volatile 我的专车_双重校验懒加载模式 我的专车;

    private 我的专车_双重校验懒加载模式() {
        super();
    }

    public static 我的专车_双重校验懒加载模式 获取我的专车() {
        我的专车_双重校验懒加载模式 我的专车_双重校验懒加载模式_结果 = 我的专车;
        if (我的专车_双重校验懒加载模式_结果 == null) {
            synchronized (我的专车_双重校验懒加载模式.class) {
                我的专车_双重校验懒加载模式_结果 = 我的专车;
                if (null == 我的专车) {
                    我的专车 = 我的专车_双重校验懒加载模式_结果 = new 我的专车_双重校验懒加载模式();
                }
            }
        }

        return 我的专车_双重校验懒加载模式_结果;
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
class 我的专车_线程安全懒加载模式 extends 我的专车父类 {

    private static 我的专车_线程安全懒加载模式 我的专车;

    private 我的专车_线程安全懒加载模式() {
        super();
    }

    public static synchronized 我的专车_线程安全懒加载模式 获取我的专车() {
        if (我的专车 == null) {
            我的专车 = new 我的专车_线程安全懒加载模式();
        }

        return 我的专车;
    }
}

//线程安全:推荐使用
class 我的专车_线程安全懒加载持有者模式 extends 我的专车父类 {

    public String 获取名称() {
        return "这是夜行者的专车" + this.getClass().getName() + ":" + uuid;
    }

    private 我的专车_线程安全懒加载持有者模式() {
        super();
    }

    public static 我的专车_线程安全懒加载持有者模式 获取我的专车() {
        return Holder.我的专车;
    }

    private static class Holder {
        public static final 我的专车_线程安全懒加载持有者模式 我的专车 = new 我的专车_线程安全懒加载持有者模式();
    }
}

