import java.time.LocalDate;
import java.util.Objects;

/**
 * Lazy calculation
 */
public class SupplierSample {
    LocalDate day = LocalDate.of(2021, 6, 17);

    private LocalDate getNonNullDay(LocalDate day) {
        return Objects.requireNonNullElse(day, LocalDate.of(1970,1,1));
    }

    // returns the first argument if it is non-null and
    // otherwise the value from supplier.get() if it is non-null
    private LocalDate lazyGetNonNullDay(LocalDate day) {
        return Objects.requireNonNullElseGet(day, () -> LocalDate.of(1970,1,1));
    }

    public static void main(String[] args) {
        SupplierSample sample = new SupplierSample();

        long start = System.currentTimeMillis();
        for (int i = 0; i <= 20000; i++) {
            sample.getNonNullDay(null);
        }
        System.out.println(String.format("Time: %s", System.currentTimeMillis() - start));

        SupplierSample sample2 = new SupplierSample();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i <= 20000; i++) {
            sample2.lazyGetNonNullDay(null);
        }
        System.out.println(String.format("Time: %s",System.currentTimeMillis() - start2));
        //result: 7 , 4
    }
}
