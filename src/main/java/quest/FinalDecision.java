package quest;

import javax.servlet.http.HttpSession;

public class FinalDecision implements  GameState{

    @Override
    public String getQuestion() {
        return "На экране вопрос: Веришь ли ты в себя? (Да/Нет) ";
    }

    @Override
    public GameState handleResponse(String answer, HttpSession session) {
        if ("Да".equalsIgnoreCase(answer)){
            session.setAttribute("result", "Ты избранный. Победа!");
        }
        else {
            session.setAttribute("result", "Твоя неуверенность тебя подвела. Ты проиграл..");
        }
        return new FinishGame();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
