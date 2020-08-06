package enigma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnigmaTest {
    static String[] rotors = new String[3];
    @BeforeAll
    static void feedRotors() {
        rotors[0] = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        rotors[1] = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        rotors[2] = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    }
    @Test
    void encodeTreeChar() throws Exception {
        String message = "AAA";
        Enigma e = new Enigma(4, message, rotors);
        String result = e.encode();
        Assertions.assertEquals(result, "KQF");
    }
    @Test
    void encodeTwentyTree() throws Exception {
        String message = "WEATHERREPORTWINDYTODAY";
        Enigma e = new Enigma(7, message, rotors);
        String result = e.encode();
        Assertions.assertEquals(result, "ALWAURKQEQQWLRAWZHUYKVN");
    }
    @Test
    void decodeTwentyOne() throws Exception {
        String message = "PQSACVVTOISXFXCIAMQEM";
        Enigma e = new Enigma(9, message, rotors);
        String result = e.decode();
        Assertions.assertEquals(result, "EVERYONEISWELCOMEHERE");
    }
    @Test
    void encodeTwentyOne() throws Exception {
        String message = "EVERYONEISWELCOMEHERE";
        Enigma e = new Enigma(9, message, rotors);
        String result = e.encode();
        Assertions.assertEquals(result, "PQSACVVTOISXFXCIAMQEM");
    }
    @Test
    void encodeFortyTwo() throws Exception {
        String message = "EVERYONEISWELCOMEHEREEVERYONEISWELCOMEHERE";
        Enigma e = new Enigma(9, message, rotors);
        String result = e.encode();
        Assertions.assertEquals(result, "PQSACVVTOISXFXCIAMQEMDZIXFJJSTQIENEFQXVZYV");
    }
    @Test
    void decodeFortyNine() throws Exception {
        String message = "XPCXAUPHYQALKJMGKRWPGYHFTKRFFFNOUTZCABUAEHQLGXREZ";
        Enigma e = new Enigma(5, message, rotors);
        String result = e.decode();
        Assertions.assertEquals(result, "THEQUICKBROWNFOXJUMPSOVERALAZYSPHINXOFBLACKQUARTZ");
    }
}