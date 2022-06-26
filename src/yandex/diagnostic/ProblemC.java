package yandex.diagnostic;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ProblemC {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        JSONParser jsonParser = new JSONParser();
        int n = Integer.parseInt(r.readLine());
        JSONArray allOffers = new JSONArray();
        for (int i = 0; i < n; i++) {
            JSONObject object = (JSONObject) jsonParser.parse(r.readLine());
            JSONArray jsonArrayOfOfferObjects = (JSONArray) object.get("offers");
            for (Object off : jsonArrayOfOfferObjects) {
                JSONObject jsonObjectOffer = (JSONObject) off;
                allOffers.add(new Offer(jsonObjectOffer));
            }
        }
        allOffers.sort(Comparator.<Offer>comparingLong(x -> x.price).thenComparing(x -> x.offerId));
        int total = allOffers.size();
        for (int i = 0; i < total; i++) allOffers.set(i, ((Offer) allOffers.get(i)).object);

        JSONObject answer = new JSONObject();
        answer.put("offers", allOffers);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        answer.writeJSONString(log);
        log.flush();
    }

    private static class Offer {
        final String offerId;
        final long price;
        final JSONObject object;

        private Offer(JSONObject object) {
            this.offerId = (String) object.get("offer_id");
            this.price = (Long) object.get("price");
            this.object = object;
        }
    }
}
