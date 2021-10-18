package lesson7;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 1. Реализовать корректный вывод информации о текущей погоде. Создать класс WeatherResponse и десериализовать ответ
 * сервера. Выводить пользователю только текстовое описание погоды и температуру в градусах Цельсия.
 * <p>
 * 2. Реализовать корректный выход из программы
 * <p>
 * 3. Реализовать вывод погоды на следующие 5 дней в формате | В городе CITY на дату DATE ожидается WEATHER_TEXT,
 * температура - TEMPERATURE |
 * <p>
 * где CITY, DATE, WEATHER_TEXT и TEMPERATURE - уникальные значения для каждого дня.
 */
public class Lesson7 {
    private final static String SPB_WEATHER_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=FPFK9ArHF4qck8Msx6lUJEfOVDB5WpF7&language=ru-ru&metric=true";

    public static void main(String[] args) {
        try {
            String json = getHttpResult(SPB_WEATHER_URL);
            WeatherResponse weatherResponse = WeatherResponse.fromJson(json);
            for (WeatherResponse.DailyForecasts dailyForecast : weatherResponse.getDailyForecasts()) {
                System.out.println(
                        String.format("В городе %s на дату %s ожидается %s, %s-%sC",
                                "Санкт-Петербург",
                                dailyForecast.getDate(),
                                String.format("днем %s, ночью %s",
                                        dailyForecast.getDay().getInfo(),
                                        dailyForecast.getNight().getInfo()
                                ),
                                dailyForecast.getTemperature().getMin().getValue(),
                                dailyForecast.getTemperature().getMax().getValue()
                        )
                );
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getHttpResult(final String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
