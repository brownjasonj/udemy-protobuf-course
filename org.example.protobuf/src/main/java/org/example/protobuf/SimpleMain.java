package org.example.protobuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        builder.setId(32)
                .setIsSimple(true)
                .setName("My simple message name")
                .addSimpleList(1)
                .addSimpleList(23);

        System.out.println(builder.toString());

        Simple.SimpleMessage message = builder.build();

        // write the protocol buffer to a file
        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read the protocol buffer from a file
        try {
            FileInputStream inputStream = new FileInputStream("simple_message.bin");
            Simple.SimpleMessage messageFromFile = Simple.SimpleMessage.parseFrom(inputStream);
            System.out.println("Message from file:");
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
