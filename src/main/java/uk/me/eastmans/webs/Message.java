package uk.me.eastmans.webs;

//This class represents the message from clients to the Websocket endpoint
public class Message {

    private String command;

    private Integer bidValue;

    public Message(String command, Integer bidValue) {
        this.command = command;
        this.bidValue = bidValue;
    }

    public String getCommand() {
        return command;
    }

    public Integer getBidValue() {
        return bidValue;
    }

}
