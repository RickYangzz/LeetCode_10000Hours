package HJ1_字符串最后一个单词的长度.java_solutions;
import java.io.InputStream;

public class InputStreamSolution {
    public static void main(String[] args) throws Exception{
        InputStream InputStream = System.in;
        
        int length = 0;
        char c;
        while ('\n' != (c=(char)InputStream.read())) {
            length++;
            if (c == ' ') {
                length = 0;
            }
        }

        System.out.println(length);
    }
}
