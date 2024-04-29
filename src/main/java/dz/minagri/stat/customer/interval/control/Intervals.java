package dz.minagri.stat.customer.interval.control;

import dz.minagri.stat.commons.control.Collections;
import dz.minagri.stat.customer.interval.entity.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public interface Intervals {

    static <T extends Comparable> Interval<T> of(T begin, T end) {
        Interval<T> interval = new Interval<>();
        interval.setBegin(begin);
        interval.setEnd(end);
        return interval;
    }

    static <T extends Comparable> Interval<T> of(T begin, T end, boolean exclusive) {
        Interval<T> interval = new Interval<>();
        interval.setBegin(begin);
        interval.setEnd(end);
        interval.setExclusive(exclusive);
        return interval;
    }

    /**
     * Returns true if the interval includes the value.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> boolean includes(I interval, T value) {
        T begin = interval.getBegin();
        T end = interval.getEnd();

        int compareValue = interval.isExclusive() ? 1 : 0;

        boolean beginCheck = begin == null || begin.compareTo((C) value) <= -compareValue;
        boolean endCheck = end == null || end.compareTo((C) value) >= compareValue;
        return beginCheck && endCheck;
    }

    /**
     * Returns true if the interval includes the value.
     */
    static <C, T extends Comparable<C>> boolean includes(T begin, T end, T value) {
        return includes(of(begin, end), value);
    }

    /**
     * Returns true if interval2 includes interval2.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> boolean includes(I interval1, I interval2) {
        T begin1 = interval1.getBegin();
        T end1 = interval1.getEnd();
        T begin2 = interval2.getBegin();
        T end2 = interval2.getEnd();

        if (begin1 != null && begin2 == null) {
            return false;
        }
        if (end1 != null && end2 == null) {
            return false;
        }

        int compareValue = interval1.isExclusive() ? 1 : 0;

        boolean beginCheck = begin1 == null || begin1.compareTo((C) begin2) <= -compareValue;
        boolean endCheck = end1 == null || end1.compareTo((C) end2) >= compareValue;
        return beginCheck && endCheck;
    }

    /**
     * Returns true if there is an overlap between interval1 and interval2.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> boolean overlaps(I interval1, I interval2) {
        T begin1 = interval1.getBegin();
        T end1 = interval1.getEnd();
        T begin2 = interval2.getBegin();
        T end2 = interval2.getEnd();

        int compareValue = interval1.isExclusive() || interval2.isExclusive() ? 1 : 0;

        boolean beginCheck = begin1 == null || end2 == null || begin1.compareTo((C) end2) <= -compareValue;
        boolean endCheck = end1 == null || begin2 == null || end1.compareTo((C) begin2) >= compareValue;
        return beginCheck && endCheck;
    }

    /**
     * Merges any overlapping in the given list of intervals.
     */
    static <T extends Comparable> List<Interval<T>> mergeOverlapping(List<Interval<T>> intervals) {
        List<Interval<T>> sortedIntervals = Collections.getSortedList(intervals, (i1, i2) -> {
            T begin1 = i1.getBegin();
            T begin2 = i2.getBegin();
            if (begin1 == null && begin2 == null) {
                return 0;
            }
            if (begin1 == null) {
                return -1;
            }
            if (begin2 == null) {
                return 1;
            }
            return begin1.compareTo(begin2);
        });

        Vector<Interval<T>> mergedIntervals = new Vector<>();
        for (Interval<T> interval : sortedIntervals) {
            Interval<T> lastMergedInterval = mergedIntervals.isEmpty() ? null : mergedIntervals.lastElement();
            if (lastMergedInterval != null && overlaps(lastMergedInterval, interval)) {
                Interval<T> mergedInterval = of(lastMergedInterval.getBegin(), interval.getEnd());
                mergedIntervals.set(mergedIntervals.size() - 1, mergedInterval);
            } else {
                mergedIntervals.add(interval);
            }
        }
        return new ArrayList<>(mergedIntervals);
    }

    /**
     * Returns all intervals overlapping the reference interval.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> List<I> getOverlapping(List<I> intervals, Interval<T> referenceInterval) {
        return intervals.stream().filter(i -> overlaps(i, referenceInterval)).collect(Collectors.toList());
    }

    /**
     * Returns the first interval including the value.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> I getFirstIncluding(List<I> intervals, T value) {
        return Collections.getFirstOrNull(getIncluding(intervals, value));
    }

    /**
     * Returns the intervals including the value.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> List<I> getIncluding(List<I> intervals, T value) {
        return intervals.stream().filter(i -> includes(i, value)).collect(Collectors.toList());
    }

    /**
     * Returns true if any of the intervals includes the value.
     */
    static <C, T extends Comparable<C>, I extends Interval<T>> boolean hasIncluding(List<I> intervals, T value) {
        return intervals.stream().anyMatch(i -> includes(i, value));
    }
}
