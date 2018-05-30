package samples.slides.crypto;

/*
 *  Inteface for objects able to creypt and decrypt
 */
public interface ICryptable {
    String encrypt(String msg);
    String decrypt(String msg);
}
