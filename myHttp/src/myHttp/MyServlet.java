package myHttp;

/**
 * <p>servlet</p>请求基类
 * 所有请求都要继承这个基类
 * <code>doGet</code>和<doPost>方法根据需要进行重写,<code>service</code>一般不要去重写
 */

public abstract class MyServlet {

	//处理Get请求
	public abstract void doGet(MyRequest myRequest, MyResponse myResponse);
	//处理Post请求
	public abstract void doPost(MyRequest myRequest, MyResponse myResponse);
	
	public void service(MyRequest myRequest, MyResponse myResponse){
		
		//根据提交的请求执行响应的操作
		if(myRequest.getMethod().equalsIgnoreCase("POST"))
			doPost(myRequest, myResponse);
		else if(myRequest.getMethod().equalsIgnoreCase("GET"))
			doGet(myRequest, myResponse);
		
	}
}
