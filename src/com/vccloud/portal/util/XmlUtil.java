package com.vccloud.portal.util;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {

	private static Map<String, Document> docs = new ConcurrentHashMap<String, Document>();

	public static Document getDocument(String filePath) throws Exception {
		Document doc = docs.get(filePath);
		if (doc == null) {
			File file = new File(filePath);
			SAXReader saxReader = new SAXReader();
			saxReader.setEncoding("utf-8");
			doc = saxReader.read(file);
		}
		if (doc == null) {
			throw new Exception("Warning: filePath invalid.");
		} else {
			docs.put(filePath, doc);
			return doc;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Element> getRootElements(String filePath)
			throws Exception {
		Document doc = getDocument(filePath);
		Element root = doc.getRootElement();
		List<Element> elements = root.elements();
		return elements;
	}

}
