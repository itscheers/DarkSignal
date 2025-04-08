package quest;

import javax.servlet.http.HttpSession;

public class LaptopChoice implements GameState {

    @Override
    public String getQuestion() {
        return "В темноте ноутбук. Запустишь ли ты единственный файл на рабочем столе? (Да/Нет)";
    }

    @Override
    public GameState handleResponse(String answer, HttpSession session) {
        if ("Да".equalsIgnoreCase(answer)){
            return new NameInput();
        }
        else {
            session.setAttribute("result", "Ты потерял свой шанс на подсказку! Ты проиграл");
            return new FinishGame();
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
