package designPattern.behavior.mediation.design;

import com.alibaba.fastjson.JSON;
import designPattern.behavior.mediation.design.mediator.DefaultSqlSessionFactory;
import designPattern.behavior.mediation.design.mediator.SqlSession;
import designPattern.behavior.mediation.design.mediator.SqlSessionFactoryBuilder;
import designPattern.behavior.mediation.design.po.Wser;
import designPattern.util.Logger;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;

public class MediatorTest {

    private static Logger logger = new Logger();
    public static void main(String[] args) {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            try {
                Wser user = sqlSession.selectOne("designPattern.behavior.mediation.design.dao.IWserDao.queryWserInfoById",
                        1);
                logger.info("测试结果： {0}", JSON.toJSONString(user));
            } finally {
                sqlSession.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
