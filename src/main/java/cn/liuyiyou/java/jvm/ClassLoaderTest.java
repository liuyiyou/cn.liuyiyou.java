package cn.liuyiyou.java.jvm;

/***
 * @author: liuyiyou
 * @date: 2018/4/23
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);  //Launcher$AppClassLoader
        System.out.println(loader.getParent()); //Launcher$ExtClassLoader
        System.out.println(loader.getParent().getParent()); //null
    }
}
