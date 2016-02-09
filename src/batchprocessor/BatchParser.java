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

import java.io.File;

import org.w3c.dom.Element;

import batchprocessor.command.Command;

public class BatchParser 
{
	
	Batch buildBatch(File batchFile) 
	{
		return null;
	}

	Command buildCommand(Element element)
	{
		return null;
	}
	
	
	
}
