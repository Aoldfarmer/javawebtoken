import com.koou.Application;
import com.koou.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-07-26 4:38 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AuthServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthService authService;

    @Test
    public void login() throws Exception {
        String username = "yunqiangdi";
        String password = "admin";
        String token = authService.login(username, password);
        logger.info("token = { }", token);
    }

}