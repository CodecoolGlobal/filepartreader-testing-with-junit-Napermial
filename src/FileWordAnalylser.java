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

    public List getStringsWhichPalindromes() throws IOException {
        String[] splitted = filePartReader.read().split("\n");
        List<String> palindoromes = new ArrayList<>();
        for(String line : splitted){
            int splitPlace = line.length()/2;
            String secondPart = line.substring(splitPlace);
            String firstPart;
            if(line.length() % 2 == 1){
                firstPart = line.substring(0, splitPlace+1);
            }else{
                firstPart = line.substring(0, splitPlace);
            }
            StringBuilder reverser = new StringBuilder();
            secondPart = reverser.append(secondPart).reverse().toString();
            if(firstPart.equals(secondPart)){
                palindoromes.add(line);
            }
        }
        return palindoromes;
    }
}
