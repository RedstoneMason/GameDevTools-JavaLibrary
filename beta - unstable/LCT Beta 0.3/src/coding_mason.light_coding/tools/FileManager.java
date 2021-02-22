package coding_mason.light_coding.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import coding_mason.light_coding.wrappers.LWArray;

public class FileManager {
	public File file;
	public String contents;
	
	public FileManager(File file) {
		if(!file.exists()) {
			return;
		}
		if(!file.isFile()) {
			return;
		}
	}
	public void save() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			String[] lines = contents.split("\r|\n");
			for(String line : lines)
				pw.println(line);
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int try_ = 0;
			LWArray<String> lines = new LWArray<>();
			while(try_ < 32000) {
				try_++;
				String line = br.readLine();
				if(line != null)
					lines.add(line);
				else break;
			}
			String contents = "";
			for(Object line : lines.values()) {
				contents = contents + (String)line + "\r";
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
