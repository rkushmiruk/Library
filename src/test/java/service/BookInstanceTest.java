package service;

import com.ateam.entity.BookInstance;
import com.ateam.repository.BookInstanceRepository;
import com.ateam.service.BookInstanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration("META-INF/spring/app-context-xml.xml")
public class BookInstanceTest {

    @Mock
    BookInstanceRepository bookInstanceRepository;

    @Autowired
    BookInstanceService bookInstanceService;

    @Test(expected = org.springframework.orm.jpa.JpaSystemException.class)
    public void saveNullAuthor() {
        BookInstance bookInstance = new BookInstance();
        bookInstanceService.save(bookInstance);
    }

}
