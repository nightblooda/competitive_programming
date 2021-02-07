import java.util.*;

class test {
    int i[] = { 0 };

    public static void main(String args[]) {
        int i[] = { 1 };
        alter(i);
        System.out.println(i[0]);
    }

    public static void alter(int i[]) {
        int j[] = { 2 };
        i = j;
    }
}
