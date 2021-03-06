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

class FilePartReaderTest {
    File file;
    String filePath = "D:\\projektek\\filepartreader-testing-with-junit-Napermial\\test\\testFile.txt";
    String testString = "lorem ipsum stabat acies ferro mortique parates \niam lituus\tpugnae\ntis\nalso\nhere";

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
    void testReadReadsFile() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath(filePath);
        Assertions.assertEquals(testString, filePartReader.read());
    }

    @Test
    void testReadThrowsException(){
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IOException.class, filePartReader::read);
    }

    @Test
    void testSetupThrowsIllegalArgumentGivenFromBiggerThanTo(){
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, 1, 0) );
    }

    @Test
    void testFromLineSmallerThanZero(){
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, -1, 0) );
    }

    @Test
    void testReadLinesOptimalImput() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath(filePath);
        Assertions.assertEquals("lorem ipsum stabat acies ferro mortique parates iam lituus\tpugnae", filePartReader.readLines(1, 2));
    }

    @Test
    void testReadLinesToAndFromAlsoOneInput() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath(filePath);
        Assertions.assertEquals("lorem ipsum stabat acies ferro mortique parates ", filePartReader.readLines(1,1));
    }
}