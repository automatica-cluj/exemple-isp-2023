/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.exemple.curs.designpatterns.creational;

import java.util.List;

/**
 * @author Radu Miron
 */
public class TestSingleton {
    public static void main(String[] args) {
        FileWriter fileWriter1 = FileWriter.getInstance();
        fileWriter1.setFileName("test1");

        System.out.println("After the first call of getInstance()");
        System.out.println(fileWriter1.getFileName());

        FileWriter fileWriter2 = FileWriter.getInstance();
        fileWriter2.setFileName("test2");

        System.out.println("After the second call of getInstance()");
        System.out.println("fileWriter1.fileName: " + fileWriter1.getFileName());
        System.out.println("fileWriter2.fileName: " + fileWriter2.getFileName());

        System.out.println("fileWriter1 == fileWriter2? " + (fileWriter1 == fileWriter2));
    }
}

class FileWriter {
    private static FileWriter instance;
    private String fileName;

    private FileWriter() {
    }

    public static FileWriter getInstance() {
        if (instance == null) {
            instance = new FileWriter();
        }

        return instance;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeLines(List<String> lines) {
        //todo: implement
    }
}