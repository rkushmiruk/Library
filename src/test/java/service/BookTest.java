package service;

import com.ateam.entity.Book;
import com.ateam.repository.BookRepository;
import com.ateam.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration("META-INF/spring/app-context-xml.xml")
public class BookTest {

    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Before
    public void init() {
        bookRepository = mock(BookRepository.class);
    }

    @Test(expected = org.springframework.orm.jpa.JpaSystemException.class)
    public void saveNullAuthor() {
        Book book = new Book();
        bookService.save(book);
    }
}
