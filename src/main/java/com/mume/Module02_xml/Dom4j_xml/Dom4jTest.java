package com.mume.Module02_xml.Dom4j_xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author mume
 */
public class Dom4jTest {
    // 1. 获取XML解析对象
    private SAXReader reader = new SAXReader();

    /**
     * 获取XML文件中的所有元素（标签）
     * @throws DocumentException
     * @throws IOException
     */
    @Test
    public void getNodes() throws DocumentException, IOException {
        // 1. 获取XML解析对象
        SAXReader reader = new SAXReader();

        // 2.解析XML 获取文档对象document
        String path = getClass().getResource("/Module02_xml/Dom4j_xml/user.xml").getPath();
        System.out.println(path);
        Document document = reader.read(path);

        // 3.获取根元素
        Element rootElement = document.getRootElement();

        System.out.println(rootElement.getName());

        // 4.获取根元素下的标签
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println("son element:" + element.getName());

            List<Element> elementList = element.elements();
            for (Element e : elementList) {
                System.out.println("user下的子节点" + e.getName());
            }
            break;
        }
    }

    /**
     * 获取XML中标签的文本信息和属性信息
     */
    @Test
    public void getContextAndAttr() throws DocumentException {

        // 2.解析XML 获取文档对象document
        String path = getClass().getResource("/Module02_xml/Dom4j_xml/user.xml").getPath();
        System.out.println(path);
        Document document = reader.read(path);

        // 3.获取根元素
        Element rootElement = document.getRootElement();

        // 4.获取子节点
        List<Element> elements = rootElement.elements();
        Element element = elements.get(0);
        String id = element.attributeValue("id");
        String name = element.elementText("name");
        String age = element.elementText("age");
        String hobby = element.element("hobby").getText();

        System.out.println(id + " " + name + " " + age + " " + hobby);
    }

    /**
     * 使用selectSingleNode() 方法 查询自定义的节点信息
     */
    @Test
    public void selectSingleNodeByXPath() throws DocumentException {

        // 2.解析XML 获取文档对象document
        String path = getClass().getResource("/Module02_xml/Dom4j_xml/book.xml").getPath();
        System.out.println(path);
        Document document = reader.read(path);

        Node node = document.selectSingleNode("/bookstore/book/name");
        System.out.println(node.getText());

        Node node2 = document.selectSingleNode("/bookstore/book[2]/name");
        System.out.println(node2.getText());
    }

    /**
     * 使用selectSingleNode()方法获取属性值 或着 通过属性值获取到节点信息
     * @throws DocumentException
     */
    @Test
    public void getAttrOrNodeByXPath() throws DocumentException {
        String path = getClass().getResource("/Module02_xml/Dom4j_xml/book.xml").getPath();
        System.out.println(path);
        Document document = reader.read(path);

        // 1.获取第一个book节点中的 id属性值
        Node node = document.selectSingleNode("/bookstore/book/attribute::id");
        System.out.println("first node id:" + node.getText());

        // 2.获取最后一个book节点的id值
        Node node1 = document.selectSingleNode("/bookstore/book[last()]/attribute::id");
        System.out.println("last node id:" + node1.getText());

        // 3.通过id的值 获取book2节点 中的书名
        Node node3 = document.selectSingleNode("/bookstore/book[@id='book2']");
        String node3Name = node3.selectSingleNode("name").getText();
        System.out.println("id为book2的节点的书名是：" + node3Name);
    }

    /**
     * 使用selectNodes() 获取所有指定名称的节点
     * @throws DocumentException
     */
    @Test
    public void getAllNamedNode() throws DocumentException {
        String path = getClass().getResource("/Module02_xml/Dom4j_xml/book.xml").getPath();
        System.out.println(path);
        Document document = reader.read(path);

        // 1.查询所有节点
        List<Node> nodes = document.selectNodes("//*");

        for (Node node : nodes) {
            System.out.println("节点名:" + node.getName());
        }

        // 2.获取所有的书名
        List<Node> nodes1 = document.selectNodes("//name");
        for (Node node : nodes1) {
            System.out.println("book name：" + node.getText());
        }

        // 3.获取id值为book1的节点中的所有内容
        List<Node> nodes2 = document.selectNodes("/bookstore/book[@id='book1']//*");
        for (Node node : nodes2) {
            System.out.println(node.getName() + "=" + node.getText());
        }

    }
}
