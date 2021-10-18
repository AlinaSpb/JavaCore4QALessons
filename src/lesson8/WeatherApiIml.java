package lesson8;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherApiIml {
    private final static String SPB_WEATHER_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=FPFK9ArHF4qck8Msx6lUJEfOVDB5WpF7&language=ru-ru&metric=true";

    public WeatherResponse getWeather() throws IOException {
        String json = getHttpResult(SPB_WEATHER_URL);
        WeatherResponse weatherResponse = WeatherResponse.fromJson(json);
        return weatherResponse;
    }

    public String getHttpResult(final String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
