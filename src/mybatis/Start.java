package mybatis;

import mybatis.mapper.TableAbcMapper;
import mybatis.model.TableAbc;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/28
 * @time 16:32
 * @package mybatis
 * @project 1008MyDemo
 * @description
 */
public class Start {

    /**
     * 脱离Spring 单独使用Mybatis框架
     */
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSession();
        TableAbcMapper mapper = sqlSession.getMapper(TableAbcMapper.class);
        List<TableAbc> tableAbcs = mapper.selectByExample(null);
        System.out.println("tableAbcs = " + tableAbcs);
        System.out.println();
    }

    /**
     * 用于建立Mybatis连接
     * @return
     * @throws IOException
     */
    private static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }
}
