package clone;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2019/10/28 15:37
 */
public class Test {

    public static void main(String[] args) {
        ObjectA a = new ObjectA();
        try {
            ObjectA aClone = (ObjectA) a.clone();
            System.out.println(a);
            System.out.println(aClone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
