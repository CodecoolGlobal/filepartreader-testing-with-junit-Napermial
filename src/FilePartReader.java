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

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
        if (fromLine > toLine || fromLine < 0) throw new IllegalArgumentException(); }

    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String joined = reader.lines().map(x -> x + "\n").collect(Collectors.joining());
        reader.close();
        return joined.trim();
    }

    public String readLines (Integer fromLine, Integer toLine) throws IOException{
        String raw = read();
        String[] splitted = raw.split("\n");
        if (fromLine == 0 && toLine == 0){
            return splitted[0];
        }
        StringBuilder rejoined = new StringBuilder();
        for(int i = fromLine-1; i < toLine;i++) {
            rejoined.append(splitted[i]);
        }
        return String.valueOf(rejoined);
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
