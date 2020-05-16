package by.itechart.application.command;

import by.itechart.application.command.action.ActionUploadPicture;
import by.itechart.application.command.page.PageUploadPicture;
import by.itechart.application.command.page.PageUploadedPictures;
import by.itechart.application.constant.ConstCommand;
import by.itechart.application.exception.ExceptionUnknownCommand;


public class CommandFactory {
    public CommandFactory(){

    }

    public Command getCommand(String command) throws ExceptionUnknownCommand  {
        switch(command) {
            case(ConstCommand.PAGE_UPLOAD_PICTURE): {
                return new PageUploadPicture();
            }
            case(ConstCommand.ACTION_UPLOAD_PICTURE): {
                return new ActionUploadPicture();
            }

            case(ConstCommand.PAGE_UPLOADED_PICTURES): {
                return new PageUploadedPictures();
            }
            default:
                throw new ExceptionUnknownCommand("Unknown command: " + command);
        }
    }
}
