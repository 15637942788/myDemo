package string;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/3/17
 * @describe:
 */
public class String_Intern {
    public static void main(String[] args) {
        String str1 = new StringBuffer("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        /* 第一个我们 new 出来的
         *  intern() 方法 如果字符串常量池中包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象的引用
          * 否则会将此String对象包含的字符串添加到常量池中，并且返回String对象的引用*/
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        /* java在系统中自带了 一个 java 字符串，我们 new 出来的 和 系统中自带的 是不一样的 */
        System.out.println(str2 == str2.intern());
    }
}
