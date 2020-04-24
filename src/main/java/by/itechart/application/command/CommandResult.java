package by.itechart.application.command;

import javax.servlet.http.HttpServletRequest;

public class CommandResult {
    private final String pageOrCommand;
    private final boolean isRedirect;
    private HttpServletRequest request;


    private CommandResult(String pageOrCommand, boolean isRedirect) {
        this.pageOrCommand = pageOrCommand;
        this.isRedirect = isRedirect;
    }

    public static CommandResult forward(String pageOrCommand) {
        return new CommandResult(pageOrCommand, false);
    }

    public static CommandResult redirect(String pageOrCommand) {
        return new CommandResult(pageOrCommand, true);
    }

    public String getPageOrCommand() {
        return pageOrCommand;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
