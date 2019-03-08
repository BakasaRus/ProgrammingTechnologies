package StockListProject;

import java.util.Objects;

public class TechnicalItem extends GenericItem {
    public short warrantyTime;

    public void printAll() {
        super.printAll();
        System.out.printf("Warranty time: %d\n", warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyTime);
    }
}
