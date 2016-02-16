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
 * CmdCommand.java: Command subclass for the cmd command, which defines a command
 * that will be executed in a process.
 */

import org.w3c.dom.Element;

import batchprocessor.BatchProcessor;
import batchprocessor.ProcessException;

public class CmdCommand extends Command 
{

	private String path;
	private String args;
	private String in;
	private String out;
	
	public CmdCommand(Element element) throws ProcessException
	{
		parse(element);
	}
	
	@Override
	public String describe() 
	{
		return "Command: " + path;
	}
	
	@Override
	public void parse(Element element) throws ProcessException
	{
		id = element.getAttribute("id");
		if (id == null || id.isEmpty())
		{
			throw new ProcessException("Missing 'id' attribute in CMD command");
		}
		
		path = element.getAttribute("path");
		if (path == null || path.isEmpty())
		{
			throw new ProcessException("Missing 'path' attribute in CMD command");
		}
		
		args = element.getAttribute("args");	
		in = element.getAttribute("in");
		out = element.getAttribute("out");

	}
	
	@Override
	public void execute(String workingDir) 
	{
		//  = BatchProcessor.batch.getCommands().get(in);
		
		
		ProcessBuilder procBuilder = new ProcessBuilder();
		
		
		
	}

}
