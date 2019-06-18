package edu.javaExtra;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JavaExtra {

	boolean ls;
	boolean named;
	boolean sized;
	boolean directory;
	boolean height;
	boolean format;
	boolean help;
	boolean reverse;
	String path = "data";

	public void run(String[] args) {
		// TODO Auto-generated method stub

		Options options = createOptions();
		File[] files;
		// args = -ls -s -n -d -h
		if (parseOptions(options, args)) {

			if (ls) {
				System.out.println("\n=====Basic ls Function====\n");
				FileReader fr = new FileReader(path); // basic ls function
				files = fr.getFiles();

				if (named) {
					System.out.println("\n========named_sorted=======\n");

					TreeMap<String, File> namedMap = new TreeMap<String, File>();
					String nameKey = "";
					for (File f1 : files) {
						nameKey = f1.getName();
						namedMap.put(nameKey, f1);
						nameKey = "";
					}

					Iterator<String> treeMapIter = namedMap.keySet().iterator();

					while (treeMapIter.hasNext()) {
						String key = treeMapIter.next();
						File f1 = namedMap.get(key);

						System.out.println(f1.getName());

					}
				}

				if (reverse) {
					System.out.println("\n======reversed_sorted=======\n");
					TreeMap<String, File> reversedMap = new TreeMap<String, File>(Collections.reverseOrder());
					String nameKey = "";
					for (File f1 : files) {
						nameKey = f1.getName();
						reversedMap.put(nameKey, f1);
						nameKey = "";
					}

					Iterator<String> treeMapIter = reversedMap.keySet().iterator();

					while (treeMapIter.hasNext()) {
						String key = treeMapIter.next();
						File f1 = reversedMap.get(key);

						System.out.println(f1.getName());

					}
				}

				if (sized) {
					System.out.println("\n========sized_sorted======\n");
					TreeMap<String, File> sortedMap = new TreeMap<String, File>();

					String sizeKey = "";
					for (File f1 : files) {
						sizeKey = sizeKey + f1.length();
						sortedMap.put(sizeKey, f1);
						sizeKey = "";
					}

					for (String tempKey : sortedMap.keySet()) {
						System.out.println(sortedMap.get(tempKey).getName() + " \t " + tempKey + "bytes");
					}

				}

				if (directory) {
					System.out.println("\n=========All Files=========\n");

					fr.subDirList(path);
				}

				if (help) {

					System.out.println("\n========Help_Manual========\n");
					printHelp(options);
					System.exit(0);
					return;
				}
			} else {
				printHelp(options);
				System.exit(0);
				return;
			}

		}

	}

	private Options createOptions() {

		// 명령 구현
		// 기본 ls
		// 도움말
		// 디렉토리 전체 출력
		// 용량순으로 출력
		// 이름 순으로 출력
		Options options = new Options();

		options.addOption(Option.builder("ls").longOpt("List")
				.desc("lists all files in the given directory, including those whose names start with \".\" ")
				.argName("list files")
				// .required()
				.build()); // 전체 ls

		options.addOption(Option.builder("s").longOpt("sized_sort").desc("Sort by File size and show files")
				.argName("sort by size")
				// .required()
				.build()); // 용량별로 정

		options.addOption(Option.builder("r").longOpt("reversed_sort")
				.desc("Sort by File name in reverse and show files").argName("sort by name")
				// .required()
				.build()); // 이름 역순으로 정

		options.addOption(Option.builder("n").longOpt("named_sort").desc("Sort by File name and show files")
				.argName("sort by name")
				// .required()
				.build()); // 이름순으로 정

		options.addOption(Option.builder("d").longOpt("all-directory").desc("list all files in source")
				.argName("all files in source")
				// .required()
				.build()); // 디렉토리 출

		options.addOption(Option.builder("h").longOpt("help").desc("show a help Page").argName("Path name to display")
				// .required()
				.build()); // 도움

		return options;
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);

			ls = cmd.hasOption("ls");
			named = cmd.hasOption("n");
			sized = cmd.hasOption("s");
			directory = cmd.hasOption("d");
			help = cmd.hasOption("h");
			reverse = cmd.hasOption("r");
		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private void printHelp(Options options) {
		// TODO Auto-generated method stub
		HelpFormatter formatter = new HelpFormatter();
		String header = "Java Extra Project";
		String footer = "";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}

}
