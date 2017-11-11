package com.ibbl.util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Khomeni
 *         Created on : 20-May-17 at 12:57 AM
 */

public class Test {
    public static void main(String[] args) throws Exception{
        /*IntStream.range(0, Constants.INCIDENT_TYPE_LIST.size())
                .boxed()
                .collect(Collectors.toMap(Constants.INCIDENT_TYPE_LIST::get, i -> i));
        Constants.INCIDENT_TYPE_LIST.stream().collect(Collectors.toMap(i -> i, i -> Constants.INCIDENT_TYPE_LIST.indexOf(i)));
        System.out.println();*/
        String[][] my2Darr = new String[][]{{"Hi", "hello"}, {"Hmm", "do"}};
        List<String> list = new ArrayList<>();
        for(int i = 0; i < my2Darr.length; i++) {
            list.addAll(Arrays.asList(my2Darr[i])); // java.util.Arrays
        }
        String[] my1Darr = new String[list.size()];
        my1Darr = list.toArray(my1Darr);
        System.out.println(my1Darr.toString());
    }
}
