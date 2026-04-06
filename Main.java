public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();

        repo.addFile("file1.txt", "Hello");
        repo.addFile("file2.txt", "World");

        repo.commit("Initial commit");

        repo.modifyFile("file1.txt", "Hello Updated");

        repo.commit("Second commit");

        System.out.println("\nCurrent Files:");
        repo.showFiles();

        System.out.println("\nCommit History:");
        repo.showHistory();
    }
}
