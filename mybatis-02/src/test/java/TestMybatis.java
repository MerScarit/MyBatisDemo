import com.scarit.entity.Employee;
import com.scarit.mapper.EmployeeMapper;
import com.scarit.mapper.UserDao;
import com.scarit.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
    public void testSession() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList("user.select");
            log.debug("result is[{}]", objects);
        }
    }

    @Test
    public void testMapper() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserDao dao = session.getMapper(UserDao.class);
            List<User> users = dao.selectAll();
            log.debug("users are [{}]", users);
        }
    }
    @Test
    public void testSelect() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.select(new Employee());
            log.debug("users are [{}]", employees);
        }
    }

    @Test
    public void testFindById() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserDao dao = session.getMapper(UserDao.class);
            User user = dao.selectOne(1);
            log.debug("The user is [{}]", user);
        }
    }

    @Test
    public void testFindUser() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserDao dao = session.getMapper(UserDao.class);
            User peo = new User(null, "coffee", "521");
            List<User> user = dao.findUser(peo);
            log.debug("The user is [{}]", user);
        }
    }

    @Test
    public void testInsert() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserDao dao = session.getMapper(UserDao.class);
            int affectedRows = dao.insert(new User(727, "kafei", "520"));
            log.debug("int affectedRows is [{}]", affectedRows);
            //必须手动提交事务
            session.commit();
        }
    }

    @Test
    public void testUpdate() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserDao dao = session.getMapper(UserDao.class);
            int affectedRows = dao.update(new User(727, "kafei", "521"));
            log.debug("int affectedRows is [{}]", affectedRows);
        }
    }

    @Test
    public void testDelete() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserDao dao = session.getMapper(UserDao.class);
            int affectedRows = dao.delete(1);
            log.debug("int affectedRows is [{}]", affectedRows);
        }
    }

    @Test
    public void testDeleteByIds() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserDao dao = session.getMapper(UserDao.class);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            int affectedRows = dao.deleteByIds(list);
            log.debug("int affectedRows is [{}]", affectedRows);
        }
    }


    @Test
    public void testBatchInsert() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserDao dao = session.getMapper(UserDao.class);
            List<User> list = null;
            list.add(new User(723,"xinxin", "2727"));
            int affectedRows = dao.batchInsert(list);
            log.debug("int affectedRows is [{}]", affectedRows);
        }
    }
}