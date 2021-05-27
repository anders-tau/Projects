package file.generation.dao;

import file.generation.models.FileGenerationEvent;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FileGenerationEventDAO {
    private final DataSource dataSource;

    private FileGenerationEventDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(FileGenerationEvent body, String table) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO " + table + " (event_id,event_datetime,param1,param2,param3,param4,param5) VALUES(?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, body.getId());
            preparedStatement.setLong(2, body.getDateTime());
            preparedStatement.setString(3, body.getParam1());
            preparedStatement.setString(4, body.getParam2());
            preparedStatement.setString(5, body.getParam3());
            preparedStatement.setString(6, body.getParam4());
            preparedStatement.setString(7, body.getParam5());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(long eventDateTime, String table) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM " + table + " WHERE event_datetime = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, eventDateTime);
            preparedStatement.executeUpdate();
        }
    }

    public int countAll(String table) throws SQLException {
        int count = 0;
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT COUNT(*) AS count FROM " + table + ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        }
        return count;
    }

    public FileGenerationEvent findFirst(String table) throws SQLException {
        FileGenerationEvent event = new FileGenerationEvent();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT event_id, MIN(event_datetime) AS event_datetime, param1, param2, param3, param4, param5 FROM " + table + ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                event.setId(resultSet.getInt("event_id"));
                event.setDateTime(resultSet.getLong("event_datetime"));
                event.setParam1(resultSet.getString("param1"));
                event.setParam2(resultSet.getString("param2"));
                event.setParam3(resultSet.getString("param3"));
                event.setParam4(resultSet.getString("param4"));
                event.setParam5(resultSet.getString("param5"));
            }
        }
        return event;
    }
}
