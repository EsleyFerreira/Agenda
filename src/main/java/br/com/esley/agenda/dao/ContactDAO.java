package br.com.esley.agenda.dao;

import br.com.esley.agenda.model.Contacts;
import br.com.esley.agenda.repository.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public void save(Contacts contacts) {
        String sql = "INSERT INTO contacts(name, age, registration_date) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = MySqlConnection.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, contacts.getName());
            pstm.setInt(2, contacts.getAge());
            pstm.setDate(3, new Date(contacts.getDataRegister().getTime()));

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Contacts contacts) {
        String sql = "Update contacts SET name = ?, age = ?, registration_date = ? " + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = MySqlConnection.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, contacts.getName());
            pstm.setInt(2, contacts.getId());
            pstm.setDate(3, new Date(contacts.getDataRegister().getTime()));
            pstm.setInt(4, contacts.getId());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id) {
        String sql = "DELETE FROM contacts WHERE id = ? ";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = MySqlConnection.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Contacts> getContacts() {
        String sql = "SELECT * FROM contacts";

        List<Contacts> contacts = new ArrayList<Contacts>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = MySqlConnection.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {

                Contacts contact = new Contacts();

                contact.setId(rset.getInt("id"));
                contact.setName(rset.getString("name"));
                contact.setAge(rset.getInt("age"));
                contact.setDataRegister(rset.getDate("registration_date"));

                contacts.add(contact);
            }
            System.out.println("Contato Salvo!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contacts;
    }
}