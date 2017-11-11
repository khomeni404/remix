package com.ibbl.util;

import com.ibbl.admin.model.Supplier;
import com.ibbl.house.model.MModel;
import com.ibbl.house.model.POrder;
import com.ibbl.incident.model.Incident;
import com.ibbl.incident.model.IncidentReview;
import com.ibbl.security.model.LoggedUser;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Khomeni
 *         Created on : 16-May-17
 */
public interface Constants {

    String LOGGED_USER = LoggedUser.class.getSimpleName();
    String INCIDENT = Incident.class.getSimpleName();
    String MASTER_MODEL = MModel.class.getSimpleName();
    String SUPPLIER = Supplier.class.getSimpleName();
    String P_ORDER = POrder.class.getSimpleName();
    String INCIDENT_REVIEW = IncidentReview.class.getSimpleName();

    SimpleDateFormat SDF_MM = new SimpleDateFormat("MM");
    SimpleDateFormat SDF_YY = new SimpleDateFormat("yy");
    SimpleDateFormat SDF_YYYY = new SimpleDateFormat("yyyy");
    SimpleDateFormat SDF_DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");


    List<String> MONTH_LIST = Arrays.asList("", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    Map<String, String> MONTH_MAP = IntStream.range(0, Constants.MONTH_LIST.size()).boxed().collect(Collectors.toMap(String::valueOf, Constants.MONTH_LIST::get));

    Map<String, String> INCIDENT_TYPE_MAP = new HashMap<String, String>() {{
        put("0", "");
        put("1", "Internet");
        put("2", "eIBS");
        put("3", "Database");
        put("4", "Network");
        put("5", "Hardware");
        put("6", "Others");
    }};


}
