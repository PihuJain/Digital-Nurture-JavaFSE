package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// loads the context and uses the service, which now has its repository injected by spring
public class LibraryManagementApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean(BookService.class);
        System.out.println(service.getLibraryName());
        System.out.println("book 1: " + service.findBook(1));

        context.close();
    }
}
