package service;

import com.ateam.repository.BookRepository;
import com.ateam.service.BookService;
import org.junit.Before;
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
    BookService authorService;

    @Before
    public void init() {
        bookRepository = mock(BookRepository.class);
    }
}
