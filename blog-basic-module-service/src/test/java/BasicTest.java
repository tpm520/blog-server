import com.tpblog.basic.api.entity.Article;
import com.tpblog.basic.api.service.ArticleService;
import com.tpblog.basic.service.BasicServiceApplication;
import com.tpblog.basic.service.mapper.ArticleMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {BasicServiceApplication.class})
@RunWith(SpringRunner.class)
public class BasicTest {

    @Autowired
    private ArticleService articleService;

    public void test1(){
        Article article = articleService.findArticleById(1);
        System.out.println(article);
    }
}
