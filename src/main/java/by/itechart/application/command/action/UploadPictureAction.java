package by.itechart.application.command.action;
import by.itechart.application.command.Command;
import by.itechart.application.command.CommandResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileExistsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

public class UploadPictureAction implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, Map<String, List<FileItem>> parsedRequest, String path) {
        try {

            List<FileItem> fileItem = (List<FileItem>) parsedRequest.get("file");
            List<FileItem> fileNameItem = (List<FileItem>) parsedRequest.get("fileName");

            String name = fileNameItem.get(0).getString();

            String currentFileName = fileItem.get(0).getName();
            String[] splittedNameForExtension = currentFileName.split("\\.");
            String fileExtension = splittedNameForExtension[splittedNameForExtension.length - 1].toLowerCase();

            fileItem.get(0).write(new File(path + "\\pictures", name + "." + fileExtension));
        } catch (FileExistsException e) {
            request.getSession().setAttribute("errormessage", "file with this name already exists");
            return CommandResult.redirect("/");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CommandResult.redirect("pageUploadedPictures");
    }
}
