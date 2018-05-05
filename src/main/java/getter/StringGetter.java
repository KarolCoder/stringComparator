package getter;


import comparator.StringComparator;
import java.util.Scanner;

public class StringGetter {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Give first String");
        String first = in.nextLine();
        System.out.println("Give second String");
        String second = in.nextLine();
        StringComparator stringComparator = new StringComparator(first,second);
        System.out.println(stringComparator.checkStrings());


        }
}
