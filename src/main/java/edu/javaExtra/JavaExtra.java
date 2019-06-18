package edu.javaExtra;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JavaExtra {

	String lists;
	String allFile;
	String longFormat;
	String directory;
	String height;
	String format;	
	boolean help;
	String path;
	
	public void run(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	private Options createOptions() {

		Options options = new Options();

		options.addOption(Option.builder("a").longOpt("allFile")
				.desc("lists all files in the given directory, including those whose names start with \".\" ")
				.hasArg()
				.argName("list all files")
				.required()
				.build());
		
		options.addOption(Option.builder("f").longOpt("format")
				.desc("do not sort. Useful for directories containing large numbers of files.")
				.hasArg()
				.argName("display format")
				.required()
				.build());
		
		options.addOption(Option.builder("l").longOpt("longformat")
				.desc("long format, displaying Unix file types, permissions, number of hard links, owner, group, size, last-modified date and filename")
				.hasArg()
				.argName("display Information")
				.required()
				.build());
		
		options.addOption(Option.builder("d").longOpt("directory")
				.desc("Set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		
		options.addOption(Option.builder("h").longOpt("height")
				.desc("print sizes in human readable format. ")
				.hasArg()
				.argName("print the size")
				.required()
				.build());
		
		options.addOption(
				Option.builder("hp").longOpt("help").desc("Show a Help page").argName("Path name to display").build());

		

		
		return options;
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);

		//	inputPath = cmd.getOptionValue("i");
		//	outputPath = cmd.getOptionValue("o");
		//	help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private void printHelp(Options options) {
		// TODO Auto-generated method stub
		HelpFormatter formatter = new HelpFormatter();
		String header = "Java Final Project";
		String footer = "";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
	
}
