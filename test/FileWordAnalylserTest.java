import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalylserTest {
    File file;
    String filePath = "D:\\projektek\\filepartreader-testing-with-junit-Napermial\\test\\testFile.txt";
    String testString = "lorem ipsum stabat acies ferro mortique parates \niam lituus\tpugnae\ntis\nalso\nhere\nebe\nlel\nqnnq\nqsdffdsq";

    @BeforeEach
    void setUp() {
        file = new File(filePath);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(testString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAlphabeticalOrdering() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(filePath, 1, 1);
        FileWordAnalylser fileWordAnalylser = new FileWordAnalylser(filePartReader);
        ArrayList lines = new ArrayList<>(
            Arrays.asList("also", "ebe", "here", "iam lituus\tpugnae","lel", "lorem ipsum stabat acies ferro mortique parates ","qnnq", "qsdffdsq", "tis")
        );
        Assertions.assertEquals(lines, fileWordAnalylser.getWordsOrderedAlphabetically());
    }

    @Test
    void testContaingSubstringOptimal() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath(filePath);
        FileWordAnalylser fileWordAnalylser = new FileWordAnalylser(filePartReader);
        ArrayList<String> lines = new ArrayList<>(
                Arrays.asList("lorem ipsum stabat acies ferro mortique parates ", "iam lituus	pugnae", "also")
        );
        assertEquals(lines, fileWordAnalylser.getWordsContainingSubstring("a"));
    }

    @Test
    void testPalindromeSearchOddAndEvenLength() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath(filePath);
        FileWordAnalylser fileWordAnalylser = new FileWordAnalylser(filePartReader);
        List<String> palindromes = new ArrayList<>(
                Arrays.asList("ebe","lel","qnnq","qsdffdsq")
        );
        assertEquals(palindromes, fileWordAnalylser.getStringsWhichPalindromes());
    }
}