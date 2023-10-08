package com.ccl.interfaces.ws.simpleintapi.constants;

public class HeadersConstants {
    public static final String WAGON_HEAD = "VAGÓN";
    public static final String CONTAINER_HEAD = "CONTENEDOR";

    public static final String CONSIGN_HEAD = "Consignado";
    public static final String NUMBER_WAGON_HEAD = "Número";
    public static final String TARA_WAGON_HEAD = "Tara";
    public static final String SEAL_ID_WAGON_HEAD = "Nº Precinto";
    public static final String FM_WAGON_HEAD = "F.M.";

    public static final String NUMBER_CONTAINER_HEAD = "Número";
    public static final String FOOTERS_CONTAINER_HEAD = "Pies";
    public static final String VC_CONTAINER_HEAD = "V/C";
    public static final String CHARGE_CONTAINER_HEAD = "Carga Conte";
    public static final String HEIGHT_CONTAINER_HEAD = "Altura";
    public static final String TARA_CONTAINER_HEAD = "Tara";
    public static final String CHARGE_MAX_CONTAINER_HEAD = "Carga Mx.";
    public static final String DESTINATION_CONTAINER_HEAD = "Destino";
    public static final String DATE_CONTAINER_HEAD = "Fecha";
    public static final String ATE_CONTAINER_HEAD = "A.T.E";

    public static final String[] HEADERS_LIST = { "", WAGON_HEAD, "", "", "", "", "", CONTAINER_HEAD };
    public static final String[] TITTLES_LIST = {
            "",
            CONSIGN_HEAD,
            NUMBER_WAGON_HEAD,
            TARA_WAGON_HEAD,
            SEAL_ID_WAGON_HEAD,
            FM_WAGON_HEAD,
            "",
            NUMBER_CONTAINER_HEAD,
            FOOTERS_CONTAINER_HEAD,
            VC_CONTAINER_HEAD,
            CHARGE_CONTAINER_HEAD,
            HEIGHT_CONTAINER_HEAD,
            TARA_CONTAINER_HEAD,
            CHARGE_MAX_CONTAINER_HEAD,
            DESTINATION_CONTAINER_HEAD,
            DATE_CONTAINER_HEAD,
            ATE_CONTAINER_HEAD
    };
}
