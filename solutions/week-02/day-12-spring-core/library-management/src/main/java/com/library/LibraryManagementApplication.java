package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// loads the spring context from the xml and pulls the beans back out to check it wired up
public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean(BookService.class);
        BookRepository repo = context.getBean(BookRepository.class);

        System.out.println(service.describe());
        System.out.println("book 1: " + repo.getBookById(1));
    }
}
