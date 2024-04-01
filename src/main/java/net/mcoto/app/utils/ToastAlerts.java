package net.mcoto.app.utils;

import jakarta.ejb.Singleton;
import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ToastAlerts {
    private String SUCCESS = "";
    private String ERROR = "";
    private String INFO = "";
    private String WARNING = "";


    public String SUCCESS(String message) {
        return this.SUCCESS = message;
    }


    public String ERROR(String message) {
        return this.ERROR = message;
    }


    public String INFO(String message) {
        return this.INFO = message;
    }

    public String WARNING(String message) {
        return this.WARNING = message;
    }
}
