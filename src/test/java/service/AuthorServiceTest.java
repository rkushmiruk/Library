package service;

import com.ateam.entity.Author;
import com.ateam.repository.AuthorRepository;
import com.ateam.service.AuthorService;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration("META-INF/spring/app-context-xml.xml")
public class AuthorServiceTest {
    AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;

    @Before
    public void init() {
        authorRepository = mock(AuthorRepository.class);
    }

    @Test
    public void getAllAuthorsTest() {
        Author author = new Author("Roman","Kushmyrul","Ukraine");
        List<Author> authors = new ArrayList<>();
        authors.add(authorService.save(author));
        authors.add(authorService.save(author));
        authors.add(authorService.save(author));

        Author otherAuthor = new Author("Dima","Chaliy","Estonia");
        authors.add(authorService.save(otherAuthor));

        System.out.println(authorRepository.findAll());
        when(authorRepository.findAll()).thenReturn(authors);
        verify(authorRepository, atLeastOnce()).findAll();
        Iterable<Author> result = authorRepository.findAll();
        long count = 0;
        for (Author item: result) {
            count++;
        }

        long expectedValue = 4L;
        System.out.println(count);
        assertThat(expectedValue, is(count));
    }
}
