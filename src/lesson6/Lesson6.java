package lesson6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Lesson6 {
    private final static String SPB_WEATHER_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=FPFK9ArHF4qck8Msx6lUJEfOVDB5WpF7&language=ru-ru";


    public static void main(String[] args) {
        try {
            System.out.println(getHttpResult(SPB_WEATHER_URL));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени, пересекающийся со
     * следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
     *
     * @return
     */
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
