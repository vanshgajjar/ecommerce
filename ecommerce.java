import java.util.*;
import java.time.LocalDate;

class Main // Main class that handles user registration process
{
	static {
		System.out.println();
		System.out.println("\t  -------------------------------------------------");
		System.out.println();
		System.out.println("\t\t\t--->> HELLO USER <<---");
		System.out.println();
		System.out.println("\t   ===>    WELCOME TO THE LJ BAZAAR    <===");
		System.out.println();
		System.out.println("\t  -------------------------------------------------");
		System.out.println("\n");
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Register r = new Register(); // Object for Register class

		while (true) {
			System.out.println("  	>>  REGESTRARION PROCESS  <<");
			System.out.println("\n");
			System.out.println("  Enter 1 for Register with E-Mail.");
			System.out.println("  Enter 2 for register with Mobile Number.");
			System.out.println();
			System.out.print("--> Enter Your Choice here : ");
			int choice = sc.nextInt(); // Taking user input for choice
			System.out.println();
			switch (choice) {
				case 1: {
					r.registeremail(); // Calling method to register with email
					break;
				}
				case 2: {
					r.registernumber(); // Calling method to register with mobile number
					break;
				}
				default: {
					System.out.println("Invalid Choice !!! \n Enter Valid Choice...");
					System.out.println();
				}
			}
		}
	}
}

class Register // Class to handle user registration
{
	Scanner sc = new Scanner(System.in);
	static String password, email = "0", number = "1";
	Login l = new Login();

	void registeremail() // Method to handle email registration
	{
		while (true) {
			String e = "";
			System.out.println("Enter E-Mail In Length Of 20...");
			System.out.println(" eg : xyz@gmail.com");
			System.out.print("-> Enter e-mail here : ");
			email = sc.nextLine();
			if (email.length() >= 11) {
				int n = email.length();
				for (int i = n - 10; i < n; i++) {
					e = e + email.charAt(i);
				}
				if (email.length() <= 20) {
					if (e.equals("@gmail.com")) {
						break;
					} else {
						System.out.println("Enter Valid E-mail !!");
					}
				} else {
					System.out.println("Enter Valid E-mail !!");
				}
			}
		}
		while (true) {
			System.out.print("-> Confirm e-mail here : ");
			String cemail = sc.nextLine();
			if (cemail.equals(email)) {
				email = cemail;
				setpassword(); // Setting password after successful email confirmation
				l.loginemail(email, password); // Redirecting to login process
				return;
			} else {
				System.out.println("Enter Valid E-mail !!");
			}
		}
	}

	void registernumber() // Method to handle mobile number registration
	{
		while (true) {
			System.out.print("-> Mobile Number : ");
			number = sc.nextLine();
			String n = number;
			int c = 0;
			int c1 = 0;
			for (int i = 0; i < number.length(); i++) // Checking if the input contains only numbers
			{
				if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
					c++;
				} else {
					System.out.println("Mobile number length must be 10... \n Re-Enter Your Mobile Number...");
					break;
				}
			}
			if (c == 10) {
				while (true) {
					System.out.print("-> Confirm Mobile Number : ");
					String cnum = sc.nextLine();
					if (number.equals(cnum)) {
						setpassword(); // Setting password after successful mobile number confirmation
						l.loginnumber(number, password); // Redirecting to login process
						return;
					}
				}
			} else {
				System.out.println("Enter Valid Mobile Number !!");
			}
		}
	}

	void setpassword() // Method to set password during registration
	{
		while (true) {
			System.out.println();
			System.out.print("-> Enter Password : ");
			password = sc.nextLine();
			System.out.print("-> Confirm Password : ");
			String cpassword = sc.nextLine();
			if (cpassword.equals(password)) {
				password = cpassword;
				System.out.println();
				System.out.println();
				System.out.println("   ===>  REGISTERED SUCCESSFULLY  <===");
				System.out.println();
				return;
			} else {
				System.out.println("Enter Valid Password  !!");
			}
		}
	}
}

class Login // Class to handle user login process
{
	secondpage s = new secondpage();
	Scanner sc = new Scanner(System.in);

	void loginemail(String email, String password) // Method to login using email
	{
		System.out.println();
		System.out.println("\t ===>>  LOGIN HERE  <<===");
		System.out.println();

		while (true) {
			String e = "";
			System.out.println();
			System.out.println("  Login with E-Mail.");
			System.out.println("  eg : xyz@gmail.com");
			System.out.println();
			System.out.print("-> Enter e-mail here : ");
			String eemail = sc.nextLine();
			if (eemail.length() >= 11) {
				int n = eemail.length();
				for (int i = n - 10; i < n; i++) {
					e = e + eemail.charAt(i);
				}
				if (eemail.length() <= 20) {
					if (e.equals("@gmail.com")) {
						checkpassword(password);
						s.option(); // Redirecting to second page
						return;
					} else {
						System.out.println("Enter Valid E-mail !");
					}
				} else {
					System.out.println("Enter Valid E-mail !");
				}
			}
		}
	}

	void loginnumber(String number, String password) // Method to check password
	{
		System.out.println();
		System.out.println("\t   ===>>  LOGIN HERE  <<===");
		System.out.println();
		while (true) {
			System.out.println();
			System.out.println("  Login with Mobile Number.");
			System.out.println();
			System.out.print("-> Enter Mobile Number : ");
			String enumber = sc.nextLine();
			int c = 0;
			for (int i = 0; i < enumber.length(); i++) {
				if (enumber.charAt(i) >= '0' && enumber.charAt(i) <= '9') {
					c++;
				} else {
					System.out.println("Mobile number length must be 10... \n Re-Enter Your Mobile Number...");
					break;
				}
			}
			if (c == 10) {
				if (enumber.length() == 10) {
					if (number.equals(enumber)) {
						// sc.nextLine();
						checkpassword(password);
						s.option();
						return;
					}
				}
			} else {
				System.out.println("Enter Valid Mobile Number !");
			}
		}
	}

	void checkpassword(String password) {
		while (true) {
			System.out.print("-> Enter Password : ");
			String epass = sc.nextLine();
			if (epass.equals(password)) {
				System.out.println();
				System.out.println("   ===>  !! LOGIN SUCCESS !!  <===");
				System.out.println();
				return;
			} else {
				System.out.println("Enter Valid Password !");
			}
		}
	}
}

class secondpage // class to handle second page
{
	Cart[] cr = new Cart[399];
	Epage e = new Epage();
	Gpage g = new Gpage();
	Wpage w = new Wpage();
	Cpage c = new Cpage();
	Cospage co = new Cospage();
	Fpage f = new Fpage();
	Cart ct = new Cart();

	Scanner sc = new Scanner(System.in);

	void option() // Method to select options
	{
		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > > Select 1 for Electronics Products.");
			System.out.println(" > > Select 2 for Grocery.");
			System.out.println(" > > Select 3 for Wearables items.");
			System.out.println(" > > Select 4 for Furniture.");
			System.out.println(" > > Select 5 for Cosmetics items.");
			System.out.println(" > > Select 6 for Crockery.");
			System.out.println(" > > Select 7 for Check Cart.");
			System.out.println(" > > Select 8 for Customer Support.");
			System.out.println();
			System.out.println(" > > Select 9 for going to Previous Page.");
			System.out.println();
			System.out.print("-> Enter Your Choice here : ");
			int choice = sc.nextInt();
			System.out.println();
			switch (choice) {
				case 1: {
					e.electronicoption(cr); // Calling method to access electronic product catagory
					break;
				}
				case 2: {
					g.groceryoption(cr); // Calling method to access grocery product catagory
					break;
				}
				case 3: {
					w.woption(cr); // Calling method to access wearable item catagory
					break;
				}
				case 4: {
					f.foption(cr); // Calling method to access furniture product catagory
					break;
				}
				case 5: {
					co.cooption(cr); // Calling method to access cosmetic product catagory
					break;
				}
				case 6: {
					c.coption(cr); // Calling method to access crockery product catagory
					break;
				}
				case 7: {
					ct.display(cr); // Calling method to display cart item
					break;
				}
				case 8: {
					System.out.println("  LJ  BAZAR 24/7 CUSTOMER SUPPORT");
					System.out.println();
					System.out.println(" Ph.No :- +91 1800-878-9890");
					System.out.println(" E Mail :- ljbazar@gmail.com");
					System.out.println(" ==> If You Have Any Query Contect Us!! ");
					System.out.println();
					break;
				}
				case 9: {
					return;
				}
				default: {
					System.out.println("Enter valid choice !");
					break;
				}
			}
		}
	}
}

class Epage // Class to handle Electronic products
{
	Scanner sc = new Scanner(System.in);

	SpeakerDetail[] spe = new SpeakerDetail[10];
	LaptopDetail lap[] = new LaptopDetail[10];
	TabletDetail tab[] = new TabletDetail[10];
	MobileDetail m[] = new MobileDetail[10];
	EarphoneDetail[] ear = new EarphoneDetail[10];
	TvDetail tv[] = new TvDetail[10];
	FridgeDetail fri[] = new FridgeDetail[10];
	WashingmachineDetail wm[] = new WashingmachineDetail[10];
	MicrowaveDetail mw[] = new MicrowaveDetail[10];

	Epage() // constructor to initialize chosen product
	{
		m[0] = new MobileDetail(1, "SAMSUNG", "S23 Ultra", 12, 256, 109999);
		m[1] = new MobileDetail(2, "SAMSUNG", "S24 Ultra", 12, 512, 159999);
		m[2] = new MobileDetail(3, "SAMSUNG", "S25 Ultra", 16, 1024, 179999);
		m[3] = new MobileDetail(4, "APPLE", "16 Plus", 8, 128, 79999);
		m[4] = new MobileDetail(5, "APPLE", "16 Pro", 8, 256, 119999);
		m[5] = new MobileDetail(6, "APPLE", "16 Pro Max", 12, 512, 159999);
		m[6] = new MobileDetail(7, "IQOO", "Z9 Turbo", 8, 256, 28999);
		m[7] = new MobileDetail(8, "IQOO", "13 Pro", 12, 512, 59999);
		m[8] = new MobileDetail(9, "ONE PLUS", "13R", 16, 1024, 45999);
		m[9] = new MobileDetail(10, "ONE PLUS", "NORD CE4", 8, 256, 29999);

		tab[0] = new TabletDetail(11, "SAMSUNG", "TAB S9", 8, 256, 80999);
		tab[1] = new TabletDetail(12, "SAMSUNG", "TAB S10 PRO", 16, 1024, 129999);
		tab[2] = new TabletDetail(13, "REALME", "PAD X", 12, 256, 20999);
		tab[3] = new TabletDetail(14, "REDMI", "PAD 10", 8, 128, 19999);
		tab[4] = new TabletDetail(15, "REALME", "PAD X PRO", 12, 256, 26999);
		tab[5] = new TabletDetail(16, "REDMI", "PAD 10 plus", 16, 512, 24999);
		tab[6] = new TabletDetail(17, "APPLE", "iPAD PRO M3", 8, 256, 94999);
		tab[7] = new TabletDetail(18, "APPLE", "iPAD M4 plus", 8, 512, 162999);
		tab[8] = new TabletDetail(19, "LENOVO", "TAB +", 8, 128, 14999);
		tab[9] = new TabletDetail(20, "LENOVO", "TAB PRO", 12, 256, 21999);

		lap[0] = new LaptopDetail(21, "ASUS", "TUF F15", 8, 256, 56999, "Snapdraagon 7 elite");
		lap[1] = new LaptopDetail(22, "ASUS", "TUF F17", 16, 512, 75999, "intel CORE i7");
		lap[2] = new LaptopDetail(23, "ASUS", "ROG Strix 16", 16, 1024, 109999, "intel CORE i7");
		lap[3] = new LaptopDetail(24, "ASUS", "ROG Strix 16 PRO", 24, 2048, 139999, "intel CORE i9");
		lap[4] = new LaptopDetail(25, "MSI", "Prestige Pro", 16, 512, 84999, "Snapdraagon elite 8");
		lap[5] = new LaptopDetail(26, "MSI", "Creator A16", 8, 256, 68999, "RYZEN 7000");
		lap[6] = new LaptopDetail(27, "MSI", "Cyborg 16", 12, 512, 58999, "Dimensity 8000");
		lap[7] = new LaptopDetail(28, "HP", "VICTUS V15", 8, 256, 55999, "intel CORE i5");
		lap[8] = new LaptopDetail(29, "HP", "Pavilion 15", 12, 512, 49999, "Dimensity 7000");
		lap[9] = new LaptopDetail(30, "HP", "15s", 8, 512, 44999, "intel CORE i3");

		spe[0] = new SpeakerDetail(31, "BOAT", "STONE 1200", 3999, 9, 28);
		spe[1] = new SpeakerDetail(32, "BOAT", "STONE BEAM", 3699, 12, 42);
		spe[2] = new SpeakerDetail(33, "BOAT", "SOUNDBAR", 28999, 25, 72);
		spe[3] = new SpeakerDetail(34, "JBL", "FLIP", 6999, 14, 24);
		spe[4] = new SpeakerDetail(35, "JBL", "BOOMBOX", 33999, 28, 72);
		spe[5] = new SpeakerDetail(36, "JBL", "PARTY BOX", 17999, 18, 36);
		spe[6] = new SpeakerDetail(37, "MIVI", "FORT", 3999, 9, 24);
		spe[7] = new SpeakerDetail(38, "MIVI", "PLAY BLUE", 8999, 14, 38);
		spe[8] = new SpeakerDetail(39, "SONY", "BRAVIA 5.1", 12999, 12, 40);
		spe[9] = new SpeakerDetail(40, "SONY", "SRS XB13", 3899, 12, 24);

		ear[0] = new EarphoneDetail(41, "SKULLCANDY", "SMOKIN BUDS", 7999, 72);
		ear[1] = new EarphoneDetail(42, "SKULLCANDY", "DIME TWS", 9899, 48);
		ear[2] = new EarphoneDetail(43, "MIVI", "SuperPods", 6999, 36);
		ear[3] = new EarphoneDetail(44, "MIVI", "DuoPods", 4999, 50);
		ear[4] = new EarphoneDetail(45, "SAMSUNG", "Galaxy Buds 3", 12999, 72);
		ear[5] = new EarphoneDetail(46, "SAMSUNG", "BUDS FE", 8999, 64);
		ear[6] = new EarphoneDetail(47, "APPLE", "AirPods Plus", 5999, 36);
		ear[7] = new EarphoneDetail(48, "APPLE", "AirPods PRO", 6999, 48);
		ear[8] = new EarphoneDetail(49, "BOAT", "NIRVANA ION", 3599, 36);
		ear[9] = new EarphoneDetail(50, "BOAT", "TWS ALPHA", 25999, 50);

		tv[0] = new TvDetail(51, "LG", "READY SMART", 32, 21999, "2K LCD");
		tv[1] = new TvDetail(52, "LG", "ULTRA HD SMART", 55, 32999, "QLED + 4K Resolution");
		tv[2] = new TvDetail(53, "LG", "SMART 4K", 40, 42999, "PLASMA + 4K Resolution");
		tv[3] = new TvDetail(54, "SAMSUNG", "CRYSTAL 4K", 50, 30999, "2K Resolution + OLED");
		tv[4] = new TvDetail(55, "SAMSUNG", "4K VIVID HD", 32, 42999, "4K Resolution");
		tv[5] = new TvDetail(56, "SAMSUNG", "D SERIES CRYSTAL", 60, 48999, "QLED");
		tv[6] = new TvDetail(57, "SONY", "BRAVIA", 40, 65999, "2K Resolution + LED");
		tv[7] = new TvDetail(58, "SONY", "BRAVIA 3 series", 43, 71999, "QLED + 4K Resolution");
		tv[8] = new TvDetail(59, "PANASONIC", "4K ANDRIOD", 50, 54999, "OLED + 4K Resolution");
		tv[9] = new TvDetail(60, "PANASONIC", "FULL HD SMART", 65, 84999, "QLED + 4K Resolution");

		fri[0] = new FridgeDetail(61, "SAMSUNG", "256L Frost Free", 32999, 256);
		fri[1] = new FridgeDetail(62, "SAMSUNG", "363L Star Convertible", 45999, 363);
		fri[2] = new FridgeDetail(63, "GODREJ", "180L Single Door", 18999, 180);
		fri[3] = new FridgeDetail(64, "GODREJ", "272L DOuble Door", 24999, 272);
		fri[4] = new FridgeDetail(65, "GODREJ", "223L Frost Free", 22999, 223);
		fri[5] = new FridgeDetail(66, "LG", "242L Smart Inverter", 26999, 242);
		fri[6] = new FridgeDetail(67, "LG", "1Star Double Door", 709995, 512);
		fri[7] = new FridgeDetail(68, "LG", "509L Convertible", 61999, 509);
		fri[8] = new FridgeDetail(69, "WHIRPOOL", "235L Frost Free", 23999, 235);
		fri[9] = new FridgeDetail(70, "WHIRPOOL", "Intellifresh", 43999, 272);

		wm[0] = new WashingmachineDetail(71, "LG", "6.5 Front Load", 24999, 6.5);
		wm[1] = new WashingmachineDetail(72, "LG", "8kg 5 Star Inverter", 32999, 8);
		wm[2] = new WashingmachineDetail(73, "LG", "8kg Semi-Automated", 14999, 8);
		wm[3] = new WashingmachineDetail(74, "SAMSUNG", "9kg EcoBubble", 38999, 9);
		wm[4] = new WashingmachineDetail(75, "SAMSUNG", "7kg Top Load", 17999, 7);
		wm[5] = new WashingmachineDetail(76, "SAMSUNG", "12kg Front LOad with Smart AI", 43999, 12);
		wm[6] = new WashingmachineDetail(77, "PANSONIC", "7kg 5STAR Fully Automatic", 18599, 7);
		wm[7] = new WashingmachineDetail(78, "PANSONIC", "8kg Automated 5STAR", 33999, 8);
		wm[8] = new WashingmachineDetail(79, "WHIRPOOL", "7.5kg SemiAutomated", 11999, 7.5);
		wm[9] = new WashingmachineDetail(80, "WHIRPOOL", "9kg ACE XL", 14499, 9);

		mw[0] = new MicrowaveDetail(81, "VOLTAS", "25L VOLATS BEKO", 11999, 25);
		mw[1] = new MicrowaveDetail(82, "VOLTAS", "28L BEKO CONVECTION", 20999, 28);
		mw[2] = new MicrowaveDetail(83, "GODREJ", "30L CONVECTION", 13999, 30);
		mw[3] = new MicrowaveDetail(84, "GODREJ", "25L OVEN", 10999, 25);
		mw[4] = new MicrowaveDetail(85, "SAMSUNG", "23L SOLO MICROWAVE", 12999, 23);
		mw[5] = new MicrowaveDetail(86, "SAMSUNG", "32L SLIM FRY CONVECTION", 17499, 32);
		mw[6] = new MicrowaveDetail(87, "WHIRPOOL", "29L Magicook OVEN", 13999, 29);
		mw[7] = new MicrowaveDetail(88, "WHIRPOOL", "32L 0Magicook PRO", 17599, 32);
		mw[8] = new MicrowaveDetail(89, "HAIER", "20L SOLO MICROWAVE OVEN", 6199, 20);
		mw[9] = new MicrowaveDetail(90, "HAIER", "30L CONVECTION OVEN", 13999, 30);
	}

	void electronicoption(Cart[] cr) // Method to manage cart for electronic items
	{
		Mobile mo = new Mobile();
		Tablet tt = new Tablet();
		Laptop l = new Laptop();
		Speaker s = new Speaker();
		Earphone e = new Earphone();
		Tv t = new Tv();
		Fridge f = new Fridge();
		Washingmachine w = new Washingmachine();
		Microwave mic = new Microwave();

		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > Enter 1 For Mobile information.");
			System.out.println(" > Enter 2 For Tablet information.");
			System.out.println(" > Enter 3 For Laptop information.");
			System.out.println(" > Enter 4 For Speaker information.");
			System.out.println(" > Enter 5 For Earphone information.");
			System.out.println(" > Enter 6 For TV information.");
			System.out.println(" > Enter 7 For Fridge information.");
			System.out.println(" > Enter 8 For Washingmachine information.");
			System.out.println(" > Enter 9 For Microwave information.");
			System.out.println();
			System.out.println(" > Enter 10 for Going To Previous Page.");
			System.out.println();
			System.out.print("-> Enter your choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					mo.mobile(m, cr); // Calling method to access mobile catagory
					break;
				}
				case 2: {
					tt.tablet(tab, cr); // Calling method to access tablet catagory
					break;
				}
				case 3: {
					l.laptop(lap, cr); // Calling method to access laptop catagory
					break;
				}
				case 4: {
					s.speaker(spe, cr); // Calling method to access speaker catagory
					break;
				}
				case 5: {
					e.earphone(ear, cr); // Calling method to access earphone catagory
					break;
				}
				case 6: {
					t.tv(tv, cr); // Calling method to access tv catagory
					break;
				}
				case 7: {
					f.fridge(fri, cr); // Calling method to access fridge catagory
					break;
				}
				case 8: {
					w.washingmachin(wm, cr); // Calling method to access washing machine catagory
					break;
				}
				case 9: {
					mic.microwave(mw, cr); // Calling method to access microwave catagory
					break;
				}
				case 10: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}

		}
	}
}

