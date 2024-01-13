package ch.bbw.lb.quiz;

public class QuizQuestion {

    private String question;

    private String[] answers;

    public QuizQuestion(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getAnswer(int index) {
        return answers[index];
    }
}
