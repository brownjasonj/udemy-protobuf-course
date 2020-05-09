package org.example.protobuf;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Example for Enum");

        EnumExample.EnumMessage.Builder builder = EnumExample.EnumMessage.newBuilder();

        builder.setId(345);
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.THURSDAY);

        EnumExample.EnumMessage message = builder.build();

        System.out.println(message);
    }
}
