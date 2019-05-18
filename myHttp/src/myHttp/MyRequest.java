package myHttp;

import java.io.IOException;
import java.io.InputStream;

//封装请求对象
public class MyRequest {

	//请求地址
	private String url;
	//请求方法
	private String method;
	
	/*
	 * 
	 	GET /favicon.icon HTTP/1.1
	 	Accept : /*	
		Accept-Encoding	:gzip, deflate
		Connection : keep-alive
		Host: localhost:8080
		User-Agent:Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/66.0
	 * */
	public MyRequest(InputStream inputStream) throws IOException {

		String httpRequest = "";
		byte[] httpRequestBytes = new byte[1024];
		int length = 0;
		if((length = inputStream.read(httpRequestBytes)) > 0)
		{
			httpRequest = new String(httpRequestBytes, 0, length);
		}
		//解析得到头部信息 GET /favicon.icon HTTP/1.1
		String httpHead = httpRequest.split("\n")[0];
		//获得 url favicon 
		url = httpHead.split("\\s")[1];
		//获得请求方法		
		method = httpHead.split("\\s")[0];
		System.out.println(this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "MyRequest [url=" + url + ", method=" + method + "]";
	}
	
}
