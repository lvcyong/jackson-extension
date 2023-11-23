package com.lvcoco.jackson.extension;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 23:25
 */
@Data
public class DemoModel {
    private int int1 = Integer.MIN_VALUE;
    private Integer int2 = Integer.MAX_VALUE;

    private byte byte1 = Byte.MIN_VALUE;
    private Byte byte2 = Byte.MAX_VALUE;

    private short short1 = Short.MIN_VALUE;
    private Short short2 = Short.MAX_VALUE;

    private long long1 = Long.MIN_VALUE;
    private Long long2 = Long.MAX_VALUE;

    private float float1 = Float.MIN_VALUE;
    private Float float2 = Float.MAX_VALUE;

    private double double1 = Double.MIN_VALUE;
    private Double double2 = Double.MAX_VALUE;

    private char char1 = 'A';
    private Character char2 = 'Z';

    private boolean boolean1 = true;
    private Boolean boolean2 = Boolean.FALSE;

    private String string1 = "q1w2e3";
    private StringBuilder stringBuilder1 = new StringBuilder("a1s2d3");

    private LocalDate localDate1 = LocalDate.now();

    private LocalTime localTime1 = LocalTime.now();

    private LocalDateTime localDateTime1 = LocalDateTime.now();

    private BigDecimal bigDecimal1 = new BigDecimal("1.00000000");

    private Object object1 = new Object();

    private BigInteger bigInteger1 = BigInteger.valueOf(Long.MIN_VALUE);
    private BigInteger bigInteger2 = BigInteger.valueOf(Long.MAX_VALUE);

    private Date date1 = new Date();

    private Timestamp timestamp1 = Timestamp.from(Instant.now());


    private byte[] byteArray1 = new byte[] {byte1, byte2};
    private Byte[] byteArray2 = new Byte[] {byte1, byte2};

    private short[] shortArray1 = new short[] {short1, short2};
    private Short[] shortArray2 = new Short[] {short1, short2};

    private int[] intArray1 = new int[] {int1, int2};
    private Integer[] intArray2 = new Integer[] {int1, int2};

    private long[] longArray1 = new long[] {long1, long2};
    private Long[] longArray2 = new Long[] {long1, long2};

    private float[] floatArray1 = new float[] {float1, float2};
    private Float[] floatArray2 = new Float[] {float1, float2};

    private double[] doubleArray1 = new double[] {double1, double2};
    private Double[] doubleArray2 = new Double[] {double1, double2};

    private char[] charArray1 = new char[] {char1, char2};
    private Character[] charArray2 = new Character[] {char1, char2};

    private boolean[] booleanArray1 = new boolean[] {boolean1, boolean2};
    private Boolean[] booleanArray2 = new Boolean[] {boolean1, boolean2};

    private String[] stringArray1 = new String[] {string1, "zaq"};
    private StringBuilder[] stringBuilderArray1 = new StringBuilder[] {stringBuilder1, new StringBuilder("xsw")}; ;

    private LocalDate[] localDateArray1 = new LocalDate[] {localDate1};

    private LocalTime[] localTimeArray1 = new LocalTime[] {localTime1};

    private LocalDateTime[] localDateTimeArray1 = new LocalDateTime[] {localDateTime1};

    private BigDecimal[] bigDecimalArray1 = new BigDecimal[] {bigDecimal1};

    private Object[] objectArray1 = new Object[] {object1};

    private BigInteger[] bigIntegerArray1 = new BigInteger[] {bigInteger1, bigInteger2};

    private Date[] dateArray1 = new Date[] {date1};

    private Timestamp[] timestampArray1 = new Timestamp[] {timestamp1};

    private List<Byte> byteList1 = Arrays.asList(byte1, byte2);

    private List<Short> shortList1 = Arrays.asList(short1, short2);

    private List<Integer> integerList1 = Arrays.asList(int1, int2);

    private List<Long> longList1 = Arrays.asList(long1, long2);

    private List<Float> floatList1 = Arrays.asList(float1, float2);

    private List<Double> doubleList1 = Arrays.asList(double1, double2);

    private List<Character> charList1 = Arrays.asList(char1, char2);

    private List<Boolean> booleanList1 = Arrays.asList(boolean1, boolean2);

    private List<String> stringList1 = Arrays.asList(string1, stringBuilder1.toString());

    private List<StringBuilder> stringBuilderList1 = List.of(stringBuilder1);

    private List<LocalDate> localDateList1 = List.of(localDate1);

    private List<LocalTime> localTimeList1 = List.of(localTime1);

    private List<LocalDateTime> localDateTimeList1 = List.of(localDateTime1);

    private List<BigDecimal> bigDecimalList1 = List.of(bigDecimal1);

    private List<Object> objectList1 = List.of(object1);

    private List<BigInteger> bigIntegerList1 = List.of(bigInteger1);

    private List<Date> dateList1 = List.of(date1);

    private List<Timestamp> timestampList1 = List.of(timestamp1);

    // private DemoModel demoModel = new DemoModel();

    // private DemoModel[] demoModelArray1 = new DemoModel[] {demoModel};
    //
    // private List<DemoModel> demoModelList1 = List.of(demoModel);
    //
    // private Map<String, DemoModel> map1 = Map.of(string1, demoModel);
    //
    // private Map<String, List<DemoModel>> map3 = Map.of(string1, List.of(demoModel));


    // private Map<String, Map<String, DemoModel>> map5 = Map.of(string1, map1);
    //
    //
    // private List<Map<String, DemoModel>> mapList1 = List.of(map1);

    // private Map<String, List<Map<String, DemoModel>>> map7 = Map.of(string1, mapList1);














}
