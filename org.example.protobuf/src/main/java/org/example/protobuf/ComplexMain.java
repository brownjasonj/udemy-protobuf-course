package org.example.protobuf;

import org.example.protobuf.Complex.DummyMessage;
import org.example.protobuf.Complex.ComplexMessage;

public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Complex example");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        ComplexMessage message = builder.setOneDummy(oneDummy)
                .addMultipleDummy(newDummyMessage(1, "second dummy message"))
                .addMultipleDummy(newDummyMessage(4, "third dummy message")).build();

        System.out.println(message);
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        DummyMessage dummyMessage = dummyMessageBuilder.setId(id)
                .setName(name)
                .build();

        return dummyMessage;
    }
}
