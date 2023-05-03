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
    /**
     * 获取XML文件中的所有元素（标签）
     * @throws DocumentException
     * @throws IOException
     */
    @Test
    public void test1() throws DocumentException, IOException {
        // 1. 获取XML解析对象
        SAXReader reader = new SAXReader();

        // 2.解析XML 获取文档对象document
        String path = getClass().getResource("/Module02_xml.Dom4j_xml/user.xml").getPath();
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
        // 1. 获取XML解析对象
        SAXReader reader = new SAXReader();

        // 2.解析XML 获取文档对象document
        String path = getClass().getResource("/Module02_xml.Dom4j_xml/user.xml").getPath();
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
        // 1. 获取XML解析对象
        SAXReader reader = new SAXReader();

        // 2.解析XML 获取文档对象document
        String path = getClass().getResource("/Module02_xml.Dom4j_xml/book.xml").getPath();
        System.out.println(path);
        Document document = reader.read(path);

        Node node = document.selectSingleNode("/bookstore/book");
        System.out.println(node.getName());
    }
}
