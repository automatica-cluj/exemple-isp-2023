/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.exemple.curs.designpatterns.structural;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author radu.miron
 */
interface FileReaderInterface {
    String readFileToString(File f);
}

// THIS IMPLEMENTATION NEEDS TO BE CHANGED WITH AdaptedFileReader
// RESTRICTION: this class cannot be changed
class OldFileReaderImpl implements FileReaderInterface {
    public String readFileToString(File f) {
        String result = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bf.readLine()) != null) {
                result = result.isEmpty() ? line : result + "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}

// RESTRICTION: this class cannot be changed
class AdaptedFileReader {
    public List<String> readAllLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}

// SOLUTION: we create this new class
class FileReaderAdapter extends AdaptedFileReader implements FileReaderInterface {

    @Override
    public String readFileToString(File f) {
        try {
            return readAllLines(f.toPath())
                    .stream()
                    .reduce((a, b) -> a + "\n" + b).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// THE CLIENT CODE CANNOT BE CHANGED EITHER
class Client {
    private FileReaderInterface fileReader;

    public Client(FileReaderInterface fileReader) {
        this.fileReader = fileReader;
    }

    public void printFile(File f) {
        System.out.println(fileReader.readFileToString(f));
    }
}

public class TestAdapter {
    private static final String FILE_NAME = "test-file.txt";

    public static void main(String[] args) throws FileNotFoundException {
        //generate test file
        File testFile = new File(FILE_NAME);
        PrintWriter pw = new PrintWriter(testFile);
        pw.println("line 1");
        pw.println("line 2");
        pw.println("line 3");
        pw.flush();
        pw.close();

        //old way
        System.out.println("old way:");
        new Client(new OldFileReaderImpl()).printFile(testFile);
        System.out.println("-------------------\n");

        //new way
        System.out.println("new way:");
        new Client(new FileReaderAdapter()).printFile(testFile);
    }
}