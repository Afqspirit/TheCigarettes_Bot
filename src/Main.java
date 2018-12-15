import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramWebhookBot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Метод для работы с таблицей excel
 *
 * Метод для обхода блокировки.
 *  (Но он не нужен, если использовать прокси на пк, либо загрузить бота на сервак с прокси.
 *                          Но этот метод теоретически должен работать )          */
public class Main {
// TODO  тут у нас будет БД

                        /** ЗАПИСЬ в таблицу*/
@SuppressWarnings("deprecation")
public static void writeIntoExcel(String file) throws FileNotFoundException, IOException {
    Workbook book = new HSSFWorkbook();
    Sheet sheet = book.createSheet("Birthdays"); // todo telegramUser =  Sheet

    // Нумерация начинается с нуля
    Row row = sheet.createRow(0);

    // Мы запишем имя и дату в два столбца
    // имя будет String, а дата рождения --- Date,
    // формата dd.mm.yyyy
    Cell telegramUser = row.createCell(0);
    telegramUser.setCellValue("John");

    Cell birthdate = row.createCell(1); //сигарета +1

    DataFormat format = book.createDataFormat();
    CellStyle dateStyle = book.createCellStyle();
    dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
    birthdate.setCellStyle(dateStyle);


    // Нумерация лет начинается с 1900-го
    birthdate.setCellValue(new Date);

    // Меняем размер столбца
    sheet.autoSizeColumn(1);

    // Записываем всё в файл
    book.write(new FileOutputStream(file));
    book.close();
}
                            /**ЧТЕНИЕ таблицы*/
                            /*
    public static void readFromExcel(String file) throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
        HSSFRow row = myExcelSheet.getRow(0);

        if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
            String name = row.getCell(0).getStringCellValue();
            System.out.println("name : " + name);
        }

        if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue();
            System.out.println("birthdate :" + birthdate);
        }

        myExcelBook.close();

    }

*/









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
