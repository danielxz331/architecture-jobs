package persistencia;

import aplicacionsolid.*;
import crud.*;
import repositorio.*;
import crudarchivos.*;
import java.sql.Connection;

public class DATA_SEED {

    static Departamento departamento1 = new Departamento(1, "Cundinamarca");
    static Departamento departamento2 = new Departamento(2, "Boyaca");
    static Departamento departamento3 = new Departamento(3, "Meta");



    static Municipio municipio1 = new Municipio(1, "Bogota", departamento1);
    static Municipio municipio2 = new Municipio(2, "Chia", departamento1);
    static Municipio municipio3 = new Municipio(3, "Tunja", departamento2);
    static Municipio municipio4 = new Municipio(4, "Duitama", departamento2);
    static Municipio municipio5 = new Municipio(5, "Cumaral", departamento2);



    static Lugar lugar1 = new Lugar(1, "Universidad de la Sabana", departamento1, municipio1);
    static Lugar lugar2 = new Lugar(2, "Universidad de la Sabana", departamento1, municipio2);
    static Lugar lugar3 = new Lugar(3, "Universidad de Boyaca", departamento2, municipio3);
    static Lugar lugar4 = new Lugar(4, "Universidad de Boyaca", departamento2, municipio4);
    static Lugar lugar5 = new Lugar(5, "Universidad de los Llanos", departamento2, municipio4);



    static Programa programa1 = new Programa(1, "Ingenieria de Sistemas", 10, lugar1);
    static Programa programa2 = new Programa(2, "Ingenieria Electronica", 10, lugar2);
    static Programa programa3 = new Programa(3, "Ingenieria de Procesos", 10, lugar3);
    static Programa programa4 = new Programa(4, "Ingenieria Ambiental", 10, lugar4);



    static Estudiante estudiante1 = new Estudiante("Daniel Stiven", "Martinez MT09", 1, 160004400, programa1, lugar1);
    static Estudiante estudiante2 = new Estudiante("Roger Roger", "Egan Roldan", 2, 160004401, programa2, lugar2);
    static Estudiante estudiante3 = new Estudiante("Rulitos Felipe", "Varon Ducu", 3, 160004402, programa3, lugar3);
    static Estudiante estudiante4 = new Estudiante("Juan Lopez", "Amortegui Matador", 4, 160004403, programa4, lugar4);
    static Estudiante estudiante5 = new Estudiante("Abelardo De", "La Asprilla", 5, 160004404, programa1, lugar1);
    static Estudiante estudiante6 = new Estudiante("Carlitos", "Bocanegra", 6, 160004405, programa2, lugar2);
    static Estudiante estudiante7 = new Estudiante("Miguel", "Angel", 7, 160004406, programa3, lugar3);
    static Estudiante estudiante8 = new Estudiante("Juan", "Perez", 8, 160004407, programa4, lugar4);
    static Estudiante estudiante9 = new Estudiante("Pedro", "Perez", 9, 160004408, programa1, lugar1);
    static Estudiante estudiante10 = new Estudiante("Manuela", "Porras", 10, 160004409, programa2, lugar2);


    static DepartamentoRepositorio departamentoRepositorio = new DepartamentoRepositorio();
    static MunicipioRepositorio municipioRepositorio = new MunicipioRepositorio();
    static LugarRepositorio lugarRepositorio  = new  LugarRepositorio();
    static ProgramaRepositorio programaRepositorio = new ProgramaRepositorio();
    static EstudianteRepositorio estudianteRepositorio = new EstudianteRepositorio();

    public static void ejecutar(){

        departamentoRepositorio.crear(departamento1);
        departamentoRepositorio.crear(departamento2);
        departamentoRepositorio.crear(departamento3);

        municipioRepositorio.crear(municipio1);
        municipioRepositorio.crear(municipio2);
        municipioRepositorio.crear(municipio3);
        municipioRepositorio.crear(municipio4);
        municipioRepositorio.crear(municipio5);

        lugarRepositorio.crear(lugar1);
        lugarRepositorio.crear(lugar2);
        lugarRepositorio.crear(lugar3);
        lugarRepositorio.crear(lugar4);
        lugarRepositorio.crear(lugar5);

        programaRepositorio.crear(programa1);
        programaRepositorio.crear(programa2);
        programaRepositorio.crear(programa3);
        programaRepositorio.crear(programa4);

        estudianteRepositorio.crear(estudiante1);
        estudianteRepositorio.crear(estudiante2);
        estudianteRepositorio.crear(estudiante3);
        estudianteRepositorio.crear(estudiante4);
        estudianteRepositorio.crear(estudiante5);
        estudianteRepositorio.crear(estudiante6);
        estudianteRepositorio.crear(estudiante7);
        estudianteRepositorio.crear(estudiante8);
        estudianteRepositorio.crear(estudiante9);
        estudianteRepositorio.crear(estudiante10);



        estudianteRepositorio.eliminar(estudiante7.getId());
        estudiante8.setNombres("Chamito");
        estudianteRepositorio.editar(estudiante8.getId(), estudiante8);

        departamentoRepositorio.eliminar(departamento3.getId());
        departamento1.setNombre("Antioquia");
        departamentoRepositorio.editar(departamento1.getId(), departamento1);

        municipioRepositorio.eliminar(municipio5.getId());
        municipio4.setNombre("Duitamita");
        municipioRepositorio.editar(municipio4.getId(), municipio4);

    }

}
