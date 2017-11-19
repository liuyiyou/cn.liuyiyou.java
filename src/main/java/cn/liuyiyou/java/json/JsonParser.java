/**
 * 
 */
package cn.liuyiyou.java.json;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 复杂json解析
 * 
 * @author liuyiyou.cn
 * @date 2017年8月22日 下午8:03:56
 * @version
 */
public class JsonParser {

	final static String DXO_ELEMENT = "dxoElement";
	final static String DXO_BOARD = "dxoBoard";

	public static String getJsonStr(String path) throws IOException {
		String json = FileUtils.readFileToString(new File(path), "UTF-8");
		return json;
	}

	public static String parseObjects(String jsonStr) {
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("objects"));
		if (jsonArray != null && jsonArray.size() >= 1) {
			for (int i = 0; i < jsonArray.size(); i++) {
				parseObject(JSONObject.fromObject(jsonArray.get(i)));
			}
		}
		return null;
	}

	private static void parseObject(JSONObject obj) {
		if (obj.get("children") != null) {
			parseChildren((JSONArray) obj.get("children"));
		} else {
			System.out.println(obj.toString());
			JSONObject metaObj = JSONObject.fromObject(obj.get("meta"));
			System.out.println(metaObj);
			System.out.println(metaObj.get("type"));
			System.out.println(metaObj.get("produce"));
		}

	}

	private static void parseChildren(JSONArray children) {
		for (int i = 0; i < children.size(); i++) {

		}
	}

	private static void parseChild(JSONObject child) {
		String typeLevel = (String) child.get("typeLevel");
		// if(typeLevel.equals(DXO_ELEMENT)) {
		// return;
		// }
		String type = (String) child.get("type");
		// 解析
		if (type.equals(DXO_BOARD)) {

		}
	}

	@Test
	public void parse() throws IOException {
		String path = "src/main/resources/test.json";
		String json = FileUtils.readFileToString(new File(path), "UTF-8");
		JSONObject child = JSONObject.fromObject(json);
		JSONObject meta = JSONObject.fromObject(child.get("meta"));
		String typeLevel = (String) meta.get("typeLevel");
		String type = (String) meta.get("type");
		if (typeLevel.equals(DXO_ELEMENT) && type.equals(DXO_BOARD)) {
			// 开始解析
			JSONObject produce = JSONObject.fromObject(meta.get("produce"));
			JSONObject board = JSONObject.fromObject(produce.get("board"));
			JSONObject holes = JSONObject.fromObject(board.get("holes"));
			JSONObject drillData = JSONObject.fromObject(holes.get("drillData"));
			String cncCode1 = String.valueOf(drillData.get("cncCode1"));
			String cncCode2 = String.valueOf(drillData.get("cncCode2"));
			if (!StringUtils.isBlank(cncCode1) && !StringUtils.isBlank(cncCode2)) {
				System.out.println("A打孔");
			} else {
				if (!StringUtils.isBlank(cncCode1)) {
					System.out.println("A打孔");
				}
				if (!StringUtils.isBlank(cncCode2)) {
					System.out.println("B打孔");
					System.out.println(header());

				}
			}
		}

	}

	public String header() {
		StringBuffer sb = new StringBuffer(200);
		sb.append("[H\\HEADER");
		sb.append("\n");
		sb.append("VERSION=\"4.0\"");
		sb.append("\n");
		sb.append("VIEW=\"NOMIRROR\"");
		sb.append("\n");
		sb.append("OP=\"1\"");
		sb.append("\n");
		sb.append("FM=\"1\"");
		sb.append("\n");
		sb.append("FW=\"800\"");
		sb.append("\n");
		sb.append("HP=\"1\"");
		sb.append("\n");
		sb.append("GX=\"1\"");
		sb.append("\n");
		sb.append("DW=\"0\"");
		sb.append("\n");
		sb.append("HP=\"1\"");
		sb.append("\n");
		sb.append("ModusMirror=\"0\"");
		return sb.toString();
	}

}
