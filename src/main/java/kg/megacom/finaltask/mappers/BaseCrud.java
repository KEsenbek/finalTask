package kg.megacom.finaltask.mappers;

import java.util.List;

public interface BaseCrud<E, D> {
    E toDto(D d);

    D toEntity(E e);

    List<E> toDtos(List<D> d);

    List<D> toEntities(List<E> e);
}
