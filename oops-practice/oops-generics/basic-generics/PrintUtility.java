
import java.util.List;

public class PrintUtility {
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4);
        List<String> strList = List.of("A", "B", "C");
        
        printList(intList);
        printList(strList);
    }
}
