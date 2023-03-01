package org.example._20230301;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Stream {
    public static void main(String[] args) throws IOException {
        // 스트림 처리의 3가지 중요점
        // 1. 인코딩 / 디코딩
        // 2. Buffered 처리
        // 3. 자원의 해제

        // 스트림
        // 외부로 부터 자바 프로그램으로 데이터는 바이트 배열 스트림으로 인입됨
        // 기본적으로 InputStream 으로 인입이 됨

        // 만들고자 하는 예제

        // euc-kr 로 저장된 파일을
        // utf-8 로 변환하여 다른 이름으로 저장하기

        // 1. euc-kr 파일 만들기
        String text = "Hello world\n" +
                "안녕하세요. 오택상입니다.\n" +
                "hi my name is 택상";

        // 자바는 내부 문자열은 유니코드로 처리한다.
        // 그러므로 euf-kr로 파일을 저장하기 위해서는
        byte[] eucBytes = text.getBytes("euc-kr");
        // 바이트 변환 후 스트링 변화해야 할듯
        String eucText = new String(eucBytes, "euc-kr"); // 다시 유니코드화일뿐

        String path = "test/euc_kr.txt";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        fileOutputStream.write(eucBytes);

        // 2. 이제 생성된 파일에서 데이터를 읽어서
        // 그걸 utf-8로 저장하자
        path = "test/utf-8.txt";
        File utf8File = new File(path);

        // euc-kr 파일에서 inputStream가져오기
        // 가져온 inputstream에서 byte[] 가져오기
        // 가져온 byte[]는 euf-kr로 되어있는 바이트배열
        // 자바에서 String으로 바꾸면 유니코드로 바뀜
        // 그걸 utf-8 byte[]로 바꾼후 파일에 쓰기
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(utf8File);
        byte[] buffer = new byte[8192];
        while (true) {
            int len = fileInputStream.read(buffer);
            if (len == -1) {
                break;
            }
            eucText = new String(buffer,0,len,"euc-kr");
            fileOutputStream2.write(eucText.getBytes(StandardCharsets.UTF_8));
        }


    }
}
