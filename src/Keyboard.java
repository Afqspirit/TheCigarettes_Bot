import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
 /**                    Возомжно сюда перенесу клавиатуру
  * Todo: Подумай об этом, и сделай, НЕОБЯЗАТЕЛЬНО*/
public class Keyboard extends TelegramLongPollingBot{


/**Получение id пользователя для дальнейшей работы с этим id*/

     public String username (){
         getMe(username);
         System.out.print(username); ;
     }




}




            /**.
             *Developer: Zhuk Aleksandr
             *St. Petersburg
             *bio: @afqspirit -telegram/git-hub
             */