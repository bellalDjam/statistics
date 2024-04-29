package dz.minagri.stat.customer.interval.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interval<T extends Comparable> {
    private T begin;
    private T end;
    private boolean exclusive;
}
