package quest;

import javax.servlet.http.HttpSession;

public class NameInput implements GameState {

    @Override
    public String getQuestion() {
        return "На экране написано: Введи свое имя - ... ";
    }

    @Override
    public GameState handleResponse(String answer, HttpSession session) {
        session.setAttribute("PlayerName", answer);
        return new FinalDecision();
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
