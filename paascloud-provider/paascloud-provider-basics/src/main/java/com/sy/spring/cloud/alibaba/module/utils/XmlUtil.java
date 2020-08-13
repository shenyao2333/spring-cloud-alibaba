/*
package com.sy.spring.cloud.alibaba.module.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

*/
/**
 *
 *//*

public class XmlUtil {

	public static JSONObject xml2Json(String xmlStr, String encode) throws JDOMException, IOException {
		if (StringUtils.isEmpty(xmlStr)) {
			return null;
		}
		xmlStr = xmlStr.replaceAll("\\\n", "");
		byte[] xml = xmlStr.getBytes(encode);
		JSONObject json = new JSONObject();
		InputStream is = new ByteArrayInputStream(xml);
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(is);
		Element root = doc.getRootElement();
		json.put(root.getName(), iterateElement(root));
		return json;
	}

	private static JSONObject iterateElement(Element element) {
		List<Element> node = element.getChildren();
		JSONObject obj = new JSONObject();
		List list = null;
		for (Element child : node) {
			list = new LinkedList();
			String text = child.getTextTrim();
			if (StringUtils.isBlank(text)) {
				if (child.getChildren().size() == 0) {
					continue;
				}
				if (obj.containsKey(child.getName())) {
					list = (List) obj.get(child.getName());
				}
				// 遍历child的子节点
				list.add(iterateElement(child));
				obj.put(child.getName(), list);
			} else {
				if (obj.containsKey(child.getName())) {
					Object value = obj.get(child.getName());
					try {
						list = (List) value;
					} catch (ClassCastException e) {
						list.add(value);
					}
				}
				// child无子节点时直接设置text
				if (child.getChildren().size() == 0) {
					obj.put(child.getName(), text);
				} else {
					list.add(text);
					obj.put(child.getName(), list);
				}
			}
		}
		return obj;
	}

	public static void main(String[] args) throws Exception {
		*/
