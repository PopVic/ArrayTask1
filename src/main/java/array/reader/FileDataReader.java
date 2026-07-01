package array.reader;
import array.exception.ArrayException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileDataReader {

    public List<String> read(String filePath) {

        try {
            return Files.readAllLines(Path.of(filePath));

        } catch (IOException e) {
            throw new ArrayException("Cannot read file: " + filePath, e);
        }
    }
}
