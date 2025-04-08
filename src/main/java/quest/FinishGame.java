package quest;



import javax.servlet.http.HttpSession;

public class FinishGame implements GameState {

    @Override
    public String getQuestion() {
        return "Игру окончено. Хочешь начать сначала? (Да/Нет)";
    }

    @Override
    public GameState handleResponse(String answer, HttpSession session) {
        if ("Да".equalsIgnoreCase(answer)){
            return new StartGame();
        }
        else {
            return this;
        }
    }

    @Override
    public boolean isFinal() {   //ТУТ НЕ ЗАБУДЬ НА ТРУ ПОМЕНЯТЬ
        return true;
    }
}
