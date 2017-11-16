package service;

import com.ateam.entity.User;
import com.ateam.repository.UserRepository;
import com.ateam.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration("META-INF/spring/app-context-xml.xml")
public class UserServiceTest {

    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Before
    public void init() {
        userRepository = mock(UserRepository.class);
    }

    @Test
    public void saveNullAuthor() {
        User user = new User();
        userRepository.save(user);

        assertThat(null, is(userRepository.findOne(user.getId())));
    }
}
