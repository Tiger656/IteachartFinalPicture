package by.itechart.application.command;

import by.itechart.application.exception.ExceptionFileAlreadyExists;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface Command {

    CommandResult execute(HttpServletRequest request, HttpServletResponse response, Map<String, List<FileItem>> parsedRequest, String path) throws ExceptionFileAlreadyExists;
}
