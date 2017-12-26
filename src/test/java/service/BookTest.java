package service;

import com.ateam.entity.Book;
import com.ateam.repository.BookRepository;
import com.ateam.service.BookService;
import com.google.common.collect.ImmutableList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

    public void saveNullAuthor() {
        Book book = new Book("12345567", "New", "Roman", "yes");
        bookService.save(book);
    }

    @Test
    public void getAllBookTest() {
        Book book = new Book("12345", "New", "Roman", "yes");
        List<Book> books = new ArrayList<>();
        books.add(book);

        when(bookRepository.findAll()).thenReturn(books);
        List<Book> result = ImmutableList.copyOf(bookRepository.findAll());
        verify(bookRepository, atLeastOnce()).findAll();

        long expectedValue = 1L;
        long actualValue = result.size();
        assertThat(expectedValue, is(actualValue));
    }

    @Test
    public void findBookTest() {
        Book book = bookService.findById(1L);

        assertNotNull(book);
        assertThat(book.getIsbn(), is("123"));
        assertThat(book.getPublisher(), is("New Times"));
        assertThat(book.getTitle(), is("King"));
        assertThat(book.getAvailability(), is("yes"));
    }

    @Test
    public void findAllBooksTest() {
        List<Book> books = bookService.findAll();
        assertThat(books.size(), is(3));
    }

}
