package com.hexaware.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springboot.model.Book;

@RestController
public class BookController {
	
	static ArrayList<Book> books=new ArrayList<>();
	BookController()
	{
		 books.add(new Book(1, "Java", "James", 500));
         books.add(new Book(2, "Spring", "Rod", 700));
	}
	
	@PostMapping("/addBook")
	String addBook(@RequestBody Book b)
	{
		books.add(b);
		return "Book added";
	}
	
	@GetMapping("/showAllBooks")
	List<Book> showAll()
	{
		return books;
	}
	@GetMapping("/searchBook/{id}")
	Book searchById(@PathVariable int id)
	{
		for(Book b:books)
		{
			if(b.getBookId()==id)
			{
				return b;
			}
		}
		return null;
	}
	 @DeleteMapping("/deleteBook/{id}")
	 String deleteBook(@PathVariable int id) {
	        for (Book b:books) {
	            if (b.getBookId() == id) {
	                books.remove(b);
	                return "Book Deleted Successfully";
	            }
	        }
	        return "Book Not Found";
	    }
	 @PutMapping("/updateBook/{id}")
	 String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
	     for (Book b : books) {
	         if (b.getBookId() == id) {
	             b.setBookName(updatedBook.getBookName());
	             b.setAuthor(updatedBook.getAuthor());
	             b.setPrice(updatedBook.getPrice());
	             return "Book Updated Successfully";
	         }
	     }
	     return "Book Not Found";
	 }
	 @GetMapping("/GreatherThan/{amount}")
	 public Object booksGreaterThanPrice(@PathVariable double amount) {
	     List<Book> result = new ArrayList<>();

	     for (Book b : books) {
	         if (b.getPrice() > amount) {
	             result.add(b);
	         }
	     }

	     if (result.isEmpty()) {
	         return "No Books Found";
	     }

	     return result;
	 }
}
