import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FilePartReaderTest {
    File file;
    String testString = "lorem ipsum stabat acies ferro mortique parates \niam lituus\tpugnae";

    @BeforeEach
    void setUp() throws IOException {
        file = new File("D:\\projektek\\filepartreader-testing-with-junit-Napermial\\test\\testFile");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath()));
        writer.write(testString);
    }

    @AfterEach
    void tearDown() {
        file.delete();
    }

    @Test
    void testReadReadsFile() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setFilePath(file.getPath());
        Assertions.assertEquals(testString, filePartReader.read());

    }
}