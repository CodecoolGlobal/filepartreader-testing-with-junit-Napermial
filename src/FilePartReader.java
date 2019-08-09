import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public void setup (){
        filePath = "there";
        fromLine = 3;
        toLine = 1;
    }

    public String read () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        return reader.lines().collect(Collectors.joining());
    }

//    public String readLines (){
//        read();
//    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
