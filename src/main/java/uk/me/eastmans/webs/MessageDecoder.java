package uk.me.eastmans.webs;

import java.io.StringReader;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

// This class is responsible to "decode" the received String
// from clients in a Message object
public class MessageDecoder implements Decoder.Text<Message> {

    private Logger logger = Logger.getLogger(getClass().getName());

    // create a Message object from JSON
    @Override
    public Message decode(String msg) throws DecodeException {
        logger.info("Decoding: " + msg);
        // It uses the JSON-P API to parse JSON content
        JsonReader reader = Json.createReader(new StringReader(msg));
        JsonObject jsonObject = reader.readObject();
        String command = jsonObject.getString("command");
        Integer bidValue = null;
        if (jsonObject.containsKey("bidValue")) {
            bidValue = jsonObject.getInt("bidValue");
        }
        return new Message(command, bidValue);
    }

    @Override
    public boolean willDecode(String msg) {
        return true;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig config) {
    }
}
