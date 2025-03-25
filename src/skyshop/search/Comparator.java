package skyshop.search;

public class Comparator implements java.util.Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int nameLength = Integer.compare(o1.length(), o2.length());
        if (nameLength != 0){
            return nameLength;
        }
        return o1.compareTo(o2);
    }
}
