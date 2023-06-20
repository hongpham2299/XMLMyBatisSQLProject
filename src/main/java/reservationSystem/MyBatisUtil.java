package reservationSystem;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory;
    private static String xmlConfigFile = "mybatis-reservationSystem-config.xml";

    static Logger logger = LogManager.getLogger(MyBatisUtil.class.getName());

    public static SqlSessionFactory getSqlSessionFactory(){
        try (InputStream stream = Resources.getResourceAsStream(xmlConfigFile)){
            factory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            logger.error(e.getMessage());
        }
        return factory;
    }
}
