import java.util.*;
public class Solution535 {
	public class Codec {
		HashMap<Integer,Character>dict;
		HashMap<String,String>urls;
		// Encodes a URL to a shortened URL.
		public Codec(){
			dict=new HashMap<Integer,Character>();
			urls=new HashMap<String, String>();
			char c='0';
			int i=0;
			for (i=0; i<=9; i++){
				dict.put(i,c);
				c++;
			}
			c='a';
			while (c<='z'){
				dict.put(i,c);
				c++;
				i++;
			}
			c='A';
			while (c<='Z'){
				dict.put(i,c);
				c++;
				i++;
			}
		}
		public String encode(String url) {
			StringBuilder tmp=new StringBuilder();
			tmp.append("http://tinyurl.com/");
			for (int i=1; i<=6; i++){
				int x=(i*url.length())%62;
				char c=dict.get(x);
				tmp.append(c);
			}
			String shortenedurl=tmp.toString();
			if (urls.containsKey(shortenedurl)) return shortenedurl;
			urls.put(shortenedurl, url);
			return shortenedurl;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			return urls.get(shortUrl);
		}
	}
}
