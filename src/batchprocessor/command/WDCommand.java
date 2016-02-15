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
 * WDCommand.java: Command subclass for the wd command, which sets the working directory
 * that the batch will execute within.
 */

import org.w3c.dom.Element;

import batchprocessor.BatchProcessor;
import batchprocessor.ProcessException;

public class WDCommand extends Command
{
	private String id;
	private String path;

	
	public WDCommand(Element element) throws ProcessException
	{
		parse(element);	
	}

	@Override
	public String describe() 
	{
		return "Working Directory: " + path;
		
	}
	
	@Override
	public void parse(Element element) throws ProcessException
	{
		id = element.getAttribute("id");
		if (id == null || id.isEmpty())
		{
			throw new ProcessException("Missing 'id' attribute in WD command");
		}
		System.err.println("ID: " + id);
		
		this.path = element.getAttribute("path");
		if (path == null)
		{
			path = "";
		}	
	}

	@Override
	public void execute(String workingDir) 
	{
		System.err.println(this.describe());
		BatchProcessor.batch.setWorkingDir(path);
	}		
}
