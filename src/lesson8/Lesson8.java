package lesson8;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 1. Добавить поддержку SQLite в проект.
 * <p>
 * 2. Создать класс-репозиторий, отвечающий за взаимодействие с базой данных.
 * <p>
 * 3. Организовать запись данных в базу при каждом успешном API запросе. Формат - String city, String localDate, String
 * weatherText, Double temperature.
 * <p>
 * 4. Организовать чтение из базы всех данных по пункту меню (требует переработки меню)
 * <p>
 * 5. Учесть, что соединение всегда нужно закрывать
 */
public class Lesson8 {
    public static void main(String[] args) {
        try {
            WeatherApiIml weatherApiIml = new WeatherApiIml();
            WeatherResponse weatherResponse = weatherApiIml.getWeather();
            System.out.println("Получили погоду на " + weatherResponse.getDailyForecasts().size() + " дней");
            SQLiteManager sqLiteManager = new SQLiteManager();
            try (
                    Connection connection = sqLiteManager.getConnection();
                    Statement stmt = connection.createStatement()
            ) {
                String sql = "CREATE TABLE WEATHER " +
                        "(CITY           TEXT    NOT NULL, " +
                        " LOCAL_DATE     TEXT    NOT NULL, " +
                        " WEATHER_TXT    TEXT    NOT NULL, " +
                        " TEMP           REAL    NOT NULL)";
                sqLiteManager.executeUpdate(stmt, sql);

//                connection.setAutoCommit(false);
                for (WeatherResponse.DailyForecasts dailyForecast : weatherResponse.getDailyForecasts()) {
                    String insert = "INSERT INTO WEATHER (CITY, LOCAL_DATE, WEATHER_TXT, TEMP) " +
                            "VALUES ('СПб', '" + dailyForecast.getDate().toString() + "', '" +
                            dailyForecast.getDay().getInfo() + "' , " +
                            dailyForecast.getTemperature().getMax().getValue() + ");";
                    sqLiteManager.executeUpdate(stmt, insert);
                }
//                connection.commit();

                String select = "SELECT * FROM WEATHER;";
                ResultSet resultSet = sqLiteManager.executeQuery(stmt, select);
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("CITY") + " ");
                    System.out.print(resultSet.getString("LOCAL_DATE") + " ");
                    System.out.print(resultSet.getString("WEATHER_TXT") + " ");
                    System.out.println(resultSet.getDouble("TEMP"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
