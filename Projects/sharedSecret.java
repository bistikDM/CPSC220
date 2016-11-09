// Daniel Mulyono
import java.util.Scanner;
// Base 4, modulo 12

public class sharedSecret 
{
    public static int publicPrivate(int moduloNumber, int base, int privateNumber)
    {
        int finalNumber = (int)Math.pow(base, privateNumber) % moduloNumber;
        return finalNumber;
    }
    
    public static int sharedSecret(int teammatePublicPrivateNumber, int privateNumber, int moduloNumber)
    {
        int finalNumber = (int)Math.pow(teammatePublicPrivateNumber, privateNumber) % moduloNumber;
        return finalNumber;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int moduloNumber;
        int base;
        int firstPrivateNumber;
        int secondPrivateNumber;
        int publicPrivateNumber;
        int teammatePublicPrivateNumber;
        int sharedSecretNumber;
        int teammateSharedSecretNumber;
        String firstPerson;
        String secondPerson;
        
        System.out.print("Enter modulo number: ");
        moduloNumber = in.nextInt();
        System.out.print("Enter base: ");
        base = in.nextInt();
        System.out.print("Enter name 1: ");
        in.nextLine();
        firstPerson = in.nextLine();
        System.out.print("Enter " + firstPerson + "'s private number :");
        firstPrivateNumber = in.nextInt();
        System.out.print("Enter name 2: ");
        in.nextLine();
        secondPerson = in.nextLine();
        System.out.print("Enter " + secondPerson + "'s private number :");
        secondPrivateNumber = in.nextInt();
        
        publicPrivateNumber = publicPrivate(moduloNumber, base, firstPrivateNumber);
        teammatePublicPrivateNumber = publicPrivate(moduloNumber, base, secondPrivateNumber);
        sharedSecretNumber = sharedSecret(teammatePublicPrivateNumber, firstPrivateNumber, moduloNumber);
        teammateSharedSecretNumber = sharedSecret(publicPrivateNumber, secondPrivateNumber, moduloNumber);
        
        System.out.println(firstPerson + "'s private: " + firstPrivateNumber + 
                " Public-Private: " + publicPrivateNumber + 
                " Shared-Secret: " + sharedSecretNumber + ".");
        System.out.println(secondPerson + "'s private: " + secondPrivateNumber + 
                " Public-Private: " + teammatePublicPrivateNumber + 
                " Shared-Secret: " + teammateSharedSecretNumber + ".");
    }
}