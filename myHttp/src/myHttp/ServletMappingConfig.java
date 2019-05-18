package myHttp;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>servlet</p>�������ļ���ģ��web.xml�µ�����ӳ��
 * @author tangyuan
 *
 */
public class ServletMappingConfig {

	public static List<ServletMapping> servletMappingList = new ArrayList<>();
	
	static{
		//ģ�������ļ�
		/*
		 *  <servlet></servlet> �� <servlet-mapping></servlet-mapping> ������ָ���ĸ� URL 
		 *  �����ĸ� servlet ���д���
		 * */
		servletMappingList.add(new ServletMapping("findhttp", "/myhttp", "myHttp.FindHttpServlet"));
		servletMappingList.add(new ServletMapping("findfavicon", "/favicon.ico", "myHttp.FindFavicon"));
	}
}
