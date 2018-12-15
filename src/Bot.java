import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

import static com.oracle.tools.packager.IOUtils.execute;


public class Bot extends TelegramLongPollingBot {

   /*
    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }//TODO! удалить нахер
    */

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

    @Override
    public String getBotUsername() {
    return "The Cigarettes";
}

    @Override
    public String getBotToken() {
        return "";   // TODO: insert TOKEN
    }

                            /**TODO необходимо объявить класс и перенести все в кейборд*/

    public int cigarette=0;
    public void methodExample(){
    ++cigarette;

    }

    @Override
               public void onUpdateReceived(Update update) {
                    Message message = update.getMessage();
                    if(message != null && message.hasText()) {
                         switch (message.getText()) {
                            case "/start":
                              {sendMag(message, "Привет, сигаретный бот к вашим услугам. Ты мне будешь говорить, когда ты куришь, а я тебе присылать всю статистику, раз в день/неделю/месяц");
                                    /** заводим БД +час+имя+цена сиг**/
                              sendMag(message, "Click /help  чтобы увидеть все  комманды");
                                //  sendMag(message, ); //todo test user function
                              System.out.println(message.getText());


                             //   System.out.println("Теперь мне нужно узнать твой часовой пояс. Достаточно написать + или - от UTC");
                                /*TODO чаасовой пояс*/
                             //   System.out.println("Как тебя зовут?");
                                /*TODO имя*/
                             //  System.out.println("Сколько стоит одна пачка сигарет?(за 20шт)");
                                /*TODO цена сигарет*/
                              }
                             break;
                             case "/help": /*TODO */
                             {sendMag(message, "+cigarette -как закуришь сигарету");
                                 //sendMag(message, );
                                 sendMag(message, "+Say -если хочешь, чтобы к тебе присоединился сосед (только в чате с соседом)");
                                 sendMag(message, "Day -статиска за день. Week -статистика за неделю. Month -статистика за месяц.");
                                 System.out.println(message.getText());}
                                 break;

                             case "+cigarette": /*TODO */
                             { //TODO; занести сигу в бд
                                 methodExample();
                                 String asCigarette = Integer.toString(cigarette);
                                 sendMag(message, "Сигарета добавлена.");
                                 sendMag(message, "Выкурено сигарет.");
                                 sendMag(message,asCigarette);
                                 System.out.println(message.getText());
                                 }
                                 break;

                                                /**Сказать соседу **/
                             case "+Say": /*TODO */
                                 sendMag(message, "***");////TODO; получить список друзей в сделать кейс с обработкой друга и отправки ему приглашения от бота
                                 System.out.println(message.getText());
                                 break;
                                                /** СТАТИСТИКА **/
                             case "Day":
                                 sendMag(message, "За этот день вы выкурили ");/**TODO; кол-во сигарет, и цена*/
                                 //TODO;  =сумма сиг за день (из бд)
                                 System.out.println(message.getText());
                                 break;
                             case "Week":
                                 sendMag(message, "за эту неделю вы выкурили");/**TODO; кол-во сигарет, и цена*/
                                 //TODO =сумма сиг за неделю (из бд)
                                 System.out.println(message.getText());
                                 break;
                             case "Month":
                                 sendMag(message, "За этот месяц вы выкурили:" /**TODO; кол-во сигарет, и цена*/);
                                 //TODO =сумма сиг за месяц (из бд)
                                 System.out.println(message.getText());
                                 break;


                                 /** СБРОС статистики*/
                             case "/removeall":
                                 cigarette=0; //TODO оочистка бд
                                 sendMag(message, "Статистика удалена");//TODO;
                                 System.out.println(message.getText());
                                 break;

                             default:
                                 sendMag(message, "Появились вопросы? Обратись к моему создателю @afqspirit");
                                 sendMag(message, "All commands /help");
                                 System.out.println(message.getText());
                                 break;
                                }

                            }
                        }

    public void sendMag(Message message, String s){

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        //TODO; тут делаем клавиатуру

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);//false
        /** Создаем список строк клавиатуры*/
        List<KeyboardRow> keyboard = new ArrayList<>();
        /**Первая строчка клавиатуры**/
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        /** Добавляем кнопки в первую строчку клавиатуры*/
        keyboardFirstRow.add("+cigarette");
        keyboardFirstRow.add("+Say");

        /** Вторая строчка клавиатуры*/
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        /** Добавляем кнопки во вторую строчку клавиатуры*/
        keyboardSecondRow.add("Day");
        keyboardSecondRow.add("Week");
        keyboardSecondRow.add("Month");

        /**  Добавляем все строчки клавиатуры в список */
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        /**  и устанваливаем этот список нашей клавиатуре */
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);


/**TODO я бы убрал эту хуйню **/
        try {

            execute(sendMessage);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();}
    }
}

            /**.
             *Developer: Zhuk Aleksandr
             *St. Petersburg
             *bio: @afqspirit -telegram/git-hub
             */