class MobileDetail // Class to handle mobile details
{
	String companyname;
	String mobilename;
	int ram;
	int storage;
	int price;
	int number;

	MobileDetail(int number, String companyname, String mobilename, int ram, int storage, int price) // Constructor to
																										// initialize
																										// mobile
																										// specification
	{
		this.number = number;
		this.companyname = companyname;
		this.mobilename = mobilename;
		this.ram = ram;
		this.storage = storage;
		this.price = price;
	}
}

class Mobile // Class to handle mobile catagory
{
	Scanner sc = new Scanner(System.in);

	void mobile(MobileDetail[] m, Cart[] cr) // Method to access mobile catgory
	{
		displayallname(m); // Method to display mobile name
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Mobile Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Sort By Strorage.");
			System.out.println(" > Press 4 For Search Mobile.");
			System.out.println(" > Press 5 For Add to Cart.");
			System.out.println();
			System.out.println(" > Press 6 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(m);
					break;
				}
				case 2: {
					sortprice(m);
					break;
				}
				case 3: {
					sortstorage(m);
					break;
				}
				case 4: {
					searchmobile(m);
					break;
				}
				case 5: {
					cart(m, cr);
					break;
				}
				case 6: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(MobileDetail[] m, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt(); // Taking user input for the number of products to purchase
		int c = 0; // Counter for successful product additions
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt(); // Taking user input for product number
			for (int j = 0; j < m.length; j++) {
				if (n == m[j].number) {
					System.out.println("   Mobiles added to Cart : " + m[j].mobilename);
					cr[j] = new Cart(m[j].number, m[j].companyname, m[j].mobilename, m[j].storage, m[j].ram,
							m[j].price);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(MobileDetail[] m) // Method to display all details of mobile products
	{
		for (int i = 0; i < m.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + m[i].number);
			System.out.println(" - Company : " + m[i].companyname);
			System.out.println(" - Mobile Name : " + m[i].mobilename);
			System.out.println(" - RAM : " + m[i].ram + "GB");
			System.out.println(" - Storage : " + m[i].storage + "GB");
			System.out.println(" - Price : " + m[i].price);
			// System.out.println();
		}
	}

	void displayallname(MobileDetail[] m) // Method to display only the names and company details of mobile products
	{
		for (int i = 0; i < m.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + m[i].number);
			System.out.println(" - Company : " + m[i].companyname);
			System.out.println(" - Mobile Name : " + m[i].mobilename);
			// System.out.println("------------------------");
		}
	}

	void sortprice(MobileDetail[] m) // Method to sort mobile products based on price
	{
		System.out.println();
		System.out.println(" > Press 1 For Sort mobiles from High price to Low price .");
		System.out.println(" > Press 2 For Sort mobiles from Low price to High price .");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < m.length - 1; i++) // Sorting in descending order (High to Low)
			{
				for (int j = 0; j < m.length - 1; j++) {
					if (m[j].price < m[j + 1].price) {
						MobileDetail t = m[j];
						m[j] = m[j + 1];
						m[j + 1] = t;
					}
				}
			}
			displayalldetails(m);
		} else if (n == 2) // Sorting in ascending order (Low to High)
		{
			for (int i = 0; i < m.length - 1; i++) {
				for (int j = 0; j < m.length - 1; j++) {
					if (m[j].price > m[j + 1].price) {
						MobileDetail t = m[j];
						m[j] = m[j + 1];
						m[j + 1] = t;
					}
				}
			}
			displayalldetails(m);
		}
	}

