package com.maven.mule;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class TransfromInputOutput {
	private File readFile;
	public void setReadFile(File readFile) {
		this.readFile = readFile;
	}

	/*public static void main(String[] args) {

		final File folder = new File("E:/mulefiles");
		List<String> fileNames = listFilesForFolder(folder);
		for (String filename : fileNames) {
			try {
				readFile(new File(filename));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}*/

	private static List<String> listFilesForFolder(File folder) {
		List<String> fileNames = new ArrayList<String>();

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				fileNames.add(fileEntry.getAbsolutePath());
			}
		}

		return fileNames;

	}

	private static void readFile(File fileEntry) throws IOException {
		RandomAccessFile file = new RandomAccessFile(fileEntry, "r");
		FileChannel channel = file.getChannel();
		System.out.println("File size is: " + channel.size());
		ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
		channel.read(buffer);
		buffer.flip();// Restore buffer to position 0 to read it
		System.out.println("Reading content and printing ... ");
		for (int i = 0; i < channel.size(); i++) {
			System.out.print((char) buffer.get());
		}
		channel.close();
		file.close();
	}
}
