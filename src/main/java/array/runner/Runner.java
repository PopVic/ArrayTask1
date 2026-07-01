package array.runner;

import array.entity.ArrayEntity;
import array.factory.ArrayFactory;
import array.factory.ArrayFactoryImpl;
import array.parser.ArrayParser;
import array.parser.ArrayParserImpl;
import array.reader.FileDataReader;
import array.util.FilePathUtil;
import array.validator.ArrayValidator;
import array.validator.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        FileDataReader reader = new FileDataReader();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();

        try {
            List<String> lines = reader.read(FilePathUtil.FILE_PATH);

            for (String line : lines) {

                if (line == null || line.isBlank()) {
                    logger.warn("Empty line skipped");
                    continue;
                }

                if (validator.isValid(line)) {

                    int[] parsed = parser.parse(line);
                    ArrayEntity entity = factory.create(parsed);

                    logger.info("Valid array: " + entity);

                } else {

                    logger.error("Invalid line: " + line);
                }
            }

        } catch (Exception e) {
            logger.error("Fatal error while reading file", e);
        }
    }
}
