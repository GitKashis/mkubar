package ru.job4j.profession;

import ru.job4j.models.*;

/**
 * Класс Доктор получает наследуемые поля от класса Profession, а так же
 * имеет поля диагноз, квалификация и рабочий план.
 */
public class Doctor extends Profession {
    private WorkPlan report;
    public Diagnose diagnose;
    private Qualifications qualifications;

    /**
     * Доктор лечит пациента типа.
     *
     * @param currentPacient пациент класса Pacient (наследован от Profession).
     */
    public void healTo(Profession currentPacient) {
        System.out.println(this.getName() + " лечит пациента " + currentPacient.getName());
        diagnose.setDisease("Приступ лени");
        System.out.println("Диагноз поставлен");
    }

    /**
     * Делаем запись в отчете согласно поставленному диагнозу.
     *
     * @param diagnose имеет строку "болезнь" (disease).
     * @return WorkPLan отчет с записью типа record.
     */
    public WorkPlan report(Diagnose diagnose) {
        this.report.setRecord(diagnose.getDisease());
        return this.report;
    }

    /**
     * Доктор проходит обучение у лектора и повышает свою квалификацию.
     *
     * @param lector - учитель класса Teacher.
     * @return qualifications - показатель квалификации повышен.
     */
    public Qualifications lectionUp(Teacher lector) {
        lector.learnTo(this);
        System.out.println(this.getName() + " прошел обучение у " + lector.getName());
        this.qualifications.qualificationChange();
        System.out.println("Квалификация изменена");
        return this.qualifications;
    }

}
