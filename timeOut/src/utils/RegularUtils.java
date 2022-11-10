package utils;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 工具类
 * 编程工具
 * 为了更方便编程
 *
 * @author 陶敏帆
 * @version 1.0
 */
public class RegularUtils {

    //输出（字符）
    public static void bufferedWriterWrite(String context) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                (new Socket(InetAddress.getByName("192.168.137.1"), 9998)).getOutputStream()));
        bufferedWriter.write(context);
        bufferedWriter.close();
    }

    //输入（字符）
    public static String bufferedReaderRead() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                (new Socket(InetAddress.getByName("192.168.137.1"), 9998).getInputStream()));
        return bufferedReader.readLine();
    }

    //输出（对象）
    public static void oosWriteObject(Object object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new Socket(InetAddress.getByName("192.168.137.1"), 9998).getOutputStream());
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    //输入（对象）
    public static Object oisReadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream
                (new Socket(InetAddress.getByName("192.168.137.1"), 9998).getInputStream());
        return objectInputStream.readObject();
    }

    //从键盘中读取字符串,返回值为读取的字符串
    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }


}
