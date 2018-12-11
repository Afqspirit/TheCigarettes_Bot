import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramWebhookBot;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
/**          Тут метод для обхода блокировки. Но он не нужен, если использовать прокси на пк, либо загрузить бота на сервак с прокси.
 *                          Но этот метод теоретически должен работать           */
public class Main {



    }


/*
    public static void main(String[] args) {
        System.setProperty("http.proxyUser", "proxyUser");
        System.setProperty("http.proxyPassword", "secret");

// Java ignores http.proxyUser. Here come's the workaround.
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                if (getRequestorType() == RequestorType.PROXY) {
                    String prot = getRequestingProtocol().toLowerCase();
                    String host = System.getProperty(prot + ".proxyHost", "185.20.184.217");
                    String port = System.getProperty(prot + ".proxyPort", "4514");
                    String user = System.getProperty(prot + ".proxyUser", "userid7459");
                    String password = System.getProperty(prot + ".proxyPassword", "FJE7EQn");
                    if (getRequestingHost().equalsIgnoreCase(host)) {
                        if (Integer.parseInt(port) == getRequestingPort()) {
                            return new PasswordAuthentication(user, password.toCharArray());
                        }
                    }
                }
                return null;
            }
        });

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot (new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    */


            /**.
             *Developer: Zhuk Aleksandr
             *St. Petersburg
             *bio: @afqspirit -telegram/git-hub
             */
