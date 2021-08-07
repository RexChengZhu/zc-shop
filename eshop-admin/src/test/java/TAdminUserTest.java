import com.zc.eshop.admin.AdminApp;
import com.zc.eshop.admin.entity.TAdminUserEntity;
import com.zc.eshop.admin.service.TAdminUserService;
import net.bytebuddy.matcher.ElementMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AdminApp.class)
@RunWith(SpringRunner.class)
public class TAdminUserTest {

    @Autowired
    private TAdminUserService adminUserService;

    @Test
    public void testAdd(){
        TAdminUserEntity entity = new TAdminUserEntity();
        entity.setName("peter");
        entity.setPassword("12321");
        adminUserService.save(entity);
    }

}
