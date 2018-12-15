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
    }//TODO! ������� �����
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

                            /**TODO ���������� �������� ����� � ��������� ��� � �������*/

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
                              {sendMag(message, "������, ���������� ��� � ����� �������. �� ��� ������ ��������, ����� �� ������, � � ���� ��������� ��� ����������, ��� � ����/������/�����");
                                    /** ������� �� +���+���+���� ���**/
                              sendMag(message, "Click /help  ����� ������� ���  ��������");
                                //  sendMag(message, ); //todo test user function
                              System.out.println(message.getText());


                             //   System.out.println("������ ��� ����� ������ ���� ������� ����. ���������� �������� + ��� - �� UTC");
                                /*TODO �������� ����*/
                             //   System.out.println("��� ���� �����?");
                                /*TODO ���*/
                             //  System.out.println("������� ����� ���� ����� �������?(�� 20��)");
                                /*TODO ���� �������*/
                              }
                             break;
                             case "/help": /*TODO */
                             {sendMag(message, "+cigarette -��� �������� ��������");
                                 //sendMag(message, );
                                 sendMag(message, "+Say -���� ������, ����� � ���� ������������� ����� (������ � ���� � �������)");
                                 sendMag(message, "Day -�������� �� ����. Week -���������� �� ������. Month -���������� �� �����.");
                                 System.out.println(message.getText());}
                                 break;

                             case "+cigarette": /*TODO */
                             { //TODO; ������� ���� � ��
                                 methodExample();
                                 String asCigarette = Integer.toString(cigarette);
                                 sendMag(message, "�������� ���������.");
                                 sendMag(message, "�������� �������.");
                                 sendMag(message,asCigarette);
                                 System.out.println(message.getText());
                                 }
                                 break;

                                                /**������� ������ **/
                             case "+Say": /*TODO */
                                 sendMag(message, "***");////TODO; �������� ������ ������ � ������� ���� � ���������� ����� � �������� ��� ����������� �� ����
                                 System.out.println(message.getText());
                                 break;
                                                /** ���������� **/
                             case "Day":
                                 sendMag(message, "�� ���� ���� �� �������� ");/**TODO; ���-�� �������, � ����*/
                                 //TODO;  =����� ��� �� ���� (�� ��)
                                 System.out.println(message.getText());
                                 break;
                             case "Week":
                                 sendMag(message, "�� ��� ������ �� ��������");/**TODO; ���-�� �������, � ����*/
                                 //TODO =����� ��� �� ������ (�� ��)
                                 System.out.println(message.getText());
                                 break;
                             case "Month":
                                 sendMag(message, "�� ���� ����� �� ��������:" /**TODO; ���-�� �������, � ����*/);
                                 //TODO =����� ��� �� ����� (�� ��)
                                 System.out.println(message.getText());
                                 break;


                                 /** ����� ����������*/
                             case "/removeall":
                                 cigarette=0; //TODO �������� ��
                                 sendMag(message, "���������� �������");//TODO;
                                 System.out.println(message.getText());
                                 break;

                             default:
                                 sendMag(message, "��������� �������? �������� � ����� ��������� @afqspirit");
                                 sendMag(message, "All commands /help");
                                 System.out.println(message.getText());
                                 break;
                                }

                            }
                        }

    public void sendMag(Message message, String s){

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        //TODO; ��� ������ ����������

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);//false
        /** ������� ������ ����� ����������*/
        List<KeyboardRow> keyboard = new ArrayList<>();
        /**������ ������� ����������**/
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        /** ��������� ������ � ������ ������� ����������*/
        keyboardFirstRow.add("+cigarette");
        keyboardFirstRow.add("+Say");

        /** ������ ������� ����������*/
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        /** ��������� ������ �� ������ ������� ����������*/
        keyboardSecondRow.add("Day");
        keyboardSecondRow.add("Week");
        keyboardSecondRow.add("Month");

        /**  ��������� ��� ������� ���������� � ������ */
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        /**  � ������������� ���� ������ ����� ���������� */
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);


/**TODO � �� ����� ��� ����� **/
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