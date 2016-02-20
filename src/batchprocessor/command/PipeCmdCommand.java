package batchprocessor.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import batchprocessor.Batch;
import batchprocessor.BatchParser;
import batchprocessor.ProcessException;

/*
 * CS 5348 - Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * Shiau Kang Wang (sxw160330)
 * Cheng Kai Huang (cxh152330)
 * Justin Fritcher (jrf130030)
 * 
 * PipeCmdCommand.java: Command subclass for the two cmd commands for a PipeCommand
 */

public class PipeCmdCommand extends Command 
{
	private final int SIZE = 2;
	private int idx = 0;
	private String path[] = new String[SIZE];
	private String args[] = new String[SIZE];
	private String in_file[] = new String[SIZE];
	private String out_file[] = new String[SIZE];
	
	public PipeCmdCommand(Element element) throws ProcessException 
	{
		parse(element);
	}
	
	@Override
	public String describe() 
	{
		return null;
	}

	@Override
	public void parse(Element element) throws ProcessException
	{
		NodeList nodes = element.getChildNodes();
		System.out.println("node size:"+nodes.getLength());
		for (int i = 0; i < nodes.getLength(); i++)
		{
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element elem = (Element) node;
				id = elem.getAttribute("id");
				if (id == null || id.isEmpty()) {
					throw new ProcessException("Missing 'id' attribute in PIPE CMD command");
				}
				path[idx] = elem.getAttribute("path");
				if (path[idx] == null || path[idx].isEmpty()) {
					throw new ProcessException("Missing 'path' attribute in PIPE CMD command");
				}
				
				args[idx] = elem.getAttribute("args");
				in_file[idx] = elem.getAttribute("in");
				out_file[idx] = elem.getAttribute("out");
				idx++;
			}
		}	
	}

	@Override
	public void execute(Batch batch) throws ProcessException
	{
		System.out.println("execute PipeCmdCommand");
//		idx = 0;
		List<String> command = new ArrayList<String>();
		
		command.add(path[idx]);
		for (String s : args[idx].split(" "))
		{
			if (!s.isEmpty())
			{
				command.add(s);
			}
		}
		ProcessBuilder procBuilder = new ProcessBuilder();
		procBuilder.command(command);
		procBuilder.directory(new File(batch.getWorkingDir()));
		
		if (!(in_file[0] == null || in_file[0].isEmpty()))
		{
			if (!(out_file[1] == null || out_file[1].isEmpty()))
			{
				if(batch.getCommands().containsKey(in_file[0]))
				{
					if(batch.getCommands().containsKey(out_file[1]))
					{
						try
						{
							File stdin = new File(procBuilder.directory(),((FileCommand)batch.getCommands().get(in_file[0])).getPath());
							final Process process = procBuilder.start();
							OutputStream os = process.getOutputStream();
							FileInputStream fis = new FileInputStream(stdin);
							copyStreams(fis, os);
							
							File stdout = new File(procBuilder.directory(),((FileCommand)batch.getCommands().get(out_file[1])).getPath());
							FileOutputStream fos = new FileOutputStream(stdout);
							InputStream is = process.getInputStream();
							copyStreams(is, fos);
						
						}
						catch (Exception ex)
						{
							throw new ProcessException("Error loading IN file from FileCommand with id '" + in_file[idx] + ".");
						}
					}
				}
				else
				{
					throw new ProcessException("Unable to locate IN FileCommand with id '" + in_file[idx] + ".");
				}
			}
		}
		
		/*
//		idx++;
		if (!(out_file[idx] == null || out_file[idx].isEmpty()))
		{
			try 
			{
				if(batch.getCommands().containsKey(out_file[idx]))
				{
					File stdout = new File(procBuilder.directory(),((FileCommand)batch.getCommands().get(out_file[idx])).getPath());
					fos = new FileOutputStream(stdout);
					InputStream is = process.getInputStream();
					copyStreams(is, fos);
				}
				else
				{

					throw new ProcessException("Unable to locate OUT FileCommand with id '" + out_file[idx] + ".");
				}
			}
			catch(Exception ex) {
				throw new ProcessException("Error creating and running output process:"+ ex.getMessage());
			}
		}
//		try
//		{
//			Process process = procBuilder.start();
//			process.waitFor();
//		}
//		catch (Exception ex)
//		{
//			throw new ProcessException("Error creating and running process: " + ex.getMessage());
//		}
		*/
	}
	
	static void copyStreams(final InputStream is, final OutputStream os) {
		Runnable copyThread = (new Runnable() {
			@Override
			public void run()
			{
				try {
					int achar;
					while ((achar = is.read()) != -1) {
						os.write(achar);
					}
					os.close();
				}
				catch (IOException ex) {
					throw new RuntimeException(ex.getMessage(), ex);
				}
			}
		});
		new Thread(copyThread).start();
	}
}
