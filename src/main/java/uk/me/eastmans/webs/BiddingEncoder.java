package uk.me.eastmans.webs;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

import uk.me.eastmans.webs.model.Bid;
import uk.me.eastmans.webs.model.Bidding;

// This class is responsible to encode the Bidding object in a String
// that will be sent to clients
public class BiddingEncoder implements Text<Bidding> {

    @Override
    public void destroy() {

    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public String encode(Bidding bidding) throws EncodeException {
        // It uses the JSON-P API to create a JSON representation
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()
                .add("item", Json.createObjectBuilder()
                        .add("buyNowPrice", bidding.getItem().getBuyNowPrice())
                        .add("description", bidding.getItem().getDescription())
                        .add("imagePath", bidding.getItem().getImagePath())
                        .add("title", bidding.getItem().getTitle())
                        .build())
                .add("bidStatus", bidding.getBidStatus().toString())
                .add("currentPrice", bidding.getCurrentPrice())
                .add("secondsLeft", 0);
        if (bidding.getDueDate() != null) {
            jsonBuilder.add("dueDate", bidding.getDueDate().getTime());
        }
        if (bidding.getSecondsLeft() != null) {
            jsonBuilder.add("secondsLeft", bidding.getSecondsLeft());
        }
        JsonArrayBuilder jsonBidArray = Json.createArrayBuilder();
        for (Bid bid : bidding.getBids()) {
            jsonBidArray.add(Json.createObjectBuilder()
                    .add("dateTime", bid.getDateTime().getTime())
                    .add("value", bid.getValue())
                    .add("id", bid.getId())
                    .build());
        }
        jsonBuilder.add("bids", jsonBidArray);
        StringWriter stWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stWriter);
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();
        return stWriter.toString();
    }
}