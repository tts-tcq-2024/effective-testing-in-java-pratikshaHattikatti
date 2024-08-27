import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Misaligned {
    static int printColorMap() {
        String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
        String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                sb.append(String.format("%d | %s | %s\n", i * 5 + j, majorColors[i], minorColors[j])); // Fixed: minorColors[j] to correctly align
            }
        }
        System.out.println(sb.toString());
        return i * j;
    }

    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        int result = printColorMap();
        System.setOut(originalOut);
        String output = baos.toString();
        assert(output.contains("0 | White | Blue"));
        assert(output.contains("4 | White | Slate"));
        assert(result == 30);
        System.out.println("All is well (maybe!)");
    }
}
