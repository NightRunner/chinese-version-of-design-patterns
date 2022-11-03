package person.nightrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * hello i am composite pattern!  like a tree!
 */
public class 组合模式主程序 {
    public static void main(String[] args) {
        句子 句子 = new 句子(new 词[]{
                new 词(字母.创建多个("hello!")),
                new 词(字母.创建多个("i")),
                new 词(字母.创建多个("am")),
                new 词(字母.创建多个("composite")),
                new 词(字母.创建多个("pattern!"))
        });
        句子.打印();

        句子 = new 句子(new 词[]{
                new 词(字母.创建多个("like")),
                new 词(字母.创建多个("a")),
                new 词(字母.创建多个("tree!")),
        });
        句子.打印();
    }
}


abstract class 字组合 {

    public void 增加(字组合 字组合) {
        子节点.add(字组合);
    }

    List<字组合> 子节点 = new ArrayList<>();

    protected void 打印前() {
    }

    protected void 打印后() {
    }

    protected void 打印() {
        打印前();
        for (字组合 字组合 : 子节点) {
            字组合.打印();
        }
        打印后();
    }
}

class 字母 extends 字组合 {

    public static 字母[] 创建多个(String 字符串) {
        字母[] 字们 = new 字母[字符串.length()];

        for (int i = 0; i < 字符串.length(); i++) {
            字们[i] = new 字母(字符串.charAt(i));
        }

        return 字们;
    }

    public 字母(Character 字) {
        this.字 = 字;
    }

    private char 字;

    @Override
    protected void 打印() {
        System.out.print(字);
    }
}

class 词 extends 字组合 {

    public 词(字母... 字们) {
        for (字母 字母 : 字们) {
            this.增加(字母);
        }
    }

    @Override
    protected void 打印后() {
        System.out.print(" ");
    }
}

class 句子 extends 字组合 {
    public 句子(词... 词们) {
        for (词 词 : 词们) {
            this.增加(词);
        }
    }

    @Override
    protected void 打印后() {
        System.out.print("\n");
    }
}
