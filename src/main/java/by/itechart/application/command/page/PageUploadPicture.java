package by.itechart.application.command.page;

import by.itechart.application.command.Command;
import by.itechart.application.command.CommandResult;
import by.itechart.application.constant.ConstPage;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PageUploadPicture implements Command {


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, Map<String, List<FileItem>> parsedRequest, String path) {
        return CommandResult.forward(ConstPage.UPLOAD_PICTURE.getPage());
    }
}
