package lesson8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private String city;
//    private String date;

    @JsonProperty("DailyForecasts")
    private List<DailyForecasts> dailyForecasts;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DailyForecasts {
        @JsonProperty("Date")
        private Date date;
        @JsonProperty("Temperature")
        private Temperature temperature;
        @JsonProperty("Day")
        private Info day;
        @JsonProperty("Night")
        private Info night;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        public void setTemperature(Temperature temperature) {
            this.temperature = temperature;
        }

        public Info getDay() {
            return day;
        }

        public void setDay(Info day) {
            this.day = day;
        }

        public Info getNight() {
            return night;
        }

        public void setNight(Info night) {
            this.night = night;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Temperature {
            @JsonProperty("Maximum")
            private TempValue max;
            @JsonProperty("Minimum")
            private TempValue min;

            public TempValue getMax() {
                return max;
            }

            public void setMax(TempValue max) {
                this.max = max;
            }

            public TempValue getMin() {
                return min;
            }

            public void setMin(TempValue min) {
                this.min = min;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TempValue {
                @JsonProperty("Value")
                private Float value;
                @JsonProperty("Unit")
                private String unit;

                public Float getValue() {
                    return value;
                }

                public void setValue(Float value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Info {
            @JsonProperty("IconPhrase")
            private String info;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<DailyForecasts> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecasts> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    public static WeatherResponse fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse result = objectMapper.readValue(json, WeatherResponse.class);
        return result;
    }
}
