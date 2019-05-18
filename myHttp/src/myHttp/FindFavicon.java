package myHttp;

/**
 * 这个类主要是为了解决谷歌浏览器的那个小图标问题
 * 在谷歌浏览器中没有不加载小图标会报错
 * @author tangyuan
 *
 * 2019年5月18日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class FindFavicon extends MyServlet{

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {

		try {
			myResponse.write("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		
		try {
			myResponse.write("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
