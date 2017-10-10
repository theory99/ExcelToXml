package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	
	public static void main(String[] args) throws IOException {
		String url = "http://www.366tax.cn:8091/dzfpkp/skfw.htm";
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
				+ "<interface version=\"1.0\">"
				+ "<globalInfo>"
				+ "<appId>DZFPQZ</appId>"
				+ "<interfaceId></interfaceId>"
				+ "<interfaceCode>FPKJ</interfaceCode>"
				+ "<requestCode>test</requestCode>"
				+ "<requestSecret>4cdbc040657a4847b2667e31d9e2c3d9</requestSecret>"
				+ "<requestTime>2017-10-10 10:00:00</requestTime>"
				+ "<responseCode>DZFPQZ</responseCode>"
				+ "<dataExchangeId>QYERPDZFPQZ20160326000000001</dataExchangeId>"
				+ "</globalInfo>"
				+ "<Data>"
				+ "<dataDescription>"
				+ "<zipCode>0</zipCode>"
				+ "</dataDescription>"
				+ "<content>"
				+ "IDxSRVFVRVNUX0NPTU1PTl9GUEtKIGNsYXNzPSJSRVFVRVNUX0NPTU1PTl9GUEtKIj4KICAgIDxGUFFRTFNIPmNzd2Z6MDk1ODI1PC9GUFFRTFNIPgo8S1BMWD4wPC9LUExYPgo8Qk1CX0JCSD4xMy4wPC9CTUJfQkJIPgo8WlNGUz4wPC9aU0ZTPgo8WFNGX05TUlNCSD45MTMzMDIyNzE0NDQwMDAwNUU8L1hTRl9OU1JTQkg+CiAgICA8WFNGX01DPuWugeazoumTtuihjDwvWFNGX01DPgo8WFNGX0RaREg+6ZSA5ZSu5pa55Zyw5Z2A44CB55S16K+dPC9YU0ZfRFpESD4KPFhTRl9ZSFpIPumUgOWUruaWuemTtuihjOi0puWPtzwvWFNGX1lIWkg+CjxHTUZfTlNSU0JIPjMzMDMyNzE5OTExMTA2MDQxNDwvR01GX05TUlNCSD4KICAgIDxHTUZfTUM+5Liq5Lq6XzE8L0dNRl9NQz4KICAgIDxHTUZfRFpESD7otK3kubDmlrnlnLDlnYDjgIHnlLXor508L0dNRl9EWkRIPgogICAgPEdNRl9ZSFpIPui0reS5sOaWuemTtuihjOi0puWPtzwvR01GX1lIWkg+CjxHTUZfU0pIPjEzNzM2MTA4NTI2PC9HTUZfU0pIPgo8R01GX0RaWVg+NDYzMjYxMzc1QHFxLmNvbTwvR01GX0RaWVg+CiAgICA8S1BSPmtwcjwvS1BSPgogICAgPFNLUj5za3I8L1NLUj4KPEZIUj5maHI8L0ZIUj4gICAgCiAgICA8WUZQX0RNPjwvWUZQX0RNPgogICAgPFlGUF9ITT48L1lGUF9ITT4KICAgIDxKU0hKPjEwPC9KU0hKPgo8SEpKRT45LjAxPC9ISkpFPgo8SEpTRT4wLjk5PC9ISlNFPgo8S0NFPjwvS0NFPgogICAgPEJaPua1i+ivlTEyMzwvQlo+CiAgPENPTU1PTl9GUEtKX1hNWFhTIGNsYXNzPSJDT01NT05fRlBLSl9YTVhYIiBzaXplPSIxIj4KICAgIDxDT01NT05fRlBLSl9YTVhYPgogICAgICA8RlBIWFo+MDwvRlBIWFo+CiAgICAgIDxTUEJNPjwvU1BCTT4gIAogICAgICA8WlhCTT48L1pYQk0+ICAgCiAgICAgIDxZSFpDQlM+PC9ZSFpDQlM+CiAgICAgIDxMU0xCUz48L0xTTEJTPgogICAgICA8WlpTVFNHTD48L1paU1RTR0w+IAogICAgICA8WE1NQz7mtYvor5XllYblk4E8L1hNTUM+CiAgICAgIDxHR1hIPjwvR0dYSD4KICAgICAgPERXPjwvRFc+CiAgICAgIDxYTVNMPjE8L1hNU0w+CiAgICAgIDxYTURKPjkuMDE8L1hNREo+CiAgICAgIDxYTUpFPjkuMDE8L1hNSkU+CiAgICAgIDxTTD4wLjExPC9TTD4KICAgICAgPFNFPjAuOTk8L1NFPgogICAgPC9DT01NT05fRlBLSl9YTVhYPgogIDwvQ09NTU9OX0ZQS0pfWE1YWFM+CjwvUkVRVUVTVF9DT01NT05fRlBLSj4="
				+ "</content>"
				+ "</Data>"
				+ "</interface>";
		dopostXmlStr(url,xml);
	}
