package string;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/3/17
 * @describe:
 */
public class String_AndAnd {
    public static void main(String[] args) {
     int x = 1, y = 1;
     if (x++ == 2 && ++y== 2){
         x = 7;
     }
        System.out.println("x=" + x + "y=" + y);
    }
}
