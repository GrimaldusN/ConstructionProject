package com.example._23project.utils;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDFunction {
    public static byte[] uuidToBin(String uuidStr) {
        UUID uuid = UUID.fromString(uuidStr);
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }
}
