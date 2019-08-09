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
    String testString = "lorem ipsum stabat acies ferro mortique parates \niam lituus\tpugnae";

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
        filePartReader.setFilePath(file.getPath());
        Assertions.assertEquals(testString, filePartReader.read());

    }
}