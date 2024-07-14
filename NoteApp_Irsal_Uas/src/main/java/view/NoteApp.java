/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.NoteController;
import model.Note;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author irsal
 */
public class NoteApp {
    private static NoteController controller = new NoteController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    showNotes();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Note App Menu:");
        System.out.println("Oleh Irsal Fauan Alfarizi NIM 2320128");
        System.out.println("1. Add Note");
        System.out.println("2. Show Notes");
        System.out.println("3. Delete Note");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static void addNote() {
        if(scanner.hasNextLine()){
            scanner.nextLine(); // Memastikan tidak ada efek input sebelumnya
        }
        System.out.print("Enter note: ");
        String note = scanner.nextLine();
        controller.addNote(note);
        System.out.println("Note saved: " + note);
    }

    private static void showNotes() {
        List<Note> notes = controller.getAllNotes();
        System.out.println("Your Notes:");
        for (Note note : notes) {
            System.out.println(note.getId() + ". " + note.getDescription() + " [" + note.getTimestamp() + "]");
        }
    }

    private static void deleteNote() {
        System.out.print("Enter note number to delete: ");
        int noteNumber = Integer.parseInt(scanner.nextLine());
        controller.deleteNote(noteNumber);
        System.out.println("Deleted note: " + noteNumber);
    }
}