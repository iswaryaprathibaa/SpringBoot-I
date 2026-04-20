package com.example.sba;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class TestController {

//    @GetMapping("/home")
//    public String homepage(){
//        return "home";
//    }
//
//     @GetMapping("/contact")
//    public String contacString(){
//        return "contactme";
//    }
     
     	
     	List<Student> users= new ArrayList<>();
     	TestController()
     	{
     		users.add(new Student(101,"Ajay",90.0));
     		users.add(new Student(102,"Jatin",20.0));
      
     		users.add(new Student(103,"Nitin",80));
      
     		users.add(new Student(104,"Kavita",70));
      
     	}
     	
     	
     	@GetMapping("/showAll")
     	
     	  List<Student> showUsers()
     	   {
     		  
     		  return  users;
     		    
     	   }
     	
     	@GetMapping("/search/{rno}")
   	 Student searchRoll(@PathVariable int rno)
   	 {
   		
   		for(Student s : users)
   		{
   		 if (s.getRoll() == rno) {
             return s;
         }
   		}
   		
   		return null;
   	 }

     	@GetMapping("/searchname/{name}")
   	 Student searchByName(@PathVariable String name)
   	 {
   		
   		for(Student s : users)
   		{
   			if(s.getName().equalsIgnoreCase(name))
   			{
   			return s;
   			}
   		}
   		
   		return null;
   	 }
     	@PostMapping("/saveData")
    	String  SaveData( @RequestBody Student  s )
    	{
    		users.add(s);
    		return "saved Data";
    	}
     	@PutMapping("/updateMark/{rno}/{mark}")
     	String updateMark(@PathVariable int rno,@PathVariable double mark)
     	{
     		for(Student i:users)
     		{
     			if(i.getRoll()==rno)
     			{
     				i.setMarks(mark);
     				return "mark updated";
     			}
     		}
     		return "No student found";
     	}
     	@DeleteMapping("/deleteData/{rno}")
     	String deleteData(@PathVariable int rno) {
     		for(Student i:users)
     		{
     			if(i.getRoll()==rno)
     			{
     				users.remove(i);
     				return "Deleted";
     			}
     		}
     		return "no student found";
     	}
     }
      


