package by.itechart.application.constant;

public enum ConstPage {
    UPLOADED_PICTURES("uploadedpictures.jsp"),
    UPLOAD_PICTURE("uploadPicture.jsp"),
    ERROR("error.jsp");

    private String page;

    ConstPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
