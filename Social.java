// This is not finalsed file, still need to fix some bugs

import java.util.ArrayList;
import java.util.Scanner;

class User {
	String username;
	String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

class Post {
	int postID;
	int likesCount;
	String content;
	ArrayList<String> comments;

	public Post(int postID, String content) {
		this.postID = postID;
		this.likesCount = 0;
		this.content = content;
		this.comments = new ArrayList<>();
	}
}

public class Social {
	public static ArrayList<Post> postsList = new ArrayList<>();
	public static ArrayList<User> usersList = new ArrayList<>();
	static int ctr = 0;
	static Scanner input = new Scanner(System.in);

	// code to allow the code run even after it is executed once successfully
	public static void successHandling() {
		System.out.println(" 1. Post. \n 2. View Posts \n 3. Create user. \n 4. Login as another user. \n 5. Exit.");
		System.out.print(" Your choice: ");
		int opt = input.nextInt();

		switch (opt) {
			case 1:
				post();
				break;

			case 2:
				viewPost();
				break;

			case 3:
				createUser();
				break;

			case 4:
				login();
				break;

			case 5:
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
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).username == username) {
				if (usersList.get(i).password == password) {
					return true;
				}
			}
		}
		return false;
	}

	// check if user exists
	public static boolean newUser(String username) {
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).username == username) {
				return false;
			}
		}
		return true;
	}

	// allows users to post
	public static void post() {
		System.out.print("Write content for the post: ");
		String content = input.nextLine();
		input.next();

		postsList.add(new Post(ctr, content));
		System.out.println("Post updated with PostID: " + ctr);
		ctr++;
		successHandling();
	}

	// allows users to view posts
	public static void viewPost() {
		System.out.print("Select postID to view the post: ");
		int option = input.nextInt();

		int commentsSize = postsList.get(option).comments.size();
		System.out.println(postsList.get(option).content);
		System.out.println("Likes: " + postsList.get(option).likesCount);
		System.out.println("Comments: " + postsList.get(option).comments.size());
		for (int i = 0; i < commentsSize; i++) {
			System.out.println("       " + postsList.get(option).comments.get(i));
		}

		System.out.println(" 1. Like \n 2. Comment");
		int opt = input.nextInt();

		if (opt == 1) {
			postsList.get(option).likesCount++;
			System.out.println("Post liked successfully...");
		} else if (opt == 2) {
			String comment = input.next();
			postsList.get(option).comments.add(comment);
			System.out.println("Comment updated successfully...");
		}
		else {
			System.out.println("Please enter a valid input");
		}

		successHandling();
	}

	// creates a new user
	public static void createUser() {
		System.out.print(" Create username: ");
		String username = input.nextLine();
		input.next();
		System.out.print(" Create password: ");
		String password = input.nextLine();
		input.next();

		if (newUser(username)) {
			usersList.add(new User(username, password));
			System.out.print("User created successfully...\n");
			mainPage();
		} else {
			System.out.println("Username is already taken... Try something else!");
			createUser();
		}
	}

	// allows existing user to login
	public static void login() {
		System.out.print(" Enter username: ");
		String username = input.nextLine();
		input.next();

		System.out.print(" Enter password: ");
		String password = input.nextLine();
		input.next();

		if (correctPassword(username, password)) {
			System.out.println(" Login successful...\n");
			mainPage();
		} else {
			System.out.println("Incorrect username or password! Please try again!");
			System.out.println(" 1. Try again. \n 2. Create new user.");
			System.out.print("Your choice: ");
			int opt = input.nextInt();

			if (opt == 1) {
				login();
			} else if (opt == 2) {
				createUser();
			} else {
				System.out.println("Please enter a valid input!");
			}
		}
	}

	// page that appears after users login or sign up
	public static void mainPage() {
		System.out.println(" 1. Post \n 2. View Posts \n 3. Login as another user \n 4. Create new user");
		System.out.print("Your choice: ");
		int in = input.nextInt();

		switch (in) {
			case 1:
				post();
				break;

			case 2:
				viewPost();
				break;

			case 3:
				login();
				break;

			case 4:
				createUser();
				break;

			default:
				System.out.println(" Please enter a valid input!");
				mainPage();
				break;
		}
	}

	// initial code execution
	public static void execute() {
		System.out.println(" 1. Login \n 2. Sign up (Create new user)");
		System.out.print("Your choice: ");
		int option = input.nextInt();

		if (option == 1) {
			login();
		} else if (option == 2) {
			createUser();
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
