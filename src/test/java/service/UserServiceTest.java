package service;

import com.ateam.entity.Role;
import com.ateam.entity.User;
import com.ateam.repository.UserRepository;
import com.ateam.service.UserService;
import com.google.common.collect.ImmutableList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
    public void saveNullUser() {
        User user = new User();
        userRepository.save(user);

        assertThat(null, is(userRepository.findOne(user.getId())));
    }

    @Test
    public void getAllUserTest() {
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);
        List<User> result = ImmutableList.copyOf(userRepository.findAll());
        verify(userRepository, atLeastOnce()).findAll();

        long expectedValue = 1L;
        long actualValue = result.size();
        Assert.assertThat(expectedValue, is(actualValue));
    }

    @Test
    public void findUserTest() {
        User user = userService.findById(1L);

        assertNotNull(user);
        Assert.assertThat(user.getEmail(), is("Ramon2@meta.ua"));
        Assert.assertThat(user.getPassword(), is("Fear"));
    }

}
