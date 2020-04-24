package by.itechart.application.command;

import by.itechart.application.command.action.UploadPictureAction;
import by.itechart.application.command.page.UploadPicture;
import by.itechart.application.command.page.UploadedPictures;

public class CommandFactory {
    public CommandFactory(){

    }

    public Command getCommand(String command) /*throws UnknownCommandException*/ {
        switch(command) {
            case("pageUploadPicture"): {
                return new UploadPicture();
            }
            case("actionUploadPicture"): {
                return new UploadPictureAction();
            }

            case("pageUploadedPictures"): {
                return new UploadedPictures();
            }
            default: return null;
                //hrow new UnknownCommandException("Unknown command: " + action);
        }
    }
}
