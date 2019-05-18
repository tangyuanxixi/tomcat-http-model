package myHttp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author tangyuan
 *
 */
public class MyTomcat {

	//默认8080端口
	private int port = 8080;
	private Map<String, String> urlServletMap = new HashMap<>();
	
	public MyTomcat(int port) {
		this.port = port;
	}
	//����
	public void start(){
		
		//��ʼ��URL���Ӧ�����servlet��Ӧ��ϵ
		initServltMapping();
		//socket����
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("myTomcat is start");
			while(true){
				//����Socket����
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				MyRequest myRequest = new MyRequest(inputStream);
				MyResponse myResponse = new MyResponse(outputStream);
				//����ַ�
				dispatch(myRequest, myResponse);
				//�ر�socket
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
			{
				try {
					serverSocket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	//���ݶ�Ӧ��url�ҵ���Ӧ���࣬���÷��䷽ʽִ��
	private void dispatch(MyRequest myRequest, MyResponse myResponse) {

		//���ݶ�Ӧ��url�Ҷ�Ӧ��
		String clazz = urlServletMap.get(myRequest.getUrl());
		
		try {
			//���ݷ�������ʵ��
			@SuppressWarnings("unchecked")
			Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
			MyServlet myServlet = myServletClass.newInstance();
			//ʵ�����÷���
			myServlet.service(myRequest, myResponse);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	private void initServltMapping() {
		//url��Ӧ�Ĵ�����
		for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
			
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
		
	}
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
	
}
