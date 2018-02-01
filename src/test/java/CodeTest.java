import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;

import com.unitmb.api.internal.tool.UnitMBApiTool;

public class CodeTest {

	public static void main(String[] args) {

		System.err.println(UnitMBApiTool.Security.md5("123456"));

		Map<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("name", 111);
		data.put("age", 16);

		JsonObject value = Json.createObjectBuilder().add("firstName", "John").add("lastName", "Smith").add("age", 25)
				.add("address",
						Json.createObjectBuilder().add("streetAddress", "21 2nd Street").add("city", "New York")
								.add("state", "NY").add("postalCode", "10021"))
				.add("phoneNumber",
						Json.createArrayBuilder()
								.add(Json.createObjectBuilder().add("type", "home").add("number", "212 555-1234"))
								.add(Json.createObjectBuilder().add("type", "fax").add("number", "646 555-4567")))
				.build();
		
		
		System.out.println(value);

		List<String> list = new ArrayList<String>();

		list.stream();

	}

}
