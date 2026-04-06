import java.util.Date;

public class Commit {
    private String message;
    private Date timestamp;
    private FileData[] files;
    private int fileCount;

    public Commit(String message, FileData[] workingFiles, int count) {
        this.message = message;
        this.timestamp = new Date();

        this.files = new FileData[100]; // fixed size
        this.fileCount = count;

        // Deep copy
        for (int i = 0; i < count; i++) {
            this.files[i] = new FileData(
                workingFiles[i].getFileName(),
                workingFiles[i].getContent()
            );
        }
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void showFiles() {
        for (int i = 0; i < fileCount; i++) {
            System.out.println(files[i].getFileName() + ": " + files[i].getContent());
        }
    }
}
