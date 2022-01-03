package utcn;

;
public interface AppRepository<T, ID> {
    T save(T entity) throws UserAlreadyRegisteredException;
    T findById(ID id);
    T delete(T entity);
}
