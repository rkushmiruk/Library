package service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.ateam.entity.Author;
import com.ateam.entity.BookInstance;
import com.ateam.repository.BookInstanceRepository;
import com.ateam.service.BookInstanceService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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

    @Autowired
    BookInstanceService bookInstanceService;

    @Test(expected = org.springframework.orm.jpa.JpaSystemException.class)
    public void saveNullAuthor() {
        BookInstance bookInstance = new BookInstance();
        bookInstanceService.save(bookInstance);
    }

    @Test
    public void saveBookInstanceTest() {
        BookInstanceRepository bookInstanceRepository1 = mock(BookInstanceRepository.class);
        BookInstance bookInstance = new BookInstance(1L, "1", "1");
        BookInstance bookInstance2 = new BookInstance(2L, "2", "2");
        bookInstanceService.save(bookInstance);
        bookInstanceService.save(bookInstance2);

        ImmutableList<BookInstance> bookInstances = ImmutableList.of(bookInstance, bookInstance2);
        when(bookInstanceRepository1.findAll()).thenReturn(bookInstances);
        List<BookInstance> result = Lists.newArrayList(bookInstanceRepository1.findAll());
        verify(bookInstanceRepository1, atLeastOnce()).findAll();

        int expectedValue = 2;
        int actualValue = result.size();
        assertThat(expectedValue, is(actualValue));
    }

}
