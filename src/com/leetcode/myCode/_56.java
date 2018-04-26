//package com.leetcode.myCode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class _56 {
//    public List<Interval> merge(List<Interval> intervals) {
//        if (intervals.size() == 0) return intervals;
//
//        Interval a = intervals.get(0);
//        for (int i = 1; i < intervals.size(); i++) {
//            Interval b = intervals.get(i);
//            if (a.end >= b.start && a.start <= b.end) {
//                a.end = Math.max(b.end, a.end);
//                a.start = Math.min(b.start, a.start);
//                intervals.remove(i);
//                i--;
//            } else if (a.start > b.end) {
//                int tempStart = a.start;
//                int tempEnd = a.end;
//                a.start = b.start;
//                a.end = b.end;
//                b.start = tempStart;
//                b.end = tempEnd;
//            }
//        }
//        return intervals;
//    }
//    public static void main(String args[]) {
//        _56 test = new _56();
//        List<Interval> intervals = new ArrayList<Interval>();
//        Interval a = new Interval(1, 4);
//        Interval b = new Interval(0, 0);
////        Interval c = new Interval(8, 10);
////        Interval d = new Interval(15, 18);
//        intervals.add(a);
//        intervals.add(b);
////        intervals.add(c);
////        intervals.add(d);
//        test.merge(intervals);
//        for (Interval i : intervals) {
//            System.out.print("[" + i.start + ", " + i.end+ "] " );
//        }
//    }
//}
