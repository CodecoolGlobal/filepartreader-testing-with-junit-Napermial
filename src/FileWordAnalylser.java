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

    public List getWordsContainingSubstring(String subString) throws IOException {
    String[] splitted = filePartReader.read().split("\n");
    List<String> containsSubsString = new ArrayList<>();
    for(String line : splitted){
        if(line.contains(subString)) containsSubsString.add(line);
    }
    return containsSubsString;
    }
//
//    public List getStringsWhichPalindromes() {
//        FilePartReader.readLines();
//        return;
//    }
}
