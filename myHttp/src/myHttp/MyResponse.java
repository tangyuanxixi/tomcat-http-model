package myHttp;

import java.io.IOException;
import java.io.OutputStream;

//封装响应对象
public class MyResponse {

	//输出流
	private OutputStream outputStream;
	
	public MyResponse(OutputStream outputStream) {

		this.outputStream = outputStream;
	}
	
	public void write(String content) throws IOException{
		
		/*
		 * 响应协议,最基本
		 * HTTP/2.0 200 OK
		 * Content-Type: text/html
		 * 
		 * “空行”
		 * <html><head></head><body></body></html>
		 * */
		
		StringBuffer httpResponse = new StringBuffer();
		httpResponse.append("HTTP/2.0 200 OK\n")
					.append("Content-Type: text/html\n")
					.append("\r\n")
					.append("<html><head></head><body>")
					.append(content)
					.append("</body></html>");
		//转为二进制传输
		System.out.println(httpResponse.toString());
		outputStream.write(httpResponse.toString().getBytes());
		outputStream.close();
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
}
