package dev.etech.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GeradorDeMassa {
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static String gerarNomeAleatorio(){
        return faker.name().fullName();
    }

    public static String gerarEmailAleatorio(){
        return faker.internet().emailAddress();
    }
}
