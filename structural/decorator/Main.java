package structural.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // 같은 InputStream 추상 클래스를 상속 하고 있다.
        InputStream in = new FileInputStream("file.txt");

        // 상속자의 매개변수를 통한 주입을 통해, 기능을 추가할 수 있다.
        InputStream bin = new BufferedInputStream(in);
    }
}
