package designPattern.behavior.mediation.design.mediator;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlSessionFactoryBuilder {
    public DefaultSqlSessionFactory build(Reader reader) {
        SAXReader saxReader = new SAXReader();

        try {
            saxReader.setEntityResolver(new XMLMapperEntityResolver());
            Document document = saxReader.read(new InputSource(reader));
            Configuration configuration = parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Configuration parseConfiguration(Element root) {
        Configuration configuration = new Configuration();

        configuration.setDataSource(dataSource(root.selectNodes("//dataSource/property")));
        configuration.setConnection(connection(configuration.dataSource));
        configuration.setMapperElement(mapperElement(root.selectNodes("//mapper")));
        return configuration;
    }

    // 获取数据源配置信息
    private Map<String, String> dataSource(List<Node> list) {
        Map<String, String> dataSource = new HashMap<>(8);
        for (Object o : list) {
            Element e = (Element) o;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }
        return dataSource;
    }

    // 获取数据库连接
    private Connection connection(Map<String, String> dataSource) {
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(dataSource.get("url"), dataSource.get("username"), dataSource.get("password"));
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    // 获取sql语句
    private Map<String, XNode> mapperElement(List<Node> list) {
        Map<String, XNode> map = new HashMap<>();

        for (Object o : list) {
            Element e = (Element) o;
            String resource = e.attributeValue("resource");

            try {
                Reader reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));
                Element root = document.getRootElement();
                String namespace = root.attributeValue("namespace");
                List<Element> select = root.elements("select");
                for (Element node : select) {
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();

                    // ？匹配
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);

                    for (int i = 1; matcher.find(); i++) {
                        String g1 = matcher.group(1);
                        String g2 = matcher.group(2);
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql.replaceAll("\\n", "").trim());
                    xNode.setParameter(parameter);
                    map.put(namespace +"." + id, xNode);
                }
            } catch (IOException | DocumentException ioException) {
                ioException.printStackTrace();
            }
        }
        return map;
    }
}
