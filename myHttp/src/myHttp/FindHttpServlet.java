package myHttp;

/**
 *<p>servlet</p>ʵ���࣬������������Ӧ����ô������ 
 * @author tangyuan
 *
 */
public class FindHttpServlet extends MyServlet {

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {

		try {
			myResponse.write("<div><a href=\"https://www.ibm.com/cn-zh/?lnk=m\">�����</a></div>");
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
