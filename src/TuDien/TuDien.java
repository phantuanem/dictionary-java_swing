package TuDien;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import search.word;

public class TuDien {
	private int M = 39367;
	private ArrayList<Tu> dsTu[];
	
	public TuDien() {
		this.dsTu = new ArrayList[this.M + 1];
		for(int i=0;i<this.M + 1;i++) {
			this.dsTu[i] = new ArrayList<>();
		}
		int tongsotu = 0;
		File file = new File("D:\\java\\Dictionary\\src\\TuDien\\anhviet109K.txt");
		try {
			List<String> conText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			String str = new String("");
			String tienganh = new String("");
			String tuloai = new String("");
			for(String line: conText) {
				if(line.length() > 0) {
					char firstChar = line.charAt(0);
					if(firstChar != '@' && firstChar != '?') {
						if(firstChar == '*') {
							tuloai = line.substring(3, line.length());
						} else {
							str = str + "<br>" + line;
						}
					} else if(firstChar == '@' && firstChar != '?' && line.indexOf(" ") >= 0) {
						if(str.length() > 0) {
							Tu w = new Tu(tienganh, tuloai, str);
							String ta = new String(w.layTiengAnh());
							int k = 0;
							for(int i=0;i<ta.length();i++) {
								char c = ta.charAt(i);
								k += ((int)c) * (i+1);
							}
							int ma_bam = this.bam(k);
							this.dsTu[ma_bam].add(w);
							tongsotu++;
						}
						str = line.substring(1, line.length());
						tienganh = new String("");
						tuloai = new String("");
						tienganh = str.substring(0, str.indexOf(" "));
					} else {
						str = "";
						tienganh = "";
						tuloai = "";
					}
				}				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		//System.out.println(tongsotu);
	}
	
	public int bam(int key) {
		int bam = key % this.M;
		while(bam >= this.M) {
			bam = bam % this.M;
		}
		return bam;
	}
	
	public Tu timKiem(String ta) {
		Tu w = new Tu();
		Boolean ok = false;
		int k = 0;
		for(int i=0;i<ta.length();i++) {
			char c = ta.charAt(i);
			k += ((int)c) * (i+1);
		}
		int ma_bam = this.bam(k);
		for(int i=0;i<this.dsTu[ma_bam].size();i++){
			if(this.dsTu[ma_bam].get(i).layTiengAnh().equals(ta)) {
				w = new Tu(this.dsTu[ma_bam].get(i));
				ok = true;
			}
		}
		return w;
	}
}
