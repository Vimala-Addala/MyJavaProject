package wiremetrics.in;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, roll_no, department, email, phone, marks) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getRollNo());
            stmt.setString(3, student.getDepartment());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getPhone());
            stmt.setInt(6, student.getMarks());
            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("roll_no"),
                    rs.getString("department"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("marks")   // ✅ FIXED
                );
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void updateStudent(String rollNo, Student updatedStudent) {
        String sql = "UPDATE students SET name=?, department=?, email=?, phone=?, marks=? WHERE roll_no=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, updatedStudent.getName());
            stmt.setString(2, updatedStudent.getDepartment());
            stmt.setString(3, updatedStudent.getEmail());
            stmt.setString(4, updatedStudent.getPhone());
            stmt.setInt(5, updatedStudent.getMarks());
            stmt.setString(6, rollNo);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student updated successfully!");
            } else {
                System.out.println("⚠️ Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String rollNo) {
        String sql = "DELETE FROM students WHERE roll_no=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rollNo);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student deleted successfully!");
            } else {
                System.out.println("⚠️ Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> searchByName(String name) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("roll_no"),
                    rs.getString("department"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("marks")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}