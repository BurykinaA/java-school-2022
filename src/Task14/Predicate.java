@FunctionalInterface
public interface  Predicate<Relies> {
    boolean test(Relies t); // для модификации сервисов, могут разные списки запрещенных слов отдавать
}
