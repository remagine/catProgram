package org.example._20230301;

import java.io.*;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class Stream2 {


    public static void main(String[] args) throws IOException {
        String text = "Hello world\n" +
                "안녕하세요. 오택상입니다.\n" +
                "hi my name is 택상";

        String path = "test/euc_kr2.txt";
        File eucFile = new File(path);

        FileOutputStream fileOutputStream = new FileOutputStream(eucFile);
        try {
            byte[] eucBytes = text.getBytes("EUC-KR");
            fileOutputStream.write(eucBytes);
        } finally {
            fileOutputStream.close();
        }

        path = "test/utf_8_2.txt";
        File utf8File = new File(path);
        FileInputStream fileInputStream = new FileInputStream(eucFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream2 = new FileOutputStream(utf8File);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[3];
        int len;
        int byteSize = 0;
        int restBufferSize = buffer.length;

        bufferedInputStream.mark(0);
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            for (byte b : buffer) {
                if ((b & 0b10000000) == 0) {
                    byteSize = 1;
                    break;
                } else if ((b & 0b11100000) == 0b11000000) {
                    byteSize = 2;
                    break;
                } else if ((b & 0b11110000) == 0b11100000) {
                    byteSize = 3;
                    break;
                } else if ((b & 0b11111000) == 0b11110000) {
                    byteSize = 4;
                    break;
                }
                if (restBufferSize >= byteSize) {
                    restBufferSize -= byteSize;
                }
                if (restBufferSize < byteSize) {
                    bufferedInputStream.reset();
                    bufferedInputStream.skip(byteSize);
                    restBufferSize = 3;
                }
                byteArrayOutputStream.write(buffer);
                bufferedInputStream.mark(bufferedInputStream.available());
            }


            String textChunk = new String(buffer, 0, len, "EUC-KR");
            byte[] utf8Bytes = textChunk.getBytes(StandardCharsets.UTF_8);
            fileOutputStream2.write(utf8Bytes);
        }
    }
}
