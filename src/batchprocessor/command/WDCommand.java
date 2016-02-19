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

import java.nio.file.Files;
import java.nio.file.Paths;

import org.w3c.dom.Element;

import batchprocessor.Batch;
import batchprocessor.ProcessException;

public class WDCommand extends Command
{
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
		
		path = element.getAttribute("path");
		if (path == null)
		{
			path = "";
		}	
	}

	@Override
	public void execute(Batch batch) throws ProcessException
	{		
		if (Files.exists(Paths.get(path)))
		{
			batch.setWorkingDir(path);
		}
		else
		{
			throw new ProcessException("Unable to locate or open directory '" + path + "'.");
		}
	}		
}
