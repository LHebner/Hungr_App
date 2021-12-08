import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.oauth.OAuthService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import transmachina.thebest.ext.YelpApi;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Tests for Yelps
 */
public class YelpApiTest {

    @Test
    public void testSearch1() throws IOException, ParseException {

        YelpApi yelpApi = YelpApi.instance();
        Response response = yelpApi.searchForBusinessesByGeo(null, 49.33, -0.39);
        String body = response.getBody();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

        JSONArray businesses = (JSONArray) jsonObject.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();

        assertEquals("la-mama-st-aubin-sur-mer", firstBusinessID);

    }

    @Test
    public void testSearch2() throws IOException, ParseException {

        String businessID = "la-mama-st-aubin-sur-mer";

        YelpApi yelpApi = YelpApi.instance();
        Response response = yelpApi.searchByBusinessId(businessID);
        String body = response.getBody();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

        String id = (String) jsonObject.get("id");
        assertEquals(businessID, id);
        assertEquals("+33231741414", jsonObject.get("phone"));

    }

}
