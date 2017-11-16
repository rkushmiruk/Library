package service;

import com.ateam.repository.BookInstanceRepository;
import com.ateam.service.BookInstanceService;
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
public class BookInstanceTest {

    BookInstanceRepository bookInstanceRepository;

    @Autowired
    BookInstanceService bookInstanceService;

    @Before
    public void init() {
        bookInstanceRepository = mock(BookInstanceRepository.class);
    }

}
