package batchprocessor.command;

/*
 * CS 5348 - Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * Shiau Kang Wang (sxw160330)
 * Cheng Kai Huang (cxh152330)
 * Justin Fritcher (jrf130030)
 * 
 * FileCommand.java: Command subclass for the file command, which identifies the path
 * to a file contained in the batch's working directory
 */


import org.w3c.dom.Element;

import batchprocessor.Batch;
import batchprocessor.ProcessException;

public class FileCommand extends Command
{
	private String path;

	public FileCommand(Element element) throws ProcessException
	{
		parse(element);
	}
	
	@Override
	public String describe() 
	{
		return "File command: " + path; 
	}
	
	@Override
	public void parse(Element element) throws ProcessException
	{
		id = element.getAttribute("id");
		if (id == null || id.isEmpty())
		{
			throw new ProcessException("Missing 'id' attribute in FILE command");
		}
		path = element.getAttribute("path");
		if (path == null || path.isEmpty())
		{
			throw new ProcessException("Missing 'path' attribute in FILE command");
		}
	}
	
	@Override
	public void execute(Batch batch) 
	{

	}
	
	public String getPath()
	{	
		return path;
	}

}
