import enigma.Enigma;

public class Main {
    static String[] r = new String[3];

    public static void main(String[] args) throws Exception {
        r[0] = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        r[1] = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        r[2] = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";

        Enigma enigma = new Enigma();

        // decoding
        enigma.setOffset(5);
        enigma.setText("AAA");
        enigma.setRotors(r);
        System.out.println(enigma.decode());

        //encoding
        enigma.setOffset(5);
        enigma.setText("THEQUICKBROWNFOXJUMPSOVERALAZYSPHINXOFBLACKQUARTZ");
        System.out.println("result " + enigma.encode());

    }




}
