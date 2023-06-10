package AimsProject.src.hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int compare = m1.getTitle().compareTo(m2.getTitle());
        if (compare != 0)
            return compare;
        return Double.compare(m1.getCost(), m2.getCost());
    }
}
