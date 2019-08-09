import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalylser {
    private FilePartReader filePartReader;

    public FileWordAnalylser(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
        //this.filePartReader.setup("D:\\projektek\\filepartreader-testing-with-junit-Napermial\\test\\testFile.txt", 0,1);
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> lines = new ArrayList<>(Arrays.asList(filePartReader.read().split("\n")));
        java.util.Collections.sort(lines);
        return lines;
    }
//
//    public List getWordsContainingSubstring(String subString) {
//        FilePartReader partReader = new FilePartReader();
//        FilePartReader.readLines();
//        return;
//    }
//
//    public List getStringsWhichPalindromes() {
//        FilePartReader.readLines();
//        return;
//    }
}
