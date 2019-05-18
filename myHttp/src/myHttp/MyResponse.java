package myHttp;

import java.io.IOException;
import java.io.OutputStream;

//��װ��Ӧ����
public class MyResponse {

	//�����
	private OutputStream outputStream;
	
	public MyResponse(OutputStream outputStream) {

		this.outputStream = outputStream;
	}
	
	public void write(String content) throws IOException{
		
		/*
		 * ��ӦЭ��,�����
		 * HTTP/2.0 200 OK
		 * Content-Type: text/html
		 * 
		 * �����С�
		 * <html><head></head><body></body></html>
		 * */
		
		StringBuffer httpResponse = new StringBuffer();
		httpResponse.append("HTTP/2.0 200 OK\n")
					.append("Content-Type: text/html\n")
					.append("\r\n")
					.append("<html><head></head><body>")
					.append(content)
					.append("</body></html>");
		//תΪ�����ƴ���
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
