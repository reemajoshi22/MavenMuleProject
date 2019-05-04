package com.maven.mule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("E:/mulefiles/first.txt", "r");

        FileChannel channel = file.getChannel();

        System.out.println("File size is: " + channel.size());

        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

        channel.read(buffer);

        buffer.flip();//Restore buffer to position 0 to read it

        System.out.println("Reading content and printing ... ");

        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char) buffer.get());
        }

        channel.close();
        file.close();

    }
		/*final File fileLocation = new File("E:/mulefiles/first.txt");
		try {
			System.out.println(fileLocation);
			readFile(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	/*private static String readFile(File fileEntry) throws IOException {
		System.out.println("inside read file" + fileEntry);
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"E:/mulefiles/first.txt")));
		StringBuilder sb;
		try {
			sb = new StringBuilder();
			String line = br.readLine();
			System.out.println("line" + line);
			while (line != null) {
				sb.append(line);
				sb.append("new line added");
				line = br.readLine();
			}
			return line;
		} finally {
			br.close();
		}
	}*/
}
