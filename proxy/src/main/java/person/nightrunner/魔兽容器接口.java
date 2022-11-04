package person.nightrunner;

import java.util.List;

public interface 魔兽容器接口<T> {
    void 放入一个单位(T 魔兽单位);

    List<T> 获取单位们();

    Integer 获取最大容量();
}
