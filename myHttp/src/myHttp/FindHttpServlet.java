package myHttp;

/**
 *<p>servlet</p>实现类，具体的请求过来应该怎么样处理 
 * @author tangyuan
 *
 */
public class FindHttpServlet extends MyServlet {

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {

		try {
			myResponse.write("<div><a href=\"https://www.ibm.com/cn-zh/?lnk=m\">请点我</a></div>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		
		try {
			myResponse.write("this is my HttpTest");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
