/**
 *
 * @author Daniel Mulyono
 */
public class Cipher 
{
    int key;
    int key2;
    
    public Cipher(int secretKey) 
    {
        key = secretKey % 26;
        key2 = secretKey;
    }
    
    private String replaceCharAt(String s, int i, char c) 
    {
        StringBuffer buf = new StringBuffer(s);
        buf.setCharAt(i, c);
        return buf.toString();
    }
    
    private String encryptLocal(String s, int key) 
    {
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if (Character.isLetter(c)) 
            {
                if (Character.isUpperCase(c)) 
                {
                    c = (char)('A' + (c - 'A' + key) % 26);
                } 
                else 
                {
                    c = (char)('a' + (c - 'a' + key) % 26);
                }
                s = replaceCharAt(s, i, c);
            }
        }
        return s;
    }
    
    public String caesarEncrypt(String s) 
    {
        return encryptLocal(s, key);
    }
    
    public String caesarDecrypt(String s) 
    {
        return encryptLocal(s, 26-key);
    }
    
    /**
     * 
     * @param text Takes a plaintext to encrypt.
     * @return Encrypted text using the provided key by the user.
     */
    public String augustusEncrypt(String text)
    {
        String augustusText = encryptLocal(text, key);
        String keyLength = String.valueOf(key2);
        int count = 0;
        
        for (int i = 0; i < augustusText.length(); i++)
        {
            if (count >= keyLength.length())
                {
                    count = 0;
                }
            char c = augustusText.charAt(i);
            if (Character.isLetter(c))
            {
                int number = Character.getNumericValue(keyLength.charAt(count));
                if (Character.isUpperCase(c))
                {
                    c = (char)('A' + (c - 'A' + number) % 26);
                }
                else
                {
                    c = (char)('a' + (c - 'a' + number) % 26);
                }
                augustusText = replaceCharAt(augustusText, i, c);
            }
            count++;
        }
        return augustusText;
    }
    
    /**
     * 
     * @param text Takes an encrypted text to decrypt.
     * @return Plaintext that has been decrypted by using the key provided by the user.
     */
    public String augustusDecrypt(String text)
    {
        String keyLength = String.valueOf(key2);
        int count = 0;
        
        for (int i = 0; i < text.length(); i++)
        {
            if (count >= keyLength.length())
                {
                    count = 0;
                }
            char c = text.charAt(i);
            if (Character.isLetter(c))
            {
                int number = Character.getNumericValue(keyLength.charAt(count));
                if (Character.isUpperCase(c))
                {
                    c = (char)('A' + (c - 'A' + (26 - number)) % 26);
                }
                else
                {
                    c = (char)('a' + (c - 'a' + (26 - number)) % 26);
                }
                text = replaceCharAt(text, i, c);
            }
            count++;
        }
        String plainText = caesarDecrypt(text);
        
        return plainText;
    }
    
    public static void main(String[] args)
    {
        Cipher x = new Cipher(93278);
        System.out.println(x.augustusEncrypt("I have a pet rabbit."));
        System.out.println(x.augustusDecrypt("H zxtd s ndm oyauaq."));
        
        Cipher y = new Cipher(143);
        System.out.println(y.augustusDecrypt("cy mvqv Y ue kxwj"));
    }
}