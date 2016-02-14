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

public class FileCommand extends Command
{

	public FileCommand(Element element)
	{
		parse(element);
	}
	
	@Override
	public String describe() 
	{
		return null;
	}
	
	@Override
	public void parse(Element element) 
	{
		
	}
	
	@Override
	public void execute(String workingDir) 
	{
		
	}

}
