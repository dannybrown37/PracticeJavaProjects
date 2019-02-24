package emailapp;

public class EmailApp {

	public static void main(String[] args) {	
		
		Email emailOne = new Email();
		
		System.out.println(emailOne.showInfo());
		
		emailOne.setAlternateEmail(emailOne.getUserName().replace(" ",  "") + "@gmail.com");
		System.out.println("Alternate Email: " + emailOne.getAlternateEmail());
	}

}
