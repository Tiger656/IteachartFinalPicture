package by.itechart.application.command.action;
import by.itechart.application.command.Command;
import by.itechart.application.command.CommandResult;
import by.itechart.application.exception.ExceptionFileAlreadyExists;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileExistsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ActionUploadPicture implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, Map<String, List<FileItem>> parsedRequest, String path) throws ExceptionFileAlreadyExists{
        try {

            List<FileItem> fileItem = (List<FileItem>) parsedRequest.get("file");
            List<FileItem> fileNameItem = (List<FileItem>) parsedRequest.get("fileName");

            String name = fileNameItem.get(0).getString();

            String currentFileName = fileItem.get(0).getName();
            String[] splittedNameForExtension = currentFileName.split("\\.");
            String fileExtension = splittedNameForExtension[splittedNameForExtension.length - 1].toLowerCase();

            File uploadDir = new File(path + File.separator + "pictures");
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            fileItem.get(0).write(new File(uploadDir, name + "." + fileExtension));
        } catch (FileExistsException e) {
            throw new ExceptionFileAlreadyExists("file with this name already exists");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CommandResult.redirect("pageUploadedPictures");
    }
}