/*String xml = "<?xml version=\"1.0\" encoding=\"gb2312\"?>\r\n" + "<business>\r\n"
				+ "  <REQUEST_COMMON_FPKJ>\r\n" + "    <COMMON_FPKJ_FPT>\r\n" + "      <FPDM>150000000001</FPDM>\r\n"
				+ "      <FPHM>10011939</FPHM>\r\n" + "      <JQBH>499000102686</JQBH>\r\n"
				+ "      <KPRQ>2019-07-18</KPRQ>\r\n"
				+ "      <FPMW>0326*-5&amp;gt;*5&amp;gt;&amp;gt;4/607/485-+0821+**7391&amp;lt;9&amp;gt;6728+91278061+0604+4/496-+-*93--&amp;gt;5*442378-99&amp;gt;&amp;lt;+&amp;lt;113&amp;lt;*9*1701130906-3*&amp;lt;55-+11</FPMW>\r\n"
				+ "      <JYM>08533788306472425861</JYM>\r\n" + "      <XSF_NSRSBH>500102000000159</XSF_NSRSBH>\r\n"
				+ "      <XSF_MC>演示企业</XSF_MC>\r\n" + "      <XSF_DZDH>演示地址</XSF_DZDH>\r\n"
				+ "      <XSF_YHZH>演示银行</XSF_YHZH>\r\n" + "      <GMF_NSRSBH>500102000000160</GMF_NSRSBH>\r\n"
				+ "      <GMF_MC>百度</GMF_MC>\r\n" + "      <GMF_DZDH>18688887777</GMF_DZDH>\r\n"
				+ "      <GMF_YHZH>6666666</GMF_YHZH>\r\n" + "      <KPR>开票人</KPR>\r\n" + "      <SKR>收款人</SKR>\r\n"
				+ "      <FHR>复核人</FHR>\r\n" + "      <BZ>备注</BZ>\r\n" + "      <JSHJ>113000.00</JSHJ>\r\n"
				+ "      <HJJE>100000.00</HJJE>\r\n" + "      <HJSE>13000.00</HJSE>\r\n" + "      <FPZT>0</FPZT>\r\n"
				+ "      <FPMX>\r\n" + "        <GROUP XH=\"1\">\r\n" + "          <SPMC>*演示简称*奔驰</SPMC>\r\n"
				+ "          <GGXH>规格型号</GGXH>\r\n" + "          <JLDW>个</JLDW>\r\n" + "          <SPSL>1</SPSL>\r\n"
				+ "          <SPDJ>1E+5</SPDJ>\r\n" + "          <JE>100000.00</JE>\r\n"
				+ "          <SLV>0.13</SLV>\r\n" + "          <SE>13000.00</SE>\r\n" + "        </GROUP>\r\n"
				+ "      </FPMX>\r\n" + "    </COMMON_FPKJ_FPT>\r\n" + "  </REQUEST_COMMON_FPKJ>\r\n"
				+ "</business>\r\n" + "\r\n" + "";
		JSONObject json = xml2Json(xml, "gb2312");
		System.out.println(json.toJSONString());*//*


		String a = "{\r\n" +
				"    \"business\": {\r\n" +
				"        \"REQUEST_COMMON_FPKJ\": [\r\n" +
				"            {\r\n" +
				"                \"COMMON_FPKJ_FPT\": [\r\n" +
				"                    {\r\n" +
				"                        \"BZ\": \"备注\",\r\n" +
				"                        \"FHR\": \"复核人\",\r\n" +
				"                        \"FPDM\": \"150000000001\",\r\n" +
				"                        \"FPHM\": \"10011939\",\r\n" +
				"                        \"FPMW\": \"0326*-5&gt;*5&gt;&gt;4/607/485-+0821+**7391&lt;9&gt;6728+91278061+0604+4/496-+-*93--&gt;5*442378-99&gt;&lt;+&lt;113&lt;*9*1701130906-3*&lt;55-+11\",\r\n" +
				"                        \"FPMX\": [\r\n" +
				"                            {\r\n" +
				"                                \"GROUP\": [\r\n" +
				"                                    {\r\n" +
				"                                        \"GGXH\": \"规格型号\",\r\n" +
				"                                        \"JE\": \"100000.00\",\r\n" +
				"                                        \"JLDW\": \"个\",\r\n" +
				"                                        \"SE\": \"13000.00\",\r\n" +
				"                                        \"SLV\": \"0.13\",\r\n" +
				"                                        \"SPDJ\": \"1E+5\",\r\n" +
				"                                        \"SPMC\": \"*演示简称*奔驰\",\r\n" +
				"                                        \"SPSL\": \"1\"\r\n" +
				"                                    }\r\n" +
				"                                ]\r\n" +
				"                            }\r\n" +
				"                        ],\r\n" +
				"                        \"FPZT\": \"0\",\r\n" +
				"                        \"GMF_DZDH\": \"18688887777\",\r\n" +
				"                        \"GMF_MC\": \"百度\",\r\n" +
				"                        \"GMF_NSRSBH\": \"500102000000160\",\r\n" +
				"                        \"GMF_YHZH\": \"6666666\",\r\n" +
				"                        \"HJJE\": \"100000.00\",\r\n" +
				"                        \"HJSE\": \"13000.00\",\r\n" +
				"                        \"JQBH\": \"499000102686\",\r\n" +
				"                        \"JSHJ\": \"113000.00\",\r\n" +
				"                        \"JYM\": \"08533788306472425861\",\r\n" +
				"                        \"KPR\": \"开票人\",\r\n" +
				"                        \"KPRQ\": \"2019-07-18\",\r\n" +
				"                        \"SKR\": \"收款人\",\r\n" +
				"                        \"XSF_DZDH\": \"演示地址\",\r\n" +
				"                        \"XSF_MC\": \"演示企业\",\r\n" +
				"                        \"XSF_NSRSBH\": \"500102000000159\",\r\n" +
				"                        \"XSF_YHZH\": \"演示银行\"\r\n" +
				"                    }\r\n" +
				"                ]\r\n" +
				"            }\r\n" +
				"        ]\r\n" +
				"    }\r\n" +
				"}";


		JSONObject resultJson = JSON.parseObject(a);
		JSONObject business = resultJson.getJSONObject("business");
		JSONArray fpkj = JSONArray.parseArray(String.valueOf(business.get("REQUEST_COMMON_FPKJ")));
		JSONObject fpkj0 = (JSONObject) fpkj.get(0);
		JSONArray fpt = JSONArray.parseArray(String.valueOf(fpkj0.get("COMMON_FPKJ_FPT")));
		JSONObject fpt0 = (JSONObject) fpt.get(0);
		String fphm = String.valueOf(fpt0.get("FPHM"));
		System.out.println("====: "+fphm);
	}
}
*/
