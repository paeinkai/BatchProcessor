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
 * BatchProcessor.java: The main class which drives both the parsing of the batch file into commands
 * 	and the execution of those commands.
 */

import java.io.File;

public class BatchProcessor 
{
	
	public static Batch batch;
	
	
	public static void executeBatch() 
	{
	
	
	}
	
	public static void main(String[] args) 
	{
		String filename = null;
		if (args.length > 0)
		{
			filename = args[0];
		}
		else
		{
			filename = "work/batch1.dos.xml";
		}
		File batchfile = new File(filename);
		batch = BatchParser.buildBatch(batchfile);

	}

}
