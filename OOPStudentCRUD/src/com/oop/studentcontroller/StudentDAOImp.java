/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.studentcontroller;
import java.sql.*;
import com.oop.model.Student;
import com.oop.studentDb.StudentDB;
//import java.util.List;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author ganidusahan
 */
public class StudentDAOImp implements StudentDAO {

    @Override
    public void save(Student students) {
        
        try{
            
            Connection con = StudentDB.getConnection();
            String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,students.getFname());
            ps.setString(2,students.getCourse());
            ps.setInt(3,students.getFee());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SAVED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
    }

    @Override
    public void update(Student students) {
        
        try{
            
           Connection con = StudentDB.getConnection();
           String sql = "UPDATE students SET fname=?,course=?,fee=? WHERE id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, students.getFname());
           ps.setString(2, students.getCourse());
           ps.setInt(3, students.getFee());
           ps.setInt(4, students.getId());
           ps.executeUpdate();
           
           
           JOptionPane.showMessageDialog(null, "UPDATED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
    }

    @Override
    public void delete(Student students) {
        
        try{
           Connection con = StudentDB.getConnection();
           String sql = "DELETE FROM students WHERE id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, students.getId());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "DELETED!");
           
            
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
    }

    @Override
    public Student get(int id) {
        Student st = new Student();
        try{
           Connection con = StudentDB.getConnection();
           String sql = "SELECT * FROM students WHERE id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               st.setId(rs.getInt("id"));
               st.setFname(rs.getString("fname"));
               st.setCourse(rs.getString("course"));
               st.setFee(rs.getInt("fee"));
           }
           
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return st;
    }
    
    @Override
    public List<Student> list() {
        List<Student> list = new ArrayList<Student>();
       try{
           
           Connection con = StudentDB.getConnection();
           String sql = "SELECT * FROM students";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               Student st = new Student();
               st.setId(rs.getInt("id"));
               st.setFname(rs.getString("fname"));
               st.setCourse(rs.getString("course"));
               st.setFee(rs.getInt("fee"));
               
               list.add(st);
           }
           
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "ERROR");
       } 
        return list;
        
    }
    
}
