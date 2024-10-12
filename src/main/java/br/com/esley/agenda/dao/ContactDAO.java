package br.com.esley.agenda.dao;

import br.com.esley.agenda.model.Contacts;
import br.com.esley.agenda.repository.MySqlConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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
}