import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "there";
        fromLine = 3;
        toLine = 1;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine){
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String joined = reader.lines().map(x -> x+"\n").collect(Collectors.joining());
        reader.close();
        return joined.trim();
    }

//    public String readLines (){
//        read();
//    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
