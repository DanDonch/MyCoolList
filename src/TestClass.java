import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) {
        MyCoolList<Integer> myCoolList = new MyCoolList<>();
        for (int i = 0; i < 10; i++) {
            int number = (int) (Math.random() * 100);
            myCoolList.add(number);
        }

        System.out.println(myCoolList);
        myCoolList.remove(2);
        System.out.println(myCoolList);
        System.out.println(myCoolList.get(5));
        Integer[] array = myCoolList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
    }
}