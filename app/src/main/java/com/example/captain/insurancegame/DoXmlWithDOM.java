package com.example.captain.insurancegame;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;

import android.content.res.Configuration;
import android.util.Log;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by captain on 2018/5/11.
 */

public class DoXmlWithDOM {


    public  void runparse(){
        File file=new File("app/src/main/res/values/strings.xml");
        (new DoXmlWithDOM()).readXML(file);
    }
    public  static void main(String []args){
        (new DoXmlWithDOM()).runparse();

    }

    public void readXML(File file){
        try{

            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Element element=doc.getDocumentElement();
            NodeList nl=doc.getElementsByTagName("resources");
            Node node=doc.getElementsByTagName("string").item(2).getFirstChild();
            String s=node.getNodeValue();
            node.setNodeValue("asdasda");
            s=node.getNodeValue();
            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer former=tf.newTransformer();
            DOMSource xmlSource=new DOMSource(doc);
            StreamResult outputTarget=new StreamResult(new File("app/src/main/res/values/strings.xml"));
            former.transform(xmlSource,outputTarget);






        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        }catch(SAXException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(TransformerConfigurationException te){
            te.printStackTrace();
        }catch(TransformerException e){
            e.printStackTrace();
        }
}

//    public void listAllChildNodes(Node node,int level){
//        if(node.getNodeType()==Node.ELEMENT_NODE){
//        boolean hasTextChild=false;
//        String  levelspace="";
//        for (int i=0;i<level;i++) {
//            levelspace += "    ";
//        }
//        System.out.print(levelspace+"<"+node.getNodeName()+(node.hasAttributes()?" ":">"));
//        if(node.hasAttributes()){
//            NamedNodeMap nnmap=node.getAttributes();
//        for(int i=0;i<nnmap.getLength();i++){
//        System.out.print(nnmap.item(i).getNodeName()+"=\""+nnmap.item(i).getNodeValue()+"\""+
//                (i==(nnmap.getLength()-1)?"":" "));}
//            System.out.print(">");
//        }
//
//            if (node.hasChildNodes()) {
//                level++;// 有下一级子节点,层次加1,新的层次表示的是这个子节点的层次(递归调用时传给了它)
//                // 获得所有的子节点列表
//                NodeList nodelist = node.getChildNodes();
//                // 循环遍历取到所有的子节点
//                for (int i = 0; i < nodelist.getLength(); i++) {
//                    // Ⅳ❹❶【有效文本子节点】子节点为TextNode类型,并且包含的文本内容有效
//                    if (nodelist.item(i).getNodeType() == Node.TEXT_NODE
//                            && (!nodelist.item(i).getTextContent()
//                            .matches("\\s+"))) {// 用正则选取内容包含非空格的有效字符的文本节点
//                        hasTextChild = true;// 该ElementNode的一级子节点是存在有效字符的文本节点
//                        System.out.print(nodelist.item(i).getTextContent());// 在开始标签后面添加文本内容
//                        // Ⅳ❹❷【ElementNode子节点】子节点是正常的ElementNode的处理
//                    } else if (nodelist.item(i).getNodeType() == Node.ELEMENT_NODE) {
//                        System.out.println();
//                        // 递归调用方法 - 以遍历该节点下面所有的子节点
//                        listAllChildNodes(nodelist.item(i), level);// level表示该节点处于第几个层次(相应空格)
//                    }
//                }
//                level--;// 遍历完所有的子节点,层次变量随子节点的层数,依次递减,回归到该节点本身的层次
//                // level++ 和 level--对于该节点的子节点影响的是子节点的初值
//            }
//            // Ⅴ❺【打印 - 结束标签】打印元素的结束标签.如果它的第一个一级子节点是有效文本的话,文本和结束标签添加到开始标签后面,
//            // 层次什么的就作废用不上了,否则,才按层次打印结束标签.
//            System.out.print(((hasTextChild) ? "" : "\n" + levelspace) + "</"
//                    + node.getNodeName() + ">");
//        }
//
//    }
public void listAllChildNodes(Node node,int level){
    if(node.getNodeType()==Node.ELEMENT_NODE){
        boolean hasTextChild=false;
        String  levelspace="";
        for (int i=0;i<level;i++) {
            levelspace += "    ";
        }
        System.out.print(levelspace+"<"+node.getNodeName()+(node.hasAttributes()?" ":">"));
        if(node.hasAttributes()){
            NamedNodeMap nnmap=node.getAttributes();
            for(int i=0;i<nnmap.getLength();i++){
                System.out.print(nnmap.item(i).getNodeName()+"=\""+nnmap.item(i).getNodeValue()+"\""+
                        (i==(nnmap.getLength()-1)?"":" "));}
            System.out.print(">");
        }

        if (node.hasChildNodes()) {
            level++;// 有下一级子节点,层次加1,新的层次表示的是这个子节点的层次(递归调用时传给了它)
            // 获得所有的子节点列表
            NodeList nodelist = node.getChildNodes();
            // 循环遍历取到所有的子节点
            for (int i = 0; i < nodelist.getLength(); i++) {
                // Ⅳ❹❶【有效文本子节点】子节点为TextNode类型,并且包含的文本内容有效
                if (nodelist.item(i).getNodeType() == Node.TEXT_NODE
                        && (!nodelist.item(i).getTextContent()
                        .matches("\\s+"))) {// 用正则选取内容包含非空格的有效字符的文本节点
                    hasTextChild = true;// 该ElementNode的一级子节点是存在有效字符的文本节点
                    System.out.print(nodelist.item(i).getTextContent());// 在开始标签后面添加文本内容
                    // Ⅳ❹❷【ElementNode子节点】子节点是正常的ElementNode的处理
                } else if (nodelist.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println();
                    // 递归调用方法 - 以遍历该节点下面所有的子节点
                    listAllChildNodes(nodelist.item(i), level);// level表示该节点处于第几个层次(相应空格)
                }
            }
            level--;// 遍历完所有的子节点,层次变量随子节点的层数,依次递减,回归到该节点本身的层次
            // level++ 和 level--对于该节点的子节点影响的是子节点的初值
        }
        // Ⅴ❺【打印 - 结束标签】打印元素的结束标签.如果它的第一个一级子节点是有效文本的话,文本和结束标签添加到开始标签后面,
        // 层次什么的就作废用不上了,否则,才按层次打印结束标签.
        System.out.print(((hasTextChild) ? "" : "\n" + levelspace) + "</"
                + node.getNodeName() + ">");
    }

}

}