	void sortstorage(MobileDetail[] m) // Method to sort mobile products based on storage in descending order
	{
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m.length - 1; j++) {
				if (m[j].storage < m[j + 1].storage) {
					MobileDetail t = m[j];
					m[j] = m[j + 1];
					m[j + 1] = t;
				}
			}
		}
		displayalldetails(m);
	}

	void searchmobile(MobileDetail[] m) // Method to search a mobile product by name
	{
		System.out.print("-> Enter Mobile Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < m.length; i++) {
			String e = m[i].mobilename;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product Number : " + m[i].number);
				System.out.println(" - Company : " + m[i].companyname);
				System.out.println(" - Mobile Name : " + m[i].mobilename);
				System.out.println(" - RAM : " + m[i].ram);
				System.out.println(" - Storage : " + m[i].storage);
				System.out.println(" - Price : " + m[i].price);
				// System.out.println();
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class TabletDetail {
	String companyname;
	String tabletname;
	int ram;
	int storage;
	int price;
	int number;

	TabletDetail(int number, String companyname, String tabletname, int ram, int storage, int price) // Constructor to
																										// initialize
																										// tablet
																										// details
	{
		this.number = number;
		this.companyname = companyname;
		this.tabletname = tabletname;
		this.ram = ram;
		this.storage = storage;
		this.price = price;
	}
}

class Tablet {
	Scanner sc = new Scanner(System.in);

	void tablet(TabletDetail[] tab, Cart[] cr) {
		displayallname(tab);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Tablet Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Sort By Strorage.");
			System.out.println(" > Press 4 For Search Tablet.");
			System.out.println(" > Press 5 For Add to Cart.");
			System.out.println();
			System.out.println(" > Press 6 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(tab);
					break;
				}
				case 2: {
					sortprice(tab);
					break;
				}
				case 3: {
					sortstorage(tab);
					break;
				}
				case 4: {
					searchtablet(tab);
					break;
				}
				case 5: {
					cart(tab, cr);
					break;
				}
				case 6: {
					return;
				}
			}
		}
	}

	void cart(TabletDetail[] t, Cart[] cr) // Method to add tablets to the cart
	{
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 11, k = 0; j < 21 && k < 10; j++, k++) {
				if (n == t[k].number) {
					cr[j] = new Cart(t[k].number, t[k].companyname, t[k].tabletname, t[k].storage, t[k].ram,
							t[k].price);
					System.out.println("   Tablet Added To Cart : " + t[k].tabletname);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(TabletDetail[] t) // Method to display all tablet details
	{
		for (int i = 0; i < t.length; i++) {
			System.out.println();
			System.out.println(" - Product number : " + t[i].number);
			System.out.println(" - Company : " + t[i].companyname);
			System.out.println(" - Tablet Name : " + t[i].tabletname);
			System.out.println(" - Ram : " + t[i].ram + "GB");
			System.out.println(" - Strorage : " + t[i].storage + "GB");
			System.out.println(" - Price : " + t[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(TabletDetail[] t) // Method to display only tablet names and company details
	{
		for (int i = 0; i < t.length; i++) {
			System.out.println();
			System.out.println(" - Product number : " + t[i].number);
			System.out.println(" - Company : " + t[i].companyname);
			System.out.println(" - Tablet Name : " + t[i].tabletname);
			// System.out.println("------------------------");
		}
	}

	void sortprice(TabletDetail[] t) // Method to sort tablets by price
	{
		System.out.println(" > Press 1 For Sort Tablets from High price to Low price.");
		System.out.println(" > Press 2 For Sort Tablets from Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < t.length - 1; i++) {
				for (int j = 0; j < t.length - 1; j++) {
					if (t[j].price < t[j + 1].price) {
						TabletDetail m = t[j];
						t[j] = t[j + 1];
						t[j + 1] = m;
					}
				}
			}
			displayalldetails(t);
		} else if (n == 2) {
			for (int i = 0; i < t.length - 1; i++) {
				for (int j = 0; j < t.length - 1; j++) {
					if (t[j].price > t[j + 1].price) {
						TabletDetail m = t[j];
						t[j] = t[j + 1];
						t[j + 1] = m;
					}
				}
			}
			displayalldetails(t);
		}
	}

	void sortstorage(TabletDetail[] t) {
		for (int i = 0; i < t.length - 1; i++) {
			for (int j = 0; j < t.length - 1; j++) {
				if (t[j].storage < t[j + 1].storage) {
					TabletDetail m = t[j];
					t[j] = t[j + 1];
					t[j + 1] = m;
				}
			}
		}
		displayalldetails(t);
	}

	void searchtablet(TabletDetail[] t) // Method to search for a tablet by name
	{
		System.out.print("-> Enter Tablet Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < t.length; i++) {
			String e = t[i].tabletname;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product Number : " + t[i].number);
				System.out.println(" - Company : " + t[i].companyname);
				System.out.println(" - Tablet Name : " + t[i].tabletname);
				System.out.println(" - Ram : " + t[i].ram);
				System.out.println(" - Strorage : " + t[i].storage);
				System.out.println(" - Price : " + t[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class LaptopDetail // Class to store details of a laptop
{
	String companyname;
	String laptopname;
	String processor;
	int ram;
	int storage;
	int price;
	int number;

	LaptopDetail(int number, String companyname, String laptopname, int ram, int storage, int price, String processor) // Constructor
																														// to
																														// initialize
																														// laptop
																														// details
	{
		this.number = number;
		this.companyname = companyname;
		this.laptopname = laptopname;
		this.ram = ram;
		this.storage = storage;
		this.price = price;
		this.processor = processor;
	}
}

class Laptop // Class to handle laptop-related operations
{
	Scanner sc = new Scanner(System.in);

	void laptop(LaptopDetail[] l, Cart[] cr) {
		displayallname(l);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Laptop Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Sort By Strorage.");
			System.out.println(" > Press 4 For Search Laptop.");
			System.out.println(" > Press 5 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 6 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(l);
					break;
				}
				case 2: {
					sortprice(l);
					break;
				}
				case 3: {
					sortstorage(l);
					break;
				}
				case 4: {
					searchlaptop(l);
					break;
				}
				case 5: {
					cart(l, cr);
				}
				case 6: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(LaptopDetail[] t, Cart[] cr) // Function to add a laptop to the cart
	{
		System.out.print("-> Enter Number Of Products You Want To Purchase :");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 21, k = 0; j < 31 && k > 10; j++, k++) {
				if (n == t[k].number) {
					cr[j] = new Cart(t[k].number, t[k].companyname, t[k].laptopname, t[k].processor, t[k].storage,
							t[k].ram, t[k].price);
					System.out.println("   Laptop added to cart : " + t[k].laptopname);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(LaptopDetail[] l) // Function to display all laptop details
	{
		for (int i = 0; i < l.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + l[i].number);
			System.out.println(" - Company : " + l[i].companyname);
			System.out.println(" - Laptop Name : " + l[i].laptopname);
			System.out.println(" - Ram : " + l[i].ram + "GB");
			System.out.println(" - Processor : " + l[i].processor);
			System.out.println(" - Strorage : " + l[i].storage + "GB");
			System.out.println(" - Price : " + l[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(LaptopDetail[] l) {
		for (int i = 0; i < l.length; i++) {
			System.out.println();
			System.out.println(" - Company : " + l[i].companyname);
			System.out.println(" - Laptop Name : " + l[i].laptopname);
			// System.out.println("------------------------");
		}
	}

	void sortprice(LaptopDetail[] l) {
		System.out.println();
		System.out.println(" > Press 1 For Sort Laptops High price to Low price.");
		System.out.println(" > Press 2 For Sort Laptops Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < l.length - 1; i++) {
				for (int j = 0; j < l.length - 1; j++) {
					if (l[j].price < l[j + 1].price) {
						LaptopDetail t = l[j];
						l[j] = l[j + 1];
						l[j + 1] = t;
					}
				}
			}
			displayalldetails(l);
		} else if (n == 2) {
			for (int i = 0; i < l.length - 1; i++) {
				for (int j = 0; j < l.length - 1; j++) {
					if (l[j].price > l[j + 1].price) {
						LaptopDetail t = l[j];
						l[j] = l[j + 1];
						l[j + 1] = t;
					}
				}
			}
			displayalldetails(l);
		}
	}

	void sortstorage(LaptopDetail[] l) {
		for (int i = 0; i < l.length - 1; i++) {
			for (int j = 0; j < l.length - 1; j++) {
				if (l[j].storage < l[j + 1].storage) {
					LaptopDetail t = l[j];
					l[j] = l[j + 1];
					l[j + 1] = t;
				}
			}
		}
		displayalldetails(l);
	}

	void searchlaptop(LaptopDetail[] l) // Method to search for a laptop by name
	{
		System.out.println(" -> Enter Laptop Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < l.length; i++) {
			String e = l[i].laptopname;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + l[i].companyname);
				System.out.println(" - Laptop Name : " + l[i].laptopname);
				System.out.println(" - Ram : " + l[i].ram);
				System.out.println(" - Processor : " + l[i].processor);
				System.out.println(" - Strorage : " + l[i].storage);
				System.out.println(" - Price : " + l[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!	");
		}
	}
}

class SpeakerDetail // Class to store details of a speake
{
	String companyname;
	String speakername;
	int price;
	int power;
	int playtime;
	int number;

	SpeakerDetail(int number, String companyname, String speakername, int price, int power, int playtime) {
		this.number = number;
		this.companyname = companyname;
		this.speakername = speakername;
		this.price = price;
		this.power = power;
		this.playtime = playtime;
	}
}

class Speaker // Class to handle speaker-related operations
{
	Scanner sc = new Scanner(System.in);

	void speaker(SpeakerDetail[] spe, Cart[] cr) {
		displayallname(spe);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Speaker Details");
			System.out.println(" > Press 2 For Sort By Price");
			System.out.println(" > Press 3 For Sort By Playtime");
			System.out.println(" > Press 4 For Sort By Power");
			System.out.println(" > Press 5 For Search Speaker");
			System.out.println(" > Press 6 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 7 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(spe);
					break;
				}
				case 2: {
					sortprice(spe);
					break;
				}
				case 3: {
					sortplaytime(spe);
					break;
				}
				case 4: {
					sortpower(spe);
					break;
				}
				case 5: {
					searchspeaker(spe);
					break;
				}
				case 6: {
					cart(spe, cr);
				}
				case 7: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(SpeakerDetail[] t, Cart[] cr) // Function to add a speaker to the cart
	{
		System.out.print(" -> Enter Number of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 31; j < 10 && k < 41; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].speakername, t[j].playtime, t[j].power,
							t[j].price, "x");
					System.out.println("   Speakers Added To Cart : " + t[j].speakername);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(SpeakerDetail[] spe) // Method to display speaker details
	{
		for (int i = 0; i < spe.length; i++) {
			System.out.println();
			System.out.println(" - Product number : " + spe[i].number);
			System.out.println(" - Company : " + spe[i].companyname);
			System.out.println(" - Speaker Name : " + spe[i].speakername);
			System.out.println(" - Power : " + spe[i].power);
			System.out.println(" - Playtime : " + spe[i].playtime);
			System.out.println(" - Price : " + spe[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(SpeakerDetail[] spe) // Method to display speaker company details
	{
		for (int i = 0; i < spe.length; i++) {
			System.out.println();
			System.out.println(" - Product number : " + spe[i].number);
			System.out.println(" - Company : " + spe[i].companyname);
			System.out.println(" - Speaker Name : " + spe[i].speakername);
			// System.out.println("------------------------");
		}
	}

	void sortprice(SpeakerDetail[] spe) // Method to sort by brice
	{
		System.out.println();
		System.out.println(" > Press 1 For Sort Speakers from High price to Low price .");
		System.out.println(" > Press 2 For Sort Speakers from Low price to High price .");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < spe.length - 1; i++) {
				for (int j = 0; j < spe.length - 1; j++) {
					if (spe[j].price < spe[j + 1].price) {
						SpeakerDetail t = spe[j];
						spe[j] = spe[j + 1];
						spe[j + 1] = t;
					}
				}
			}
			displayalldetails(spe);
		} else if (n == 2) {
			for (int i = 0; i < spe.length - 1; i++) {
				for (int j = 0; j < spe.length - 1; j++) {
					if (spe[j].price > spe[j + 1].price) {
						SpeakerDetail t = spe[j];
						spe[j] = spe[j + 1];
						spe[j + 1] = t;
					}
				}
			}
			displayalldetails(spe);
		}
	}

	void sortpower(SpeakerDetail[] spe) // Method to sort by speaker-power
	{
		for (int i = 0; i < spe.length - 1; i++) {
			for (int j = 0; j < spe.length; j++) {
				if (spe[j].power > spe[j + 1].power) {
					SpeakerDetail t = spe[j];
					spe[j] = spe[j + 1];
					spe[j + 1] = t;
				}
			}
		}
		displayalldetails(spe);
	}

	void sortplaytime(SpeakerDetail[] spe) // Method to sort by speaker-playtime
	{
		for (int i = 0; i < spe.length - 1; i++) {
			for (int j = 0; j < spe.length; j++) {
				if (spe[j].playtime > spe[j + 1].playtime) {
					SpeakerDetail t = spe[j];
					spe[j] = spe[j + 1];
					spe[j + 1] = t;
				}
			}
		}
		displayalldetails(spe);
	}

	void searchspeaker(SpeakerDetail[] spe) // Method to search speaker
	{
		System.out.print("-> Enter Speaker Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < spe.length; i++) {
			String e = spe[i].speakername;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product number : " + spe[i].number);
				System.out.println(" - Company : " + spe[i].companyname);
				System.out.println(" - Speaker Name : " + spe[i].speakername);
				System.out.println(" - Power : " + spe[i].power);
				System.out.println(" - Playtime : " + spe[i].playtime);
				System.out.println(" - Price : " + spe[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class EarphoneDetail {
	String companyname;
	String earphonename;
	int price;
	int playtime;
	int number;

	EarphoneDetail(int number, String companyname, String earphonename, int price, int playtime) {
		this.number = number;
		this.companyname = companyname;
		this.earphonename = earphonename;
		this.price = price;
		this.playtime = playtime;
	}
}

class Earphone {
	Scanner sc = new Scanner(System.in);

	void earphone(EarphoneDetail[] ear, Cart[] cr) {
		displayallname(ear);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Earphone Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Sort By Strorage.");
			System.out.println(" > Press 4 For Search Earphpne.");
			System.out.println(" > Press 5 For Add to Cart.");
			System.out.println();
			System.out.println(" > Press 6 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(ear);
					break;
				}
				case 2: {
					sortprice(ear);
					break;
				}
				case 3: {
					sortplaytime(ear);
					break;
				}
				case 4: {
					searchearphone(ear);
					break;
				}
				case 5: {
					cart(ear, cr);
				}
				case 6: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(EarphoneDetail[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 41; j < 10 && k < 51; j++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].earphonename, t[j].playtime, t[j].price);
					System.out.println("   Earphone added to cart : " + t[j].earphonename);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(EarphoneDetail[] ear) {
		for (int i = 0; i < ear.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ear[i].number);
			System.out.println(" - Company : " + ear[i].companyname);
			System.out.println(" - Earphone Name : " + ear[i].earphonename);
			System.out.println(" - Playtime : " + ear[i].playtime);
			System.out.println(" - Price : " + ear[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(EarphoneDetail[] ear) {
		for (int i = 0; i < ear.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ear[i].number);
			System.out.println(" - Company : " + ear[i].companyname);
			System.out.println(" - Earphone Name : " + ear[i].earphonename);
			// System.out.println("------------------------");
		}
	}

	void sortprice(EarphoneDetail[] ear) {
		System.out.println("Press 1 For Sort Earphone High price to Low price.");
		System.out.println("Press 2 For Sort Earphone Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ear.length - 1; i++) {
				for (int j = 0; j < ear.length - 1; j++) {
					if (ear[j].price < ear[j + 1].price) {
						EarphoneDetail t = ear[j];
						ear[j] = ear[j + 1];
						ear[j + 1] = t;
					}
				}
			}
			displayalldetails(ear);
		} else if (n == 2) {
			for (int i = 0; i < ear.length - 1; i++) {
				for (int j = 0; j < ear.length - 1; j++) {
					if (ear[j].price > ear[j + 1].price) {
						EarphoneDetail t = ear[j];
						ear[j] = ear[j + 1];
						ear[j + 1] = t;
					}
				}
			}
			displayalldetails(ear);
		}
	}

	void sortplaytime(EarphoneDetail[] ear) {
		for (int i = 0; i < ear.length - 1; i++) {
			for (int j = 0; j < ear.length; j++) {
				if (ear[j].playtime > ear[j + 1].playtime) {
					EarphoneDetail t = ear[j];
					ear[j] = ear[j + 1];
					ear[j + 1] = t;
				}
			}
		}
	}

	void searchearphone(EarphoneDetail[] ear) {
		System.out.print("-> Enter Earphone Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < ear.length; i++) {
			String e = ear[i].earphonename;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product Number : " + ear[i].number);
				System.out.println(" - Company : " + ear[i].companyname);
				System.out.println(" - Earphone Name : " + ear[i].earphonename);
				System.out.println(" - Playtime : " + ear[i].playtime);
				System.out.println(" - Price : " + ear[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class TvDetail {
	String companyname;
	String tvname;
	int size;
	int price;
	String dtype;
	int number;

	TvDetail(int number, String companyname, String tvname, int size, int price, String dtype) {
		this.number = number;
		this.companyname = companyname;
		this.tvname = tvname;
		this.size = size;
		this.price = price;
		this.dtype = dtype;
	}
}

class Tv {
	Scanner sc = new Scanner(System.in);

	void tv(TvDetail[] v, Cart[] cv) {
		displayallname(v);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All TV Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Sort By size.");
			System.out.println(" > Press 4 For Search TV.");
			System.out.println(" > Press 5 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 6 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(v);
					break;
				}
				case 2: {
					sortprice(v);
					break;
				}
				case 3: {
					sortsize(v);
					break;
				}
				case 4: {
					searchtv(v);
					break;
				}
				case 5: {
					cart(v, cv);
				}
				case 6: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(TvDetail[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 51; j < 10 && k < 61; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].tvname, t[j].dtype, t[j].size, t[j].price);
					System.out.println("   TV added to Cart : " + t[j].tvname);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(TvDetail[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println();
			System.out.println(" - Product number : " + v[i].number);
			System.out.println(" - Company : " + v[i].companyname);
			System.out.println(" - TV Name : " + v[i].tvname);
			System.out.println(" - Size : " + v[i].size);
			System.out.println(" - Display Type : " + v[i].dtype);
			System.out.println(" - Price : " + v[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(TvDetail[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println();
			System.out.println(" - Product number : " + v[i].number);
			System.out.println(" - Company : " + v[i].companyname);
			System.out.println(" - TV Name : " + v[i].tvname);
			// System.out.println("------------------------");
		}
	}

	void sortprice(TvDetail[] v) {
		System.out.println("Press 1 For Sort TV High price to Low price.");
		System.out.println("Press 2 For Sort TV Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < v.length - 1; i++) {
				for (int j = 0; j < v.length - 1; j++) {
					if (v[j].price < v[j + 1].price) {
						TvDetail t = v[j];
						v[j] = v[j + 1];
						v[j + 1] = t;
					}
				}
			}
			displayalldetails(v);
		} else if (n == 2) {
			for (int i = 0; i < v.length - 1; i++) {
				for (int j = 0; j < v.length - 1; j++) {
					if (v[j].price > v[j + 1].price) {
						TvDetail t = v[j];
						v[j] = v[j + 1];
						v[j + 1] = t;
					}
				}
			}
			displayalldetails(v);
		}
	}

	void sortsize(TvDetail[] v) {
		for (int i = 0; i < v.length - 1; i++) {
			for (int j = 0; j < v.length - 1; j++) {
				if (v[j].size > v[j + 1].size) {
					TvDetail t = v[j];
					v[j] = v[j + 1];
					v[j + 1] = t;
				}
			}
		}
		displayalldetails(v);
	}

	void searchtv(TvDetail[] v) {
		System.out.print("-> Enter TV Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < v.length; i++) {
			String e = v[i].tvname;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product number : " + v[i].number);
				System.out.println(" - Company : " + v[i].companyname);
				System.out.println(" - TV Name : " + v[i].tvname);
				System.out.println(" - Size : " + v[i].size);
				System.out.println(" - Display Type : " + v[i].dtype);
				System.out.println(" - Price : " + v[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class FridgeDetail {
	String companyname;
	String fridgename;
	int price;
	double capacity;
	int number;

	FridgeDetail(int number, String companyname, String fridgename, int price, double capacity) {
		this.number = number;
		this.companyname = companyname;
		this.fridgename = fridgename;
		this.price = price;
		this.capacity = capacity;
	}
}

class Fridge {
	Scanner sc = new Scanner(System.in);

	void fridge(FridgeDetail[] fri, Cart[] cr) {
		displayallname(fri);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Fridge Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Sort By Capacity.");
			System.out.println(" > Press 4 For Search Fridge.");
			System.out.println(" > Press 5 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 6 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(fri);
					break;
				}
				case 2: {
					sortprice(fri);
					break;
				}
				case 3: {
					sortcapacity(fri);
					break;
				}
				case 4: {
					searchfridge(fri);
					break;
				}
				case 5: {
					cart(fri, cr);
				}
				case 6: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(FridgeDetail[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 61; j < 10 && k < 71; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].fridgename, t[j].capacity, t[j].price);
					System.out.println("   Fridge added to cart: " + t[j].fridgename);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(FridgeDetail[] fri) {
		for (int i = 0; i < fri.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + fri[i].number);
			System.out.println(" - Company : " + fri[i].companyname);
			System.out.println(" - Fridge Name : " + fri[i].fridgename);
			System.out.println(" - Size : " + fri[i].capacity + "L");
			System.out.println(" - Price : " + fri[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(FridgeDetail[] fri) {
		for (int i = 0; i < fri.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + fri[i].number);
			System.out.println(" - Company : " + fri[i].companyname);
			System.out.println(" - Fridge Name : " + fri[i].fridgename);
			// System.out.println("------------------------");
		}
	}

	void sortprice(FridgeDetail[] fri) {
		System.out.println("Press 1 For Sort Fridge High price to Low price.");
		System.out.println("Press 2 For Sort Fridge Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < fri.length - 1; i++) {
				for (int j = 0; j < fri.length - 1; j++) {
					if (fri[j].price < fri[j + 1].price) {
						FridgeDetail t = fri[j];
						fri[j] = fri[j + 1];
						fri[j + 1] = t;
					}
				}
			}
			displayalldetails(fri);
		} else if (n == 2) {
			for (int i = 0; i < fri.length - 1; i++) {
				for (int j = 0; j < fri.length - 1; j++) {
					if (fri[j].price > fri[j + 1].price) {
						FridgeDetail t = fri[j];
						fri[j] = fri[j + 1];
						fri[j + 1] = t;
					}
				}
			}
			displayalldetails(fri);
		}
	}

	void sortcapacity(FridgeDetail[] fri) {
		for (int i = 0; i < fri.length - 1; i++) {
			for (int j = 0; j < fri.length - 1; j++) {
				if (fri[j].capacity > fri[j + 1].capacity) {
					FridgeDetail t = fri[j];
					fri[j] = fri[j + 1];
					fri[j + 1] = t;
				}
			}
		}
		displayalldetails(fri);
	}

	void searchfridge(FridgeDetail[] fri) {
		System.out.println("-> Enter Fridge Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < fri.length; i++) {
			String e = fri[i].fridgename;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product Number : " + fri[i].number);
				System.out.println(" - Company : " + fri[i].companyname);
				System.out.println(" - Fridge Name : " + fri[i].fridgename);
				System.out.println(" - Size : " + fri[i].capacity + "L");
				System.out.println(" - Price : " + fri[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class WashingmachineDetail {
	String companyname;
	String washingmachinname;
	int price;
	double capacity;
	int number;

	WashingmachineDetail(int number, String companyname, String washingmachinname, int price, double capacity) {
		this.number = number;
		this.companyname = companyname;
		this.washingmachinname = washingmachinname;
		this.price = price;
		this.capacity = capacity;
	}
}

class Washingmachine {
	Scanner sc = new Scanner(System.in);

	void washingmachin(WashingmachineDetail[] mw, Cart[] cr) {
		displayallname(mw);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Washing Machine Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Search Washing Machine.");
			System.out.println(" > Press 4 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 5 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayalldetails(mw);
					break;
				}
				case 2: {
					sortprice(mw);
					break;
				}
				case 3: {
					searchwashingmachin(mw);
					break;
				}
				case 4: {
					cart(mw, cr);
				}
				case 5: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(WashingmachineDetail[] t, Cart[] cr) {
		System.out.println("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 71; j < 10 && k < 81; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].washingmachinname, t[j].capacity, t[j].price);
					System.out.println("   Washing Machine added to Cart : " + t[j].washingmachinname);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(WashingmachineDetail[] mw) {
		for (int i = 0; i < mw.length; i++) {
			System.out.println();
			System.out.println(" - Product N`umber : " + mw[i].number);
			System.out.println(" - Company : " + mw[i].companyname);
			System.out.println(" - Washing Machine Name : " + mw[i].washingmachinname);
			System.out.println(" - Size : " + mw[i].capacity + "L");
			System.out.println(" - Price : " + mw[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(WashingmachineDetail[] mw) {
		for (int i = 0; i < mw.length; i++) {
			System.out.println();
			System.out.println(" - Product N`umber : " + mw[i].number);
			System.out.println(" - Company : " + mw[i].companyname);
			System.out.println(" - Washing Machine Name : " + mw[i].washingmachinname);
			System.out.println(" - Size : " + mw[i].capacity + "L");
			// System.out.println("------------------------");
		}
	}

	void sortprice(WashingmachineDetail[] mw) {
		System.out.println("Press 1 For Sort Washing Machine High price to Low price.");
		System.out.println("Press 2 For Sort Washing Machine Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < mw.length - 1; i++) {
				for (int j = 0; j < mw.length - 1; j++) {
					if (mw[j].price < mw[j + 1].price) {
						WashingmachineDetail t = mw[j];
						mw[j] = mw[j + 1];
						mw[j + 1] = t;
					}
				}
			}
			displayalldetails(mw);
		} else if (n == 2) {
			for (int i = 0; i < mw.length - 1; i++) {
				for (int j = 0; j < mw.length - 1; j++) {
					if (mw[j].price > mw[j + 1].price) {
						WashingmachineDetail t = mw[j];
						mw[j] = mw[j + 1];
						mw[j + 1] = t;
					}
				}
			}
			displayalldetails(mw);
		}
	}

	void searchwashingmachin(WashingmachineDetail[] mw) {
		System.out.println("-> Enter Washing Machine Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < mw.length; i++) {
			String e = mw[i].washingmachinname;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product N`umber : " + mw[i].number);
				System.out.println(" - Company : " + mw[i].companyname);
				System.out.println(" - Washing Machine Name : " + mw[i].washingmachinname);
				System.out.println(" - Size : " + mw[i].capacity + "L");
				System.out.println(" - Price : " + mw[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class MicrowaveDetail {

	int number;
	String companyname;
	String microwavename;
	int price;
	double capacity;

	MicrowaveDetail(int number, String companyname, String microwavename, int price, double capacity) {
		this.number = number;
		this.companyname = companyname;
		this.microwavename = microwavename;
		this.price = price;
		this.capacity = capacity;
	}
}

class Microwave {
	Scanner sc = new Scanner(System.in);

	void microwave(MicrowaveDetail mw[], Cart[] cr) {
		displayallname(mw);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Display All Microwave Details.");
			System.out.println(" > Press 2 For Sort By Price.");
			System.out.println(" > Press 3 For Search Microwave.");
			System.out.println(" > Press 4 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 5 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					displayallname(mw);
					break;
				}
				case 2: {
					sortprice(mw);
					break;
				}
				case 3: {
					searchmicrowave(mw);
					break;
				}
				case 4: {
					cart(mw, cr);
					break;
				}
				case 5: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
					break;
				}
			}
		}
	}

	void cart(MicrowaveDetail[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 81; j < 10 && k < 91; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].microwavename, t[j].capacity, t[j].price);
					System.out.println("   Microwave added to Cart : " + t[j].microwavename);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(MicrowaveDetail mw[]) {
		for (int i = 0; i < mw.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + mw[i].number);
			System.out.println(" - Company : " + mw[i].companyname);
			System.out.println(" - Fridge Name : " + mw[i].microwavename);
			System.out.println(" - Size : " + mw[i].capacity + "L");
			System.out.println(" - Price : " + mw[i].price);
			// System.out.println("------------------------");
		}
	}

	void displayallname(MicrowaveDetail mw[]) {
		for (int i = 0; i < mw.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + mw[i].number);
			System.out.println(" - Company : " + mw[i].companyname);
			System.out.println(" - Fridge Name : " + mw[i].microwavename);
		}
	}

	void sortprice(MicrowaveDetail mw[]) {
		System.out.println("Press 1 For Sort Microwave High price to Low price.");
		System.out.println("Press 2 For Sort Microwave Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < mw.length - 1; i++) {
				for (int j = 0; j < mw.length - 1; j++) {
					if (mw[j].price < mw[j + 1].price) {
						MicrowaveDetail t = mw[j];
						mw[j] = mw[j + 1];
						mw[j + 1] = t;
					}
				}
			}
			displayalldetails(mw);
		} else if (n == 2) {
			for (int i = 0; i < mw.length - 1; i++) {
				for (int j = 0; j < mw.length - 1; j++) {
					if (mw[j].price > mw[j + 1].price) {
						MicrowaveDetail t = mw[j];
						mw[j] = mw[j + 1];
						mw[j + 1] = t;
					}
				}
			}
			displayalldetails(mw);
		}
	}

	void searchmicrowave(MicrowaveDetail mw[]) {
		System.out.print("-> Enter Microwave Name : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < mw.length; i++) {
			String e = mw[i].microwavename;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Product Number : " + mw[i].number);
				System.out.println(" - Company : " + mw[i].companyname);
				System.out.println(" - Fridge Name : " + mw[i].microwavename);
				System.out.println(" - Size : " + mw[i].capacity + "L");
				System.out.println(" - Price : " + mw[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class Gpage {
	Scanner sc = new Scanner(System.in);
	AttaDetails aa[] = new AttaDetails[10];
	RiceDetails ri[] = new RiceDetails[10];
	DaalDetails da[] = new DaalDetails[10];
	OilDetails o[] = new OilDetails[10];
	GheeDetails g[] = new GheeDetails[10];
	MilkDetails m[] = new MilkDetails[10];
	MasalaDetails ma[] = new MasalaDetails[10];
	BeveragesDetails be[] = new BeveragesDetails[10];
	ChipsDetails ch[] = new ChipsDetails[10];

	Gpage() {
		aa[0] = new AttaDetails(91, "AASHIRVAD", "WHEAT FLOUR", 49, 1);
		aa[1] = new AttaDetails(92, "AASHIRVAD", "RICE FLOUR", 45, 1);
		aa[2] = new AttaDetails(93, "AASHIRVAD", "CORN FLOUR", 59, 1);
		aa[3] = new AttaDetails(94, "AASHIRVAD", "MILLET FLOUR", 45, 1);
		aa[4] = new AttaDetails(95, "AASHIRVAD", "SORGHUM FLOUR", 59, 1);
		aa[5] = new AttaDetails(96, "FORTUNE", "WHEAT FLOUR", 45, 1);
		aa[6] = new AttaDetails(97, "FORTUNE", "RICE FLOUR", 39, 1);
		aa[7] = new AttaDetails(98, "FORTUNE", "CORN FLOUR", 55, 1);
		aa[8] = new AttaDetails(99, "FORTUNE", "MILLET FLOUR", 39, 1);
		aa[9] = new AttaDetails(100, "FORTUNE", "SORGHUM FLOUR", 49, 1);

		ri[0] = new RiceDetails(101, "INDIA GATE", "LONG GRAIN", 99, 1);
		ri[1] = new RiceDetails(102, "INDIA GATE", "BASMATI RICE", 59, 1);
		ri[2] = new RiceDetails(103, "INDIA GATE", "BIRYANI RICE", 149, 1);
		ri[3] = new RiceDetails(104, "INDIA GATE", "SHORT GRAIN", 119, 1);
		ri[4] = new RiceDetails(105, "INDIA GATE", "MILLET RICE", 145, 1);
		ri[5] = new RiceDetails(106, "DAWAT", "LONG GRAIN", 109, 1);
		ri[6] = new RiceDetails(107, "DAWAT", "BASMATI RICE", 69, 1);
		ri[7] = new RiceDetails(108, "DAWAT", "BIRYANI RICE", 139, 1);
		ri[8] = new RiceDetails(109, "DAWAT", "SHORT GRAIN", 99, 1);
		ri[9] = new RiceDetails(110, "DAWAT", "MILLET RICE", 139, 1);

		da[0] = new DaalDetails(111, "TATA SAMPANN", "TOOR DAL", 195, 1);
		da[1] = new DaalDetails(112, "TATA SAMPANN", "MASOOR DAL", 119, 1);
		da[2] = new DaalDetails(113, "TATA SAMPANN", "CHANA DAL", 145, 1);
		da[3] = new DaalDetails(114, "TATA SAMPANN", "MOONG DAL", 169, 1);
		da[4] = new DaalDetails(115, "TATA SAMPANN", "URAD DAL", 159, 1);
		da[5] = new DaalDetails(116, "AASHIRVAD", "TOOR DAL", 199, 1);
		da[6] = new DaalDetails(117, "AASHIRVAD", "MASOOR DAL", 139, 1);
		da[7] = new DaalDetails(118, "AASHIRVAD", "CHANA DAL", 139, 1);
		da[8] = new DaalDetails(119, "AASHIRVAD", "MOONG DAL", 179, 1);
		da[9] = new DaalDetails(120, "AASHIRVAD", "URAD DAL", 165, 1);

		o[0] = new OilDetails(121, "SAFFOLA", "COCONUT OIL", 779, 2);
		o[1] = new OilDetails(122, "SAFFOLA", "SUNFLOWER OIL", 159, 1);
		o[2] = new OilDetails(123, "SAFFOLA", "OLIVE OIL", 489, 2);
		o[3] = new OilDetails(124, "SAFFOLA", "PEANUT OIL", 1999, 15);// 15KG
		o[4] = new OilDetails(125, "SAFFOLA", "VEGETABLE OIL", 159, 1);
		o[5] = new OilDetails(126, "FORTUNE", "COCONUT OIL", 819, 2);
		o[6] = new OilDetails(127, "FORTUNE", "SUNFLOWER OIL", 165, 1);
		o[7] = new OilDetails(128, "FORTUNE", "OLIVE OIL", 499, 2);
		o[8] = new OilDetails(129, "FORTUNE", "PEANUT OIL", 2099, 15);// 15KG
		o[9] = new OilDetails(130, "FORTUNE", "VEGETABLE OIL", 149, 1);

		g[0] = new GheeDetails(131, "AMUL", "COW GHEE", 549, 1);
		g[1] = new GheeDetails(132, "AMUL", "BUFFALLO GHEE", 669, 1);
		g[2] = new GheeDetails(133, "AMUL", "PURE DESI GHEE", 559, 1);
		g[3] = new GheeDetails(134, "AMUL", "GOAT GHEE", 719, 1);
		g[4] = new GheeDetails(135, "AMUL", "ORGANIC GHEE", 679, 1);
		g[5] = new GheeDetails(136, "PATANJALI", "COW GHEE", 499, 1);
		g[6] = new GheeDetails(137, "PATANJALI", "BUFFALLO GHEE", 699, 1);
		g[7] = new GheeDetails(138, "PATANJALI", "A2 GHEE", 459, 1);
		g[8] = new GheeDetails(139, "PATANJALI", "GOAT GHEE", 749, 1);
		g[9] = new GheeDetails(140, "PATANJALI", "ORGANIC GHEE", 709, 1);

		m[0] = new MilkDetails(142, "MILKY MIST", "COW MILK", 59, 1);// LITRE
		m[1] = new MilkDetails(142, "MILKY MIST", "BUFFALLO MILK", 62, 1);
		m[2] = new MilkDetails(143, "MILKY MIST", "ALMOND MILK", 229, 1);
		m[3] = new MilkDetails(144, "MILKY MIST", "COCONUT MILK", 379, 1);
		m[4] = new MilkDetails(145, "MILKY MIST", "WHOLE MILK", 179, 1);
		m[5] = new MilkDetails(146, "AMUL", "COW MILK", 59, 1);
		m[6] = new MilkDetails(147, "AMUL", "BUFFALLO MILK", 65, 1);
		m[7] = new MilkDetails(148, "AMUL", "ALMOND MILK", 225, 1);
		m[8] = new MilkDetails(149, "AMUL", "COCONUT MILK", 359, 1);
		m[9] = new MilkDetails(150, "AMUL", "WHOLE MILK", 185, 1);

		ma[0] = new MasalaDetails(151, "CATCH", "GARAM MASALA", 45, 50);// ALL IN GRAM
		ma[1] = new MasalaDetails(152, "CATCH", "CHAT MASALA", 39, 50);
		ma[2] = new MasalaDetails(153, "EVEREST", "TURMERIC POWDER", 15, 100);
		ma[3] = new MasalaDetails(154, "EVEREST", "OREGANO", 49, 50);
		ma[4] = new MasalaDetails(155, "GOLDIEE", "CHILLI FALKES", 55, 50);
		ma[5] = new MasalaDetails(156, "GOLDIEE", "BLACK PEPPER", 59, 50);
		ma[6] = new MasalaDetails(157, "MDH", "SAMBHAR MASALA", 65, 50);
		ma[7] = new MasalaDetails(158, "MDH", "TANDOORI MASALA", 85, 75);
		ma[8] = new MasalaDetails(159, "SUHANA", "MAGGIE MASALA", 95, 100);
		ma[9] = new MasalaDetails(160, "SUHANA", "BIRYANI MASALA", 69, 50);

		be[0] = new BeveragesDetails(161, "COCA-COLA", "SPRITE", 40, 750);// IN ML
		be[1] = new BeveragesDetails(162, "COCA-COLA", "COKE", 40, 750);
		be[2] = new BeveragesDetails(163, "COCA-COLA", "FANTA", 40, 750);
		be[3] = new BeveragesDetails(164, "COCA-COLA", "THUMBS-UP", 40, 750);
		be[4] = new BeveragesDetails(165, "COCA-COLA", "LIMCA", 40, 750);
		be[5] = new BeveragesDetails(166, "PEPSI CO.", "PEPSI", 20, 350);
		be[6] = new BeveragesDetails(167, "PEPSI CO.", "7 UP", 20, 350);
		be[7] = new BeveragesDetails(168, "PEPSI CO.", "MOUNTAIN DEW", 20, 350);
		be[8] = new BeveragesDetails(169, "PARLE AGRO", "FROOTI", 10, 125);
		be[9] = new BeveragesDetails(170, "PARLE AGRO", "APPY FIZZ", 10, 160);

		ch[0] = new ChipsDetails(171, "LAYS", "INDIAN MAGIC MASALA", 20, 50);/// GRAM
		ch[1] = new ChipsDetails(172, "LAYS", "AMERICAN CREAM & ONION", 40, 80);
		ch[2] = new ChipsDetails(173, "LAYS", "CLASSIC SALTED", 20, 50);
		ch[3] = new ChipsDetails(174, "KURKURE", "SOLID MASTI", 20, 61);
		ch[4] = new ChipsDetails(175, "KURKURE", "CHILLI CHATAKA", 40, 70);
		ch[5] = new ChipsDetails(176, "BALAJI", "CREAM & ONION CHIPS", 20, 80);
		ch[6] = new ChipsDetails(177, "BALAJI", "CRUNCHEX", 40, 150);
		ch[7] = new ChipsDetails(178, "BALAJI", "BANANA WAFER", 20, 50);
		ch[8] = new ChipsDetails(179, "DORITOS", "LIME & CHILLI", 30, 100);
		ch[9] = new ChipsDetails(180, "DORITOS", "MASALA MAYHEM", 55, 160);
	}

	void groceryoption(Cart[] cr) {
		Atta a = new Atta();
		Rice r = new Rice();
		Daal d = new Daal();
		Oil oo = new Oil();
		Ghee gg = new Ghee();
		Milk mm = new Milk();
		Masala maa = new Masala();
		Bevarages b = new Bevarages();
		Chips c = new Chips();
		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > Select 1 for Atta.");
			System.out.println(" > Select 2 for Rice.");
			System.out.println(" > Select 3 for Daal.");
			System.out.println(" > Select 4 for Oil.");
			System.out.println(" > Select 5 for Ghee.");
			System.out.println(" > Select 6 for Milk.");
			System.out.println(" > Select 7 for Masala.");
			System.out.println(" > Select 8 for Bevarages.");
			System.out.println(" > Select 9 for Chips.");
			System.out.println();
			System.out.println(" > Select 10 for going to Previous Page.");
			System.out.println();
			System.out.print("-> Enter Your Choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					a.atta(aa, cr);
					break;
				}
				case 2: {
					r.rice(ri, cr);
					break;
				}
				case 3: {
					d.daal(da, cr);
					break;
				}
				case 4: {
					oo.oil(o, cr);
					break;
				}
				case 5: {
					gg.ghee(g, cr);
					break;
				}
				case 6: {
					mm.milk(m, cr);
					break;
				}
				case 7: {
					maa.masala(ma, cr);
					break;
				}
				case 8: {
					b.beverages(be, cr);
					break;
				}
				case 9: {
					c.chips(ch, cr);
					break;
				}
				case 10: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}
}

class AttaDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	AttaDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Atta {
	Scanner sc = new Scanner(System.in);

	void atta(AttaDetails[] aa, Cart[] cr) {
		displayalldetails(aa);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For sort by price.");
			System.out.println(" > Press 2 For search Atta.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(aa);
					break;
				}
				case 2: {
					searchatta(aa);
					break;
				}
				case 3: {
					cart(aa, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter valid Choice !");
					break;
				}
			}
		}
	}

	void cart(AttaDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 91; j < 10 && k < 101; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Atta added to cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(AttaDetails[] aa) {
		for (int i = 0; i < aa.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + aa[i].number);
			System.out.println(" - Company : " + aa[i].companyname);
			System.out.println(" - Atta Type : " + aa[i].type);
			System.out.println(" - Weight : " + aa[i].weight);
			System.out.println(" - Price : " + aa[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(AttaDetails[] aa) {
		System.out.println("Press 1 For Sort atta High price to Low price.");
		System.out.println("Press 2 For Sort atta Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < aa.length - 1; i++) {
				for (int j = 0; j < aa.length - 1; j++) {
					if (aa[j].price < aa[j + 1].price) {
						AttaDetails t = aa[j];
						aa[j] = aa[j + 1];
						aa[j + 1] = t;
					}
				}
			}
			displayalldetails(aa);
		} else if (n == 2) {
			for (int i = 0; i < aa.length - 1; i++) {
				for (int j = 0; j < aa.length - 1; j++) {
					if (aa[j].price > aa[j + 1].price) {
						AttaDetails t = aa[j];
						aa[j] = aa[j + 1];
						aa[j + 1] = t;
					}
				}
			}
			displayalldetails(aa);
		}
	}

	void searchatta(AttaDetails[] aa) {
		System.out.print("-> Enter Atta Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < aa.length; i++) {
			String e = aa[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + aa[i].companyname);
				System.out.println(" - Atta Type : " + aa[i].type);
				System.out.println(" - Weight : " + aa[i].weight);
				System.out.println(" - Price : " + aa[i].price);
				// System.out.println("------------------------");
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class RiceDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	RiceDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Rice {
	Scanner sc = new Scanner(System.in);

	void rice(RiceDetails[] ri, Cart[] cr) {
		displayalldetails(ri);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Rice.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Previous page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(ri);
					break;
				}
				case 2: {
					searchrice(ri);
					break;
				}
				case 3: {
					cart(ri, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter Valid Number !");
					break;
				}
			}
		}
	}

	void cart(RiceDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 101; j < 10 && k < 111; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Rice added to cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(RiceDetails[] ri) {
		for (int i = 0; i < ri.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ri[i].number);
			System.out.println(" - Company : " + ri[i].companyname);
			System.out.println(" - Rice Type : " + ri[i].type);
			System.out.println(" - Weight : " + ri[i].weight);
			System.out.println(" - Price : " + ri[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(RiceDetails[] ri) {
		System.out.println("Press 1 For Sort Rice High price to Low price.");
		System.out.println("Press 2 For Sort Rice Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ri.length - 1; i++) {
				for (int j = 0; j < ri.length - 1; j++) {
					if (ri[j].price < ri[j + 1].price) {
						RiceDetails t = ri[j];
						ri[j] = ri[j + 1];
						ri[j + 1] = t;
					}
				}
			}
			displayalldetails(ri);
		} else if (n == 2) {
			for (int i = 0; i < ri.length - 1; i++) {
				for (int j = 0; j < ri.length - 1; j++) {
					if (ri[j].price > ri[j + 1].price) {
						RiceDetails t = ri[j];
						ri[j] = ri[j + 1];
						ri[j + 1] = t;
					}
				}
			}
			displayalldetails(ri);
		}
	}

	void searchrice(RiceDetails[] ri) {
		System.out.print("-> Enter Rice Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < ri.length; i++) {
			String e = ri[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + ri[i].companyname);
				System.out.println(" - Rice Type : " + ri[i].type);
				System.out.println(" - Weight : " + ri[i].weight);
				System.out.println(" - Price : " + ri[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class DaalDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	DaalDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Daal {
	Scanner sc = new Scanner(System.in);

	void daal(DaalDetails[] da, Cart[] cr) {
		displayalldetails(da);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Daal.");
			System.out.println(" > Press 3 For Add to Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(da);
					break;
				}
				case 2: {
					searchdaal(da);
					break;
				}
				case 3: {
					cart(da, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter Valid Number !");
					break;
				}
			}
		}
	}

	void cart(DaalDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 111; j < 10 && k < 121; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Daal added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(DaalDetails[] da) {
		for (int i = 0; i < da.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + da[i].number);
			System.out.println(" - Company : " + da[i].companyname);
			System.out.println(" - Daal Type : " + da[i].type);
			System.out.println(" - Weight : " + da[i].weight);
			System.out.println(" - Price : " + da[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(DaalDetails[] da) {
		System.out.println("Press 1 For Sort Daal High price to Low price.");
		System.out.println("Press 2 For Sort Daal Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < da.length - 1; i++) {
				for (int j = 0; j < da.length - 1; j++) {
					if (da[j].price < da[j + 1].price) {
						DaalDetails t = da[j];
						da[j] = da[j + 1];
						da[j + 1] = t;
					}
				}
			}
			displayalldetails(da);
		} else if (n == 2) {
			for (int i = 0; i < da.length - 1; i++) {
				for (int j = 0; j < da.length - 1; j++) {
					if (da[j].price > da[j + 1].price) {
						DaalDetails t = da[j];
						da[j] = da[j + 1];
						da[j + 1] = t;
					}
				}
			}
			displayalldetails(da);
		}
	}

	void searchdaal(DaalDetails[] da) {
		System.out.print("-> Enter Daal Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < da.length; i++) {
			String e = da[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + da[i].companyname);
				System.out.println(" - Daal Type : " + da[i].type);
				System.out.println(" - Weight : " + da[i].weight);
				System.out.println(" - Price : " + da[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class OilDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	OilDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Oil {
	Scanner sc = new Scanner(System.in);

	void oil(OilDetails[] o, Cart[] cr) {
		displayalldetails(o);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Oil.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(o);
					break;
				}
				case 2: {
					searchoil(o);
					break;
				}
				case 3: {
					cart(o, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter Valid Number ! ");
					break;
				}
			}
		}
	}

	void cart(OilDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 121; j < 10 && k < 131; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Oil added to cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(OilDetails[] o) {
		for (int i = 0; i < o.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + o[i].number);
			System.out.println(" - Company : " + o[i].companyname);
			System.out.println(" - Oil Type : " + o[i].type);
			System.out.println(" - Weight : " + o[i].weight);
			System.out.println(" - Price : " + o[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(OilDetails[] o) {
		System.out.println("Press 1 For Sort Oils High price to Low price.");
		System.out.println("Press 2 For Sort Oils Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < o.length - 1; i++) {
				for (int j = 0; j < o.length - 1; j++) {
					if (o[j].price < o[j + 1].price) {
						OilDetails t = o[j];
						o[j] = o[j + 1];
						o[j + 1] = t;
					}
				}
			}
			displayalldetails(o);
		} else if (n == 2) {
			for (int i = 0; i < o.length - 1; i++) {
				for (int j = 0; j < o.length - 1; j++) {
					if (o[j].price > o[j + 1].price) {
						OilDetails t = o[j];
						o[j] = o[j + 1];
						o[j + 1] = t;
					}
				}
			}
			displayalldetails(o);
		}
	}

	void searchoil(OilDetails[] o) {
		System.out.print("-> Enter Oil Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < o.length; i++) {
			String e = o[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + o[i].companyname);
				System.out.println(" - Oil Type : " + o[i].type);
				System.out.println(" - Weight : " + o[i].weight);
				System.out.println(" - Price : " + o[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class GheeDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	GheeDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Ghee {
	Scanner sc = new Scanner(System.in);

	void ghee(GheeDetails[] g, Cart[] cr) {
		displayalldetails(g);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Ghee.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(g);
					break;
				}
				case 2: {
					searchghee(g);
					break;
				}
				case 3: {
					cart(g, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter Valid Number ! ");
					break;
				}
			}
		}
	}

	void cart(GheeDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 131; j < 10 && k < 141; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("  Ghee Added To Cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(GheeDetails[] g) {
		for (int i = 0; i < g.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + g[i].number);
			System.out.println(" - Company : " + g[i].companyname);
			System.out.println(" - Ghee Type : " + g[i].type);
			System.out.println(" - Weight : " + g[i].weight);
			System.out.println(" - Price : " + g[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(GheeDetails[] g) {
		System.out.println();
		System.out.println("Press 1 For Sort Ghee High price to Low price.");
		System.out.println("Press 2 For Sort Ghee Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < g.length - 1; i++) {
				for (int j = 0; j < g.length - 1; j++) {
					if (g[j].price < g[j + 1].price) {
						GheeDetails t = g[j];
						g[j] = g[j + 1];
						g[j + 1] = t;
					}
				}
			}
			displayalldetails(g);
		} else if (n == 2) {
			for (int i = 0; i < g.length - 1; i++) {
				for (int j = 0; j < g.length - 1; j++) {
					if (g[j].price > g[j + 1].price) {
						GheeDetails t = g[j];
						g[j] = g[j + 1];
						g[j + 1] = t;
					}
				}
			}
			displayalldetails(g);
		}
	}

	void searchghee(GheeDetails[] g) {
		System.out.print("-> Enter Ghee Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < g.length; i++) {
			String e = g[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + g[i].companyname);
				System.out.println(" - Ghee Type : " + g[i].type);
				System.out.println(" - Weight : " + g[i].weight);
				System.out.println(" - Price : " + g[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class MilkDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	MilkDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Milk {
	Scanner sc = new Scanner(System.in);

	void milk(MilkDetails[] m, Cart[] cr) {
		displayalldetails(m);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Milk.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(m);
					break;
				}
				case 2: {
					searchmilk(m);
					break;
				}
				case 3: {
					cart(m, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter valid number !");
					break;
				}
			}
		}
	}

	void cart(MilkDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 141; j < 10 && k < 151; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("  Milk added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(MilkDetails[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + m[i].number);
			System.out.println(" - Company : " + m[i].companyname);
			System.out.println(" - Milk Type : " + m[i].type);
			System.out.println(" - Weight : " + m[i].weight);
			System.out.println(" - Price : " + m[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(MilkDetails[] m) {
		System.out.println("Press 1 For Sort Milk High price to Low price.");
		System.out.println("Press 2 For Sort Milk Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < m.length - 1; i++) {
				for (int j = 0; j < m.length - 1; j++) {
					if (m[j].price < m[j + 1].price) {
						MilkDetails t = m[j];
						m[j] = m[j + 1];
						m[j + 1] = t;
					}
				}
			}
			displayalldetails(m);
		} else if (n == 2) {
			for (int i = 0; i < m.length - 1; i++) {
				for (int j = 0; j < m.length - 1; j++) {
					if (m[j].price > m[j + 1].price) {
						MilkDetails t = m[j];
						m[j] = m[j + 1];
						m[j + 1] = t;
					}
				}
			}
			displayalldetails(m);
		}
	}

	void searchmilk(MilkDetails[] m) {
		System.out.print("-> Enter Milk Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < m.length; i++) {
			String e = m[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + m[i].companyname);
				System.out.println(" - Milk Type : " + m[i].type);
				System.out.println(" - Weight : " + m[i].weight);
				System.out.println(" - Price : " + m[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class MasalaDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	MasalaDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Masala {
	Scanner sc = new Scanner(System.in);

	void masala(MasalaDetails[] ma, Cart[] cr) {
		displayalldetails(ma);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Masala.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(ma);
					break;
				}
				case 2: {
					searchmasala(ma);
					break;
				}
				case 3: {
					cart(ma, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter Valid Number !");
					break;
				}
			}
		}
	}

	void cart(MasalaDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 151; j < 10 && k < 161; j++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Masala added to cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(MasalaDetails[] ma) {
		for (int i = 0; i < ma.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ma[i].number);
			System.out.println(" - Company : " + ma[i].companyname);
			System.out.println(" - Masala Type : " + ma[i].type);
			System.out.println(" - Weight : " + ma[i].weight);
			System.out.println(" - Price : " + ma[i].price);
			/// System.out.println("------------------------");
		}
	}

	void sortprice(MasalaDetails[] ma) {
		System.out.println();
		System.out.println("Press 1 For Sort Masala High price to Low price.");
		System.out.println("Press 2 For Sort Masala Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ma.length - 1; i++) {
				for (int j = 0; j < ma.length - 1; j++) {
					if (ma[j].price < ma[j + 1].price) {
						MasalaDetails t = ma[j];
						ma[j] = ma[j + 1];
						ma[j + 1] = t;
					}
				}
			}
			displayalldetails(ma);
		} else if (n == 2) {
			for (int i = 0; i < ma.length - 1; i++) {
				for (int j = 0; j < ma.length - 1; j++) {
					if (ma[j].price > ma[j + 1].price) {
						MasalaDetails t = ma[j];
						ma[j] = ma[j + 1];
						ma[j + 1] = t;
					}
				}
			}
			displayalldetails(ma);
		}
	}

	void searchmasala(MasalaDetails[] ma) {
		System.out.print("-> Enter Masala Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < ma.length; i++) {
			String e = ma[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + ma[i].companyname);
				System.out.println(" - Masala Type : " + ma[i].type);
				System.out.println(" - Weight : " + ma[i].weight);
				System.out.println(" - Price : " + ma[i].price);
				/// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class BeveragesDetails {
	int number;
	String companyname;
	String type;
	double price;
	double weight;

	BeveragesDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
}

class Bevarages {
	Scanner sc = new Scanner(System.in);

	void beverages(BeveragesDetails[] be, Cart[] cr) {
		displayalldetails(be);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Search Bevarages.");
			System.out.println(" > Press 3 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 4 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(be);
					break;
				}
				case 2: {
					searchbev(be);
					break;
				}
				case 3: {
					cart(be, cr);
					break;
				}
				case 4: {
					return;
				}
				default: {
					System.out.println("Enter Valid Number !");
					break;
				}
			}
		}
	}

	void cart(BeveragesDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 161; j < 10 && k < 171; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Bevarages added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(BeveragesDetails[] be) {
		for (int i = 0; i < be.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + be[i].number);
			System.out.println(" - Company : " + be[i].companyname);
			System.out.println(" - Beverages Type : " + be[i].type);
			System.out.println(" - Weight : " + be[i].weight);
			System.out.println(" - rice : " + be[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(BeveragesDetails[] be) {
		System.out.println("Press 1 For Sort Bevarages High price to Low price.");
		System.out.println("Press 2 For Sort Bevarages Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < be.length - 1; i++) {
				for (int j = 0; j < be.length - 1; j++) {
					if (be[j].price < be[j + 1].price) {
						BeveragesDetails t = be[j];
						be[j] = be[j + 1];
						be[j + 1] = t;
					}
				}
			}
			displayalldetails(be);
		} else if (n == 2) {
			for (int i = 0; i < be.length - 1; i++) {
				for (int j = 0; j < be.length - 1; j++) {
					if (be[j].price > be[j + 1].price) {
						BeveragesDetails t = be[j];
						be[j] = be[j + 1];
						be[j + 1] = t;
					}
				}
			}
			displayalldetails(be);
		}
	}

	void searchbev(BeveragesDetails[] be) {
		System.out.print("-> Enter Bevarage Type : ");
		sc.nextLine();
		String ename = sc.nextLine();
		int c = 0;
		for (int i = 0; i < be.length; i++) {
			String e = be[i].type;
			if (ename.equalsIgnoreCase(e)) {
				System.out.println();
				System.out.println(" - Company : " + be[i].companyname);
				System.out.println(" - Beverages Type : " + be[i].type);
				System.out.println(" - Weight : " + be[i].weight);
				System.out.println(" - rice : " + be[i].price);
				// System.out.println("------------------------");
				c++;
			}
		}
		if (c == 0) {
			System.out.println("Record Not Found !!");
		}
	}
}

class ChipsDetails {
	int number;
	String type;
	String companyname;
	double price;
	double weight;

	ChipsDetails(int number, String companyname, String type, double price, double weight) {
		this.number = number;
		this.type = type;
		this.companyname = companyname;
		this.price = price;
		this.weight = weight;
	}
}

class Chips {
	Scanner sc = new Scanner(System.in);

	void chips(ChipsDetails[] ch, Cart[] cr) {
		displayalldetails(ch);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort By Price.");
			System.out.println(" > Press 2 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(ch);
					break;
				}
				case 2: {
					cart(ch, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter valid number !");
					break;
				}
			}
		}
	}

	void cart(ChipsDetails[] t, Cart[] cr) {
		System.out.print("-> Enter The Number Of Products You Wanted To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 171; j < 10 && k < 181; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].type, t[j].weight, t[j].price);
					System.out.println("   Chips Added To Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ChipsDetails[] ch) {
		for (int i = 0; i < ch.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ch[i].number);
			System.out.println(" - Company : " + ch[i].companyname);
			System.out.println(" - Weight : " + ch[i].weight);
			System.out.println(" - Chips Type : " + ch[i].type);
			System.out.println(" - Price : " + ch[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ChipsDetails[] ch) {
		System.out.println();
		System.out.println("Press 1 For Sort Chips High price to Low price.");
		System.out.println("Press 2 For Sort Chips Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ch.length - 1; i++) {
				for (int j = 0; j < ch.length - 1; j++) {
					if (ch[j].price < ch[j + 1].price) {
						ChipsDetails t = ch[j];
						ch[j] = ch[j + 1];
						ch[j + 1] = t;
					}
				}
			}
			displayalldetails(ch);
		} else if (n == 2) {
			for (int i = 0; i < ch.length - 1; i++) {
				for (int j = 0; j < ch.length - 1; j++) {
					if (ch[j].price > ch[j + 1].price) {
						ChipsDetails t = ch[j];
						ch[j] = ch[j + 1];
						ch[j + 1] = t;
					}
				}
			}
			displayalldetails(ch);
		}
	}
}

class Wpage {
	Scanner sc = new Scanner(System.in);
	TshirtDetails t[] = new TshirtDetails[10];
	ShirtDetails shi[] = new ShirtDetails[10];
	JeansDetails je[] = new JeansDetails[10];
	ShortsDetails s[] = new ShortsDetails[10];
	ShoesDetails so[] = new ShoesDetails[10];
	Tshirt ts = new Tshirt();
	Shirt si = new Shirt();
	Jeans ja = new Jeans();
	Shorts sh = new Shorts();
	Shoes sho = new Shoes();

	Wpage() {
		t[0] = new TshirtDetails(350, "URBAN MONKEY", "SHORT SLEEVE", 799, "S,M,L,XL");
		t[1] = new TshirtDetails(351, "URBAN MONKEY", "REGULAR FIT", 849, "S,M,L,XL");
		t[2] = new TshirtDetails(352, "URBAN MONKEY", "OVERSIZED FIT", 999, "S,M,L,XL");
		t[3] = new TshirtDetails(353, "THE SHOULED STORE", "OVERSIZED FIT", 899, "S,M,L,XL");
		t[4] = new TshirtDetails(354, "THE SHOULED STORE", "SWEAT SHIRT", 1299, "S,M,L,XL");
		t[5] = new TshirtDetails(355, "THE SHOULED STORE", "BACK PRINTED TSHIRT", 1199, "S,M,L,XL");
		t[6] = new TshirtDetails(356, "MONTE CARLO", "FULL SLEEVED TSHIRT", 1499, "S,M,L,XL");
		t[7] = new TshirtDetails(357, "MONTE CARLO", "TURTLE NECK", 1249, "S,M,L,XL");
		t[8] = new TshirtDetails(358, "KWABEY", "SLIM FIT", 449, "S,M,L,XL");
		t[9] = new TshirtDetails(359, "KWABEY", "REGULAR FIT", 499, "S,M,L,XL");

		shi[0] = new ShirtDetails(360, "SNITCH", "CASUAL SHIRT", 899, "S,M,L,XL");
		shi[1] = new ShirtDetails(361, "SNITCH", "FULL SLEEVED CHECKS SHIRT", 949, "S,M,L,XL");
		shi[2] = new ShirtDetails(362, "SNITCH", "FLORAL SHIRT", 899, "S,M,L,XL");
		shi[3] = new ShirtDetails(363, "MONTE CARLO", "PLAIN SINGLE COLOURED", 1249, "S,M,L,XL");
		shi[4] = new ShirtDetails(364, "MONTE CARLO", "FORMAL SHIRT", 1499, "S,M,L,XL");
		shi[5] = new ShirtDetails(365, "JACK & JONES", "OVERSIZED FIT", 1399, "S,M,L,XL");
		shi[6] = new ShirtDetails(366, "JACK & JONES", "CASUAL OVERSIZED", 1549, "S,M,L,XL");
		shi[7] = new ShirtDetails(367, "JACK & JONES", "BACKPRINTED STREET STYLE", 1599, "S,M,L,XL");
		shi[8] = new ShirtDetails(368, "US POLO", "SIMPLE PRINTED", 1149, "S,M,L,XL");
		shi[9] = new ShirtDetails(369, "US POLO", "SOLID COTTON SHIRT", 1399, "S,M,L,XL");

		je[0] = new JeansDetails(370, "BEWAKOOF", "REGULAR FIT", 799, "28,30,32,34,36,38");
		je[1] = new JeansDetails(371, "BEWAKOOF", "BOOT CUT", 1199, "28,30,32,34,36,38");
		je[2] = new JeansDetails(372, "BEWAKOOF", "MONK FIT", 1349, "28,30,32,34,36,38");
		je[3] = new JeansDetails(373, "SNITCH", "OVERSIZED", 999, "28,30,32,34,36,38");
		je[4] = new JeansDetails(374, "SNITCH", "BAGGY JEANS", 1399, "28,30,32,34,36,38");
		je[5] = new JeansDetails(375, "SNITCH", "RELAXED FIT", 849, "28,30,32,34,36,38");
		je[6] = new JeansDetails(376, "LEVI'S", "FORMALS", 1599, "28,30,32,34,36,38");
		je[7] = new JeansDetails(377, "LEVI'S", "REGULAR FIT", 1849, "28,30,32,34,36,38");
		je[8] = new JeansDetails(378, "KILLER X", "BAGGY JEANS", 1649, "28,30,32,34,36,38");
		je[9] = new JeansDetails(379, "KILLER X", "MONK FIT", 1799, "28,30,32,34,36,38");

		s[0] = new ShortsDetails(380, "NIKE", "NORMAL SHORTS", 949, "30,32,34,36");
		s[1] = new ShortsDetails(381, "NIKE", "WITH INNER SHORTS", 1299, "30,32,34,36");
		s[2] = new ShortsDetails(382, "NIKE", "DEINM SHORTS", 849, "30,32,34,36");
		s[3] = new ShortsDetails(383, "PUMA", "SPORTS SHORTS", 1349, "30,32,34,36");
		s[4] = new ShortsDetails(384, "PUMA", "WITH INNER SHORTS", 1499, "30,32,34,36");
		s[5] = new ShortsDetails(385, "PUMA", "CYCLING SHORTS", 1149, "30,32,34,36");
		s[6] = new ShortsDetails(386, "ADIDAS", "SPORTS SHORTS", 1599, "30,32,34,36");
		s[7] = new ShortsDetails(387, "ADIDAS", "DOUBLE POCKET SHORTS", 1199, "30,32,34,36");
		s[8] = new ShortsDetails(388, "UNDER ARMOUR", "WITH INNER SHORTS", 1499, "30,32,34,36");
		s[9] = new ShortsDetails(389, "UNDER ARMOUR", "SPORTS SHORTS", 1349, "30,32,34,36");

		so[0] = new ShoesDetails(390, "NIKE", "AIR JORDAN 1", 16499, "UK7,UK8,UK9,UK10");
		so[1] = new ShoesDetails(391, "NIKE", "AIR FORCE 1", 7999, "UK7,UK8,UK9,UK10");
		so[2] = new ShoesDetails(392, "PUMA", "FUTURE RIDER (SPORTS) ", 35999, "UK7,UK8,UK9,UK10");
		so[3] = new ShoesDetails(393, "PUMA", "SMACIC UNISEX", 31999, "UK7,UK8,UK9,UK10");
		so[4] = new ShoesDetails(394, "ADIDAS", "SAMBA OG", 11999, "UK7,UK8,UK9,UK10");
		so[5] = new ShoesDetails(395, "ADIDAS", "SUPERSTAR", 7199, "UK7,UK8,UK9,UK10");
		so[6] = new ShoesDetails(396, "CONVERSE", "CHUCK HIGH TOP", 7499, "UK7,UK8,UK9,UK10");
		so[7] = new ShoesDetails(397, "CONVERSE", "CHUCK TAILOR", 6499, "UK7,UK8,UK9,UK10");
		so[8] = new ShoesDetails(398, "SKECHERS", "GO RUN (SPORTS) ", 3899, "UK7,UK8,UK9,UK10");
		so[9] = new ShoesDetails(399, "SKECHERS", "UNO STANDS", 4399, "UK7,UK8,UK9,UK10");
	}

	void woption(Cart[] cr) {
		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > Select 1 for Tshirts.");
			System.out.println(" > Select 2 for Shirts.");
			System.out.println(" > Select 3 for Jeans.");
			System.out.println(" > Select 4 for Shorts.");
			System.out.println(" > Select 5 for Shoes.");
			System.out.println(" > Select 6 for Previous Page.");
			System.out.println();
			System.out.print("-> Enter Your Choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					ts.tshirt(t, cr);
					break;
				}
				case 2: {
					si.shirt(shi, cr);
					break;
				}
				case 3: {
					ja.jeans(je, cr);
					break;
				}
				case 4: {
					sh.shorts(s, cr);
					break;
				}
				case 5: {
					sho.shoes(so, cr);
					break;
				}
				case 6: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}
}

class TshirtDetails {
	int number;
	String companyname;
	String type;
	double price;
	String size;

	TshirtDetails(int number, String companyname, String type, double price, String size) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.size = size;
	}
}

class Tshirt {
	Scanner sc = new Scanner(System.in);

	void tshirt(TshirtDetails[] t, Cart[] cr) {
		displayalldetails(t);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort T-shirt By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(t);
					break;
				}
				case 2: {
					cart(t, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(TshirtDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 350; j < 10 && k < 360; j++, k++) {
				if (n == t[j].number) {
					cr[j] = new Cart(t[j].number, t[j].companyname, t[j].size, t[j].type, t[j].price);
					System.out.println("   T-shirt added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c == nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(TshirtDetails[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + t[i].number);
			System.out.println(" - Company : " + t[i].companyname);
			System.out.println(" - Tshirt Type : " + t[i].type);
			System.out.println(" - Tshirt Size : " + t[i].size);
			System.out.println(" - Price : " + t[i].price);
			/// System.out.println("------------------------");
		}
	}

	void sortprice(TshirtDetails[] t) {
		System.out.println();
		System.out.println("Press 1 For Sort T-shirt High price to Low price.");
		System.out.println("Press 2 For Sort T-shirt Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < t.length - 1; i++) {
				for (int j = 0; j < t.length - 1; j++) {
					if (t[j].price < t[j + 1].price) {
						TshirtDetails p = t[j];
						t[j] = t[j + 1];
						t[j + 1] = p;
					}
				}
			}
			displayalldetails(t);
		} else if (n == 2) {
			for (int i = 0; i < t.length - 1; i++) {
				for (int j = 0; j < t.length - 1; j++) {
					if (t[j].price > t[j + 1].price) {
						TshirtDetails p = t[j];
						t[j] = t[j + 1];
						t[j + 1] = p;
					}
				}
			}
			displayalldetails(t);
		}
	}
}

class ShirtDetails {
	int number;
	String companyname;
	String type;
	double price;
	String size;

	ShirtDetails(int number, String companyname, String type, double price, String size) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.size = size;
	}
}

class Shirt {
	Scanner sc = new Scanner(System.in);

	void shirt(ShirtDetails[] sh, Cart[] cr) {
		displayalldetails(sh);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Shirt By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(sh);
					break;
				}
				case 2: {
					cart(sh, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(ShirtDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 360; j < 10 && k < 370; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].size, t[j].type, t[j].price);
					System.out.println("   Shirts added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c == nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ShirtDetails[] sh) {
		for (int i = 0; i < sh.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + sh[i].number);
			System.out.println(" - Company : " + sh[i].companyname);
			System.out.println(" - Tshirt Type : " + sh[i].type);
			System.out.println(" - Tshirt Size : " + sh[i].size);
			System.out.println(" - Price : " + sh[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ShirtDetails[] sh) {
		System.out.println();
		System.out.println("Press 1 For Sort Shirts High price to Low price.");
		System.out.println("Press 2 For Sort Shirts Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < sh.length - 1; i++) {
				for (int j = 0; j < sh.length - 1; j++) {
					if (sh[j].price < sh[j + 1].price) {
						ShirtDetails t = sh[j];
						sh[j] = sh[j + 1];
						sh[j + 1] = t;
					}
				}
			}
			displayalldetails(sh);
		} else if (n == 2) {
			for (int i = 0; i < sh.length - 1; i++) {
				for (int j = 0; j < sh.length - 1; j++) {
					if (sh[j].price > sh[j + 1].price) {
						ShirtDetails t = sh[j];
						sh[j] = sh[j + 1];
						sh[j + 1] = t;
					}
				}
			}
			displayalldetails(sh);
		}
	}
}

class JeansDetails {
	int number;
	String companyname;
	String type;
	double price;
	String size;

	JeansDetails(int number, String companyname, String type, double price, String size) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.size = size;
	}
}

class Jeans {
	Scanner sc = new Scanner(System.in);

	void jeans(JeansDetails[] je, Cart[] cr) {
		displayalldetails(je);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Shirt By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(je);
					break;
				}
				case 2: {
					cart(je, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}

	void cart(JeansDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 370; j < 10 && k < 380; j++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].size, t[j].type, t[j].price);
					System.out.println("   Jeans added to cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c == nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(JeansDetails[] je) {
		for (int i = 0; i < je.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + je[i].number);
			System.out.println(" - Company : " + je[i].companyname);
			System.out.println(" - Jeans Type : " + je[i].type);
			System.out.println(" - Jeans Size : " + je[i].size);
			System.out.println(" - Price : " + je[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(JeansDetails[] je) {
		System.out.println("Press 1 For Sort Jeans High price to Low price.");
		System.out.println("Press 2 For Sort Jeans Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < je.length - 1; i++) {
				for (int j = 0; j < je.length - 1; j++) {
					if (je[j].price < je[j + 1].price) {
						JeansDetails t = je[j];
						je[j] = je[j + 1];
						je[j + 1] = t;
					}
				}
			}
			displayalldetails(je);
		} else if (n == 2) {
			for (int i = 0; i < je.length - 1; i++) {
				for (int j = 0; j < je.length - 1; j++) {
					if (je[j].price > je[j + 1].price) {
						JeansDetails t = je[j];
						je[j] = je[j + 1];
						je[j + 1] = t;
					}
				}
			}
			displayalldetails(je);
		}
	}
}

class ShortsDetails {
	int number;
	String companyname;
	String type;
	double price;
	String size;

	ShortsDetails(int number, String companyname, String type, double price, String size) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.size = size;
	}
}

class Shorts {
	Scanner sc = new Scanner(System.in);

	void shorts(ShortsDetails[] sh, Cart[] cr) {
		displayalldetails(sh);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Shirt By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(sh);
					break;
				}
				case 2: {
					cart(sh, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}

	void cart(ShortsDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 380; j < 10 && k < 390; j++, k++) {
				if (n == t[j].number) {
					cr[j] = new Cart(t[j].number, t[j].companyname, t[j].size, t[j].type, t[j].price);
					System.out.println("   Shorts added to cart: " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ShortsDetails[] sh) {
		for (int i = 0; i < sh.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + sh[i].number);
			System.out.println(" - Company : " + sh[i].companyname);
			System.out.println(" - Short Type : " + sh[i].type);
			System.out.println(" - Short Size : " + sh[i].size);
			System.out.println(" - Price : " + sh[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ShortsDetails[] sh) {
		System.out.println("Press 1 For Sort Shorts High price to Low price.");
		System.out.println("Press 2 For Sort Shorts Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < sh.length - 1; i++) {
				for (int j = 0; j < sh.length - 1; j++) {
					if (sh[j].price < sh[j + 1].price) {
						ShortsDetails t = sh[j];
						sh[j] = sh[j + 1];
						sh[j + 1] = t;
					}
				}
			}
			displayalldetails(sh);
		} else if (n == 2) {
			for (int i = 0; i < sh.length - 1; i++) {
				for (int j = 0; j < sh.length - 1; j++) {
					if (sh[j].price > sh[j + 1].price) {
						ShortsDetails t = sh[j];
						sh[j] = sh[j + 1];
						sh[j + 1] = t;
					}
				}
			}
			displayalldetails(sh);
		}
	}
}

class ShoesDetails {
	int number;
	String companyname;
	String type;
	double price;
	String size;

	ShoesDetails(int number, String companyname, String type, double price, String size) {
		this.number = number;
		this.companyname = companyname;
		this.type = type;
		this.price = price;
		this.size = size;
	}
}

class Shoes {
	Scanner sc = new Scanner(System.in);

	void shoes(ShoesDetails[] so, Cart[] cr) {
		displayalldetails(so);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Shirt By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(so);
					break;
				}
				case 2: {
					cart(so, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}

	void cart(ShoesDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 390; j < 10 && k < 400; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].companyname, t[j].size, t[j].type, t[j].price);
					System.out.println("   Shoes added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ShoesDetails[] so) {
		for (int i = 0; i < so.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + so[i].number);
			System.out.println(" - Company : " + so[i].companyname);
			System.out.println(" - Short Type : " + so[i].type);
			System.out.println(" - Short Size : " + so[i].size);
			System.out.println(" - Price : " + so[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ShoesDetails[] so) {
		System.out.println("Press 1 For Sort Shoes High price to Low price.");
		System.out.println("Press 2 For Sort Shoes Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < so.length - 1; i++) {
				for (int j = 0; j < so.length - 1; j++) {
					if (so[j].price < so[j + 1].price) {
						ShoesDetails t = so[j];
						so[j] = so[j + 1];
						so[j + 1] = t;
					}
				}
			}
			displayalldetails(so);
		} else if (n == 2) {
			for (int i = 0; i < so.length - 1; i++) {
				for (int j = 0; j < so.length - 1; j++) {
					if (so[j].price > so[j + 1].price) {
						ShoesDetails t = so[j];
						so[j] = so[j + 1];
						so[j + 1] = t;
					}
				}
			}
			displayalldetails(so);
		}
	}
}

class Cpage {
	Scanner sc = new Scanner(System.in);
	PlateDetails pl[] = new PlateDetails[10];
	SpoonDetails sp[] = new SpoonDetails[10];
	GlassDetails gl[] = new GlassDetails[7];
	KnifeDetails kn[] = new KnifeDetails[5];
	BottleDetails bo[] = new BottleDetails[7];
	JarDetails ja[] = new JarDetails[5];
	BowlDetails bw[] = new BowlDetails[5];

	Cpage() {
		pl[0] = new PlateDetails(181, "1 nos", 200);
		pl[1] = new PlateDetails(182, "2 nos", 369);
		pl[2] = new PlateDetails(183, "3 nos", 549);
		pl[3] = new PlateDetails(184, "4 nos", 749);
		pl[4] = new PlateDetails(185, "5 nos", 999);
		pl[5] = new PlateDetails(186, "6 nos", 1189);
		pl[6] = new PlateDetails(187, "7 nos", 1299);
		pl[7] = new PlateDetails(188, "8 nos", 1589);
		pl[8] = new PlateDetails(189, "9 nos", 1799);
		pl[9] = new PlateDetails(190, "10 nos", 1899);

		sp[0] = new SpoonDetails(191, "2 nos", 110);
		sp[1] = new SpoonDetails(192, "3 nos", 149);
		sp[2] = new SpoonDetails(193, "4 nos", 299);
		sp[3] = new SpoonDetails(194, "6 nos", 409);
		sp[4] = new SpoonDetails(195, "8 nos", 459);
		sp[5] = new SpoonDetails(196, "10 nos", 500);
		sp[6] = new SpoonDetails(197, "12 nos", 589);
		sp[7] = new SpoonDetails(198, "16 nos", 699);
		sp[8] = new SpoonDetails(199, "18 nos", 799);
		sp[9] = new SpoonDetails(200, "22 nos", 899);

		gl[0] = new GlassDetails(201, "2 nos", 99);
		gl[1] = new GlassDetails(202, "3 nos", 149);
		gl[2] = new GlassDetails(203, "5 nos", 199);
		gl[3] = new GlassDetails(204, "6 nos", 299);
		gl[4] = new GlassDetails(205, "8 nos", 359);
		gl[5] = new GlassDetails(206, "10 nos", 510);
		gl[6] = new GlassDetails(207, "14 nos", 649);

		kn[0] = new KnifeDetails(208, "1 nos", 99);
		kn[1] = new KnifeDetails(209, "1 nos", 299);
		kn[2] = new KnifeDetails(210, "2 nos", 159);
		kn[3] = new KnifeDetails(211, "4 nos", 359);
		kn[4] = new KnifeDetails(212, "6 nos", 599);

		bo[0] = new BottleDetails(213, "1 nos", 149);
		bo[1] = new BottleDetails(214, "2 nos", 199);
		bo[2] = new BottleDetails(215, "3 nos", 259);
		bo[3] = new BottleDetails(216, "4 nos", 299);
		bo[4] = new BottleDetails(217, "6 nos", 349);
		bo[5] = new BottleDetails(218, "10 nos", 399);
		bo[6] = new BottleDetails(220, "12 nos", 449);

		ja[0] = new JarDetails(221, "1 nos", 210);
		ja[1] = new JarDetails(222, "2 nos", 449);
		ja[2] = new JarDetails(223, "3 nos", 599);
		ja[3] = new JarDetails(224, "4 nos", 666);
		ja[4] = new JarDetails(225, "5 nos", 799);

		bw[0] = new BowlDetails(226, "1 nos", 199);
		bw[1] = new BowlDetails(227, "2 nos", 298);
		bw[2] = new BowlDetails(228, "3 nos", 389);
		bw[3] = new BowlDetails(229, "4 nos", 459);
		bw[4] = new BowlDetails(230, "6 nos", 599);

	}

	void coption(Cart[] cr) {
		Plate p = new Plate();
		Spoon s = new Spoon();
		Glass g = new Glass();
		Knife k = new Knife();
		Bottle b = new Bottle();
		Jar j = new Jar();
		Bowl bl = new Bowl();
		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > Select 1 for  Plate.");
			System.out.println(" > Select 2 for Spoon.");
			System.out.println(" > Select 3 for Glass.");
			System.out.println(" > Select 4 for Knife.");
			System.out.println(" > Select 5 for Bottle.");
			System.out.println(" > Select 6 for Jar.");
			System.out.println(" > Select 7 for Bowl.");
			System.out.println();
			System.out.println(" > Select 8 for Previous Page.");
			System.out.println();
			System.out.print("-> Enter Your Choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					p.plate(pl, cr);
					break;
				}
				case 2: {
					s.spoon(sp, cr);
					break;
				}
				case 3: {
					g.glass(gl, cr);
					break;
				}
				case 4: {
					k.knife(kn, cr);
					break;
				}
				case 5: {
					b.bottle(bo, cr);
					break;
				}
				case 6: {
					j.jar(ja, cr);
					break;
				}
				case 7: {
					bl.bowl(bw, cr);
					break;
				}
				case 8: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}
}

class PlateDetails {
	int number;
	String Quantity;
	double price;

	PlateDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Plate {
	Scanner sc = new Scanner(System.in);

	void plate(PlateDetails[] pl, Cart[] cr) {
		displayalldetails(pl);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Plates By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(pl);
					break;
				}
				case 2: {
					cart(pl, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}

	void cart(PlateDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 181; j < 10 && k < 191; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("   Plates added to Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(PlateDetails[] pl) {
		for (int i = 0; i < pl.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + pl[i].number);
			System.out.println(" - Plate Quantity : " + pl[i].Quantity);
			System.out.println(" - Price : " + pl[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(PlateDetails[] pl) {
		System.out.println("Press 1 For Sort Plates High price to Low price.");
		System.out.println("Press 2 For Sort Plates Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < pl.length - 1; i++) {
				for (int j = 0; j < pl.length - 1; j++) {
					if (pl[j].price < pl[j + 1].price) {
						PlateDetails t = pl[j];
						pl[j] = pl[j + 1];
						pl[j + 1] = t;
					}
				}
			}
			displayalldetails(pl);
		} else if (n == 2) {
			for (int i = 0; i < pl.length - 1; i++) {
				for (int j = 0; j < pl.length - 1; j++) {
					if (pl[j].price > pl[j + 1].price) {
						PlateDetails t = pl[j];
						pl[j] = pl[j + 1];
						pl[j + 1] = t;
					}
				}
			}
			displayalldetails(pl);
		}
	}
}

class SpoonDetails {
	int number;
	String Quantity;
	double price;

	SpoonDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Spoon {
	Scanner sc = new Scanner(System.in);

	void spoon(SpoonDetails[] sp, Cart[] cr) {
		displayalldetails(sp);
		while (true) {
			System.out.println(" > Press 1 For Sort Spoons By Price.");
			System.out.println(" > Press 2 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(sp);
					break;
				}
				case 2: {
					cart(sp, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(SpoonDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase :");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 191; j < 10 && k < 201; j++, k++) {
				if (n == t[j].number) {
					cr[j] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("   Spoons added to Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(SpoonDetails[] sp) {
		for (int i = 0; i < sp.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + sp[i].number);
			System.out.println(" - Spoon Quantity : " + sp[i].Quantity);
			System.out.println(" - Price : " + sp[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(SpoonDetails[] sp) {
		System.out.println("Press 1 For Sort Spoons High price to Low price.");
		System.out.println("Press 2 For Sort Spoons Low price to High price");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < sp.length - 1; i++) {
				for (int j = 0; j < sp.length - 1; j++) {
					if (sp[j].price < sp[j + 1].price) {
						SpoonDetails t = sp[j];
						sp[j] = sp[j + 1];
						sp[j + 1] = t;
					}
				}
			}
			displayalldetails(sp);
		} else if (n == 2) {
			for (int i = 0; i < sp.length - 1; i++) {
				for (int j = 0; j < sp.length - 1; j++) {
					if (sp[j].price > sp[j + 1].price) {
						SpoonDetails t = sp[j];
						sp[j] = sp[j + 1];
						sp[j + 1] = t;
					}
				}
			}
			displayalldetails(sp);
		}
	}
}

class GlassDetails {
	int number;
	String Quantity;
	double price;

	GlassDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Glass {
	Scanner sc = new Scanner(System.in);

	void glass(GlassDetails[] gl, Cart[] cr) {
		displayalldetails(gl);
		while (true) {
			System.out.println(" > Press 1 For Sort Glass By Price.");
			System.out.println(" > Press 2 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(gl);
					break;
				}
				case 2: {
					cart(gl, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(GlassDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 201; j < 10 && k < 207; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("   Glass added to Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(GlassDetails[] gl) {
		for (int i = 0; i < gl.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + gl[i].number);
			System.out.println(" - Glass Quantity : " + gl[i].Quantity);
			System.out.println(" - Price : " + gl[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(GlassDetails[] gl) {
		System.out.println("Press 1 For Sort Glass High price to Low price.");
		System.out.println("Press 2 For Sort Glass Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < gl.length - 1; i++) {
				for (int j = 0; j < gl.length - 1; j++) {
					if (gl[j].price < gl[j + 1].price) {
						GlassDetails t = gl[j];
						gl[j] = gl[j + 1];
						gl[j + 1] = t;
					}
				}
			}
			displayalldetails(gl);
		} else if (n == 2) {
			for (int i = 0; i < gl.length - 1; i++) {
				for (int j = 0; j < gl.length - 1; j++) {
					if (gl[j].price > gl[j + 1].price) {
						GlassDetails t = gl[j];
						gl[j] = gl[j + 1];
						gl[j + 1] = t;
					}
				}
			}
			displayalldetails(gl);
		}
	}
}

class KnifeDetails {
	int number;
	String Quantity;
	double price;

	KnifeDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Knife {
	Scanner sc = new Scanner(System.in);

	void knife(KnifeDetails[] kn, Cart[] cr) {
		displayalldetails(kn);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Knives By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(kn);
					break;
				}
				case 2: {
					cart(kn, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice !");
				}
			}
		}
	}

	void cart(KnifeDetails[] t, Cart[] cr) {
		System.out.print("->Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 208; j < 10 && k < 213; j++, k++) {
				if (n == t[j].number) {
					cr[j] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("   Knives Added To Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(KnifeDetails[] kn) {
		for (int i = 0; i < kn.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + kn[i].number);
			System.out.println(" - Knife Quantity : " + kn[i].Quantity);
			System.out.println(" - Price : " + kn[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(KnifeDetails[] kn) {
		System.out.println();
		System.out.println("Press 1 For Sort Knives High price to Low price.");
		System.out.println("Press 2 For Sort Knives Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < kn.length - 1; i++) {
				for (int j = 0; j < kn.length - 1; j++) {
					if (kn[j].price < kn[j + 1].price) {
						KnifeDetails t = kn[j];
						kn[j] = kn[j + 1];
						kn[j + 1] = t;
					}
				}
			}
			displayalldetails(kn);
		} else if (n == 2) {
			for (int i = 0; i < kn.length - 1; i++) {
				for (int j = 0; j < kn.length - 1; j++) {
					if (kn[j].price > kn[j + 1].price) {
						KnifeDetails t = kn[j];
						kn[j] = kn[j + 1];
						kn[j + 1] = t;
					}
				}
			}
			displayalldetails(kn);
		}
	}
}

class BottleDetails {
	int number;
	String Quantity;
	double price;

	BottleDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Bottle {
	Scanner sc = new Scanner(System.in);

	void bottle(BottleDetails[] bo, Cart[] cr) {
		displayalldetails(bo);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Bottles By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(bo);
					break;
				}
				case 2: {
					cart(bo, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(BottleDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 213; j < 10 && k < 212; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("   Bottle added to Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(BottleDetails[] bo) {
		for (int i = 0; i < bo.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + bo[i].number);
			System.out.println(" - Bottle Quantity : " + bo[i].Quantity);
			System.out.println(" - Price : " + bo[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(BottleDetails[] bo) {
		System.out.println("Press 1 For Sort Bottles High price to Low price.");
		System.out.println("Press 2 For Sort Bottles Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < bo.length - 1; i++) {
				for (int j = 0; j < bo.length - 1; j++) {
					if (bo[j].price < bo[j + 1].price) {
						BottleDetails t = bo[j];
						bo[j] = bo[j + 1];
						bo[j + 1] = t;
					}
				}
			}
			displayalldetails(bo);
		} else if (n == 2) {
			for (int i = 0; i < bo.length - 1; i++) {
				for (int j = 0; j < bo.length - 1; j++) {
					if (bo[j].price > bo[j + 1].price) {
						BottleDetails t = bo[j];
						bo[j] = bo[j + 1];
						bo[j + 1] = t;
					}
				}
			}
			displayalldetails(bo);
		}
	}
}

class JarDetails {
	int number;
	String Quantity;
	double price;

	JarDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Jar {
	Scanner sc = new Scanner(System.in);

	void jar(JarDetails[] ja, Cart[] cr) {
		displayalldetails(ja);
		while (true) {
			System.out.println(" > Press 1 For Sort Jar By Price.");
			System.out.println(" > Press 2 For Add To Cart.");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page.");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(ja);
					break;
				}
				case 2: {
					cart(ja, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(JarDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase :");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 221; j < 10 && k < 226; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("   Jar added to Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(JarDetails[] ja) {
		for (int i = 0; i < ja.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ja[i].number);
			System.out.println(" - Jar Quantity : " + ja[i].Quantity);
			System.out.println(" - Price : " + ja[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(JarDetails[] ja) {
		System.out.println("Press 1 For Sort Jar High price to Low price.");
		System.out.println("Press 2 For Sort Jar Low price to High price");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ja.length - 1; i++) {
				for (int j = 0; j < ja.length - 1; j++) {
					if (ja[j].price < ja[j + 1].price) {
						JarDetails t = ja[j];
						ja[j] = ja[j + 1];
						ja[j + 1] = t;
					}
				}
			}
			displayalldetails(ja);
		} else if (n == 2) {
			for (int i = 0; i < ja.length - 1; i++) {
				for (int j = 0; j < ja.length - 1; j++) {
					if (ja[j].price > ja[j + 1].price) {
						JarDetails t = ja[j];
						ja[j] = ja[j + 1];
						ja[j + 1] = t;
					}
				}
			}
			displayalldetails(ja);
		}
	}
}

class BowlDetails {
	int number;
	String Quantity;
	double price;

	BowlDetails(int number, String Quantity, double price) {
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}
}

class Bowl {
	Scanner sc = new Scanner(System.in);

	void bowl(BowlDetails[] bw, Cart[] cr) {
		displayalldetails(bw);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Bowls By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(bw);
					break;
				}
				case 2: {
					cart(bw, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice ! ");
				}
			}
		}
	}

	void cart(BowlDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase :");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 226; j < 10 && k < 231; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].Quantity, t[j].price, "X");
					System.out.println("Bowl added to Cart : " + t[j].Quantity);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(BowlDetails[] bw) {
		for (int i = 0; i < bw.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + bw[i].number);
			System.out.println(" - Bowl Quantity : " + bw[i].Quantity);
			System.out.println(" -- Price : " + bw[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(BowlDetails[] bw) {
		System.out.println("Press 1 For Sort Bowls High price to Low price.");
		System.out.println("Press 2 For Sort Bowls Low price to High price");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < bw.length - 1; i++) {
				for (int j = 0; j < bw.length - 1; j++) {
					if (bw[j].price < bw[j + 1].price) {
						BowlDetails t = bw[j];
						bw[j] = bw[j + 1];
						bw[j + 1] = t;
					}
				}
			}
			displayalldetails(bw);
		} else if (n == 2) {
			for (int i = 0; i < bw.length - 1; i++) {
				for (int j = 0; j < bw.length - 1; j++) {
					if (bw[j].price > bw[j + 1].price) {
						BowlDetails t = bw[j];
						bw[j] = bw[j + 1];
						bw[j + 1] = t;
					}
				}
			}
			displayalldetails(bw);
		}
	}
}

class Fpage {
	Scanner sc = new Scanner(System.in);
	SofaDetails so[] = new SofaDetails[9];
	BedDetails be[] = new BedDetails[10];
	ChairDetails ch[] = new ChairDetails[10];
	TableDetails ta[] = new TableDetails[10];
	WardrobeDetails wa[] = new WardrobeDetails[10];
	ShelfDetails sh[] = new ShelfDetails[10];

	Fpage() {
		so[0] = new SofaDetails(231, "2 seater", 7499);
		so[1] = new SofaDetails(232, "3 seater", 8999);
		so[2] = new SofaDetails(233, "4 seater", 9999);
		so[3] = new SofaDetails(234, "5 seater", 14599);
		so[4] = new SofaDetails(235, "6 seater", 23999);
		so[5] = new SofaDetails(236, "7 seater", 29249);
		so[6] = new SofaDetails(237, "8 seater", 34899);
		so[7] = new SofaDetails(238, "9 seater", 38999);
		so[8] = new SofaDetails(239, "10 seater", 51099);

		be[0] = new BedDetails(240, "Product Dimensions  =  2.04L x 1.88W x 0.8H Meters", 12749);
		be[1] = new BedDetails(241, "Product Dimensions  =  2.06L x 1.6W x 0.89H Meters", 14979);
		be[2] = new BedDetails(242, "Product Dimensions  =  2.1L x 1.57W x 0.8H Meters", 11698);
		be[3] = new BedDetails(243, "Product Dimensions  =  2.07L x 0.45W x 0.13H Meters", 11990);
		be[4] = new BedDetails(244, "Product Dimensions  =  2.21L x 1.58W x 0.89H Meters", 14898);
		be[5] = new BedDetails(245, "Product Dimensions  =  2.19L x 1.9W x 1H Meters", 42000);
		be[6] = new BedDetails(246, "Product Dimensions  =  2.13L x 1.91W x 1.19H Meters", 29999);
		be[7] = new BedDetails(247, "Product Dimensions  =  2.23L x 1.59W x 1.05H Meters", 23999);
		be[8] = new BedDetails(248, "Product Dimensions  =  2.24L x 1.58W x 0.8H Meters", 29499);
		be[9] = new BedDetails(249, "Product Dimensions  =  2.08L x 1.93W x 0.99H Meters", 32899);

		ta[0] = new TableDetails(250, "Product Dimensions  =  20D x 5W x 12H Centimeters", 1799);
		ta[1] = new TableDetails(251, "Product Dimensions  =  45D x 90W x 76H Centimeters", 4199);
		ta[2] = new TableDetails(252, "Product Dimensions  =  59.9D x 119.4W x 76.2H Centimeters", 8699);
		ta[3] = new TableDetails(253, "Product Dimensions  =  40D x 114.3W x 120H Centimeters", 6499);
		ta[4] = new TableDetails(254, "Product Dimensions  =  123D x 54.5W x 19H Centimeters", 10499);
		ta[5] = new TableDetails(255, "Product Dimensions  =  60D x 60W x 75.5H Centimeters", 11999);
		ta[6] = new TableDetails(256, "Product Dimensions  =  45D x 125W x 119H Centimeters", 7990);
		ta[7] = new TableDetails(257, "Product Dimensions  =  123D x 54.5W x 19H Centimeters", 10499);
		ta[8] = new TableDetails(258, "Product Dimensions  =  114.3D x 54W x 77H Centimeters", 8899);
		ta[9] = new TableDetails(259, "Product Dimensions  =  60D x 119.8W x 114.5H Centimeters", 9199);

		sh[0] = new ShelfDetails(260, "Number of Shelves  =  5  \nProduct Dimensions  =  78 x 70 x 24 cm", 3562);
		sh[1] = new ShelfDetails(261, "Number of Shelves  =  6  \nProduct Dimensions  =  180 x 33 x 24 cm", 2680);
		sh[2] = new ShelfDetails(262, "Number of Shelves  =  3 \nProduct Dimensions  =  90 x 33 x 24 cm", 1789);
		sh[3] = new ShelfDetails(263, "Number of Shelves  =  6  \nProduct Dimensions  =  136 x 24 x 71 cm", 3965);
		sh[4] = new ShelfDetails(264, "Number of Shelves  =  6  \nProduct Dimensions  =  180 x 33 x 24 cm", 2680);
		sh[5] = new ShelfDetails(265, "Number of Shelves  =  7  \nProduct Dimensions  =  70 x 23 x 93 cm", 3750);
		sh[6] = new ShelfDetails(266, "Number of Shelves  =  8  \nProduct Dimensions  =  164 x 24 x 70 cm", 3637);
		sh[7] = new ShelfDetails(267, "Number of Shelves  =  4  \nProduct Dimensions  =  91.5 x 30 x 60 cm", 3780);
		sh[8] = new ShelfDetails(268, "Number of Shelves  =  4  \nProduct Dimensions  =  112 x 58.5 x 23.5 cm", 2279);
		sh[9] = new ShelfDetails(269, "Number of Shelves  =  6  \nProduct Dimensions  =  160 x 31 x 26 cm", 1995);

		ch[0] = new ChairDetails(270, "Ikea Chair : \nProduct Dimensions  =  76D x 50W x 8H Centimeters", 1380);
		ch[1] = new ChairDetails(271, "Nilkamal Chair : \nProduct Dimensions  =  40D x 35W x 25H Centimeters", 1410);
		ch[2] = new ChairDetails(272, "Nilkamal Office Chair : \nProduct Dimensions  =  70D x 70W x 104H Centimeters",
				4490);
		ch[3] = new ChairDetails(273,
				"Cello Comfort Chair : \nProduct Dimensions  =  83.8D x 55.9W x 88.9H Centimeters", 1299);
		ch[4] = new ChairDetails(274, "Varmora Chair : \nProduct Dimensions  =  62D X 57W X 87H Centimeters", 700);
		ch[5] = new ChairDetails(275,
				"Varmora Designer Chair : \nProduct Dimensions  =  56D x 57.5W x 84.5H Centimeters", 1999);
		ch[6] = new ChairDetails(276, "Nilkamal Chair : \nProduct Dimensions  =  54D x 67.5W x 88H Centimeters", 1780);
		ch[7] = new ChairDetails(277,
				"Nilkamal Signature Chair : \nProduct Dimensions  =  55.5D x 54.8W x 80.1H Centimeters", 3680);
		ch[8] = new ChairDetails(278, "IKEA Folding Chair : \nProduct Dimensions  =  47D x 45W x 76H Centimeters",
				1650);
		ch[9] = new ChairDetails(279, "Ikea Dining Chair : \nProduct Dimensions  =  87.6D x 69.9W x 55.9H Centimeters",
				5999);

		wa[0] = new WardrobeDetails(280, "Product Dimensions  =  47.6D x 60W x 182H Centimeters", 8299);
		wa[1] = new WardrobeDetails(281, "Product Dimensions  =  46D x 80W x 182H Centimeters", 11999);
		wa[2] = new WardrobeDetails(282, "Product Dimensions  =  42D x 43W x 183H Centimeters", 8674);
		wa[3] = new WardrobeDetails(283, "Product Dimensions  =  50.8D x 119W x 190H Centimeters", 15529);
		wa[4] = new WardrobeDetails(284, "Product Dimensions  =  490D x 210W x 200H Centimeters", 25899);
		wa[5] = new WardrobeDetails(285, "Product Dimensions  =  45D x 75W x 180.5H Centimeters", 7790);
		wa[6] = new WardrobeDetails(286, "Product Dimensions  =  45D x 112.5W x 183.5H Centimeters", 12990);
		wa[7] = new WardrobeDetails(287, "Product Dimensions  =  45D x 80W x 120H Centimeters", 9999);
		wa[8] = new WardrobeDetails(288, "Product Dimensions  =  45.7D x 104.1W x 180.3H Centimeters", 14899);
		wa[9] = new WardrobeDetails(289, "Product Dimensions  =  50.8D x 119W x 190H Centimeters", 15529);
	}

	void foption(Cart[] cr) {
		Sofa sf = new Sofa();
		Bed bd = new Bed();
		Chair ca = new Chair();
		Table tb = new Table();
		Wardrobe wr = new Wardrobe();
		Shelf se = new Shelf();
		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > Select 1 for Sofa.");
			System.out.println(" > Select 2 for Bed.");
			System.out.println(" > Select 3 for Chair.");
			System.out.println(" > Select 4 for Table.");
			System.out.println(" > Select 5 for Wardrobe.");
			System.out.println(" > Select 6 for Shelf.");
			System.out.println();
			System.out.println(" > Select 7 for Previous Page.");
			System.out.println();
			System.out.print("-> Enter Your Choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sf.sofa(so, cr);
					break;
				}
				case 2: {
					bd.bed(be, cr);
					break;
				}
				case 3: {
					ca.chair(ch, cr);
					break;
				}
				case 4: {
					tb.table(ta, cr);
					break;
				}
				case 5: {
					wr.wardrobe(wa, cr);
					break;
				}
				case 6: {
					se.shelf(sh, cr);
					break;
				}
				case 7: {
					return;
				}
				default: {
					System.out.println("Enter Valid Choice");
				}
			}
		}
	}
}

class SofaDetails {
	int number;
	String type;
	int price;

	SofaDetails(int number, String type, int price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Sofa {
	Scanner sc = new Scanner(System.in);

	void sofa(SofaDetails[] so, Cart[] cr) {
		displayalldetails(so);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Sofa By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(so);
					break;
				}
				case 2: {
					cart(so, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(SofaDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.println("sitani");
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 231; j < 10 && k < 240; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price);
					System.out.println("   Sofa added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(SofaDetails[] so) {
		for (int i = 0; i < so.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + so[i].number);
			System.out.println(" - Type : " + so[i].type);
			System.out.println(" - Price : " + so[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(SofaDetails[] so) {
		System.out.println("Press 1 For Sort Sofa High price to Low price.");
		System.out.println("Press 2 For Sort Sofa Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < so.length - 1; i++) {
				for (int j = 0; j < so.length - 1; j++) {
					if (so[j].price < so[j + 1].price) {
						SofaDetails t = so[j];
						so[j] = so[j + 1];
						so[j + 1] = t;
					}
				}
			}
			displayalldetails(so);
		} else if (n == 2) {
			for (int i = 0; i < so.length - 1; i++) {
				for (int j = 0; j < so.length - 1; j++) {
					if (so[j].price > so[j + 1].price) {
						SofaDetails t = so[j];
						so[j] = so[j + 1];
						so[j + 1] = t;
					}
				}
			}
			displayalldetails(so);
		}
	}
}

class BedDetails {
	int number;
	String type;
	double price;

	BedDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Bed {
	Scanner sc = new Scanner(System.in);

	void bed(BedDetails[] be, Cart[] cr) {
		displayalldetails(be);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Beds By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(be);
					break;
				}
				case 2: {
					cart(be, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(BedDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 240; j < 10 && k < 250; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price);
					System.out.println("   Bed added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(BedDetails[] be) {
		for (int i = 0; i < be.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + be[i].number);
			System.out.println(" - " + be[i].type);
			System.out.println("Price:-" + be[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(BedDetails[] be) {
		System.out.println("Press 1 For Sort Bed High price to Low price.");
		System.out.println("Press 2 For Sort Bed Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < be.length - 1; i++) {
				for (int j = 0; j < be.length - 1; j++) {
					if (be[j].price < be[j + 1].price) {
						BedDetails t = be[j];
						be[j] = be[j + 1];
						be[j + 1] = t;
					}
				}
			}
			displayalldetails(be);
		} else if (n == 2) {
			for (int i = 0; i < be.length - 1; i++) {
				for (int j = 0; j < be.length - 1; j++) {
					if (be[j].price > be[j + 1].price) {
						BedDetails t = be[j];
						be[j] = be[j + 1];
						be[j + 1] = t;
					}
				}
			}
			displayalldetails(be);
		}
	}
}

class ChairDetails {
	int number;
	String type;
	double price;

	ChairDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Chair {
	Scanner sc = new Scanner(System.in);

	void chair(ChairDetails[] ch, Cart[] cr) {
		displayalldetails(ch);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Chair By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(ch);
					break;
				}
				case 2: {
					cart(ch, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(ChairDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 270; j < 10 && k < 289; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price);
					System.out.println("   Chair added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ChairDetails[] ch) {
		for (int i = 0; i < ch.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ch[i].number);
			System.out.println(" - " + ch[i].type);
			System.out.println(" - Price : " + ch[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ChairDetails[] ch) {
		System.out.println("Press 1 For Sort Chair High price to Low price.");
		System.out.println("Press 2 For Sort Chair Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ch.length - 1; i++) {
				for (int j = 0; j < ch.length - 1; j++) {
					if (ch[j].price < ch[j + 1].price) {
						ChairDetails t = ch[j];
						ch[j] = ch[j + 1];
						ch[j + 1] = t;
					}
				}
			}
			displayalldetails(ch);
		} else if (n == 2) {
			for (int i = 0; i < ch.length - 1; i++) {
				for (int j = 0; j < ch.length - 1; j++) {
					if (ch[j].price > ch[j + 1].price) {
						ChairDetails t = ch[j];
						ch[j] = ch[j + 1];
						ch[j + 1] = t;
					}
				}
			}
			displayalldetails(ch);
		}
	}
}

class TableDetails {
	int number;
	String type;
	double price;

	TableDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Table {
	Scanner sc = new Scanner(System.in);

	void table(TableDetails[] ta, Cart[] cr) {
		displayalldetails(ta);
		while (true) {

			System.out.println();
			System.out.println(" > Press 1 For Sort Table By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(ta);
					break;
				}
				case 2: {
					cart(ta, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(TableDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 250; j < 10 && k < 260; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price);
					System.out.println("   Table added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(TableDetails[] ta) {
		for (int i = 0; i < ta.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + ta[i].number);
			System.out.println(" - " + ta[i].type);
			System.out.println("Price:-" + ta[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(TableDetails[] ta) {
		System.out.println("Press 1 For Sort Table High price to Low price.");
		System.out.println("Press 2 For Sort Table Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < ta.length - 1; i++) {
				for (int j = 0; j < ta.length - 1; j++) {
					if (ta[j].price < ta[j + 1].price) {
						TableDetails t = ta[j];
						ta[j] = ta[j + 1];
						ta[j + 1] = t;
					}
				}
			}
			displayalldetails(ta);
		} else if (n == 2) {
			for (int i = 0; i < ta.length - 1; i++) {
				for (int j = 0; j < ta.length - 1; j++) {
					if (ta[j].price > ta[j + 1].price) {
						TableDetails t = ta[j];
						ta[j] = ta[j + 1];
						ta[j + 1] = t;
					}
				}
			}
			displayalldetails(ta);
		}
	}
}

class WardrobeDetails {
	int number;
	String type;
	double price;

	WardrobeDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Wardrobe {
	Scanner sc = new Scanner(System.in);

	void wardrobe(WardrobeDetails[] wa, Cart[] cr) {
		displayalldetails(wa);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Wardrobe By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(wa);
					break;
				}
				case 2: {
					cart(wa, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(WardrobeDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 280; j < 10 && k < 290; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price);
					System.out.println("   Wardrobe added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(WardrobeDetails[] wa) {
		for (int i = 0; i < wa.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + wa[i].number);
			System.out.println(" - " + wa[i].type);
			System.out.println(" - Price : " + wa[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(WardrobeDetails[] wa) {
		System.out.println("Press 1 For Sort Wardrobe High price to Low price.");
		System.out.println("Press 2 For Sort Wardrobe Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < wa.length - 1; i++) {
				for (int j = 0; j < wa.length - 1; j++) {
					if (wa[j].price < wa[j + 1].price) {
						WardrobeDetails t = wa[j];
						wa[j] = wa[j + 1];
						wa[j + 1] = t;
					}
				}
			}
			displayalldetails(wa);
		} else if (n == 2) {
			for (int i = 0; i < wa.length - 1; i++) {
				for (int j = 0; j < wa.length - 1; j++) {
					if (wa[j].price > wa[j + 1].price) {
						WardrobeDetails t = wa[j];
						wa[j] = wa[j + 1];
						wa[j + 1] = t;
					}
				}
			}
			displayalldetails(wa);
		}
	}
}

class ShelfDetails {
	int number;
	String type;
	double price;

	ShelfDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Shelf {
	Scanner sc = new Scanner(System.in);

	void shelf(ShelfDetails[] sh, Cart[] cr) {
		displayalldetails(sh);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Shelf By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(sh);
					break;
				}
				case 2: {
					cart(sh, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(ShelfDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 260; j < 10 && k < 270; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price);
					System.out.println("   Shelf added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ShelfDetails[] sh) {
		for (int i = 0; i < sh.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + sh[i].number);
			System.out.println(" - " + sh[i].type);
			System.out.println(" - Price : " + sh[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ShelfDetails[] sh) {
		System.out.println("Press 1 For Sort Shelf High price to Low price.");
		System.out.println("Press 2 For Sort Shelf Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < sh.length - 1; i++) {
				for (int j = 0; j < sh.length - 1; j++) {
					if (sh[j].price < sh[j + 1].price) {
						ShelfDetails t = sh[j];
						sh[j] = sh[j + 1];
						sh[j + 1] = t;
					}
				}
			}
			displayalldetails(sh);
		} else if (n == 2) {
			for (int i = 0; i < sh.length - 1; i++) {
				for (int j = 0; j < sh.length - 1; j++) {
					if (sh[j].price > sh[j + 1].price) {
						ShelfDetails t = sh[j];
						sh[j] = sh[j + 1];
						sh[j + 1] = t;
					}
				}
			}
			displayalldetails(sh);
		}
	}
}

class Cospage {
	Scanner sc = new Scanner(System.in);
	ShampooDetails shmp[] = new ShampooDetails[10];
	ConditionerDetails co[] = new ConditionerDetails[10];
	FaceWashDetails fw[] = new FaceWashDetails[10];
	FaceScrubDetails fs[] = new FaceScrubDetails[10];
	BodyWashDetails bw[] = new BodyWashDetails[10];
	MoisturiserDetails mo[] = new MoisturiserDetails[10];

	Cospage() {

		shmp[0] = new ShampooDetails(290, "Mamaearth - 1L", 779);
		shmp[1] = new ShampooDetails(291, "TRESemme Keratin Smooth Shampoo - 1L", 738);
		shmp[2] = new ShampooDetails(292, "TRESemme Keratin Smooth Shampoo - 200ml", 220);
		shmp[3] = new ShampooDetails(293, "Head & Shoulders - 1L", 512);
		shmp[4] = new ShampooDetails(294, "L'Oréal - 1L", 990);
		shmp[5] = new ShampooDetails(295, "Dove Hair Fall Rescue Shampoo - 1L", 949);
		shmp[6] = new ShampooDetails(296, "Herbal Essences - 1L", 822);
		shmp[7] = new ShampooDetails(297, "Herbal Essences  - 400ml", 389);
		shmp[8] = new ShampooDetails(298, "Meera Hairfall Care Shampoo - 340ml", 265);
		shmp[9] = new ShampooDetails(299, "Meera Hairfall Care Shampoo - 650ml", 517);

		co[0] = new ConditionerDetails(300, "L'Oréal - 386ml", 287);
		co[1] = new ConditionerDetails(301, "Dove - 400ml", 420);
		co[2] = new ConditionerDetails(302, "TRESemme - 200ml", 250);
		co[3] = new ConditionerDetails(303, "Mamaearth - 1L", 899);
		co[4] = new ConditionerDetails(304, "Dove - 1L", 999);
		co[5] = new ConditionerDetails(305, "Mamaearth - 250ml", 360);
		co[6] = new ConditionerDetails(306, "L'Oréal - 650ml", 549);
		co[7] = new ConditionerDetails(307, "TRESemme - 1L", 949);
		co[8] = new ConditionerDetails(308, "Mamaearth - 650", 599);
		co[9] = new ConditionerDetails(309, "TRESemme - 450", 399);

		fw[0] = new FaceWashDetails(310, "Cetaphil - 236ml", 400);
		fw[1] = new FaceWashDetails(311, "POND's - 200ml", 221);
		fw[2] = new FaceWashDetails(312, "Himalaya - 150ml", 165);
		fw[3] = new FaceWashDetails(313, "Garnier - 150ml", 199);
		fw[4] = new FaceWashDetails(314, "Nivea - 150", 118);
		fw[5] = new FaceWashDetails(315, "Minimalist - 150", 284);
		fw[6] = new FaceWashDetails(316, "Mamaearth - 200ml", 245);
		fw[7] = new FaceWashDetails(317, "Cetaphil - 650ml", 989);
		fw[8] = new FaceWashDetails(318, "Garnier - 200ml", 249);
		fw[9] = new FaceWashDetails(319, "POND's - 100ml", 200);

		fs[0] = new FaceScrubDetails(320, "Himalaya - 100gm", 150);
		fs[1] = new FaceScrubDetails(321, "Everyuth - 200gm", 230);
		fs[2] = new FaceScrubDetails(322, "Lotus - 100gm", 230);
		fs[3] = new FaceScrubDetails(323, "Biotique - 100gm", 126);
		fs[4] = new FaceScrubDetails(324, "Plum - 100gm", 348);
		fs[5] = new FaceScrubDetails(325, "Nivea - 100gm", 300);
		fs[6] = new FaceScrubDetails(326, "Mamaearth - 100gm", 306);
		fs[7] = new FaceScrubDetails(327, "Joy - 100gm", 195);
		fs[8] = new FaceScrubDetails(328, "POND's - 250", 239);
		fs[9] = new FaceScrubDetails(329, "M caffeine - 100gm", 509);

		bw[0] = new BodyWashDetails(330, "Dove - 150ml", 349);
		bw[1] = new BodyWashDetails(331, "Pears - 200ml", 342);
		bw[2] = new BodyWashDetails(332, "Vivel - 250ml", 84);
		bw[3] = new BodyWashDetails(333, "Lux - 100ml", 79);
		bw[4] = new BodyWashDetails(334, "Nivea - 250ml", 225);
		bw[5] = new BodyWashDetails(335, "Dettol - 200ml", 229);
		bw[6] = new BodyWashDetails(336, "Santoor - 750ml", 275);
		bw[7] = new BodyWashDetails(337, "Liril - 250ml", 146);
		bw[8] = new BodyWashDetails(338, "Yardley London - 250ml", 149);
		bw[9] = new BodyWashDetails(339, "M caffein - 250", 249);

		mo[0] = new MoisturiserDetails(340, "Nivea - 600ml", 419);
		mo[1] = new MoisturiserDetails(341, "Mamaearth - 80ml", 286);
		mo[2] = new MoisturiserDetails(342, "POND's - 100ml", 200);
		mo[3] = new MoisturiserDetails(343, "Minimalist - 50ml", 331);
		mo[4] = new MoisturiserDetails(344, "Joy - 750ml", 299);
		mo[5] = new MoisturiserDetails(345, "Nivea - 400ml", 319);
		mo[6] = new MoisturiserDetails(346, "Vaseline - 600ml", 438);
		mo[7] = new MoisturiserDetails(347, "Plum - 50ml", 451);
		mo[8] = new MoisturiserDetails(348, "Dot & Key - 60ml", 425);
		mo[9] = new MoisturiserDetails(349, "Boroplus - 400ml", 145);
	}

	void cooption(Cart[] cr) {
		Shampoo sh = new Shampoo();
		Conditioner cn = new Conditioner();
		Facewash fa = new Facewash();
		Facescrube fc = new Facescrube();
		Bodywash bd = new Bodywash();
		Moisturiser mi = new Moisturiser();
		while (true) {
			System.out.println();
			System.out.println("===>> CHOSE THE CARTEGORY OF PRODUCTS FROM BELOW YOU WANTED TO SEE / PURCHASE...");
			System.out.println();
			System.out.println(" > Select 1 for Shampoo.");
			System.out.println(" > Select 2 for Conditioner.");
			System.out.println(" > Select 3 for Face Wash.");
			System.out.println(" > Select 4 for Face Scrub.");
			System.out.println(" > Select 5 for Body Wash.");
			System.out.println(" > Select 6 for Moisturiser.");
			System.out.println();
			System.out.println(" > Select 7 for Previous Page.");
			System.out.println();
			System.out.print("-> Enter Your Choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sh.shampoo(shmp, cr);
					break;
				}
				case 2: {
					cn.conditioner(co, cr);
					break;
				}
				case 3: {
					fa.facewash(fw, cr);
					break;
				}
				case 4: {
					fc.facesrube(fs, cr);
					break;
				}
				case 5: {
					bd.bodywash(bw, cr);
					break;
				}
				case 6: {
					mi.moisturiser(mo, cr);
					break;
				}
				case 7: {
					return;
				}
				default: {
					System.out.println("Enter valid Choice ! ");
					break;
				}
			}
		}
	}
}

class ShampooDetails {
	int number;
	String type;
	double price;

	ShampooDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Shampoo {
	Scanner sc = new Scanner(System.in);

	void shampoo(ShampooDetails[] shmp, Cart[] cr) {
		displayalldetails(shmp);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Shampoos By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(shmp);
					break;
				}
				case 2: {
					cart(shmp, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(ShampooDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 290; j < 10 && k < 300; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price, "x");
					System.out.println("   Shampoo added to Cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ShampooDetails[] shmp) {
		for (int i = 0; i < shmp.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + shmp[i].number);
			System.out.println(" - " + shmp[i].type);
			System.out.println(" - Price : " + shmp[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ShampooDetails[] shmp) {
		System.out.println();
		System.out.println("Press 1 For Sort Shampoo High price to Low price.");
		System.out.println("Press 2 For Sort Shampoo Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < shmp.length - 1; i++) {
				for (int j = 0; j < shmp.length - 1; j++) {
					if (shmp[j].price < shmp[j + 1].price) {
						ShampooDetails t = shmp[j];
						shmp[j] = shmp[j + 1];
						shmp[j + 1] = t;
					}
				}
			}
			displayalldetails(shmp);
		} else if (n == 2) {
			for (int i = 0; i < shmp.length - 1; i++) {
				for (int j = 0; j < shmp.length - 1; j++) {
					if (shmp[j].price > shmp[j + 1].price) {
						ShampooDetails t = shmp[j];
						shmp[j] = shmp[j + 1];
						shmp[j + 1] = t;
					}
				}
			}
			displayalldetails(shmp);
		}
	}
}

class ConditionerDetails {
	int number;
	String type;
	double price;

	ConditionerDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Conditioner {
	Scanner sc = new Scanner(System.in);

	void conditioner(ConditionerDetails[] co, Cart[] cr) {
		displayalldetails(co);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Conditioner By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(co);
					break;
				}
				case 2: {
					cart(co, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(ConditionerDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 300; j < 10 && k < 310; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price, "x");
					System.out.println("   Conditioner added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(ConditionerDetails[] co) {
		for (int i = 0; i < co.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + co[i].number);
			System.out.println(" - " + co[i].type);
			System.out.println(" - Price : " + co[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(ConditionerDetails[] co) {
		System.out.println();
		System.out.println("Press 1 For Sort Conditioner High price to Low price.");
		System.out.println("Press 2 For Sort Conditioner price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < co.length - 1; i++) {
				for (int j = 0; j < co.length - 1; j++) {
					if (co[j].price < co[j + 1].price) {
						ConditionerDetails t = co[j];
						co[j] = co[j + 1];
						co[j + 1] = t;
					}
				}
			}
			displayalldetails(co);
		} else if (n == 2) {
			for (int i = 0; i < co.length - 1; i++) {
				for (int j = 0; j < co.length - 1; j++) {
					if (co[j].price > co[j + 1].price) {
						ConditionerDetails t = co[j];
						co[j] = co[j + 1];
						co[j + 1] = t;
					}
				}
			}
			displayalldetails(co);
		}
	}
}

class FaceWashDetails {
	int number;
	String type;
	double price;

	FaceWashDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Facewash {
	Scanner sc = new Scanner(System.in);

	void facewash(FaceWashDetails[] fw, Cart[] cr) {
		displayalldetails(fw);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Face Wash By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(fw);
					break;
				}
				case 2: {
					cart(fw, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(FaceWashDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 310; j < 10 && k < 320; j++, k++) {
				if (n == t[j].number) {
					cr[j] = new Cart(t[j].number, t[j].type, t[j].price, "x");
					System.out.println("   Face Wash added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(FaceWashDetails[] fw) {
		for (int i = 0; i < fw.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + fw[i].number);
			System.out.println(" - " + fw[i].type);
			System.out.println(" - Price : " + fw[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(FaceWashDetails[] fw) {
		System.out.println();
		System.out.println("Press 1 For Sort Face Wash High price to Low price.");
		System.out.println("Press 2 For Sort Face Wash Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < fw.length - 1; i++) {
				for (int j = 0; j < fw.length - 1; j++) {
					if (fw[j].price < fw[j + 1].price) {
						FaceWashDetails t = fw[j];
						fw[j] = fw[j + 1];
						fw[j + 1] = t;
					}
				}
			}
			displayalldetails(fw);
		} else if (n == 2) {
			for (int i = 0; i < fw.length - 1; i++) {
				for (int j = 0; j < fw.length - 1; j++) {
					if (fw[j].price > fw[j + 1].price) {
						FaceWashDetails t = fw[j];
						fw[j] = fw[j + 1];
						fw[j + 1] = t;
					}
				}
			}
			displayalldetails(fw);
		}
	}
}

class FaceScrubDetails {
	int number;
	String type;
	double price;

	FaceScrubDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Facescrube {
	Scanner sc = new Scanner(System.in);

	void facesrube(FaceScrubDetails[] fs, Cart[] cr) {
		displayalldetails(fs);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Face Scrub By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(fs);
					break;
				}
				case 2: {
					cart(fs, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(FaceScrubDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 320; j < 10 && k < 330; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price, "x");
					System.out.println("   Facescrube added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		}
	}

	void displayalldetails(FaceScrubDetails[] fs) {
		for (int i = 0; i < fs.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + fs[i].number);
			System.out.println(" - " + fs[i].type);
			System.out.println(" - Price : " + fs[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(FaceScrubDetails[] fs) {
		System.out.println();
		System.out.println("Press 1 For Sort Face Scrub High price to Low price.");
		System.out.println("Press 2 For Sort Face Scrub Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < fs.length - 1; i++) {
				for (int j = 0; j < fs.length - 1; j++) {
					if (fs[j].price < fs[j + 1].price) {
						FaceScrubDetails t = fs[j];
						fs[j] = fs[j + 1];
						fs[j + 1] = t;
					}
				}
			}
			displayalldetails(fs);
		} else if (n == 2) {
			for (int i = 0; i < fs.length - 1; i++) {
				for (int j = 0; j < fs.length - 1; j++) {
					if (fs[j].price > fs[j + 1].price) {
						FaceScrubDetails t = fs[j];
						fs[j] = fs[j + 1];
						fs[j + 1] = t;
					}
				}
			}
			displayalldetails(fs);
		}
	}
}

class BodyWashDetails {
	int number;
	String type;
	double price;

	BodyWashDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Bodywash {
	Scanner sc = new Scanner(System.in);

	void bodywash(BodyWashDetails[] bw, Cart[] cr) {
		displayalldetails(bw);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Body Wash By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(bw);
					break;
				}
				case 2: {
					cart(bw, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(BodyWashDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 330; j < 10 && k < 340; j++, k++) {
				if (n == t[j].number) {
					cr[k] = new Cart(t[j].number, t[j].type, t[j].price, "x");
					System.out.println("   Body Wash added To cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(BodyWashDetails[] bw) {
		for (int i = 0; i < bw.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + bw[i].number);
			System.out.println(" - " + bw[i].type);
			System.out.println(" - Price : " + bw[i].price);
			// System.out.println("------------------------");
		}
	}

	void sortprice(BodyWashDetails[] bw) {
		System.out.println();
		System.out.println("Press 1 For Sort Body Wash High price to Low price.");
		System.out.println("Press 2 For Sort Body Wash Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < bw.length - 1; i++) {
				for (int j = 0; j < bw.length - 1; j++) {
					if (bw[j].price < bw[j + 1].price) {
						BodyWashDetails t = bw[j];
						bw[j] = bw[j + 1];
						bw[j + 1] = t;
					}
				}
			}
			displayalldetails(bw);
		} else if (n == 2) {
			for (int i = 0; i < bw.length - 1; i++) {
				for (int j = 0; j < bw.length - 1; j++) {
					if (bw[j].price > bw[j + 1].price) {
						BodyWashDetails t = bw[j];
						bw[j] = bw[j + 1];
						bw[j + 1] = t;
					}
				}
			}
			displayalldetails(bw);
		}
	}
}

class MoisturiserDetails {
	int number;
	String type;
	double price;

	MoisturiserDetails(int number, String type, double price) {
		this.number = number;
		this.type = type;
		this.price = price;
	}
}

class Moisturiser {
	Scanner sc = new Scanner(System.in);

	void moisturiser(MoisturiserDetails[] mo, Cart[] cr) {
		displayalldetails(mo);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Sort Moisturiser By Price.");
			System.out.println(" > Press 2 For Add To Cart");
			System.out.println();
			System.out.println(" > Press 3 For Go To Previous Page");
			System.out.println();
			System.out.print("-> Enter choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					sortprice(mo);
					break;
				}
				case 2: {
					cart(mo, cr);
					break;
				}
				case 3: {
					return;
				}
				default: {
					System.out.println("Enate Valid Choice ! ");
				}
			}
		}
	}

	void cart(MoisturiserDetails[] t, Cart[] cr) {
		System.out.print("-> Enter Number Of Products You Want To Purchase : ");
		int nu = sc.nextInt();
		int c = 0;
		for (int i = 0; i < nu; i++) {
			System.out.println();
			System.out.print("-> Enter Product Number / id from above list : ");
			int n = sc.nextInt();
			for (int j = 0, k = 340; j < 10 && k < 350; j++) {
				if (n == t[j].number) {
					cr[j] = new Cart(t[j].number, t[j].type, t[j].price, "x");
					System.out.println("    Moisturiser added to cart : " + t[j].type);
					c++;
				}
			}
		}
		if (c != nu) {
			System.out.println("Product Number / id Not Found !\n Please Try Again !\n");
		} else {
			return;
		}
	}

	void displayalldetails(MoisturiserDetails[] bw) {
		for (int i = 0; i < bw.length; i++) {
			System.out.println();
			System.out.println(" - Product Number : " + bw[i].number);
			System.out.println(" - " + bw[i].type);
			System.out.println(" - Price : " + bw[i].price);
		}
	}

	void sortprice(MoisturiserDetails[] mo) {
		System.out.println();
		System.out.println("Press 1 For Sort Moisturizer High price to Low price.");
		System.out.println("Press 2 For Sort Moisturizer Low price to High price.");
		System.out.print("-> Enter choice here : ");
		int n = sc.nextInt();
		if (n == 1) {
			for (int i = 0; i < mo.length - 1; i++) {
				for (int j = 0; j < mo.length - 1; j++) {
					if (mo[j].price < mo[j + 1].price) {
						MoisturiserDetails t = mo[j];
						mo[j] = mo[j + 1];
						mo[j + 1] = t;
					}
				}
			}
			displayalldetails(mo);
		} else if (n == 2) {
			for (int i = 0; i < mo.length - 1; i++) {
				for (int j = 0; j < mo.length - 1; j++) {
					if (mo[j].price > mo[j + 1].price) {
						MoisturiserDetails t = mo[j];
						mo[j] = mo[j + 1];
						mo[j + 1] = t;
					}
				}
			}
			displayalldetails(mo);
		}
	}
}

class Cart // Class to manage cart operations
{
	int number = 0;
	String companyname = "";
	String laptopname = "";
	String tvname = "";
	String speakername = "";
	String earphonename = "";
	String productname = "";
	int ram = 0;
	int storage = 0;
	double price = 0.0;
	String processor = "";
	int size = 0;
	String dtype = "";
	double capacity = 0.0;
	int playtime = 0;
	int power = 0;
	String producttype = "";
	double weight = 0.0;
	String ssize = "";
	String type = "";
	String Quantity = "";
	String fridgename = "";
	Scanner sc = new Scanner(System.in);

	Cart() {

	}

	Cart(int number, String companyname, String productname, int storage, int ram, int price) // mobile//teblet
	{
		this.number = number;
		this.companyname = companyname;
		this.productname = productname;
		this.storage = storage;
		this.ram = ram;
		this.price = price;
	}

	Cart(int number, String companyname, String laptopname, String processor, int storage, int ram, int price)// laptop
	{
		this.number = number;
		this.companyname = companyname;
		this.laptopname = laptopname;
		this.storage = storage;
		this.processor = processor;
		this.ram = ram;
		this.price = price;
	}

	Cart(int number, String companyname, String speakername, int playtime, int power, int price, String x)// speaker
	{
		this.number = number;
		this.companyname = companyname;
		this.speakername = speakername;
		this.playtime = playtime;
		this.power = power;
		this.price = price;
	}

	Cart(int number, String companyname, String earphonename, int playtime, int price)// earphone
	{
		this.number = number;
		this.companyname = companyname;
		this.earphonename = earphonename;
		this.playtime = playtime;
		this.price = price;
	}

	Cart(int number, String companyname, String tvname, String dtype, int size, int price)// tv
	{
		this.number = number;
		this.companyname = companyname;
		this.tvname = tvname;
		this.dtype = dtype;
		this.size = size;
		this.price = price;
	}

	Cart(int number, String companyname, String fridgename, double capacity, int price)// fridge//washingmachin//microwave
	{
		this.number = number;
		this.companyname = companyname;
		this.productname = productname;
		this.capacity = capacity;
		this.price = price;
	}

	Cart(int number, String companyname, String producttype, double weight, double price)// grocery
	{
		this.number = number;
		this.companyname = companyname;
		this.producttype = producttype;
		this.weight = weight;
		this.price = price;
	}

	Cart(int number, String productname, double price)// furni
	{
		this.number = number;
		this.productname = productname;
		this.price = price;
	}

	Cart(int number, String productname, String size, String type, double price) // wearable
	{
		this.number = number;
		this.productname = productname;
		this.ssize = ssize;
		this.type = type;
		this.price = price;
	}

	Cart(int number, String Quantity, double price, String y) // cosmetic
	{
		this.number = number;
		this.Quantity = Quantity;
		this.price = price;
	}

	void display(Cart[] cr) // Method to display product
	{
		int c = 0;
		for (int i = 0; i < cr.length; i++) {
			if (cr[i] != null) {
				if (cr[i].number >= 1 && cr[i].number <= 20) // for mobile,tablet
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Product Name : " + cr[i].productname);
					System.out.println(" - Ram : " + cr[i].ram);
					System.out.println(" - Strorage : " + cr[i].storage);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 21 && cr[i].number <= 30) // for laptop
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Product Name : " + cr[i].laptopname);
					System.out.println(" - Ram : " + cr[i].ram);
					System.out.println(" - Strorage : " + cr[i].storage);
					System.out.println(" - Processor : " + cr[i].processor);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
				} else if (cr[i].number >= 31 && cr[i].number <= 40) // for speaker
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Product Name : " + cr[i].speakername);
					System.out.println(" - Playtime : " + cr[i].playtime);
					System.out.println(" - Power : " + cr[i].power);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 41 && cr[i].number <= 50) // for earphones
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Earphone Name : " + cr[i].earphonename);
					System.out.println(" - Playtime : " + cr[i].playtime);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 51 && cr[i].number <= 60) // for tv
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Product Name : " + cr[i].tvname);
					System.out.println(" - Display type : " + cr[i].dtype);
					System.out.println(" - Size in inch : " + cr[i].size);
					System.out.println(" - Price:-" + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 61 && cr[i].number <= 90) // for fridge,washing machine
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Product Name : " + cr[i].fridgename);
					System.out.println(" - Capacity : " + cr[i].capacity);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 91 && cr[i].number <= 180) // for grocery
				{
					System.out.println();
					System.out.println(" - Company : " + cr[i].companyname);
					System.out.println(" - Product Name : " + cr[i].producttype);
					System.out.println(" - Quantity : " + cr[i].weight);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 181 && cr[i].number <= 230) // for crockery
				{
					System.out.println();
					System.out.println(" - Product Quantity : " + cr[i].Quantity);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 231 && cr[i].number <= 289) // for furniture
				{
					System.out.println();
					System.out.println(" - " + cr[i].productname);
					System.out.println(" - Price - " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				} else if (cr[i].number >= 290 && cr[i].number <= 349) // for cosmetics
				{
					System.out.println();
					System.out.println(" - " + cr[i].Quantity);
					System.out.println(" - Price : " + cr[i].price);
					// System.out.println("------------------------");
					c++;
				}
			}
		}
		if (c == 0) {
			System.out.println("Cart is Empty !!");
		} else {
			while (true) {
				System.out.println();
				System.out.println(" > Press 1 If You Want To Buy/Purchase This Products.");
				System.out.println(" > Press 2 For Go To Previous Page.");
				System.out.print("-> Enter your Choice here : ");
				int n = sc.nextInt();
				if (n == 1) {
					System.out.println();
					sc.nextLine();
					System.out.print(" -> Enter delivery Address : ");
					String address = sc.nextLine();
					System.out.println();
					System.out.print(" -> Enter Your Name : ");
					String name = sc.nextLine();
					System.out.println();
					buy(cr, address, name);
				} else if (n == 2) {
					return;
				} else {
					System.out.println("Enter Valid Number !");
				}
			}
		}
	}

	void buy(Cart cr[], String address, String name) // Method to buy products
	{
		double totalprice = 0;
		for (int i = 0; i < cr.length; i++) {
			if (cr[i] != null) {
				totalprice += cr[i].price;
			}
		}
		System.out.println();
		System.out.println(" --> Total price : " + totalprice);
		System.out.println();
		System.out.println(" > Press 1 For Pay With Debit Card.");
		System.out.println(" > Press 2 For Pay With Credit Card.");
		System.out.println();
		System.out.print("-> Enter your Choice here : ");
		int choice = sc.nextInt();
		switch (choice) {
			case 1: {
				debitcard(totalprice, address, name); // To access debit card operation
			}
			case 2: {
				creditcard(totalprice, address, name); // To access credit card operation
			}
		}
	}

	void debitcard(double totalprice, String address, String name) // Method for debit card payment
	{
		double n = totalprice;
		n = (5 / 100) * totalprice; // add discount
		totalprice -= n;
		while (true) {
			int c = 0;
			System.out.println();
			System.out.print("-> Enter Debit Card Number (16 digits) : ");
			String debitnum = sc.nextLine();
			for (int i = 0; i < debitnum.length(); i++) {
				if (debitnum.charAt(i) >= '0' && debitnum.charAt(i) <= '9') {
					c++;
				}
			}
			if (c == 16) {
				System.out.print("-> Enter Expiry Year : ");
				int year = sc.nextInt();
				if (year >= 2025) {
					while (true) {
						System.out.print("-> Enter Expiry Month : ");
						int month = sc.nextInt();
						if (month >= 1 && month <= 12) {
							if (month >= 2) {
								cheakcvv();
								conformpayment(totalprice, address, name);
								return;
							} else {
								System.out.println("Your Debit Card Has Been Expaired !!");
							}
						} else {
							System.out.println("Enter Valid Month !");
						}
					}
				} else {
					System.out.println("Your Debit Card has been Expaired !!");
				}
			} else {
				System.out.println("Enter Valid Credit Card Number !");
			}
		}
	}

	void creditcard(double totalprice, String address, String name) // Method for debit card payment
	{
		double n = totalprice;
		n = (10 / 100) * totalprice;
		totalprice -= n;
		while (true) {
			int c = 0;
			System.out.println();
			System.out.print("-> Enter Credit Card Number (16 digits) : ");
			String creditnum = sc.nextLine();
			for (int i = 0; i < creditnum.length(); i++) {
				if (creditnum.charAt(i) >= '0' && creditnum.charAt(i) <= '9') {
					c++;
				}
			}
			if (c == 16) {
				System.out.print("-> Enter Expiry Year : ");
				int year = sc.nextInt();
				if (year >= 2025) {
					while (true) {
						System.out.print("-> Enter Expiry Month : ");
						int month = sc.nextInt();
						if (month >= 1 && month <= 12) {
							if (month >= 2) {
								cheakcvv();
								conformpayment(totalprice, address, name);
								return;
							} else {
								System.out.println("Your Credit Card has been Expaired !!");
							}
						} else {
							System.out.println("Enter Valid Month !");
						}
					}
				} else {
					System.out.println("Your Credit Card has been Expaired !!");
				}
			} else {
				System.out.println("Enter Valid Credit Card Number !");
			}
		}
	}

	void cheakcvv() // Method to check cvv need
	{
		while (true) {
			System.out.print("-> Enter CVV Code (3 digits) : ");
			int cvv = sc.nextInt();
			int n = cvv, c = 0;
			while (n > 0) {
				n = n / 10;
				c++;
			}
			if (c == 3) {
				System.out.println();
				System.out.println(" => Details verified...");
				return;
			} else {
				System.out.println("Enter Valid CVV !");
			}
		}
	}

	void conformpayment(double totalprice, String address, String name) // Method to confirm payment
	{
		System.out.println();
		System.out.println("  Your Grand Total after Applying all the eligible Discount is : " + totalprice);
		while (true) {
			System.out.println();
			System.out.println(" > Press 1 For Confirm Your Payment.");
			System.out.println();
			System.out.println(" > Press 2 For Generate bill.");
			System.out.println();
			System.out.println(" > Press 3 For To Go Previous Page.");
			System.out.println();
			System.out.println(" > Press 4 For Exit The Program.");
			System.out.println();
			System.out.print("-> Enter your choice here : ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					System.out.println("  ==>> Payment Successfull !!");
					break;
				}
				case 2: {
					bill b = new bill(name, address, totalprice); // Object to create bill
					break;
				}
				case 3: {
					return;
				}
				case 4: {

					System.exit(0);
				}
				default: {
					System.out.println("Enter valid Choice !");
				}
			}
		}
	}
}

class bill // Class to manage bill
{
	bill(String cname, String address, double totalprice) {
		System.out.println("==================================");
		System.out.println("|           E-Commerce Bill         ");
		System.out.println("|==================================");
		LocalDate date = LocalDate.now();
		System.out.println("| Date : " + date);
		System.out.println("| Customer Name : " + cname);
		if ("0".equals(Register.email)) {
			System.out.println("| Mobile Number : " + Register.number);
		} else {
			System.out.println("| Email : " + Register.email);
		}
		System.out.println("| Delivery Address : " + address);
		System.out.println("| Total price : " + totalprice);
		System.out.println("==================================");
	}
}