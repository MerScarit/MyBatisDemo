import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class TestMybatis {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
       sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }
    @Test
    public void testSession() throws IOException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList("user.select");
            log.debug("result is[{}]",objects);
        }
    }

    @Test
    public void testMapper() throws IOException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
        }
    }
}
