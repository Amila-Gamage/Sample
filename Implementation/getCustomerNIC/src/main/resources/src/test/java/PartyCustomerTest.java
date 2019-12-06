import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.camel.Exchange;
import org.junit.Test;

import org.junit.BeforeClass;
import com.temenos.irf.testsupport.*;


public class PartyCustomerTest extends CamelRouteTest
{

 private static CamelUnitTestHelper helper;
@BeforeClass
public static void init() {
   helper = new CamelUnitTestHelper("party-customer.service.v1.0.0", "./src/test/resources/test-data/");
}
@Test
public void testgetCustomerNIC() {
  String requestName = "getCustomerNIC";
helper.getTestSupportConnectionFactory().setRequestName(requestName);
helper.getTestSupportConnectionFactory().setRecording(true);
Map<String, Object> headers = new HashMap<>();
headers.put("customerId", "");// THIS IS REQUIRED
headers.put("page_size", "");
headers.put("page_start", "");
headers.put("page_token", "");
headers.put("credentials", "");
headers.put("companyId", "");
headers.put(Exchange.HTTP_METHOD, "GET");
String body = "";
Object result = helper.getProducerTemplate().requestBodyAndHeaders("direct-vm:party-customer.getCustomerNIC", body, headers);
 Map<String, List<String>> testResults = helper.checkResponse(requestName, result);
super.checkPaths(testResults);
}
}
