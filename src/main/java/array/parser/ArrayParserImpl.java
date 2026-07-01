package array.parser;
import array.exception.ArrayException;

public class ArrayParserImpl implements ArrayParser {

    @Override
    public int[] parse(String line) {
        try {
            String normalized = line.replaceAll("[,;\\-]", " ");
            String[] parts = normalized.trim().split("\\s+");

            int[] result = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                result[i] = Integer.parseInt(parts[i]);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new ArrayException("Invalid array format: " + line, e);

        }
    }
}
