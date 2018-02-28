import java.util.HashMap;
import java.util.Map;

import com.unitmb.data.http.HttpUtil;

public class CodeTest {

	public static void main(String[] args) {
		
		String url = "https://www.toutiao.com/api/comment/list/?group_id=6469607077483381261&item_id=6469607077483381261&offset=0&count=1000";
		
		//Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
		//Accept-Encoding:gzip, deflate, br
		//Accept-Language:zh-CN,zh;q=0.9
		//Cache-Control:no-cache
		//Connection:keep-alive
		//Cookie:__tasessionId=hxw0mflb71519790671455; tt_webid=6527451362907768323
		//Host:www.toutiao.com
		//Pragma:no-cache
		//Upgrade-Insecure-Requests:1
		//User-Agent:Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36
				
		Map<String, String> propertys = new HashMap<String, String>();
		//propertys.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		//propertys.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36"); 
		
		System.out.println(new String(HttpUtil.getHttpByteData(HttpUtil.METHOD_GET, url, propertys)));
	}

}
