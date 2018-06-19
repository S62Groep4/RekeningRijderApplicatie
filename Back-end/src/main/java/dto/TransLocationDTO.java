package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class TransLocationDTO implements Serializable {

    private Long lat;
    private Long lon;
    private String dateTime;
    private String serialNumber;
    private String countryCode;

    public TransLocationDTO() {
    }

    public TransLocationDTO(Double lat, Double lon, String dateTime, String serialNumber, String countryCode) {
        this.lat = lat.longValue();
        this.lon = lon.longValue();
        this.dateTime = dateTime;
        this.serialNumber = serialNumber;
        this.countryCode = countryCode;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getLat() {
        return lat;
    }

    public Long getLon() {
        return lon;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
