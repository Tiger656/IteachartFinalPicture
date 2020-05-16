package by.itechart.application.command.page;

import by.itechart.application.command.Command;
import by.itechart.application.command.CommandResult;
import by.itechart.application.constant.ConstPage;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PageUploadedPictures implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, Map<String, List<FileItem>> parsedRequest, String path) {
        String fullPath = path + "pictures";

        try (Stream<Path> walk = Files.walk(Paths.get(fullPath))) {
            List<String> result = walk.filter(pathValue -> Files.isRegularFile(pathValue))
                    .<String>map(Path::toString)
                    .map(str -> str.replace(path, ""))
                    .collect(Collectors.toList());
            request.setAttribute("images", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommandResult.forward(ConstPage.UPLOADED_PICTURES.getPage());
    }
}
