package util.convertor;

import static util.UtilErrorMessages.*;

import util.UtilErrorMessages;

public class StringToIntegerConvertor {

    public static int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE.getMessage());
        }

    }

}
