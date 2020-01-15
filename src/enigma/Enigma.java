package enigma;

public class Enigma {
    private int offset;
    private String text;
    private final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String[] rotors = new String[3];

    public Enigma(int offset, String str, String[] r) {
        this.offset = offset;
        this.text = str;
        this.rotors = r;
    }

    public Enigma() {

    }

    public String encode() throws Exception {
        try {
            if (this.rotors.length > 0 || this.offset > 0 || !this.text.isEmpty()) {
                String result = this.caesar(this.offset, this.text, true);
                return this.rotator(result);
            }
        } catch (Exception e ) {
            throw new Exception("One or more param is not defined in the class");
        }
        return "";
    }

    public String decode() throws Exception {
        if (this.rotors.length > 0 || this.offset > 0 || !this.text.isEmpty()) {
            String unrotored = this.unRotator(this.text);
            return this.caesar(this.offset, unrotored, false);
        }
        throw new Exception("One or more param is not defined in the class");
    }

    /**
     * Bouger la position d'un caractère de n + i
     * @param n offset
     * @param m le chaine de caractère
     * @param encode true encoder / false decoder
     * @return String
     */
    private String caesar(int n, String m, boolean encode) {
        String result = "";
        char ch;
        for (int i = 0; i < m.length(); i++) {
            int move = n + i;
            if (encode) {
                ch = (char) (((int) m.charAt(i) + move + 65) % 26 + 65);
            } else {
                ch = (char) (((int) m.charAt(i) - move + 65) % 26 + 65);
            }
            result += ch;
        }
        return result;
    }


    /**
     * fait passer une chaine de caractère dans le rotor pour retrouver les positions initiale
     * @param res la chaine à décoder
     * @return String
     */
    private String unRotator(String res) {
        for (int j = rotors.length -1; j >= 0 ; j--) {
            String done = "";
            for (int i = 0; i < res.length(); i++) {
                char currentChar = res.charAt(i);
                int pos = rotors[j].indexOf(currentChar);
                done += alpha.charAt(pos);
            }
            res = done;
        }
        return res;
    }

    /**
     * crypter la chaine de caractaire en la faisant passer dans les rotos
     * @param res chaine de caractaire
     * @return String
     */
    private String rotator(String res) {
        for (int j = 0; j < rotors.length; j++) {
            String done = "";
            for (int i = 0; i < res.length(); i++) {
                char currentChar = res.charAt(i);
                int pos = alpha.indexOf(currentChar);
                done += rotors[j].charAt(pos);
            }
            res = done;
        }
        return res;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getRotors() {
        return rotors;
    }

    public void setRotors(String[] rotors) {
        this.rotors = rotors;
    }
}