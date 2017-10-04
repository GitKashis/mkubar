package ru.job4j.tracker;

/**
 * Class for answers to tests.
 */
class StubInput implements Input {
    /**
     * Answers array.
     */
    private String[] answers;
    /**
     * Answer position in array.
     */
    private int position = 0;

    /**
     * Constructor.
     * @param answers - answers array.
     */

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Take question and return answers from answers arry.
     * @param question - question.
     * @return String.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }
    /**
     * Ask question and return answer.
     * @param question - question.
     * @param range - range of menu.
     * @return String.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        return exist ? key : -1;
    }

    @Override
    public void print(Object[] objects) {

    }

//    /**
//     * No operation.
//     * @param message - message.
//     */
//    @Override
//    public void print(String message) {
//        System.out.println(message);
//    }
}