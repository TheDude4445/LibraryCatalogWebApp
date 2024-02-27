package main;

import java.util.List;
import java.util.Scanner;
import model.Book;
import controller.BookHelper;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static BookHelper bh = new BookHelper();

	private static void addABook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title: ");
		String title = in.nextLine();
		System.out.print("Enter the author: ");
		String author = in.nextLine();
		System.out.print("Enter the ISBN: ");
		String isbn = in.nextLine();
		Book toAdd = new Book(title, author, isbn);
		bh.insertBook(toAdd);
	}

	private static void deleteABook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title of the book to delete: ");
		String title = in.nextLine();
		System.out.print("Enter the author of the book to delete: ");
		String author = in.nextLine();
		System.out.print("Enter the ISBN of the book to delete: ");
		String isbn = in.nextLine();
		Book toDelete = new Book(title, author, isbn);
		bh.deleteBook(toDelete);
	}
	
	private static void editABook() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by title");
		System.out.println("2 : Search by author");
		System.out.println("3 : Search by isbn");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Book> foundItems;
		
		if (searchBy == 1) {
			System.out.print("Enter the title: ");
			String title = in.nextLine();
			foundItems = bh.searchForBookByTitle(title);
		} else if (searchBy == 2) {
			System.out.print("Enter the author: ");
			String author = in.nextLine();
			foundItems = bh.searchForBookByAuthor(author);
		}
		else {
			System.out.print("Enter the isbn: ");
			String isbn = in.nextLine();
			foundItems = bh.searchForBookByISBN(isbn);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Book l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			Book toEdit = bh.searchForBookById(idToEdit);
			System.out.println("Retrieved " + toEdit.getAuthor() + " and " + toEdit.getIsbn() + " from " + toEdit.getTitle());
			System.out.println("1 : Update title");
			System.out.println("2 : Update Author");
			System.out.println("3 : Update ISBN");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New title: ");
				String newtitle = in.nextLine();
				toEdit.setTitle(newtitle);
			} else if (update == 2) {
				System.out.print("New Author: ");
				String newAuthor = in.nextLine();
				toEdit.setAuthor(newAuthor);
			}
			else if (update == 3) {
				System.out.print("New ISBN: ");
				String newISBN = in.nextLine();
				toEdit.setIsbn(newISBN);
			}
			bh.updateBook(toEdit);
		} else {
			System.out.println("---- No results found");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome book list! ---");
		while (goAgain) {
			System.out.println("*  Select a choice:");
			System.out.println("*  1 -- Add a book");
			System.out.println("*  2 -- Edit an book");
			System.out.println("*  3 -- Delete a book");
			System.out.println("*  4 -- View the book list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addABook();
			} else if (selection == 2) {
				editABook();
			} else if (selection == 3) {
				deleteABook();
			} else if (selection == 4) {
				viewTheList();
			} else {
				bh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<Book> allBooks = bh.showAllBooks();
		for(Book singleBook : allBooks) {
			System.out.println(singleBook.returnBookDetails());
		}
	}
}
