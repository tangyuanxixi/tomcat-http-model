package myHttp;

/**
 * <p>servlet</p>�������
 * ��������Ҫ�̳��������
 * <code>doGet</code>��<doPost>����������Ҫ������д,<code>service</code>һ�㲻Ҫȥ��д
 */

public abstract class MyServlet {

	//����Get����
	public abstract void doGet(MyRequest myRequest, MyResponse myResponse);
	//����Post����
	public abstract void doPost(MyRequest myRequest, MyResponse myResponse);
	
	public void service(MyRequest myRequest, MyResponse myResponse){
		
		//�����ύ������ִ����Ӧ�Ĳ���
		if(myRequest.getMethod().equalsIgnoreCase("POST"))
			doPost(myRequest, myResponse);
		else if(myRequest.getMethod().equalsIgnoreCase("GET"))
			doGet(myRequest, myResponse);
		
	}
}
