package neu.edu.Io;

import java.io.*;
import java.nio.charset.Charset;

public class Io {
    public static void main(String[] args) {
        File file = new File("F:\\新建文件夹 (2)\\a\\b.txt");
        InputStream inputStream=null;
        {
            try {
                inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                try {
                    inputStream.read(bytes);
                    System.out.println(new String(bytes,Charset.forName("utf-8")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        OutputStream outputStream =null;
        try {
            outputStream = new FileOutputStream(file,true);
            try {
                outputStream.write("一一一".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        字符流的输入输出
        Reader reader = null;
        try {
            char[] chars = new char[(int)(file.length())];
            reader = new FileReader(file);
            try {
                reader.read(chars);
                System.out.println(new String (chars));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer writer =null;
        try {
            writer = new FileWriter(file,true);
            writer.write("二二");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        文件的复制
        File file1 = new File("F:\\新建文件夹 (2)\\a\\c.txt");
        try {
            InputStream inputStream1 = new FileInputStream(file);
            OutputStream outputStream1 = new FileOutputStream(file1);
            byte[] bytes =new byte[1024];
            inputStream1.read(bytes);
            outputStream1.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        将字节流变成字符流
        try {
            InputStreamReader inputStreamReader = new FileReader(file);
            char[] chars = new char[(int)(file.length())];
            inputStreamReader.read(chars,0,chars.length);
            System.out.println(new String(chars));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//    序列化
        Student student = new Student();
        student.setAge(11);
        student.setName("sda");
        OutputStream outputStream1 =null;
        ObjectOutputStream objectOutputStream =null;
        try {
            outputStream1 =new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream1);
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
                outputStream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        反序列化
        InputStream inputStream1 =null;
        ObjectInputStream objectInputStream = null;
        try {
            inputStream1 = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream1);
            Student student1 = (Student)objectInputStream.readObject();
            System.out.println(student1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
                inputStream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
