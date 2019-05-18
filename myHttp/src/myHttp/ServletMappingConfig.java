package myHttp;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>servlet</p>的配置文件，模拟web.xml下的请求映射
 * @author tangyuan
 *
 */
public class ServletMappingConfig {

	public static List<ServletMapping> servletMappingList = new ArrayList<>();
	
	static{
		//模拟配置文件
		/*
		 *  <servlet></servlet> 和 <servlet-mapping></servlet-mapping> 来进行指定哪个 URL 
		 *  交给哪个 servlet 进行处理。
		 * */
		servletMappingList.add(new ServletMapping("findhttp", "/myhttp", "myHttp.FindHttpServlet"));
		servletMappingList.add(new ServletMapping("findfavicon", "/favicon.ico", "myHttp.FindFavicon"));
	}
}
