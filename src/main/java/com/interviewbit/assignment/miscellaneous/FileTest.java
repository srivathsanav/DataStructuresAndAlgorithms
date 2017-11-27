import sun.nio.fs.DefaultFileSystemProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by avsrivathsan on 7/20/2017.
 */
public class FileTest {

    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("user.name"));
            new java.io.FileReader("\\\\10.47.59.83\\VUE-Share\\inventory_upload.txt");
            File.createTempFile("site_zone___1802703080379272160", ".csv", new File("Z:/")).getAbsolutePath();
            while(true) {

            }
            //File.createTempFile("site_zone___1802703080379272160", ".csv", new File("Y:")).getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
