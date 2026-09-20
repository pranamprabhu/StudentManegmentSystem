import java.util.Scanner;

public class StudentManagementSystem {
    // Arrays to store student data. Assuming max 100 students for this simple system.
    private static int[] studentIds = new int[100];
    private static String[] studentNames = new String[100];
    private static int[] studentAges = new int[100];
    private static String[] studentGrades = new String[100];
    private static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Student Management System");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number option.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        if (studentCount >= studentIds.length) {
            System.out.println("System is full. Cannot add more students.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int id = -1;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. ID must be an integer.");
            return;
        }

        // Check if ID already exists
        if (findStudentIndex(id) != -1) {
            System.out.println("Student with ID " + id + " already exists. IDs must be unique.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = -1;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Age format. Age must be an integer.");
            return;
        }

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        // Add to arrays
        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentAges[studentCount] = age;
        studentGrades[studentCount] = grade;
        studentCount++;

        System.out.println("Student added successfully!");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        int id = -1;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. ID must be an integer.");
            return;
        }

        int index = findStudentIndex(id);
        if (index != -1) {
            System.out.println("\nStudent Found:");
            System.out.println("ID: " + studentIds[index]);
            System.out.println("Name: " + studentNames[index]);
            System.out.println("Age: " + studentAges[index]);
            System.out.println("Grade: " + studentGrades[index]);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        int id = -1;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. ID must be an integer.");
            return;
        }

        int index = findStudentIndex(id);
        if (index != -1) {
            System.out.println("Student found. Enter new details (leave blank and press Enter to keep current value):");
            
            System.out.print("Enter New Name [" + studentNames[index] + "]: ");
            String name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                studentNames[index] = name;
            }

            System.out.print("Enter New Age [" + studentAges[index] + "]: ");
            String ageStr = scanner.nextLine();
            if (!ageStr.trim().isEmpty()) {
                try {
                    studentAges[index] = Integer.parseInt(ageStr);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Age format. Age was not updated.");
                }
            }

            System.out.print("Enter New Grade [" + studentGrades[index] + "]: ");
            String grade = scanner.nextLine();
            if (!grade.trim().isEmpty()) {
                studentGrades[index] = grade;
            }

            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students in the system to display.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        System.out.printf("%-10s %-20s %-5s %-10s\n", "ID", "Name", "Age", "Grade");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-10d %-20s %-5d %-10s\n", studentIds[i], studentNames[i], studentAges[i], studentGrades[i]);
        }
        System.out.println("--------------------------------------------------");
    }

    private static int findStudentIndex(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i] == id) {
                return i; // Returns the index where the student is found
            }
        }
        return -1; // -1 indicates the student was not found
    }
}
