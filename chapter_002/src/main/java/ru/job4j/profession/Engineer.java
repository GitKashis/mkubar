package ru.job4j.profession;

import ru.job4j.models.*;

public class Engineer extends Profession {
    private Scheme sheme;
    private Makita toolset;

    private Car companyCar;
    private Scheme projection;

    /**
     * Инженер ремонтирует машину.
     *
     * @param mashine машина типа Mashine, имеет имя name  и состояние repair.
     */
    public void repairTo(Mashine mashine) {
        System.out.println(this.getName() + "ремонтирует машину " + mashine.getName());
        mashine.setRepair(true);
    }

    /**
     * Инженер проектирует схему по данной фигуре.
     *
     * @param figure - параметр со строковым значением value.
     * @return Sheme.
     */
    public Scheme projection(Figure figure) {
        this.projection.setParameter(figure.getValue());
        return this.projection;
    }

    /**
     * Инженер проверяется у доктора, получает диагноз.
     *
     * @param doctor - doctor.
     * @return String возвращает то, что написал доктор при лечении.
     */
    public String checkHeal(Doctor doctor) {
        doctor.healTo(this);
        System.out.println(doctor.getName() + " поставил диагноз.");
        return doctor.diagnose.getDisease();
    }

}
