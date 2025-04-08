package quest;

import javax.servlet.http.HttpSession;

public class StartGame implements GameState {

    @Override
    public String getQuestion(){
        return "Мерцает свет. Перед тобой - две двери. Какую выберешь? (Левая/Правая)";
    }

    @Override
    public GameState handleResponse(String answer, HttpSession session) {
        Object countObj = session.getAttribute("gameCount");
        int count = (countObj instanceof Integer) ? (Integer) countObj : 0;
        session.setAttribute("gameCount", count + 1);



        if ("Левая".equalsIgnoreCase(answer)) {
            return new LaptopChoice();
        }
        else {
            session.setAttribute("result", "Тебя ждала ловушка... Ты проиграл...");
            return new FinishGame();
        }

    }




    @Override
    public boolean isFinal() {
        return false;
    }

}
