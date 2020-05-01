package com.jsglobe.service;

public class Random {
    private static final String[] names = new String[]{
            "Wirya",
            "Gelawêj",
            "Nazdar",
            "Hêja",
            "Çiya",
            "Mehabad",
            "Zagros",
            "Dîlan",
            "Zîlan",
            "Cengawer",
            "Zirêbar",
            "Cigerxên",
            "Serok",
            "Pêşewa",
            "Samal",
            "Hêmin",
            "Şemal",
            "Rojan",
            "Rêbuwar",
            "Çiro",
            "Xece",
            "Şêrko",
            "Sirwe"
    };

    private static final String[] families = new String[]{
            "Mcbride",
            "Kaiser",
            "Leonard",
            "Roberts",
            "Pierce",
            "Herman",
            "Booth",
            "Shaffer",
            "Arroyo",
            "Stafford",
            "Mooney",
            "Jensen",
            "Garrett",
            "Sellers",
            "Russell",
            "Dominguez",
            "Aguilar",
            "Andersen",
            "Wang",
            "Walls",
            "Peters",
            "Hermê",
    };

    private static final String[] cities = new String[]{
            "Hewlêr",
            "Diyarbekir",
            "Qirs",
            "Qamişlû",
            "Serêkanî",
            "Kirmanşa",
            "Efrîn",
            "Amed",
            "Îlam",
            "Sine",
            "Şirnix",
            "Bane",
            "Kirkûk",
            "Dîrok",
            "Derbendînxan"
    };

    public static int number(int min, int max) {
        return Math.toIntExact(min + Math.round(Math.random() * (max - min)));
    }

    public static String city() {
        return cities[number(0, cities.length - 1)];
    }

    public static String address() {
        return number(1, 122) +
                "." +
                number(0, 254) +
                "." +
                number(0, 254) +
                "." +
                number(1, 122);
    }

    public static String name() {
        return names[number(0, names.length - 1)];
    }

    public static String family() {
        return families[number(0, families.length - 1)];
    }

    public static String fullName() {
        return name() + " " + family();
    }

}
