import com.scarit.entity.Dept;
import com.scarit.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class TestDept {

    SqlSessionFactory sqlSessionFactory = null;


    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            List<Dept> depts = mapper.selectAll(null);
            log.debug("users are [{}]", depts);
        }
    }

    @Test
    public void testSelect2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            List<Dept> depts = mapper.select2(null);
            log.debug("users are [{}]", depts);
        }
    }





}