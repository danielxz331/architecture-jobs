package interfaces;

public interface Repositorio<Obj> {

    void crear(Obj objeto);

    Obj obtener(int id);

    void editar(int id, Obj objeto);

    void eliminar(int id);

}
