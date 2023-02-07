import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        byte[] buffer = new byte[2];
        String s = "";

        // int len = -1
        while(true){
            int len = inputStream.read(buffer);
            if(len == -1){
                break;
            }
            //System.out.print(new String(buffer, 0, len, StandardCharsets.UTF_8));
            s += new String(buffer, 0 , len , StandardCharsets.UTF_8);

        }
        System.out.println(s);
    }
}
