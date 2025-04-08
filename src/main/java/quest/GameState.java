package quest;


import javax.servlet.http.HttpSession;

public interface GameState {

    String getQuestion(); //возвращает текст вопроса
    GameState handleResponse(String answer, HttpSession session);
    boolean isFinal(); // финальный стейт ну стан для завершения игрульки
}
