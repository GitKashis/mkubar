package ru.job4j.profession;

import ru.job4j.models.*;

public class Teacher extends Profession {
    private Money money;
    private WorkPlan report;

    /**
     * Учитель учит студента, делает отметку в журнале и рабочем плане.
     *
     * @param student
     */
    public void learnTo(Profession student) {
        System.out.println(this.getName() + " проводит урок для " + student.getName());
        student.journal.setStatus(true);
        System.out.println("Отметка в журнал поставлена");
        this.report.setCount(100);
    }

    /**
     * Метод показывает, есть ли отметка (true) в журнале ученика.
     *
     * @param learner
     * @return
     */
    public boolean checkJournal(Student learner) {
        System.out.print("Идет проверка журнала у " + learner.getName());
        return learner.journal.getStatus();
    }

    /**
     * Инженер проверяетcя у доктора и получает диагноз.
     *
     * @param doctor - содержит в себе имя врача name.
     * @return Diagnose - содержит название болезни disease.
     */
    public String healStatus(Doctor doctor) {
        doctor.healTo(this);
        System.out.println(doctor.getName() + " поставил диагноз.");
        return doctor.diagnose.getDisease();
    }

    /**
     * Метод начисляет плату в соответствии с отчетом выполненной работы.
     *
     * @param
     * @return
     */
    public Money salary(WorkPlan report) {
        this.money.setPay(this.report.getCount());
        System.out.println("Оплата получена");
        return this.money;
    }
}
