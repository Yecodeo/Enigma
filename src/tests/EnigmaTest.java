package tests;

import enigma.Enigma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnigmaTest {

    @Test
    void encodeThree() throws Exception {
        String[] r = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
        Enigma e = new Enigma(4, "AAA", r);
        assertEquals("KQF", e.encode());
    }

    @Test
    void encodeTwentyThree() throws Exception {
        String[] r = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
        Enigma e = new Enigma(7, "WEATHERREPORTWINDYTODAY", r);
        assertEquals("ALWAURKQEQQWLRAWZHUYKVN", e.encode());
    }

    @Test
    void decodeTwentyOne() throws Exception {
        String[] r = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
        Enigma e = new Enigma(9, "PQSACVVTOISXFXCIAMQEM", r);
        assertEquals("EVERYONEISWELCOMEHERE", e.decode());
    }

    @Test
    void encodeTwentyOne() throws Exception {
        String[] r = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
        Enigma e = new Enigma(9, "EVERYONEISWELCOMEHERE", r);
        assertEquals("PQSACVVTOISXFXCIAMQEM", e.encode());
    }

    @Test
    void decodeFourtyNine() throws Exception {
        String[] r = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
        Enigma e = new Enigma(5, "XPCXAUPHYQALKJMGKRWPGYHFTKRFFFNOUTZCABUAEHQLGXREZ", r);
        assertEquals("THEQUICKBROWNFOXJUMPSOVERALAZYSPHINXOFBLACKQUARTZ", e.decode());
    }

    @Test
    void exception() {
        Enigma e = new Enigma();
        Exception exception = assertThrows(Exception.class, () ->
               e.encode() );
        assertEquals("One or more param is not defined in the class", exception.getMessage());
    }
}