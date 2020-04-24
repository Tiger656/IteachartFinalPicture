package by.itechart.application;

import by.itechart.application.command.Command;
import by.itechart.application.command.CommandFactory;
import by.itechart.application.command.CommandResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Controller extends HttpServlet {
    private String controllerPath;
    private final String CONTROLLER_COMMAND= "/controller?command=";

    public void init(ServletConfig config) throws
            ServletException {
        super.init(config);
        controllerPath = getServletContext().getRealPath("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandResult commandResult = null;
        String action = null;
        CommandFactory commandFactory = new CommandFactory();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                Map<String, List<FileItem>> parsedRequest = upload.parseParameterMap(request);
                List<FileItem> fileItem = parsedRequest.get("command");
                action = fileItem.get(0).getString();
                Command command = commandFactory.getCommand(action);
                commandResult = command.execute(request, response, parsedRequest, controllerPath);

            } else {
                action = request.getParameter("command");
                Command command = commandFactory.getCommand(action);
                commandResult = command.execute(request, response, null, getServletContext().getRealPath(""));
            }

        } catch (Exception e) {
            request.setAttribute("cause", e.getCause());
            dispatch(request, response, CommandResult.forward("index.jsp"));
        }
        dispatch(request, response, commandResult);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, CommandResult commandResult) throws ServletException, IOException {
        if (commandResult.isRedirect()) {
            response.sendRedirect(request.getContextPath() + CONTROLLER_COMMAND + commandResult.getPageOrCommand());
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + commandResult.getPageOrCommand());
            dispatcher.forward(request, response);
        }
    }

}
