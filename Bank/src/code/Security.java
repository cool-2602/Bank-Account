package code;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

class Security {
	
	private String ResetPassword() {
		String Password=Security.getEnteredPassword();
		return setEncryptPassword(Password);
	}
	
	private String EnterPassword() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new Password.");
		String Password = scan.nextLine();
		System.out.println("Re-Enter new Password");
		String Password1=scan.nextLine();
		boolean bool=Password.equals(Password1);
		while(! bool) {
			System.out.println("you enter wrong password");
			bool =true;
			EnterPassword();
		}
		return Password;
	}
	
	
	
	private static String PasswordEncrypt(String Password) {
		char[] PasswordChar = Password.toCharArray();
		String EncryptPassword = "";
		for(char Char : PasswordChar) {
			EncryptPassword+=(Char+=5);
		}
		return EncryptPassword;
	}
	
//	public static void main(String[] args) {
//		System.out.println(PasswordEncrypt("Kulvant@123"));
//		String Encrypt=setEncryptPassword("Kulvant@123");
//		System.out.println("Encrypt Password ---> "+Encrypt);
//		String Decrypt=getDecryptPassword(Encrypt);
//		System.out.println("Decrypt Password ---> "+Decrypt);
//	}
	
	private String EncryptPassword(String Password) {
		Encoder encoder = Base64.getEncoder();
		byte[] Encrypt=encoder.encode(Password.getBytes());
		return new String(Encrypt);
	}
	
	private String DecryptPassword(String EncryptedPassword) {
		Decoder decoder = Base64.getDecoder();
		byte[] arr=new byte[EncryptedPassword.length()];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(byte)EncryptedPassword.charAt(i);
		}
		byte[] Decrypt = decoder.decode(arr);
		return new String(Decrypt);
	}
	
	public static String setEncryptPassword(String Password) {
		Security security = new Security();
		String EncryptedPassword = security.EncryptPassword(Password);
		return EncryptedPassword;
	}
	
	public static String getDecryptPassword(String EncryptedPassword) {
		Security security = new Security();
		String DecryptedPassword = security.DecryptPassword(EncryptedPassword);
		return DecryptedPassword;
	}
	
	public static String getEnteredPassword() {
		Security security = new Security();
		return security.EnterPassword();
	}
	
	public static String getResetPassword() {
		Security security = new Security();
		return security.ResetPassword();
	}
}