// <REQUEST_COMMON_FPKJ class="REQUEST_COMMON_FPKJ">
//    <FPQQLSH>cswfz095825</FPQQLSH>
//<KPLX>0</KPLX>
//<BMB_BBH>13.0</BMB_BBH>
//<ZSFS>0</ZSFS>
//<XSF_NSRSBH>91330227144400005E</XSF_NSRSBH>
//    <XSF_MC>宁波银行</XSF_MC>
//<XSF_DZDH>销售方地址、电话</XSF_DZDH>
//<XSF_YHZH>销售方银行账号</XSF_YHZH>
//<GMF_NSRSBH>330327199111060414</GMF_NSRSBH>
//    <GMF_MC>个人_1</GMF_MC>
//    <GMF_DZDH>购买方地址、电话</GMF_DZDH>
//    <GMF_YHZH>购买方银行账号</GMF_YHZH>
//<GMF_SJH>13736108526</GMF_SJH>
//<GMF_DZYX>463261375@qq.com</GMF_DZYX>
//    <KPR>kpr</KPR>
//    <SKR>skr</SKR>
//<FHR>fhr</FHR>    
//    <YFP_DM></YFP_DM>
//    <YFP_HM></YFP_HM>
//    <JSHJ>10</JSHJ>
//<HJJE>9.01</HJJE>
//<HJSE>0.99</HJSE>
//<KCE></KCE>
//    <BZ>测试123</BZ>
//  <COMMON_FPKJ_XMXXS class="COMMON_FPKJ_XMXX" size="1">
//    <COMMON_FPKJ_XMXX>
//      <FPHXZ>0</FPHXZ>
//      <SPBM></SPBM>  
//      <ZXBM></ZXBM>   
//      <YHZCBS></YHZCBS>
//      <LSLBS></LSLBS>
//      <ZZSTSGL></ZZSTSGL> 
//      <XMMC>测试商品</XMMC>
//      <GGXH></GGXH>
//      <DW></DW>
//      <XMSL>1</XMSL>
//      <XMDJ>9.01</XMDJ>
//      <XMJE>9.01</XMJE>
//      <SL>0.11</SL>
//      <SE>0.99</SE>
//    </COMMON_FPKJ_XMXX>
//  </COMMON_FPKJ_XMXXS>
//</REQUEST_COMMON_FPKJ>
	public static String dopostXmlStr(String surl,String xml) throws IOException{
		URL url=null;
	    HttpURLConnection connection = null;
        url = new URL(surl);   
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "text/xml");
        connection.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection     
                .getOutputStream(), "UTF-8");
        out.write(xml);//发送报文
        out.flush();     
        out.close();
        // 一旦发送成功，用以下方法就可以得到服务器的回应：
        String responseContent = "";
        //读取数据并按GBK方式进行解码
        InputStreamReader l_urlStream = new InputStreamReader(connection.getInputStream(),"UTF-8"); 
        // 传说中的三层包装阿
        BufferedReader l_reader = new BufferedReader(l_urlStream);
        String sCurrentLine="";//按行读取xml
        while ((sCurrentLine = l_reader.readLine()) != null) {
        	responseContent += sCurrentLine + "\r\n";     
        }
        System.out.println(responseContent);
        if (connection != null) {
        	connection.disconnect();//销毁连接
    	}
		return responseContent;
	}
}
