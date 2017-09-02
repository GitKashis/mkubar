package ru.job4j.profession;

import ru.job4j.models.Adress;
import ru.job4j.models.Journal;

/**
 * Класс является родительским для Doctor, Engineer, Teacher, Student, Pacient.
 * Содержит поля, используемые во всех классах. *
 */
public class Profession {

	private String name;

    private Adress address;
    public Journal journal;
    public String getName() {
		return this.name;
	}

	public String getAdress() {
		return this.name;
	}

}
