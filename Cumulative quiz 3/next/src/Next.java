public class Next implements ListADT<String>, Iterable<String> {
    public static testNext{
    String x = new String();
    x += "A";
    x += "B";
    x += "C";
    Iterator<String> chars = x.Iterator();
    while (chars.hasnext()) {
        System.out.println(chars.next());
    }
}

    public static void main() {
        testNext();
    }

}

