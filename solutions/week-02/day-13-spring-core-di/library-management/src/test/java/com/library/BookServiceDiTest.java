package com.library;

import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

// proving both injection styles actually happened
// findBook working means the repository got set (setter injection)
// the library name means the constructor-arg went in (constructor injection)
class BookServiceDiTest {

    @Test
    void bothInjectionsWired() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean(BookService.class);

        // setter injection worked if the service can reach the repo
        assertEquals("the pragmatic programmer", service.findBook(1));
        // constructor injection worked if the name came through
        assertEquals("city central library", service.getLibraryName());

        context.close();
    }
}
