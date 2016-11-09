/**
 *
 * @author Daniel Mulyono
 */
public class CipherTester 
{
    public static void main(String[] args)
    {
        Cipher x = new Cipher(72345);
        System.out.println(x.caesarEncrypt("Hello!"));
        System.out.println(x.caesarDecrypt("Uryyb!"));
        System.out.println(x.augustusEncrypt("Hello!"));
        System.out.println(x.augustusDecrypt(x.augustusEncrypt("Hello!")));
        
        Cipher y = new Cipher(1062);
        System.out.println(y.augustusDecrypt("Qdg xyvsxh Ckqocowvglj qewnj xg jwfc skreep qdtcb RMHegKxdP Vacpp cdqat qdg cetqq Ocbpkld qd pjc Yqldngqp qd pjc Qpgqaf Ppcrbo,"));
    }
}
