public class Repository {
    private FileData[] workingDirectory;
    private int fileCount;

    private Commit[] commits;
    private int commitCount;

    public Repository() {
        workingDirectory = new FileData[100];
        commits = new Commit[100];
        fileCount = 0;
        commitCount = 0;
    }

    public void addFile(String name, String content) {
        workingDirectory[fileCount] = new FileData(name, content);
        fileCount++;
    }

    public void modifyFile(String name, String newContent) {
        for (int i = 0; i < fileCount; i++) {
            if (workingDirectory[i].getFileName().equals(name)) {
                workingDirectory[i].setContent(newContent);
                return;
            }
        }
        System.out.println("File not found!");
    }

    public void commit(String message) {
        commits[commitCount] = new Commit(message, workingDirectory, fileCount);
        commitCount++;
        System.out.println("Committed: " + message);
    }

    public void showHistory() {
        for (int i = 0; i < commitCount; i++) {
            System.out.println(commits[i].getTimestamp() + " - " + commits[i].getMessage());
        }
    }

    public void showFiles() {
        for (int i = 0; i < fileCount; i++) {
            System.out.println(workingDirectory[i].getFileName() + ": " + workingDirectory[i].getContent());
        }
    }
}
