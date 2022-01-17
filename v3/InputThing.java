import java.util.Scanner;

public interface InputThing {

    Scanner scanner = new Scanner(System.in);
    default String receiveInput() {
        return scanner.next();
    }
}
