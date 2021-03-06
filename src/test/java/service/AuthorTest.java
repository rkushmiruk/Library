package service;

import com.ateam.entity.Author;
import com.ateam.repository.AuthorRepository;
import com.ateam.service.AuthorService;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration("META-INF/spring/app-context-xml.xml")
public class AuthorTest {

    AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;

    @Before
    public void init() {
        authorRepository = mock(AuthorRepository.class);
    }

    @Test
    public void getAllAuthorsTest() {
        Author author = new Author("Roman", "Kushmyrul", "Ukraine");
        List<Author> authors = new ArrayList<>();
        authors.add(authorService.save(author));
        authors.add(authorService.save(author));
        authors.add(authorService.save(author));

        Author otherAuthor = new Author("Dima", "Chaliy", "Estonia");
        authors.add(authorService.save(otherAuthor));

        when(authorRepository.findAll()).thenReturn(authors);
        List<Author> result = Lists.newArrayList(authorRepository.findAll());
        verify(authorRepository, atLeastOnce()).findAll();

        long expectedValue = 4L;
        long actualValue = result.size();
        assertThat(expectedValue, is(actualValue));
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void saveNullAuthor() {
        Author author = new Author();
        authorService.save(author);
    }

    @Test(expected = RuntimeException.class)
    public void MaxAuthorNameLengthTest() {
        String name = "amdsmdasmdmasdmasmdasmdmasdmasmdamdmasmdasmasmdma" +
            "admadmasmdamdamdmamdamdammadmasmdmadmamdamdamsdamdmamdamma";

        authorService.save(new Author(name, "Surname", "Country"));
    }

    @Test
    public void findAuthorTest() {
        Author author = authorService.findById(1L);

        assertNotNull(author);
        assertThat(author.getName(), is("Roman"));
        assertThat(author.getCountry(), is("Ukraine"));
        assertThat(author.getSurname(), is("Kushmyruk"));
    }

    @Test
    public void findAllAuthorsTest() {
        List<Author> authorList = authorService.findAll();
        assertThat(authorList.size(), is(3));
    }

}
