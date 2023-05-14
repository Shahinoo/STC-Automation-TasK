package stc.ta.data;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    /**
     * Class members that will be hold the data from the json file to use it in assertions
     */
    public String sa_litePrice, sa_classicPrice, sa_premiumPrice;
    public String bh_litePrice, bh_classicPrice, bh_premiumPrice;
    public String kw_litePrice, kw_classicPrice, kw_premiumPrice;

    /**
     * Read data from json file and parse it
     *
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws IOException
     * @throws ParseException
     */
    public void JsonReader() throws JsonIOException, JsonSyntaxException, IOException, ParseException {

        String filePath = System.getProperty("user.dir") + "/src/test/java/stc/ta/data/planPrices.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(srcFile));

        //  Iterate on the Json file to get the all objects
        for (
                Object jsonObj : jsonArray) {
            JSONObject plan = (JSONObject) jsonObj;
            sa_litePrice = (String) plan.get("sa-lite-price");
            sa_classicPrice = (String) plan.get("sa-classic-price");
            sa_premiumPrice = (String) plan.get("sa-premium-price");

            bh_litePrice = (String) plan.get("bh-lite-price");
            bh_classicPrice = (String) plan.get("bh-classic-price");
            bh_premiumPrice = (String) plan.get("bh-premium-price");

            kw_litePrice = (String) plan.get("kw-lite-price");
            kw_classicPrice = (String) plan.get("kw-classic-price");
            kw_premiumPrice = (String) plan.get("kw-premium-price");
        }
    }
}