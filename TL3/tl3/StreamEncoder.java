import java.util.Arrays;
import java.util.stream.Stream;


/**
 * See PDF for instructions.
 *
 * @author <INSERT Anirudh Gubba>
 * @version 4:30-6:00 Section
 */
public class StreamEncoder {

    /* Modify this method */
    public static String decodeSentence(String sentence) {
        String output = getWordStream(sentence)
            .map(StreamEncoder::decodeWord).reduce("" , String::concat);
        return output;
    }

    /** Provided main method for testing */
    public static void main(String[] args) {
        System.out.println(decodeSentence("s@?VE rC@DD %96 $EC62>DP"));
    }

    /** DO NOT MODIFY THIS METHOD */
    private static Stream<String> getWordStream(String sentence) {
        return Arrays.stream(sentence.split("\\s"));
    }

    /** DO NOT MODIFY THIS METHOD */
    private static String decodeWord(String s) {
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char) ((characters[i] - 33 + 47) % 94 + 33);
        }
        return String.valueOf(characters);
    }
}
