class User {
   String username;
   String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Post {
    private int postID;
    private int likesCount;
    private int commentsCount;

    public Post(int postID) {
        this.postID = postID;
        this.likesCount = 0;
        this.commentsCount = 0;
    }
}

public class Main {
    static Scanner input = Scanner(System.in);
    
    public static void createUser() {
    	System.out.print(" Create username: ");
    	String username = input.next();
    	System.out.print(" Create password: ");
    	String password = input.next();
    	
    	User username = new User(username, password);
    }
    
    public static void login() {
    	System.out.print(" Enter username: ");
    	String username = input.next();
    	
    	System.out.print(" Enter password: ");
    	String password = input.next();
    	
    	if (username.password == password) {
    		mainPage();
    	}
    	else {
    		System.out.println("Incorrect username or password");
    	}
    }
    
    public static void mainPage() {
    	System.out.println("1. Post \n 2. View Posts");
    	System.out.println("Your choice: ");
    	int option = input.nextInt();
    	
    	if (option == 1) {
    		post();
    	}
    	 else if (option == 2) {
    	 	viewPosts();
    	 }
    	else {
    		System.out.println(" Please enter a valid input!");
    	}
    }
    
    public static void execute() {
    	System.out.println("1. Login \n 2. Sign up (Create new user)");
    	System.out.println("Your choice: ");
    	int option = input.nextInt();
    	
    	if (option == 1) {
    		createUser();
    	}
    	else if (option == 2) {
    		login();
    	}
    	else {
    		System.out.println(" Please enter a valid input! ");
    		execute();
    	}
    }
    
    public static void main(String[] args) {
	System.out.println(" Welcome to our platform! ");
       execute();
       
       input.close();
    }
}
