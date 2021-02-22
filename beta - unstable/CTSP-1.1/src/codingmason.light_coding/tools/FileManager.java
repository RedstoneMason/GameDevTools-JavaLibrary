package codingmason.light_coding.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import codingmason.light_coding.wrappers.LList;

public class FileManager {
	public File file;
	public String contents;
	private LList<File> all = new LList<>();
	private LList<String> extFilter = new LList<>();
	
	public FileManager(File file) {
		if(!file.exists())
			return;
		this.file = file;
	}
	
	public File[] getChilderen(String... extensions) {
		dispose();
		extFilter.add(extensions);
		loadChilderen(file);
		File[] out = all.toArray(new File[] {});
		return out;
	}
	private void loadChilderen(File dir) {
		if(dir == null)
			return;
		if(!dir.isDirectory())
			return;
		File[] files = dir.listFiles();
		for(File f : files) {
			if(f.isDirectory()) {
				loadChilderen(f);
				continue;
			}
			String name = f.getName();
			if(!name.contains(".")) continue;
			String ext = name.substring(name.lastIndexOf(".")+1);
			if(extFilter.contains(ext) || extFilter.size() == 0)
				all.add(f);
		}
	}
	public void dispose() {
		extFilter.clear();
		all.clear();
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
			LList<String> lines = new LList<>();
			while(try_ < 32000) {
				try_++;
				String line = br.readLine();
				if(line != null)
					lines.add(line);
				else break;
			}
			String contents = "";
			for(String line : lines) {
				contents = contents + line + "\r";
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
