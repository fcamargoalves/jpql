package br.com.devmedia.introducaojpql;

import br.com.devmedia.introducaojpql.consultas.ConsultasJPQL;

public class Programa {
    public static void main(String args[]) {

        ConsultasJPQL consultas = new ConsultasJPQL();

        //System.out.println(consultas.listarTodasSeries());
        //System.out.println(consultas.listarSeriesCriadasNoAno2008());
        //System.out.println(consultas.listarSeriesCriadasNoAno(2013));
        //System.out.println(consultas.listarSeriesCujoNomeContenha("ng"));
        //System.out.println(consultas.recuperarSeriePorAnoENome("Gotham", 2013));
        //System.out.println(consultas.recuperarSeriePorAnoENome("Gotham", 2013));
        System.out.println(consultas.recuperarSeriePorNomeEAno2("Gotham", 2013));


    }
}
