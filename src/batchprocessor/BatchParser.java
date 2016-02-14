package batchprocessor;

/*
 * CS 5348 - Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * Shiau Kang Wang (sxw160330)
 * Cheng Kai Huang (cxh152330)
 * Justin Fritcher (jrf130030)
 * 
 * BatchParser.java: Builds an instance of Batch containing the N Commands parsed from the XML
 * document provided in the batch file. The parser is responsible for visiting each of the XML 
 * elements in the given XML document and generating the correct Command subclass from the 
 * element. The actual parsing is delegated to the Command subclass. 
 */

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import batchprocessor.command.Command;

public class BatchParser 
{
	
	Batch buildBatch(File batchFile) 
	{
		Batch batch = null;
		try 
		{
			FileInputStream f_in = new FileInputStream(batchFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f_in);
			
			Element dNode = doc.getDocumentElement();
			NodeList nodes = dNode.getChildNodes();
			
			batch = new Batch(batchFile.getParent());
			for (int i = 0; i < nodes.getLength(); i++)
			{
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element elem = (Element) node;
					Command comm = buildCommand(elem);
					if (comm != null)
					{
						batch.addCommand(comm);
					}
					else
					{
						return null;
					}
				}
			}
			
					
			
		} catch (FileNotFoundException ex)
		{
			System.err.println("Unable to open file: " + batchFile.getName());
			ex.printStackTrace();
			
		} catch (ParserConfigurationException ex)
		{
			System.err.println("Error creating DocumentBuilder");
			ex.printStackTrace();
		} catch (IOException ex)
		{
			System.err.println("");
			ex.printStackTrace();
		} catch (SAXException ex)
		{
			System.err.println("");
			ex.printStackTrace();
		}
		
		
		return batch;
	}

	Command buildCommand(Element element)
	{
		return null;
	}
	
	
	
}
