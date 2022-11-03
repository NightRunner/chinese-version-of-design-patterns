package person.nightrunner;

/**
 * 老司机需要适配才能骑自行车!
 */
public class 适配器模式主程序 {
    public static void main(String[] args) {
        老司机 老司机 = new 老司机(new 摩托车());
        老司机.出发();

        老司机 = new 老司机(new 适配器(new 自行车()));
        老司机.出发();
    }
}

class 老司机 {

    public 老司机(机动车 机动车) {
        this.机动车 = 机动车;
    }

    机动车 机动车;

    public void 出发() {
        机动车.挂挡();
    }
}

interface 机动车 {
    void 挂挡();
}

class 摩托车 implements 机动车 {
    @Override
    public void 挂挡() {
        System.out.println("随着发动机轰隆隆作响,摩托车动了起来");
    }
}


class 适配器 implements 机动车 {

    适配器(非机动车 非机动车) {
        this.非机动车 = 非机动车;
    }

    非机动车 非机动车;

    @Override
    public void 挂挡() {
        非机动车.驱动();
    }
}

interface 非机动车 {
    void 驱动();
}


class 自行车 implements 非机动车 {
    public void 驱动() {
        System.out.println("随着脚蹬子不断转圈,自行车动了起来");
    }
}

