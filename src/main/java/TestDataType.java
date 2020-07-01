public class TestDataType {
    public static void main(String[] args) {
        byte b = 127;
        int i = b + 1;

        System.out.println(i);

        byte c = 1;
        c = c++;

        System.out.println(c);

    }
}
