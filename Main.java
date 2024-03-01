import java.util.ArrayList;
import java.util.Scanner;

class User {
	String username;
	String password;

	public static ArrayList<String> usersList = new ArrayList<>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

class Post {
	int postID;
	int likesCount;
	String content;

	public ArrayList<String> postsList = new ArrayList<>();

	public Post(int postID, String content) {
		this.postID = postID;
		this.likesCount = 0;
		this.content = content;
		ArrayList<String> comments = new ArrayList<>();
	}
}

public class Main {
	static int ctr = 0;
	static Scanner input = new Scanner(System.in);

	// code to allow the code run even after it is executed once successfully
	public static void successHandling() {
		System.out.print(" 1. Make another post. \n 2. View another post \n 3. Exit.");
		int option = input.nextInt();

		switch (option) {
			case 1:
				post();
				break;

			case 2:
				viewPost();
				break;

			case 3:
				System.out.println("See you soon :)");
				break;

			default:
				System.out.println("Please enter a valid input");
				successHandling();
				break;
		}
	}

	// checks password
	public static boolean correctPassword(String username, String password) {
		for (int i = 0; i < User.usersList.size(); i++) {
			if (User.usersList.get(i).username == username) {
				if (User.usersList.get(i).password == password) {
					return true;
				}
			}
		}
		return false;
	}

	// check if user exists
	public static boolean newUser(String username) {
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.username == username) {
				return false;
			}
		}
		return true;
	}

	// allows users to post
	public static void post() {
		System.out.print("Write content for the post: ");
		String content = input.next();

		posts.add(new Post(ctr++, content));
	}

	// allows users to view posts
	public static void viewPost() {
		System.out.print("Select postID to view the post: ");
		int option = input.nextInt();

		int commentsSize = postsList[option].comments.size();
		System.out.println(postsList[option].content);
		System.out.println("Likes: " + postsList[option].likesCount);
		System.out.println("Comments: " + postsList[option].comments.size());
		for (int i = 0; i < commentsSize; i++) {
			System.out.println("\n" + postsList[option].comments[i]);
		}

		System.out.println(" 1. Like \n 2. Comment ");
		int opt = input.nextInt();

		if (opt == 1) {
			postsList[option].likesCount++;
		} else if (opt == 2) {
			String comment = input.next();
			postsList[option].Comments.add(comment);
		}

		successHandling();
	}

	// creates a new user
	public static void createUser() {
		System.out.print(" Create username: ");
		String username = input.next();
		System.out.print(" Create password: ");
		String password = input.next();

		if (newUser(username)) {
			usersList.add(new User(username, password));
		} else {
			System.out.println("Username is already taken... Try again!");
			createUser();
		}
	}

	// allows existing user to login
	public static void login() {
		System.out.print(" Enter username: ");
		String username = input.next();

		System.out.print(" Enter password: ");
		String password = input.next();

		if (correctPassword(username, password)) {
			mainPage();
		} else {
			System.out.println("Incorrect username or password");
			login();
		}
	}

	// page that appears after users login or sign up
	public static void mainPage() {
		System.out.println("1. Post \n 2. View Posts");
		System.out.println("Your choice: ");
		int option = input.nextInt();

		if (option == 1) {
			post();
		} else if (option == 2) {
			viewPost();
		} else {
			System.out.println(" Please enter a valid input!");
			mainPage();
		}
	}

	// initial code execution
	public static void execute() {
		System.out.println("1. Login \n 2. Sign up (Create new user)");
		System.out.println("Your choice: ");
		int option = input.nextInt();

		if (option == 1) {
			createUser();
		} else if (option == 2) {
			login();
		} else {
			System.out.println(" Please enter a valid input! ");
			execute();
		}
	}

	// main method
	public static void main(String[] args) {
		System.out.println(" Welcome to our platform! ");
		execute();

		input.close();
	}
}
