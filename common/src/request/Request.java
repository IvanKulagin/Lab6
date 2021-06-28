package request;

import java.io.Serializable;

public class Request implements Serializable {

    private static final long serialVersionUID = 7766749381571691204L;
    private RequestType requestType;
    private String command;
    private String[] args;
    private MarineData marineData;
    private String message;

    public Request(String command, String[] args) {
        this.command = command;
        this.args = args;
    }

    public Request(MarineData marineData) {
        this.marineData = marineData;
    }

    public Request(String message) {
        this.message = message;
        requestType = RequestType.MESSAGE;
    }

    public Request() {
        requestType = RequestType.DATA;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }

    public MarineData getMarineData() {
        return marineData;
    }

    public String getMessage() {
        return message;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
