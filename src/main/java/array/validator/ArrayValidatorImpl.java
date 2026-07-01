package array.validator;

public class ArrayValidatorImpl implements ArrayValidator {

    private static final String REGEX = "^\\s*-?\\d+(\\s*[ ,;\\-]\\s*-?\\d+)*\\s*$";

    @Override
    public boolean isValid(String line) {

        if (line == null || line.isBlank()) {
            return false;
        }

        return line.matches(REGEX);
    }
}
