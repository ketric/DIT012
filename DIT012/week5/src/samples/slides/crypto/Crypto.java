package samples.slides.crypto;

import static java.lang.System.out;

/**
 * Interface to
 */
public class Crypto {


    public static void main(String[] args) {
        new Crypto().program();
    }

    private void program() {
        // Use one object
        ICryptable c1 = new CesarCipher(13);
        String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
        ICryptable c2 = new SomeCipher(key, initVector);

        doIt(c1, "Hello world");
        doIt(c2, "Hello world");
    }


    // Hm,, don't matter if we change implementing object, method will work anyway
    private void doIt(ICryptable c, String msg){
        String s = c.encrypt(msg);
        out.println(s);
        out.println(c.decrypt(s));
    }

}
